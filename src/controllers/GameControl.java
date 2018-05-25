package controllers;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;

import model.GameEngine;
import model.GameState;
import model.Player;
import model.pieces.Piece;
import view.GameBoardUtilities;
import view.GamePanel;
import view.HexButton;

public class GameControl {

	private GameEngine ge;
	private GamePanel gp;
	private JFrame frame;
	private GameState gs;
	private Player currentPlayer;
	private int test = 0;
	
	GameControl(GameEngine ge, GamePanel gp, JFrame frame){
		this.ge = ge;
		this.gp = gp;
		this.frame = frame;
		
		ge.setCurrentPlayer(ge.getPlayers().get(0));
		assignPlayerStartPieces();
		GameState gs = new GameState();
		gs.saveData(gp, ge);
		ge.addToHistory(gs);
		playerTurn(ge.getPlayers().get(0));
	}
	
	GameControl(GameEngine ge, GamePanel gp, JFrame frame, GameState gs){
		this.ge = ge;
		this.gp = gp;
		this.frame = frame;
		this.gs = gs;
		
		
		restorePlayerPieceLocations();
		for(Player player : ge.getPlayers()) {
			if(player.getName() == gs.getPlayerTurn()) {
				playerTurn(player);
			}
		}
		
	}
	
	
	public void assignPlayerStartPieces() {
		
		ge.addPlayerStartingPieces();
		
		Iterator<Piece> pieceIterator = ge.getAllPlayerPieces().iterator();
		Iterator<HexButton> buttonIterator = gp.getStartingLocations().iterator();
		
		while(pieceIterator.hasNext() && buttonIterator.hasNext()) {
			buttonIterator.next().setPiece(pieceIterator.next());
		}
		
	}
	
	public void restorePlayerPieceLocations(){
		ArrayList<int[]> xyLocations = gs.getPlayer1PieceLocations();
		xyLocations.addAll(gs.getPlayer2PieceLocations());
		
		Iterator<Piece> pieceIterator = ge.getAllPlayerPieces().iterator();
		Iterator<int[]> xyIterator = xyLocations.iterator();
		
		while(pieceIterator.hasNext() && xyIterator.hasNext()) {
			int xy[] = xyIterator.next();
			gp.getBoard()[xy[0]][xy[1]].setPiece(pieceIterator.next());
		}
		
	}
	 
	public Player nextPlayer(Player player) {
		
		for(int i = 0; i < ge.getPlayers().size()-1; i++) {
			if(ge.getPlayers().get(i) == player) {
				return ge.getPlayers().get(i+1);
			}
		}
		return ge.getPlayers().get(0);
	}
	
	public void nextTurn() {
		for(Piece piece : ge.getAllPlayerPieces()) 
			piece.resetStats();
		
		GameBoardUtilities gu = new GameBoardUtilities(gp);
		gu.removeAllListeners();
		gu.recolor();
		gu.transferFocus();
		GameState gs = new GameState();
		gs.saveData(gp, ge);
		ge.addToHistory(gs);
		playerTurn(nextPlayer(currentPlayer));
	}
	
	public void playerTurn(Player player) {
		this.setCurrentPlayer(player);
		ge.setCurrentPlayer(player);
		new TurnControl(currentPlayer, ge, gp);
	}
	
	public void updateTextArea(String name) {
		gp.getTextArea().append(name);
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	
	
}
