package model;

import java.util.ArrayList;

import controllers.GameControl;
import model.pieces.Archer;
import model.pieces.Footman;
import model.pieces.Horsemen;
import model.pieces.Piece;
import model.pieces.Pikeman;

public class GameEngine {

	private int GAME_SIZE;
	private int NUM_PIECES;
	
	private ArrayList<Player> players = new ArrayList<Player>();
	private Player currentPlayer;
	private ArrayList<GameState> history = new ArrayList<GameState>();
	
	
	public void setHistory(ArrayList<GameState> history) {
		this.history = history;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	private GameControl gc;
	
	public GameEngine(int GAME_SIZE, int NUM_PIECES){
		this.GAME_SIZE = GAME_SIZE;
		this.NUM_PIECES = NUM_PIECES;
		
	}
	
	public void addPlayerStartingPieces() {
		for(int i = 0; i < players.size(); i++) {
			
			// TODO: implement pieces based on chosen number of pieces in game
			if(i == 0) {
				
				players.get(i).addPiece(new Footman(players.get(i)));
				players.get(i).addPiece(new Pikeman(players.get(i)));
				players.get(i).addPiece(new Archer(players.get(i)));
				players.get(i).addPiece(new Pikeman(players.get(i)));
				players.get(i).addPiece(new Footman(players.get(i)));
				
				if(NUM_PIECES == 2) {
					players.get(i).addPiece(new Footman(players.get(i)));
					players.get(i).addPiece(new Pikeman(players.get(i)));
					players.get(i).addPiece(new Archer(players.get(i)));
					players.get(i).addPiece(new Archer(players.get(i)));
					players.get(i).addPiece(new Pikeman(players.get(i)));
					players.get(i).addPiece(new Footman(players.get(i)));
				}
			}
			
			else if(i == 1) {
				
				if(NUM_PIECES == 2) {
					players.get(i).addPiece(new Footman(players.get(i)));
					players.get(i).addPiece(new Horsemen(players.get(i)));
					players.get(i).addPiece(new Archer(players.get(i)));
					players.get(i).addPiece(new Archer(players.get(i)));
					players.get(i).addPiece(new Horsemen(players.get(i)));
					players.get(i).addPiece(new Footman(players.get(i)));
				}
				
				players.get(i).addPiece(new Footman(players.get(i)));
				players.get(i).addPiece(new Horsemen(players.get(i)));
				players.get(i).addPiece(new Archer(players.get(i)));
				players.get(i).addPiece(new Horsemen(players.get(i)));
				players.get(i).addPiece(new Footman(players.get(i)));
				
				
			}
			
		}
	}
	
	public ArrayList<Piece> getAllPlayerPieces() {
		ArrayList<Piece> allPlayerPieces = new ArrayList<Piece>();
		for(Player player : players) {
			for(Piece piece : player.getPieces()) {
				allPlayerPieces.add(piece);
				
			}
		}
		return allPlayerPieces;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void addPlayer(Player player) {
		players.add(player);
	}

	public GameControl getGc() {
		return gc;
	}

	public void setGc(GameControl gc) {
		this.gc = gc;
	}

	public int getGAME_SIZE() {
		return GAME_SIZE;
	}

	public int getNUM_PIECES() {
		return NUM_PIECES;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public ArrayList<GameState> getHistory() {
		return history;
	}

	public void addToHistory(GameState gs) {
		history.add(gs);
	}
}
