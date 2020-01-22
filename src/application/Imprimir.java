package application;

import xadrez.Xadrez_Peca;

public class Imprimir {

	public static void printBoard(Xadrez_Peca[][]pcs) {
		for(int i = 0 ; i < pcs.length ; i++) {
			System.out.print((8 -i) + " ");
			for(int j = 0 ; j < pcs.length ; j++) {
				printPiece(pcs[i][j]);
			}
			System.out.println();
		}
		System.out.print("  a b c d e f g h");
	}
	
	private static void printPiece(Xadrez_Peca piece) {
		if(piece == null) {
			System.out.print("-");
		}else {
			System.out.print(piece);
		}
		System.out.print(" ");
	}
	
}
