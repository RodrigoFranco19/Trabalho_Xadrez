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
	
	public Xadrez_Peca performChessMove(Xadrez_Posicao src , Xadrez_Posicao tgt) {
		Posicao source = src.toPosition();
		Posicao target = tgt.toPosition();
		
		validateSourcePosition(source);
		Peca capturada = makeMove(source,target);
		
		return (Xadrez_Peca) capturada;
	}
	
	private Peca makeMove(Posicao src , Posicao tgt) {
		Peca p = tab.RemovePiece(src);
		Peca capturar = tab.RemovePiece(tgt);
		tab.placePiece(p, tgt);
		return capturar;
	}
	
	private void validateSourcePosition(Posicao p) {
		if(!tab.Tempeca(p)) {
			throw new ChessException("Nao existe peca na posicao de origem");
		}
		if(!tab.piece(p).isThereAnyPossibleMove()) {
			throw new ChessException("Nao existe movimentos possiveis para a peca escolhida");

		}
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
		
		placeNewPiece('a',1, new Torre(tab, Cor.WHITE));
		placeNewPiece('b',1,new Cavalo(tab,Cor.WHITE));
		placeNewPiece('c',1,new Bispo(tab,Cor.WHITE));
		placeNewPiece('d',1,new Rainha(tab,Cor.WHITE));
		placeNewPiece('e',1,new Rei(tab,Cor.WHITE));
		placeNewPiece('f',1,new Bispo(tab,Cor.WHITE));
		placeNewPiece('g',1,new Cavalo(tab,Cor.WHITE));
		placeNewPiece('h',1, new Torre(tab, Cor.WHITE));
	
		placeNewPiece('a',2, new Piao(tab, Cor.WHITE));
		placeNewPiece('b',2,new Piao(tab,Cor.WHITE));
		placeNewPiece('c',2,new Piao(tab,Cor.WHITE));
		placeNewPiece('d',2,new Piao(tab,Cor.WHITE));
		placeNewPiece('e',2,new Piao(tab,Cor.WHITE));
		placeNewPiece('f',2,new Piao(tab,Cor.WHITE));
		placeNewPiece('g',2,new Piao(tab,Cor.WHITE));
		placeNewPiece('h',2, new Piao(tab, Cor.WHITE));
	}
}