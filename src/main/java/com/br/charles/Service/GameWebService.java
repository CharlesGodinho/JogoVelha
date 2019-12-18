package com.br.charles.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.example.game.GameResponse;
import org.example.game.MoveRequest;
import org.example.game.MoveResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.br.charles.DTO.GameDTO;
import com.br.charles.DTO.MoveResponseDTO;

@Service("gameWebService")
public class GameWebService {
	final String uriGame = "http://localhost:9000/jogodavelha/game";

	public GameResponse getGameRest() {
		RestTemplate rest = new RestTemplate();
		ResponseEntity<GameDTO> response = rest.getForEntity(uriGame, GameDTO.class);
		GameResponse gameresp = convertGame(response);
		return gameresp;
	}

	private GameResponse convertGame(ResponseEntity<GameDTO> response) {
		GameDTO gameDTO = (GameDTO) response.getBody();
		GameResponse gameresp = new GameResponse();
		gameresp.setId(gameDTO.getId());
		gameresp.setPlayer(gameDTO.getPlayer());
		return gameresp;
	}

	public MoveResponse moveRest(MoveRequest moveRequest) {
		RestTemplate rest = new RestTemplate();
		HttpEntity<Map<String, Object>> entity = new HttpEntity<>(convertMoveJson(moveRequest), getHeader());
		ResponseEntity<MoveResponseDTO> response = rest.postForEntity(uriGame + "/" + moveRequest.getId() + "/movement",
				entity, MoveResponseDTO.class);

		MoveResponse moveResp = convertMove(response);
		return moveResp;
	}

	private MoveResponse convertMove(ResponseEntity<MoveResponseDTO> response) {
		MoveResponseDTO move = (MoveResponseDTO) response.getBody();
		MoveResponse moveResp = new MoveResponse();
		moveResp.setMsg(move.getMsg());
		moveResp.setStatus(move.getStatus());
		moveResp.setWinner(move.getWinner());
		return moveResp;
	}

	private Map<String, Object> convertMoveJson(MoveRequest moveRequest) {
		Map<String, Object> move = new HashMap<String, Object>();
		Map<String, Integer> position = new HashMap<String, Integer>();
		position.put("x", moveRequest.getPosition().getX());
		position.put("y", moveRequest.getPosition().getY());
		move.put("id", moveRequest.getId());
		move.put("player", moveRequest.getPlayer());
		move.put("position", position);
		return move;
	}

	public HttpHeaders getHeader() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		return headers;
	}
}