package model;

import java.io.Serializable;
import java.util.ArrayList;

import model.pieces.Archer;
import model.pieces.Footman;
import model.pieces.Horsemen;
import model.pieces.Piece;
import model.pieces.Pikeman;
import view.GamePanel;
import view.HexButton;

public class GameState implements Serializable {

	private static final long serialVersionUID = 1L;

	private ArrayList<String> playerNames = new ArrayList<String>();
	private ArrayList<String> player1Pieces = new ArrayList<String>();
	private ArrayList<String> player2Pieces = new ArrayList<String>();
	private ArrayList<int[]> player1PieceLocations = new ArrayList<int[]>();
	private ArrayList<int[]> player2PieceLocations = new ArrayList<int[]>();
	private int size;
	private int numPieces;
	private String playerTurnName;
	private ArrayList<GameState> gameStates = new ArrayList<GameState>();

	public ArrayList<GameState> getGameStates() {
		return gameStates;
	}

	public void saveGameStates(GameEngine ge) {
		for (GameState gs : ge.getHistory()) {
			gameStates.add(gs);
		}
	}

	public void saveNames(ArrayList<Player> players, GamePanel gp) {
		int i = 0;
		for (Player player : players) {
			playerNames.add(player.getName());
			if (i == 0) {
				saveP1Pieces(player, gp);
			}
			if (i == 1) {
				saveP2Pieces(player, gp);
			}
			i++;
		}
	}

	public ArrayList<int[]> getPlayer1PieceLocations() {
		return player1PieceLocations;
	}

	public ArrayList<int[]> getPlayer2PieceLocations() {
		return player2PieceLocations;
	}

	public int getSize() {
		return size;
	}

	public int getNumPieces() {
		return numPieces;
	}

	public void saveP1Pieces(Player player, GamePanel gp) {
		for (Piece piece : player.getPieces()) {
			player1Pieces.add(piece.toString());
			System.out.println(piece.toString());

			for (HexButton button : gp.getPieceLocations()) {
				if (button.getPiece() == piece) {
					if (button.getPiece().getPlayer() == player) {
						int[] xy = new int[2];
						xy[0] = button.getHexX();
						xy[1] = button.getHexY();
						System.out.println(xy[0] + ", " + xy[1]);
						player1PieceLocations.add(xy);
					}
				}
			}
		}

	}

	public void saveP2Pieces(Player player, GamePanel gp) {
		for (Piece piece : player.getPieces()) {
			player2Pieces.add(piece.toString());
			System.out.println(piece.toString());

			for (HexButton button : gp.getPieceLocations()) {
				if (button.getPiece() == piece) {
					if (button.getPiece().getPlayer() == player) {
						int[] xy = new int[2];
						xy[0] = button.getHexX();
						xy[1] = button.getHexY();
						System.out.println(xy[0] + ", " + xy[1]);
						player2PieceLocations.add(xy);
					}
				}
			}
		}

	}

	public void saveData(GamePanel gp, GameEngine ge) {
		saveNames(ge.getPlayers(), gp);
		size = ge.getGAME_SIZE();
		numPieces = ge.getNUM_PIECES();
		setPlayerTurnName(ge.getCurrentPlayer().getName());
		saveGameStates(ge);

	}

	public GameEngine loadGameEngine() {

		int i = 0;

		GameEngine ge = new GameEngine(size, numPieces);
		ge.setHistory(getGameStates());

		for (String name : playerNames) {
			Player player = new Player(name);
			if (i == 0) {
				for (String pieceName : player1Pieces) {
					if (pieceName.equals("model.pieces.Archer")) {
						Piece piece = new Archer(player);
						player.addPiece(piece);
					} else if (pieceName.equals("model.pieces.Footman")) {
						Piece piece = new Footman(player);
						player.addPiece(piece);
					} else if (pieceName.equals("model.pieces.Horsemen")) {
						Piece piece = new Horsemen(player);
						player.addPiece(piece);
					} else if (pieceName.equals("model.pieces.Pikeman")) {
						Piece piece = new Pikeman(player);
						player.addPiece(piece);
					}
				}
				ge.addPlayer(player);
			}

			else if (i == 1) {
				for (String pieceName : player2Pieces) {
					if (pieceName.equals("model.pieces.Archer")) {
						Piece piece = new Archer(player);
						player.addPiece(piece);
					} else if (pieceName.equals("model.pieces.Footman")) {
						Piece piece = new Footman(player);
						player.addPiece(piece);
					} else if (pieceName.equals("model.pieces.Horsemen")) {
						Piece piece = new Horsemen(player);
						player.addPiece(piece);
					} else if (pieceName.equals("model.pieces.Pikeman")) {
						Piece piece = new Pikeman(player);
						player.addPiece(piece);
					}
				}
				ge.addPlayer(player);
			}

			i++;
		}

		return ge;
	}

	public String getPlayerTurn() {
		return playerTurnName;
	}

	public void setPlayerTurnName(String playerTurnName) {
		this.playerTurnName = playerTurnName;
	}

}
