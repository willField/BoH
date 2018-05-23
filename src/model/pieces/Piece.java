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
	
	private int strength = 0;
	private int moves = 0;
	private Image image;
	private ImageIcon icon;
	private int[] location;
	private Player player;
	
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
	
	public Player getPlayer() {
		return player;
	}
	public int getStrength() {
		return strength;
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
	
	
}
