package Pecas;

import Tabuleiro_Jogo.Posicao;
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

	@Override
	public boolean[][] possibleMoves() {
		boolean [][]mat = new boolean[getTab().getLinha()][getTab().getColuna()];
		
		Posicao p = new Posicao(0,0);
		
		if(getC() == Cor.WHITE) {
		p.SetValues(p.getLinha() - 1, p.getColuna());
		if(getTab().PositionExists(p) && !getTab().Tempeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//Contagem de Movimento = 0
		p.SetValues(p.getLinha() - 2, p.getColuna());
		Posicao p2 = new Posicao(p.getLinha() - 1 , p.getColuna());
		if(getTab().PositionExists(p) && !getTab().Tempeca(p) && getMoveCount() == 0 && getTab().PositionExists(p2) && !getTab().Tempeca(p2)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//Diagonais
		p.SetValues(p.getLinha() - 1, p.getColuna() - 1);
		if(getTab().PositionExists(p) && IsThereOponnentPiece(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		p.SetValues(p.getLinha() - 1, p.getColuna() + 1);
		if(getTab().PositionExists(p) && IsThereOponnentPiece(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
	}else {
		p.SetValues(p.getLinha() + 1, p.getColuna());
		if(getTab().PositionExists(p) && !getTab().Tempeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//Contagem de Movimento = 0
		p.SetValues(p.getLinha() + 2, p.getColuna());
		Posicao p2 = new Posicao(p.getLinha() + 1 , p.getColuna());
		if(getTab().PositionExists(p) && !getTab().Tempeca(p) && getMoveCount() == 0 && getTab().PositionExists(p2) && !getTab().Tempeca(p2)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//Diagonais
		p.SetValues(p.getLinha() + 1, p.getColuna() - 1);
		if(getTab().PositionExists(p) && IsThereOponnentPiece(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		p.SetValues(p.getLinha() + 1, p.getColuna() + 1);
		if(getTab().PositionExists(p) && IsThereOponnentPiece(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
	}
		return mat;
	}
}