/*******************************************************************************
 * Laurence Ashdown
 * OOSD Assignment
 * RMIT Semester 1 2018
 ******************************************************************************/
package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

import javax.swing.JButton;

import model.pieces.Piece;

/**
 * The HexButton class is an extension of JButton which is the basis for the hexagons on
 * which the game is played. Using trigonometry the hexagons are drawn based on a 100px
 * sized button.
 * 
 * The buttons also store a player's game piece, and using the setPiece function, sets the
 * piece and also takes it's corresponding icon, and applies it to the HexButton.
 * @author laurence
 *
 */

public class HexButton extends JButton{

	private static final long serialVersionUID = 1L;
	static int aSide = (int) (45 * Math.tan(Math.toRadians(30)));
	static int xPoints[] = {50, 90, 90, 50, 10, 10};
	static int yPoints[] = {5, aSide+5, 95-aSide, 95, 95-aSide, aSide+5};
    static BasicStroke stroke = new BasicStroke ( 5f );
    private Color color = Color.RED;
    private Color borderColor = Color.DARK_GRAY;
    private int x, y;
    private Piece piece;
   
   
    public HexButton(int offsetX, int offsetY, int i, int j, Boolean coords) {
    	this.setBounds(offsetX, offsetY, 100, 100);
    	this.setPreferredSize(new Dimension(100, 100));
    	this.setBorderPainted(false);
    	this.setMargin(new Insets(0,0,0,0));
    	this.setContentAreaFilled(false);
    	this.setFocusPainted(false);
    	if(coords) {
    		this.setForeground(Color.WHITE);
    		this.setText("[" + Integer.toString(i) + ", " + Integer.toString(j)+ "]");
    	}
    	
	}
    
    public Boolean hasPiece() {
    	if(piece == null) {
    		return false;
    	}
    	else
    	{
    		return true;
    	}
    }
    
    public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	
	public void drawHex(Graphics2D g, Color color) {
		g.setStroke(stroke);
		g.setColor (color);
        g.fillPolygon ( xPoints, yPoints, 6 );
        g.setColor (borderColor);
        g.drawPolygon ( xPoints, yPoints, 6 );
        g.setBackground(color);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2D = ( Graphics2D ) g;
        drawHex(g2D, color);
        super.paintComponent(g);
	}

	/**
	 * @return the x
	 */
	public int getHexX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setHexX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getHexY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setHexY(int y) {
		this.y = y;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		if(piece != null) {
			this.piece = piece;
			this.setIcon(piece.getIcon());
		}
		else {
			this.setIcon(null);
			this.piece = null;
		}
		
		
	}
	

	

	
}
