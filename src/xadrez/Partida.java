package xadrez;

import Tabuleiro_Jogo.Tabuleiro;

public class Partida {
	
	private Tabuleiro tab;
	
	public Partida() {
		tab = new Tabuleiro(8,8);
	}

	public Xadrez_Peca[][] getPieces(){
		Xadrez_Peca[][]mat = new Xadrez_Peca[tab.getLinha()][tab.getColuna()];
		
		for(int i = 0 ; i < tab.getLinha() ; i++) {
			for(int j = 0 ; j < tab.getColuna() ; j++) {
				mat[i][j] = (Xadrez_Peca) tab.piece(i,j);
			}}
		return mat;
	}
	
	
}
