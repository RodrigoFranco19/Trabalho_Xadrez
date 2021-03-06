package xadrez;

import java.security.*;
import java.util.*;
import java.util.stream.*;
import Pecas.*;
import Tabuleiro_Jogo.*;

public class Partida {
	
private Tabuleiro tab;
private	int turn;
public Cor jog;
private boolean check;
private boolean checkMate;
private Xadrez_Peca enPassantVulnerabel;
private Xadrez_Peca promoted;

private List<Peca> noTabuleiro = new ArrayList();
private List<Peca> foraTabuleiro = new ArrayList();

	public Partida() {
		tab = new Tabuleiro(8,8);
		turn = 1;
		jog = Cor.WHITE;
		InicialSetUp();
	}
	
	public int getTurn() {
		return turn;
	}

	public Cor getJog() {
		return jog;
	}

	public boolean isCheck() {
		return check;
	}
	
	public boolean isCheckMate() {
		return checkMate;
	}
	
	public Xadrez_Peca getEnPassantVulnerabel() {
		return enPassantVulnerabel;
	}
	
	public Xadrez_Peca getPromoted() {
		return promoted;
	}
	
	public Xadrez_Peca[][] getPieces(){
		Xadrez_Peca[][]mat = new Xadrez_Peca[tab.getLinha()][tab.getColuna()];
		
		for(int i = 0 ; i < tab.getLinha() ; i++) {
			for(int j = 0 ; j < tab.getColuna() ; j++) {
				mat[i][j] = (Xadrez_Peca) tab.piece(i,j);
			}}
		return mat;
	}
	
	public boolean [][] possibleMove(Xadrez_Posicao srcP){
		Posicao p = srcP.toPosition();
		validateSourcePosition(p);
		return tab.piece(p).possibleMoves();
	}
	
	public Xadrez_Peca performChessMove(Xadrez_Posicao src , Xadrez_Posicao tgt) {
		Posicao source = src.toPosition();
		Posicao target = tgt.toPosition();
		
		validateSourcePosition(source);
		validateTargetPosition(source,target);
		Peca capturada = makeMove(source,target);
		
		if(TestCheck(jog) == true) {
			UndoMove(source,target,capturada);
			throw new ChessException("Voce nao pode se colocar em cheque");
		}
		
		
		Xadrez_Peca movida = (Xadrez_Peca) tab.piece(target);
	//Promoted	
		promoted = null;
		if(movida instanceof Piao) {
			if((movida.getC() == Cor.WHITE && source.getLinha() == 0) || (movida.getC() == Cor.WHITE && source.getLinha() == 7)) {
				promoted = (Xadrez_Peca) tab.piece(target);
				promoted = ReplacePromotedPiece("Q");
			}
		}
		
		check = (TestCheck(opponent(jog))) ? true:false;
		
		if(TestCheckMate(opponent(jog))) {
			checkMate = true;
			
		}else {
		nextTurn();
		}
		
		
	//enPassant	
		if(movida instanceof Piao && (target.getLinha() == source.getLinha() - 2 ||target.getLinha() == source.getLinha() + 2)) {
			enPassantVulnerabel = movida;
		}else {
			enPassantVulnerabel = null;
		}
		
		return (Xadrez_Peca) capturada;
	}

	
	private void validateSourcePosition(Posicao p) {
		if(!tab.Tempeca(p)) {
			throw new ChessException("Nao existe peca na posicao de origem");
		}
		
		if(jog != ((Xadrez_Peca)tab.piece(p)).getC()) {
			throw new ChessException("a peca escolhida nao � sua");
		}
				
		if(!tab.piece(p).isThereAnyPossibleMove()) {
			throw new ChessException("Nao existe movimentos possiveis para a pe�a escolhida");
		}}
	
	
	
	private void validateTargetPosition(Posicao src , Posicao tgt) {
		if(!tab.piece(src).possibleMove(tgt)) {
			throw new ChessException("A peca escolhida nao pode se mover na posicao de destino");
		}}
	
	
	
	public Xadrez_Peca ReplacePromotedPiece(String type) {
		if(promoted == null) {
			throw new IllegalStateException("Nao ha pe�a para ser promovida");
		}
		
		if(!type.equals("B") && !type.equals("Q") && !type.equals("C") && !type.equals("T")) {
			throw new InvalidParameterException("Tipo invalido para promover");
		}
		
		Posicao pos = promoted.getChessPos().toPosition();
		Peca p = tab.RemovePiece(pos);
		noTabuleiro.remove(p);
		
		
		Xadrez_Peca newPiece = newPiece(type,promoted.getC());
		tab.placePiece(newPiece, pos);
		noTabuleiro.add(newPiece);
		
		return newPiece;
	}
	
