package controllers;

import model.GameEngine;
import view.GamePanel;
import view.HexButton;

public class GameControl {

	private GameEngine ge;
	private GamePanel gp;
	
	GameControl(GameEngine ge, GamePanel gp){
		this.ge = ge;
		this.gp = gp;
		
		ge.addPlayerStartingPieces();
		for(HexButton button : gp.getStartingLocations()) {
			
		}
	}
	
	
	
}
