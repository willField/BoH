package model;

import view.GamePanel;

public class Memento {

	private GamePanel gp;
	private GameEngine ge; 
	
	public Memento(GamePanel gp, GameEngine ge) {
		this.setGp(gp);
		this.setGe(ge);
	}

	public GamePanel getGp() {
		return gp;
	}

	public void setGp(GamePanel gp) {
		this.gp = gp;
	}

	public GameEngine getGe() {
		return ge;
	}

	public void setGe(GameEngine ge) {
		this.ge = ge;
	}

}
