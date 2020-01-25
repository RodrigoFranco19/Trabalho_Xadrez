package Pecas;

import Tabuleiro_Jogo.Posicao;
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

	@Override
	public boolean[][] possibleMoves() {
		boolean [][]mat = new boolean[getTab().getLinha()][getTab().getColuna()];
		
		Posicao p = new Posicao(0,0);
		
		//Torre
		//Cima
		p.SetValues(pos.getLinha() -1 , pos.getColuna());
		while(getTab().PositionExists(p) && !getTab().Tempeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() -1);
		}
		if(getTab().PositionExists(p) && IsThereOponnentPiece(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//Esquerda
		p.SetValues(pos.getLinha(), pos.getColuna() - 1);
		while(getTab().PositionExists(p) && !getTab().Tempeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setColuna(p.getColuna() -1);
		}
		if(getTab().PositionExists(p) && IsThereOponnentPiece(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//Direita
		p.SetValues(pos.getLinha(), pos.getColuna() + 1);
		while(getTab().PositionExists(p) && !getTab().Tempeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setColuna(p.getColuna() + 1);
		}
		if(getTab().PositionExists(p) && IsThereOponnentPiece(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//Abaixo
		p.SetValues(pos.getLinha() + 1 , pos.getColuna());
		while(getTab().PositionExists(p) && !getTab().Tempeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() + 1);
		}
		if(getTab().PositionExists(p) && IsThereOponnentPiece(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//Bispo
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