	private Xadrez_Peca newPiece(String type , Cor c) {
		if(type.equals("B")) return new Bispo(tab,c);
		if(type.equals("C")) return new Cavalo(tab,c);
		if(type.equals("Q")) return new Rainha(tab,c);
		return new Torre(tab,c);
	}
	
	private Peca makeMove(Posicao src , Posicao tgt) {
		Xadrez_Peca p = (Xadrez_Peca)tab.RemovePiece(src);
		p.IncreaseMoveCount();
		
		Peca capturar = tab.RemovePiece(tgt);
		tab.placePiece(p, tgt);

		if(capturar != null) {
			noTabuleiro.remove(capturar);
			foraTabuleiro.add(capturar);
		}
		
		
	//Movimento_Especial
		//Pequeno
		if(p instanceof Rei && tgt.getColuna() == src.getColuna() + 2) {
			Posicao srcT = new Posicao(src.getLinha(),src.getColuna() + 3);
			
			Posicao tgtT = new Posicao(src.getLinha(),src.getColuna() + 1);
			
			Xadrez_Peca torre = (Xadrez_Peca) tab.RemovePiece(srcT);
			tab.placePiece(torre, tgtT);
			torre.IncreaseMoveCount();
		}
		
		//Grande
		if(p instanceof Rei && tgt.getColuna() == src.getColuna() - 2) {
			Posicao srcT = new Posicao(src.getLinha(),src.getColuna() - 4);
			
			Posicao tgtT = new Posicao(src.getLinha(),src.getColuna() - 1);
			
			Xadrez_Peca torre = (Xadrez_Peca) tab.RemovePiece(srcT);
			tab.placePiece(torre, tgtT);
			torre.IncreaseMoveCount();
		}
		
		
	//EnPassant
		if(p instanceof Piao) {
			if(src.getColuna() != tgt.getColuna() && capturar == null) {
				Posicao piao;
				
				if(p.getC() == Cor.WHITE) {
					piao = new Posicao(tgt.getLinha() + 1 ,tgt.getColuna());
				}else {
					piao = new Posicao(tgt.getLinha() - 1 ,tgt.getColuna());
				}
				capturar = tab.RemovePiece(piao);
				foraTabuleiro.add(capturar);
				noTabuleiro.remove(capturar);
			}
		}
		
		return capturar;
	}
	
	private void UndoMove(Posicao src , Posicao tgt , Peca capt) {
		Xadrez_Peca p = (Xadrez_Peca)tab.RemovePiece(tgt);
		p.DecreaseMoveCount();
		
		tab.placePiece(p, src);
		
		if(capt != null) {
			tab.placePiece(capt, tgt);
			noTabuleiro.add(capt);
			foraTabuleiro.remove(capt);
		}
	
		
	//Movimento_Especial
		//Pequeno
		if(p instanceof Rei && tgt.getColuna() == src.getColuna() + 2) {
			Posicao srcT = new Posicao(src.getLinha(),src.getColuna() + 3);
			
			Posicao tgtT = new Posicao(src.getLinha(),src.getColuna() + 1);
			
			Xadrez_Peca torre = (Xadrez_Peca) tab.RemovePiece(tgtT);
			tab.placePiece(torre, srcT);
			torre.DecreaseMoveCount();
		}
		
		//Grande
		if(p instanceof Rei && tgt.getColuna() == src.getColuna() - 2) {
			Posicao srcT = new Posicao(src.getLinha(),src.getColuna() - 4);
			
			Posicao tgtT = new Posicao(src.getLinha(),src.getColuna() - 1);
			
			Xadrez_Peca torre = (Xadrez_Peca) tab.RemovePiece(tgtT);
			tab.placePiece(torre, srcT);
			torre.IncreaseMoveCount();
		}
		
	//Enpassant	
		if(p instanceof Piao) {
			if(src.getColuna() != tgt.getColuna() && capt == enPassantVulnerabel) {
				Xadrez_Peca pi = (Xadrez_Peca) tab.RemovePiece(tgt);
				Posicao piao;
				
				if(p.getC() == Cor.WHITE) {
					piao = new Posicao(3,tgt.getColuna());
				}else {
					piao = new Posicao(4,tgt.getColuna());
				}
				
				tab.placePiece(pi, piao);
			}
		}
	}
	
	private void nextTurn() {
		turn ++;
		jog = (jog == Cor.WHITE) ? Cor.BLACK : Cor.WHITE;
	}
	
	private Cor opponent(Cor c) {
		return (c == Cor.WHITE) ? Cor.BLACK : Cor.WHITE;
	}
	
