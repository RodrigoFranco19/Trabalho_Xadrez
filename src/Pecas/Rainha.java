package Pecas;

import Tabuleiro_Jogo.Tabuleiro;
import xadrez.Cor;
import xadrez.Xadrez_Peca;

public class Rainha extends Xadrez_Peca{

	public Rainha(Tabuleiro tab, Cor c) {
		super(tab, c);
	}
	
	@Override
	public String toString() {
		return "Q";
	}
}
