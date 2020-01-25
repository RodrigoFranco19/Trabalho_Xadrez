package Pecas;

import Tabuleiro_Jogo.Posicao;
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

	private boolean canMove(Posicao pos) {
		Xadrez_Peca pc = (Xadrez_Peca) getTab().piece(pos);
		return pc == null && pc.getC() != getC();
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean [][]mat = new boolean[getTab().getLinha()][getTab().getColuna()];
		
		Posicao p = new Posicao(0,0);
		
		p.SetValues(p.getLinha() - 1, p.getColuna() - 2);
		while(getTab().PositionExists(p) && canMove(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		p.SetValues(p.getLinha() -2 , p.getColuna() - 1);
		while(getTab().PositionExists(p) && canMove(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		p.SetValues(p.getLinha() -2 , p.getColuna() +1);
		while(getTab().PositionExists(p) && canMove(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		p.SetValues(p.getLinha() - 1, p.getColuna() + 2);
		while(getTab().PositionExists(p) && canMove(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		p.SetValues(p.getLinha() + 1, p.getColuna() + 2);
		while(getTab().PositionExists(p) && canMove(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		p.SetValues(p.getLinha() + 2, p.getColuna() + 1);
		while(getTab().PositionExists(p) && canMove(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		p.SetValues(p.getLinha() + 2, p.getColuna() - 1);
		while(getTab().PositionExists(p) && canMove(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		p.SetValues(p.getLinha() + 1, p.getColuna() - 2);
		while(getTab().PositionExists(p) && canMove(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		return mat;
	}
}