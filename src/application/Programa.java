package application;

import java.util.*;
import xadrez.*;

public class Programa {
	public static void main(String[] args) {
		
		Partida p = new Partida();
		Scanner sc =new Scanner(System.in);
		List<Xadrez_Peca> capturar = new ArrayList();
		
		while(!p.isCheckMate()) {
		try {
		//Imprimir.clearScreen();	
		Imprimir.printMatch(p,capturar);
		System.out.println();
		
		System.out.print("Source:");
		Xadrez_Posicao p1 = Imprimir.readChessPosition(sc);
		
		System.out.println();
		System.out.print("Target:");
		Xadrez_Posicao p2 = Imprimir.readChessPosition(sc);
		
		boolean[][] possibleMoves = p.possibleMove(p1);
		//Imprimir.clearScreen();
		Imprimir.printBoard(p.getPieces(),possibleMoves);

		Xadrez_Peca capturada = p.performChessMove(p1, p2);
			
		if(capturada != null) {
			capturar.add(capturada);
		}
		
		if(p.getPromoted() != null) {
			System.out.println("Digite a peca para a promocao (B/Q/T/C)");
			String promovida = sc.nextLine();
			p.ReplacePromotedPiece(promovida);
		}
		
		}catch(ChessException e) {
			System.out.println(e.getMessage());
			sc.nextLine();
			
		}catch(InputMismatchException e) {
			System.out.println(e.getMessage());
			sc.nextLine();
		}}	
		
		Imprimir.clearScreen();
		Imprimir.printMatch(p, capturar);
}
}