package com.br.charles.Service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.charles.DTO.GameDTO;
import com.br.charles.DTO.PositionDTO;
import com.br.charles.Entity.Game;
import com.br.charles.Repository.GameRepository;

import javassist.NotFoundException;
import net.minidev.json.JSONObject;

@Service("gameService")
public class GameService {

	@Autowired
	private Tabuleiro tabuleiro;

	@Autowired
	private GameRepository gameRepository;

	public GameDTO generateNewGame() {

		Game game = new Game();
		String tabuleiro[][] = new String[3][3];
		game.setJogo(tabuleiro);
		gameRepository.save(game);
		Random r = new Random(2);
		return new GameDTO(game.getId().toString(), ((r.nextInt() != 1) ? "X" : "O"));
	}

	public JSONObject makeMove(String id, String player, PositionDTO position) {
		JSONObject jsonObject = new JSONObject();
		try {
			Game game = gameRepository.findById(UUID.fromString(id))
					.orElseThrow(() -> new NotFoundException("Partida não encontrada"));
			if (player.equals(game.getLastPlayer())) {
				jsonObject.put("msg", "Não é o turno do jogador");
			} else {
				if (tabuleiro.makeMove(game.getJogo(), player, position.getY(), position.getX())) {
					String checkWinner = tabuleiro.checkWinner(game.getJogo());
					if ("".equals(checkWinner)) {
						jsonObject.put("msg", "Jogada realizada");
						game.setLastPlayer(player);
						gameRepository.save(game);
					} else if ("X".equals(checkWinner)) {
						jsonObject.put("status", "Partida finalizada");
						jsonObject.put("winner", "X");
					} else if ("O".equals(checkWinner)) {
						jsonObject.put("status", "Partida finalizada");
						jsonObject.put("winner", "O");
					}
				}
			}

		} catch (NotFoundException e) {
			jsonObject.put("msg", e.getMessage());
		} catch (Exception e) {
			jsonObject.put("msg", "Ocorreu um erro");
		}
		return jsonObject;
	}
}