package Pecas;

import Tabuleiro_Jogo.Tabuleiro;
import xadrez.Cor;
import xadrez.Xadrez_Peca;

public class Bispo extends Xadrez_Peca{

	public Bispo(Tabuleiro tab, Cor c) {
		super(tab, c);
	}
	
	@Override
	public String toString() {
		return "B";
	}

}
