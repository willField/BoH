package model.pieces;

import java.awt.Image;

import javax.swing.ImageIcon;

import model.Player;

/** 
 * This is the base game piece class that all the pieces extend. Currently does not have
 * much implementation for part1 of the assignment.
 * 
 * @author laurence
 *
 */
public class Piece {
	
	
	protected int strength;
	protected int health;
	protected int moves;
	private Image image;
	private ImageIcon icon;
	private int[] location;
	private Player player;
	
	public void resetStats() {
	}
	
	public ImageIcon getIcon() {
		return icon;
	}
	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}
	public int[] getLocation() {
		return location;
	}
	public void setLocation(int[] location) {
		this.location = location;
	}
	
	@Override
	public String toString() {
		return this.getClass().getName();
	}
	
	public Player getPlayer() {
		return player;
	}
	public int getStrength() {
		return strength;
	}
	
	public int getHealth() {
		return health;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public int getMoves() {
		return moves;
	}
	public void setMoves(int moves) {
		this.moves = moves;
	}
	
	public int getSTR() {
		return 0;
	}
	public int getMOVES() {
		return 0;
	}
	
	
}
