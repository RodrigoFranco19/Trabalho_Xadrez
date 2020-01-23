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
}
