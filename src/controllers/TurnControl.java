package controllers;

import java.awt.Color;
import java.util.ArrayList;

import model.GameEngine;
import model.Player;
import view.GamePanel;
import view.HexButton;
import view.TurnListener;

public class TurnControl {
	
	private Player player;
	private GameEngine ge;
	private GamePanel gp;
	private MovementControl mc;

	public TurnControl(Player player, GameEngine ge, GamePanel gp) {
		this.player = player;
		this.ge = ge;
		this.gp = gp;
		
		addPlayerAvailableListener();
		
	}
	
	public void addPlayerAvailableListener() {
		for(HexButton hex : getPlayerPieceLocations()) {
			hex.addMouseListener(new TurnListener(hex, getPlayerPieceLocations(), gp, this));
			hex.setBorderColor(Color.CYAN);
		}
	}
	
	public ArrayList<HexButton> getPlayerPieceLocations(){
		ArrayList<HexButton> playerHexes = new ArrayList<HexButton>();
		for(HexButton hex : gp.getPieceLocations()) {
			if(hex.getPiece().getPlayer() == player) {
				playerHexes.add(hex);
			}
		}
		return playerHexes;
	}
	
	public void finishedTurn() {
		ge.getGc().nextTurn();
	}
}
