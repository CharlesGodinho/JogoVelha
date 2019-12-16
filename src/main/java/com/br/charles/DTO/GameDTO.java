package com.br.charles.DTO;

public class GameDTO {

	public GameDTO() {
		super();
	}

	public GameDTO(String id, String player) {
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