package Pecas;

import Tabuleiro_Jogo.*;
import xadrez.*;

public class Rei extends Xadrez_Peca {

	public Rei(Tabuleiro tab, Cor c) {
		super(tab, c);
	}

	@Override
	public String toString() {
		return "K";
	}

	private boolean canMove(Posicao pos) {
		Xadrez_Peca p = (Xadrez_Peca) getTab().piece(pos);
		
		return p == null && p.getC() != getC();
	}
	
	
	@Override
	public boolean[][] possibleMoves() {
		boolean [][]mat = new boolean[getTab().getLinha()][getTab().getColuna()];
		
		Posicao p1 = new Posicao(0,0);
		
		//Cima
		p1.SetValues(p1.getLinha() - 1, p1.getColuna());
		while(getTab().PositionExists(p1) && canMove(p1)) {
			mat[p1.getLinha()][p1.getColuna()] = true;
		}
		
		//Baixo
		p1.SetValues(p1.getLinha() + 1, p1.getColuna());
		while(getTab().PositionExists(p1) && canMove(p1)) {
			mat[p1.getLinha()][p1.getColuna()] = true;
		}
		
		//Esquerda
		p1.SetValues(p1.getLinha(), p1.getColuna() -1);
		while(getTab().PositionExists(p1) && canMove(p1)) {
			mat[p1.getLinha()][p1.getColuna()] = true;
		}
		
		//Direita
		p1.SetValues(p1.getLinha(), p1.getColuna() + 1);
		while(getTab().PositionExists(p1) && canMove(p1)) {
			mat[p1.getLinha()][p1.getColuna()] = true;
		}
		
		//Noroeste
		p1.SetValues(p1.getLinha() - 1, p1.getColuna() - 1);
		while(getTab().PositionExists(p1) && canMove(p1)) {
			mat[p1.getLinha()][p1.getColuna()] = true;
		}
		
		//Nordeste
		p1.SetValues(p1.getLinha() - 1, p1.getColuna() + 1);
		while(getTab().PositionExists(p1) && canMove(p1)) {
			mat[p1.getLinha()][p1.getColuna()] = true;
		}
		
		//Sudoeste
		p1.SetValues(p1.getLinha() + 1, p1.getColuna() - 1);
		while(getTab().PositionExists(p1) && canMove(p1)) {
			mat[p1.getLinha()][p1.getColuna()] = true;
		}
		
		//Sudeste
		p1.SetValues(p1.getLinha() + 1, p1.getColuna() + 1);
		while(getTab().PositionExists(p1) && canMove(p1)) {
			mat[p1.getLinha()][p1.getColuna()] = true;
		}
		
		return mat;
	}
}
