package com.br.charles.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.br.charles.DTO.GameDTO;

public class GameWebService {
	final String uriGame = "localhost/jogodavelha/game";

	@Autowired
	RestTemplate rest;

	public GameDTO getGameRest() {
		ResponseEntity<GameDTO> response = rest.getForEntity(uriGame, GameDTO.class);
		return (GameDTO) response.getBody();
	}
}