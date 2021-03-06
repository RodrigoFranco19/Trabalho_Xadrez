package application;

import java.util.*;
import java.util.stream.*;
import xadrez.*;

public class Imprimir {
	
/*	public static final String ANSI_RESET = "\u001B[0m";

	public static final String ANSI_BLACK = "\u001B[30m";

	public static final String ANSI_RED = "\u001B[31m";

	public static final String ANSI_GREEN = "\u001B[32m";

	public static final String ANSI_YELLOW = "\u001B[33m";

	public static final String ANSI_BLUE = "\u001B[34m";

	public static final String ANSI_PURPLE = "\u001B[35m";

	public static final String ANSI_CYAN = "\u001B[36m";

	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";

	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";

	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";

	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";

	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";

	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";

	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";

	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
	
	
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}*/
	
	public static Xadrez_Posicao readChessPosition(Scanner sc) {
	try {
			
		String s = sc.nextLine();
		char column = s.charAt(0);
		int row = Integer.parseInt(s.substring(1));
		return new Xadrez_Posicao(column,row);
		
	}catch(RuntimeException e){
			throw new InputMismatchException("Erro ao ler posicao de xadrez");
	}}
	
	
	public static void printMatch(Partida part, List<Xadrez_Peca> capturar) {
		printBoard(part.getPieces());
		System.out.println();
		printCaptured(capturar);
		System.out.println();
		System.out.println("Turno: " + part.getTurn());
				
		if(!part.isCheckMate()) {
			System.out.println("Jogador: " + part.getJog());
		}else {
			System.out.println("Cheque Mate");
			System.out.println("Vencedor: " + part.jog);
		}
		
		if(part.isCheck()) {
			System.out.println("CHECK!");
		}}
	
	
	public static void printBoard(Xadrez_Peca[][]pcs) {
		for(int i = 0 ; i < pcs.length ; i++) {
			System.out.print((8 -i) + " ");
			
			for(int j = 0 ; j < pcs.length ; j++) {
				printPiece(pcs[i][j],false);
			}
			
			System.out.println();
		}
		System.out.print("  a b c d e f g h");
	}
	
	
	public static void printBoard(Xadrez_Peca[][] pcs, boolean[][] possibleMoves) {
		for(int i = 0 ; i < pcs.length ; i++) {
			System.out.print((8 -i) + " ");
			
			for(int j = 0 ; j < pcs.length ; j++) {
				printPiece(pcs[i][j],possibleMoves[i][j]);
			}
			
			System.out.println();
		}
		System.out.print("  a b c d e f g h");
	}
	
	
	
	private static void printPiece(Xadrez_Peca piece,boolean background) {
		if(background) {
			System.out.print(/*ANSI_BLUE_BACKGROUND + */"x");
		}
		if(piece == null) {
			System.out.print("-" /*+ ANSI_RESET*/);
		}else {
			if(piece.getC() == Cor.WHITE) {
				System.out.print(/*ANSI_WHITE +*/ piece /*+ ANSI_RESET*/);
			}else {
				System.out.print(/*ANSI_YELLOW +*/ piece /*+ ANSI_RESET*/);
			}
		}
		System.out.print(" ");
	}

	
	private static void printCaptured(List<Xadrez_Peca>capturada) {
		List<Xadrez_Peca> branca = capturada.stream().filter(x -> x.getC() == Cor.WHITE).collect(Collectors.toList());
		List<Xadrez_Peca> preta = capturada.stream().filter(x -> x.getC() == Cor.BLACK).collect(Collectors.toList());
		
		System.out.println("Capturadas:");
		System.out.print("White:");
	//	System.out.print(ANSI_WHITE);
		System.out.println(Arrays.toString(branca.toArray()));
		//System.out.print(ANSI_RESET);

		System.out.print("Black:");
		//System.out.print(ANSI_YELLOW);
		System.out.println(Arrays.toString(preta.toArray()));
		//System.out.print(ANSI_RESET);
	}
}