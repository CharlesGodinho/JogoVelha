package com.br.charles.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.br.charles.DTO.GameDTO;
import com.br.charles.DTO.MoveDTO;
import com.br.charles.Service.GameService;

import net.minidev.json.JSONObject;

@RestController
public class GameController {

	@Autowired
	private GameService gameService;

	@RequestMapping(value = "/game", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GameDTO> createGame() {
		GameDTO game = gameService.generateNewGame();
		return new ResponseEntity<GameDTO>(game, HttpStatus.OK);
	}

	@RequestMapping(value = "/game/{id}/movement", method = RequestMethod.POST)
	public ResponseEntity<JSONObject> makeMove(@PathVariable("id") String id, @RequestBody MoveDTO move) {
		JSONObject jsonObject = gameService.makeMove(id, move.getPlayer(), move.getPosition());
		return new ResponseEntity<JSONObject>(jsonObject, HttpStatus.OK);
	}
}