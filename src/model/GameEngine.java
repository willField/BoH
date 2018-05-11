package model;

import java.util.ArrayList;

import model.pieces.Archer;
import model.pieces.Footman;
import model.pieces.Pikeman;

public class GameEngine {

	private static int GAME_SIZE;
	private static int NUM_PIECES;
	
	private ArrayList<Player> players = new ArrayList<Player>();
	
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

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void addPlayer(Player player) {
		players.add(player);
	}
}
