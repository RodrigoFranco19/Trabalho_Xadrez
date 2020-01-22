package Tabuleiro_Jogo;

public class Tabuleiro {

	private int linha,coluna;
	private Peca[][]pcs;

	public Tabuleiro(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
		pcs = new Peca[linha][coluna];
	}
	
	public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	public int getColuna() {
		return coluna;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}
	
	public Peca piece(int linha , int coluna) {
		return pcs[linha][coluna];
	}
	
	public Peca piece(Posicao pos) {
		return pcs[pos.getLinha()][pos.getColuna()];
	}
	
	public void placePiece(Peca piece , Posicao pos) {
		pcs[pos.getLinha()][pos.getColuna()] = piece;
		piece.pos = pos;
	}
}