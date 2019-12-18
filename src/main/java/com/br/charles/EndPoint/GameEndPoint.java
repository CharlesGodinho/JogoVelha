package com.br.charles.EndPoint;

import org.example.game.GameRequest;
import org.example.game.GameResponse;
import org.example.game.MoveRequest;
import org.example.game.MoveResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.br.charles.Service.GameWebService;

@Endpoint
public class GameEndPoint {

	@Autowired
	private GameWebService gameWebService;

	@PayloadRoot(namespace = "http://www.example.org/game", localPart = "GameRequest")
	@ResponsePayload
	public GameResponse gameInit(@RequestPayload GameRequest request) {
		return gameWebService.getGameRest();
	}

	@PayloadRoot(namespace = "http://www.example.org/game", localPart = "MoveRequest")
	@ResponsePayload
	public MoveResponse moveGame(@RequestPayload MoveRequest request) {
		return gameWebService.moveRest(request);
	}
}