	private Xadrez_Peca rei(Cor c) {
		List<Peca> lista = noTabuleiro.stream().filter(x -> ((Xadrez_Peca)x).getC() == c).collect(Collectors.toList());
		
		for(Peca p: lista) {
			if(p instanceof Rei){
				return (Xadrez_Peca) p;
			}}
		
		throw new IllegalStateException("Nao existe o rei da cor " + c + " No tabuleiro"); 
	}
	
	private boolean TestCheck(Cor col) {
		
		Posicao rp = rei(col).getChessPos().toPosition();
		List<Peca> peca_oponente = noTabuleiro.stream().filter(x -> ((Xadrez_Peca)x).getC() == opponent(col)).collect(Collectors.toList());
		
		for(Peca p : peca_oponente) {
			boolean[][] mat = p.possibleMoves();
			
			if(mat[rp.getLinha()][rp.getColuna()]) {
				return true;
			}}
		
		return false;
	}
	
	
	private boolean TestCheckMate(Cor col) {
		if(!TestCheck(col)) {
			return false;
		}
		
		List<Peca> list = noTabuleiro.stream().filter(x -> ((Xadrez_Peca)x).getC() == opponent(col)).collect(Collectors.toList());
		
		for(Peca p : list) {
			boolean [][] mat = p.possibleMoves();
			
			for(int i = 0 ; i <tab.getLinha() ; i++) {
				for(int j = 0 ; j <  tab.getColuna() ; j++) {
					if(mat[i][j]) {
						
						Posicao src = ((Xadrez_Peca)p).getChessPos().toPosition();
						Posicao tgt = new Posicao(i,j);
						Peca capt = makeMove(src,tgt);
						
						boolean testCheck = TestCheck(col);
						UndoMove(src,tgt,capt);
						
						if(!testCheck) {
							return false;
						}}
					}}
			}
		return true;
	}

	private void placeNewPiece(char column , int row , Xadrez_Peca piece) {
		tab.placePiece(piece, new Xadrez_Posicao(column,row).toPosition());
		noTabuleiro.add(piece);
	}
	
	public void InicialSetUp() {
		placeNewPiece('a',8,new Torre(tab, Cor.WHITE));
		placeNewPiece('b',8,new Cavalo(tab,Cor.WHITE));
		placeNewPiece('c',8,new Bispo(tab,Cor.WHITE));
		placeNewPiece('d',8,new Rainha(tab,Cor.WHITE));
		placeNewPiece('e',8,new Rei(tab,Cor.WHITE,this));
		placeNewPiece('f',8,new Bispo(tab,Cor.WHITE));
		placeNewPiece('g',8,new Cavalo(tab,Cor.WHITE));
		placeNewPiece('h',8,new Torre(tab, Cor.WHITE));
		placeNewPiece('a',7,new Piao(tab,Cor.WHITE,this));
		placeNewPiece('b',7,new Piao(tab,Cor.WHITE,this));
		placeNewPiece('c',7,new Piao(tab,Cor.WHITE,this));
		placeNewPiece('d',7,new Piao(tab,Cor.WHITE,this));
		placeNewPiece('e',7,new Piao(tab,Cor.WHITE,this));
		placeNewPiece('f',7,new Piao(tab,Cor.WHITE,this));
		placeNewPiece('g',7,new Piao(tab,Cor.WHITE,this));
		placeNewPiece('h',7,new Piao(tab,Cor.WHITE,this));
		
		placeNewPiece('a',1,new Torre(tab,Cor.BLACK));
		placeNewPiece('b',1,new Cavalo(tab,Cor.BLACK));
		placeNewPiece('c',1,new Bispo(tab,Cor.BLACK));
		placeNewPiece('d',1,new Rainha(tab,Cor.BLACK));
		placeNewPiece('e',1,new Rei(tab,Cor.BLACK,this));
		placeNewPiece('f',1,new Bispo(tab,Cor.BLACK));
		placeNewPiece('g',1,new Cavalo(tab,Cor.BLACK));
		placeNewPiece('h',1,new Torre(tab,Cor.BLACK));
		placeNewPiece('a',2,new Piao(tab,Cor.BLACK,this));
		placeNewPiece('b',2,new Piao(tab,Cor.BLACK,this));
		placeNewPiece('c',2,new Piao(tab,Cor.BLACK,this));
		placeNewPiece('d',2,new Piao(tab,Cor.BLACK,this));
		placeNewPiece('e',2,new Piao(tab,Cor.BLACK,this));
		placeNewPiece('f',2,new Piao(tab,Cor.BLACK,this));
		placeNewPiece('g',2,new Piao(tab,Cor.BLACK,this));
		placeNewPiece('h',2,new Piao(tab,Cor.BLACK,this));
	}
}