package Pecas;

import Tabuleiro_Jogo.Tabuleiro;
import xadrez.Cor;
import xadrez.Xadrez_Peca;

public class Cavalo extends Xadrez_Peca{

	public Cavalo(Tabuleiro tab, Cor c) {
		super(tab, c);
	}
	
	@Override
	public String toString() {
		return "C";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean [][]mat = new boolean[getTab().getLinha()][getTab().getColuna()];
		return mat;
	}
}
