package model;

import java.util.ArrayList;

import controllers.GameControl;
import model.pieces.Archer;
import model.pieces.Footman;
import model.pieces.Piece;
import model.pieces.Pikeman;

public class GameEngine {

	private static int GAME_SIZE;
	private static int NUM_PIECES;
	
	private ArrayList<Player> players = new ArrayList<Player>();
	
	
	
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	private GameControl gc;
	
	public GameEngine(int GAME_SIZE, int NUM_PIECES){
		GameEngine.GAME_SIZE = GAME_SIZE;
		GameEngine.NUM_PIECES = NUM_PIECES;
		
	}
	
	public void addPlayerStartingPieces() {
		for(Player player : players) {
			
			// TODO: implement pieces based on chosen number of pieces in game
			player.addPiece(new Footman(player));
			player.addPiece(new Pikeman(player));
			player.addPiece(new Archer(player));
			player.addPiece(new Pikeman(player)); 
			player.addPiece(new Footman(player));
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
}
