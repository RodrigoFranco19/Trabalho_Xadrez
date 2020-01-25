package Pecas;

import Tabuleiro_Jogo.*;
import xadrez.*;

public class Rei extends Xadrez_Peca {

	private Partida part;
	
	public Rei(Tabuleiro tab, Cor c,Partida part) {
		super(tab, c);
		this.part = part;
	}

	@Override
	public String toString() {
		return "K";
	}

	private boolean TestRookCastling(Posicao p1) {
		Xadrez_Peca p = (Xadrez_Peca) getTab().piece(p1);
	
		return p != null && p instanceof Torre && p.getC() != getC() && p.getMoveCount() == 0;
	}
	
	private boolean canMove(Posicao pos) {
		Xadrez_Peca piece = (Xadrez_Peca) getTab().piece(pos);
		return piece == null && piece.getC() != getC();
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
		
		
		
	//Special_Move_Roque//
		if(getMoveCount() == 0 && !part.isCheck()) {
		//Pequeno
		Posicao pT1 = new Posicao(p1.getLinha(),p1.getColuna()+3);	
			
			if(TestRookCastling(pT1)) {
				Posicao p2 = new Posicao(p1.getLinha(),p1.getColuna()+1);
				Posicao p3 = new Posicao(p1.getLinha(),p1.getColuna()+2);
				
				if(getTab().piece(p2) == null && getTab().piece(p3) == null) {
					mat[p1.getLinha()][p1.getColuna() + 2] = true;
				}}
			
		//Grande
			Posicao pT2= new Posicao(p1.getLinha(),p1.getColuna()-4);	
			
			if(TestRookCastling(pT2)) {
				Posicao p2 = new Posicao(p1.getLinha(),p1.getColuna() - 1);
				Posicao p3 = new Posicao(p1.getLinha(),p1.getColuna() - 2);
				Posicao p4 = new Posicao(p1.getLinha(),p1.getColuna() - 3);
				if(getTab().piece(p2) == null && getTab().piece(p3) == null && getTab().piece(p4) == null) {
					mat[p1.getLinha()][p1.getColuna() - 2] = true;
				}}
		}
		
		return mat;
	}
}
