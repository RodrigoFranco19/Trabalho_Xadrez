package Pecas;

import Tabuleiro_Jogo.Tabuleiro;
import xadrez.Cor;
import xadrez.Xadrez_Peca;

public class Piao extends Xadrez_Peca{

	public Piao(Tabuleiro tab, Cor c) {
		super(tab, c);
	}

	@Override
	public String toString() {
		return "P";
	}
	
	
}
