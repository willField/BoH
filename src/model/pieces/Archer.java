package model.pieces;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import model.Player;

public class Archer extends Piece {

	private ImageIcon icon;
	private Player player;
	protected final int STR = 2;
	protected final int HEALTH = 2;
	protected final int MOVES = 0;
	
	public Archer(Player player) {
		strength = STR;
		health = HEALTH;
		moves = MOVES;
		this.setPlayer(player);
		try {
			icon = new ImageIcon(ImageIO.read(getClass().getResource("/bow.png")));
		} catch(IOException e){
		
		}
	}
	@Override
	public int getSTR() {
		return STR;
	}
	@Override
	public int getMOVES() {
		return MOVES;
	}
	
	@Override
	public void resetStats() {
		strength = STR;
		health = HEALTH;
		moves = MOVES;
	}
	
	@Override
	public ImageIcon getIcon() {
		return icon;
	}
	@Override
	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
}
