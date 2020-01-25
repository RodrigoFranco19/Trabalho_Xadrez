package Pecas;

import Tabuleiro_Jogo.Posicao;
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

	@Override
	public boolean[][] possibleMoves() {
		boolean [][]mat = new boolean[getTab().getLinha()][getTab().getColuna()];
		
		Posicao p = new Posicao(0,0);
		
		//Noroeste
		p.SetValues(p.getLinha() -1 , p.getColuna() - 1);
		while(getTab().PositionExists(p) && !getTab().Tempeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.SetValues(p.getLinha() - 1, p.getColuna() - 1);
		}
		if(getTab().PositionExists(p) && IsThereOponnentPiece(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//Nordeste
		p.SetValues(p.getLinha() - 1, p.getColuna() + 1);
		while(getTab().PositionExists(p) && !getTab().Tempeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.SetValues(p.getLinha() - 1, p.getColuna() + 1);
		}
		if(getTab().PositionExists(p) && IsThereOponnentPiece(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//Sudeste
		p.SetValues(p.getLinha() + 1, p.getColuna() + 1);
		while(getTab().PositionExists(p) && !getTab().Tempeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.SetValues(p.getLinha() + 1, p.getColuna() + 1);
		}
		if(getTab().PositionExists(p) && IsThereOponnentPiece(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//Sudoeste
		p.SetValues(p.getLinha() + 1 , p.getColuna() - 1);
		while(getTab().PositionExists(p) && !getTab().Tempeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.SetValues(p.getLinha() + 1, p.getColuna() - 1);
		}
		if(getTab().PositionExists(p) && IsThereOponnentPiece(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		return mat;
	}
}