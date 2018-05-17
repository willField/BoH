package controllers;

import java.awt.BorderLayout;
import java.util.Iterator;
import java.util.ListIterator;

import model.GameEngine;
import model.Player;
import model.pieces.Piece;
import view.GamePanel;
import view.GameBoardUtilities;
import view.GameMenuBar;
import view.HexButton;

public class GameControl {

	private GameEngine ge;
	private GamePanel gp;
	private Player currentPlayer;
	private TurnControl tc;
	private MenuControl mc;
	
	GameControl(GameEngine ge, GamePanel gp){
		this.ge = ge;
		this.gp = gp;
		
		assignPlayerStartPieces();
		playerTurn(ge.getPlayers().get(0));
		
		
	}
	
	public void assignPlayerStartPieces() {
		
		ge.addPlayerStartingPieces();
		
		Iterator<Piece> pieceIterator = ge.getAllPlayerPieces().iterator();
		Iterator<HexButton> buttonIterator = gp.getStartingLocations().iterator();
		
		while(pieceIterator.hasNext() && buttonIterator.hasNext()) {
			buttonIterator.next().setPiece(pieceIterator.next());
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
	
	public void updatePlayerPieces() {
		
	}
	
	public void nextTurn() {
		ge.addPlayerHistory();
		playerTurn(nextPlayer(currentPlayer));
	}
	
	public void playerTurn(Player player) {
		this.setCurrentPlayer(player);
		tc = new TurnControl(currentPlayer, ge, gp);
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
