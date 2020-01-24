package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import xadrez.ChessException;
import xadrez.Partida;
import xadrez.Xadrez_Peca;
import xadrez.Xadrez_Posicao;

public class Programa {
	public static void main(String[] args) {
		Partida p = new Partida();
		
		Scanner sc =new Scanner(System.in);
		
		List<Xadrez_Peca> capturar = new ArrayList();
		
		while(true) {
			try {
		//Imprimir.clearScreen();
				
		Imprimir.printMatch(p,capturar);
		System.out.println();
		
		System.out.print("Source:");
		Xadrez_Posicao p1 = Imprimir.readChessPosition(sc);
		
		boolean[][] possibleMoves = p.possibleMove(p1);
		Imprimir.clearScreen();
		Imprimir.printBoard(p.getPieces(),possibleMoves);

		System.out.println();
		System.out.print("Target:");
		Xadrez_Posicao p2 = Imprimir.readChessPosition(sc);
		
		Xadrez_Peca capturada = p.performChessMove(p1, p2);
			
		if(capturada != null) {
			capturar.add(capturada);
		}
		
		}catch(ChessException e) {
			System.out.println(e.getMessage());
			sc.nextLine();
		}
		
		catch(InputMismatchException e) {
			System.out.println(e.getMessage());
			sc.nextLine();
		}}
}
}