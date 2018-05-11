package model.pieces;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import model.Player;

public class Horsemen extends Piece {

	private int strength;
	private int moves;
	private Image image;
	private ImageIcon icon;
	private Player player;
	
	public Horsemen(Player player) {
		this.setPlayer(player);
		try {
			image = ImageIO.read(new File("src/resources/horse.png"));
			icon = new ImageIcon(image);
		} catch(IOException e){
		
		}
	
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
