package Tabuleiro_Jogo;

public abstract class Peca {

	protected Posicao pos;
	private Tabuleiro tab;
	
	public Peca(Tabuleiro tab) {
		this.tab = tab;
	}

	protected Tabuleiro getTab() {
		return tab;
	}
	
	public abstract boolean[][] possibleMoves();
		

	public boolean possibleMove(Posicao p1) {
		return possibleMoves()[p1.getLinha()][p1.getColuna()];
	}
	
	public boolean isThereAnyPossibleMove() {
		boolean [][] mat= possibleMoves();
		
		for(int i = 0 ; i < mat.length ; i++) {
			for(int j = 0 ; j < mat.length ; j++) {
				if(mat[i][j]) {
					return true;
				}}}

		return false;
	}
	
}
