package Tabuleiro_Jogo;

public class Tabuleiro {

	private int linha,coluna;
	private Peca[][]pcs;

	public Tabuleiro(int linha, int coluna) {
		if(linha < 1 || coluna < 1) {
			throw new BoardException("Precisa ter numeros maiores que 0");
		}
		
		this.linha = linha;
		this.coluna = coluna;
		pcs = new Peca[linha][coluna];
	}
	
	public int getLinha() {
		return linha;
	}
	
	public int getColuna() {
		return coluna;
	}

	public Peca piece(int linha , int coluna) {
		if(!PositionExists(linha,coluna)) {
			throw new BoardException("Posicao inexistente");
		}
		return pcs[linha][coluna];
	}
	
	public Peca piece(Posicao pos) {
		if(!PositionExists(pos)) {
			throw new BoardException("Posicao inexistente");
		}
		return pcs[pos.getLinha()][pos.getColuna()];
	}
	
	public void placePiece(Peca piece , Posicao pos) {
		if(Tempeca(pos)) {
			throw new BoardException("Ja possui uma peca na posicao: " + pos);
		}
		
		pcs[pos.getLinha()][pos.getColuna()] = piece;
		piece.pos = pos;
	}
	
	public 	Peca RemovePiece(Posicao pos) {
		if(!PositionExists(pos)) {
			throw new BoardException("Posicao inexistente");
		}
		if(piece(pos) == null) {
			return null;
		}
		
		Peca aux = piece(pos);
		aux.pos = null;
		pcs[pos.getLinha()][pos.getColuna()] = null;
		return aux;
	}
	
	
	private boolean PositionExists(int linhas , int colunas) {
		return linhas >= 0 && linhas < linha && colunas >= 0 && colunas < coluna;
	}
	
	public boolean PositionExists(Posicao pos) {
		return PositionExists(pos.getLinha(),pos.getColuna());
	}
	
	public boolean Tempeca(Posicao p) {
		if(!PositionExists(p)) {
			throw new BoardException("Posicao inexistente");
		}
		
		return piece(p) != null;
	}
}