package xadrez;

import Tabuleiro_Jogo.*;

public abstract class Xadrez_Peca extends Peca{

	private Cor c;
	
	public Xadrez_Peca(Tabuleiro tab,Cor c) {
		super(tab);
		this.c = c;
	}

	public Cor getC() {
		return c;
	}
	
	protected boolean IsThereOponnentPiece(Posicao p) {
		Xadrez_Peca p1 = (Xadrez_Peca) getTab().piece(p);
		
		return p1 != null &&  p1.getC() != c;
	}
	
	public Xadrez_Posicao getChessPos() {
		return Xadrez_Posicao.fromPosition(pos);
	}
}
