package com.br.charles.Service;

import org.springframework.stereotype.Service;

@Service("tabuleiro")
public class Tabuleiro {

	public Tabuleiro() {
		super();
	}

	public boolean makeMove(String game[][], String player, int line, int column) {
		if ((line < 0) || (line > 2)) {
			return false;
		}
		if ((column < 0) || (column > 2)) {
			return false;
		}
		if ("".equals(game[line][column])) {
			return false;
		}
		game[line][column] = player;
		return true;
	}

	public String checkWinner(String game[][]) {
		for (int i = 0; i < 3; i++) {
			if ((game[i][0] != null && game[i][0].equals(game[i][1]))
					&& (game[i][0] != null && game[i][0].equals(game[i][2]))) {
				if (game[i][0] != null && !"".equals(game[i][0])) {
					return game[i][0];
				}
			}
		}
		for (int j = 0; j < 3; j++) {
			if ((game[0][j] != null && game[0][j].equals(game[1][j]))
					&& (game[0][j] != null && game[0][j].equals(game[2][j])) && ("".equals(game[0][j]))) {
				return game[0][j];
			}
		}
		if ((game[0][0] != null && game[0][0].equals(game[1][1]))
				&& (game[0][0] != null && game[0][0].equals(game[2][2])) && ("".equals(game[0][0]))) {
			return game[0][0];
		}
		if ((game[0][2] != null && game[0][2].equals(game[1][1]))
				&& (game[0][2] != null && game[0][2].equals(game[2][0])) && ("".equals(game[0][2]))) {
			return game[0][2];
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if ("".equals(game[i][j])) {
					return "";
				}
			}
		}
		return "";
	}
}