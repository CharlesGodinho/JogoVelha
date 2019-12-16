package com.br.charles.XML;

public class GameXML {

	public GameXML() {
		super();
	}

	public GameXML(String id, String player) {
		super();
		this.id = id;
		this.player = player;
	}

	private String id;

	private String player;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}
}