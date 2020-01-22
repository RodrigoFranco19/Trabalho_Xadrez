package Pecas;

import Tabuleiro_Jogo.Tabuleiro;
import xadrez.Cor;
import xadrez.Xadrez_Peca;

public class Torre extends Xadrez_Peca{
	public Torre(Tabuleiro tab, Cor c) {
		super(tab, c);
	}
	
	@Override
	public String toString() {
		return "T";
	}
	
}
