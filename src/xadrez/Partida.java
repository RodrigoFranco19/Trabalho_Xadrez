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
	
	private void placeNewPiece(char column , int row , Xadrez_Peca piece) {
		tab.placePiece(piece, new Xadrez_Posicao(column,row).toPosition());
	}
	
	public void InicialSetUp() {
		placeNewPiece('a',8, new Torre(tab, Cor.BLACK));
		placeNewPiece('b',8,new Cavalo(tab,Cor.BLACK));
		placeNewPiece('c',8,new Bispo(tab,Cor.BLACK));
		placeNewPiece('d',8,new Rainha(tab,Cor.BLACK));
		placeNewPiece('e',8,new Rei(tab,Cor.BLACK));
		placeNewPiece('f',8,new Bispo(tab,Cor.BLACK));
		placeNewPiece('g',8,new Cavalo(tab,Cor.BLACK));
		placeNewPiece('h',8, new Torre(tab, Cor.BLACK));
		
		placeNewPiece('a',7, new Piao(tab, Cor.BLACK));
		placeNewPiece('b',7,new Piao(tab,Cor.BLACK));
		placeNewPiece('c',7,new Piao(tab,Cor.BLACK));
		placeNewPiece('d',7,new Piao(tab,Cor.BLACK));
		placeNewPiece('e',7,new Piao(tab,Cor.BLACK));
		placeNewPiece('f',7,new Piao(tab,Cor.BLACK));
		placeNewPiece('g',7,new Piao(tab,Cor.BLACK));
		placeNewPiece('h',7, new Piao(tab, Cor.BLACK));
	}
}