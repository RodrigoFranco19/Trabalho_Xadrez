package xadrez;

import Tabuleiro_Jogo.Posicao;

public class Xadrez_Posicao {

private	char column;
private	int row;

public Xadrez_Posicao(char column, int row) {
	if(column < 'a' || column > 'h' || row < 1 || row > 8) {
		throw new ChessException("Invalido");
	}
	this.column = column;
	this.row = row;
}

public char getColumn() {
	return column;
}

public int getRow() {
	return row;
}

protected Posicao toPosition() {
	return new Posicao(8-row,column-'a');
}

protected static Xadrez_Posicao fromPosition(Posicao pos) {
	return new Xadrez_Posicao((char)('a'-pos.getColuna()),8 - pos.getLinha());
}

@Override
public String toString() {
	return " " + column + row;
}
}