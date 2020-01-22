package application;

import xadrez.Partida;

public class Programa {
	public static void main(String[] args) {
		Partida p = new Partida();
		Imprimir.printBoard(p.getPieces());
		
	}
}
