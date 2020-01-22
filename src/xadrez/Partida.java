package xadrez;

import Pecas.*;
import Tabuleiro_Jogo.*;

public class Partida {
	
	private Tabuleiro tab;
	
	public Partida() {
		tab = new Tabuleiro(8,8);
		InicialSetUp();
	}

	public Xadrez_Peca[][] getPieces(){
		Xadrez_Peca[][]mat = new Xadrez_Peca[tab.getLinha()][tab.getColuna()];
		
		for(int i = 0 ; i < tab.getLinha() ; i++) {
			for(int j = 0 ; j < tab.getColuna() ; j++) {
				mat[i][j] = (Xadrez_Peca) tab.piece(i,j);
			}}
		return mat;
	}
	
	public void InicialSetUp() {
		tab.placePiece(new Torre(tab,Cor.WHITE), new Posicao(0,0));
		
	}
}