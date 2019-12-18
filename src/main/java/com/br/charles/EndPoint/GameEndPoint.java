package com.br.charles.EndPoint;

import org.example.game.GameResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class GameEndPoint {

	@PayloadRoot(namespace = "http://localhost/jogodavelha/endpoint", localPart = "")
	@ResponsePayload
	public GameResponse teste() {
		return null;
	}
}
