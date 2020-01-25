package Pecas;

import Tabuleiro_Jogo.Posicao;
import Tabuleiro_Jogo.Tabuleiro;
import xadrez.Cor;
import xadrez.Partida;
import xadrez.Xadrez_Peca;

public class Piao extends Xadrez_Peca{

	private Partida partida;
	
	public Piao(Tabuleiro tab, Cor c,Partida partida) {
		super(tab, c);
		this.partida = partida;
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
		
	//enPassant
		if(p.getLinha() == 3) {
			Posicao left = new Posicao(p.getLinha(),p.getColuna() - 1);
			
			if(getTab().PositionExists(left) && IsThereOponnentPiece(left) && getTab().piece(left) == partida.getEnPassantVulnerabel()) {
				mat[left.getLinha() - 1][left.getColuna()] = true;
			}
			
			Posicao right = new Posicao(p.getLinha(),p.getColuna() + 1);
			
			if(getTab().PositionExists(right) && IsThereOponnentPiece(right) && getTab().piece(right) == partida.getEnPassantVulnerabel()) {
				mat[right.getLinha() - 1][right.getColuna()] = true;
			}
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
		
		
		//enPassant
				if(p.getLinha() == 4) {
					Posicao left = new Posicao(p.getLinha(),p.getColuna() - 1);
					
					if(getTab().PositionExists(left) && IsThereOponnentPiece(left) && getTab().piece(left) == partida.getEnPassantVulnerabel()) {
						mat[left.getLinha() + 1][left.getColuna()] = true;
					}
					
					Posicao right = new Posicao(p.getLinha(),p.getColuna() + 1);
					
					if(getTab().PositionExists(right) && IsThereOponnentPiece(right) && getTab().piece(right) == partida.getEnPassantVulnerabel()) {
						mat[right.getLinha() + 1][right.getColuna()] = true;
					}
				}
		}
		return mat;
	}
}