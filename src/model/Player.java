package model;

import java.util.ArrayList;

import model.pieces.Piece;

public class Player {

	private String name;
	private ArrayList<Piece> pieces = new ArrayList<Piece>();
	
	public Player(String name){
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Piece> getPieces() {
		return pieces;
	}

	public void addPiece(Piece piece) {
		pieces.add(piece);
	}
}
