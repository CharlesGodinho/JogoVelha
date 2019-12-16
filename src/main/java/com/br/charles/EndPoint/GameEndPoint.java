package com.br.charles.EndPoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.br.charles.XML.GameXML;

@Endpoint
public class GameEndPoint {

	@PayloadRoot(namespace = "http://localhost:9000/charles/", localPart = "gameEndPoint")
	@ResponsePayload
	public GameXML teste() {
		return null;
	}
}
