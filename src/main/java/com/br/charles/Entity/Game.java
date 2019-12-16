package com.br.charles.Entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "game")
public class Game {

	@Id
	@GeneratedValue(generator = "uuid2")
	@Column(name = "id")
	private UUID id;

	@Column
	private String lastPlayer;

	private String jogo[][];

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getLastPlayer() {
		return lastPlayer;
	}

	public void setLastPlayer(String lastPlayer) {
		this.lastPlayer = lastPlayer;
	}

	public String[][] getJogo() {
		return jogo;
	}

	public void setJogo(String[][] jogo) {
		this.jogo = jogo;
	}
}