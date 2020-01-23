package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import xadrez.ChessException;
import xadrez.Partida;
import xadrez.Xadrez_Peca;
import xadrez.Xadrez_Posicao;

public class Programa {
	public static void main(String[] args) {
		Partida p = new Partida();
		
		Scanner sc =new Scanner(System.in);
		
		while(true) {
			try {
	//	Imprimir.clearScreen();
		Imprimir.printBoard(p.getPieces());
		System.out.println();
		
		System.out.print("Source:");
		Xadrez_Posicao p1 = Imprimir.readChessPosition(sc);
		
		System.out.println();
		System.out.print("Target");
		Xadrez_Posicao p2 = Imprimir.readChessPosition(sc);
		
		Xadrez_Peca capturada = p.performChessMove(p1, p2);
			
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
