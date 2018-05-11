package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GamePanel extends JPanel{
	
	private JFrame frame;
	private HexButton[][] board;
	private int size;
	private Boolean coords;
	private ArrayList<HexButton> startingLocations = new ArrayList<HexButton>();
	
	public GamePanel(JFrame frame, int size, Boolean coords){
		this.coords = coords;
		this.frame = frame;
		this.size = size;
		board = new HexButton[size][size];
		this.setBackground(Color.BLACK);
		this.setLayout(new BorderLayout());
		loadBoard();
		cropBoard();
		this.add(new GameMenuBar(frame, this), BorderLayout.NORTH);
		frame.setSize(new Dimension(size*91, size * 88 + 15));
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	private void cropBoard() {
		
		int xAStart = 0;
		int xVisibleLength = (size + 1 ) / 2;
		int xVisibleStart = (size - xVisibleLength)/2;
		int xBStart = xVisibleLength + xVisibleStart;
		
		// DO THIS
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if((j == 0 || (j == size - 1 && i%2 == 0))&& i != (size)/2) {
            		board[i][j].setVisible(false);
            	}
            	if((j == 1 || j == size - 1) && (i < size/4 || i > 3*size/4)) {
            		board[i][j].setVisible(false);
            	}
            	if(j == size - 2 && (i == 0 || i == size -1)) {
            		board[i][j].setVisible(false);
            	}
			}
		}
	}
	
	private void loadBoard() {
		
		int offsetX = 0;
		int offsetY = 50;
		
		if(size % 4 == 3) {
			offsetX = 45;
		}
		
		for(int i = 0; i<size; i++) {
			for(int j = 0; j < size; j++){
				
				HexButton button = new HexButton(offsetX, offsetY, i , j, coords);
				
				if(i == 0 || i == size-1) {
					startingLocations.add(button);
				}
				
				offsetX += 90;
            	this.add(button);
            	board[i][j] = button;
			}
			if(size % 4 != 3) {

				if(i%2 == 0) {
	                offsetX = -45;
	            } else {
	                offsetX = 0;
	            }
			}
			else {
				if(i%2 == 0) {
	                offsetX = 0;
	            } else {
	                offsetX = 45;
	            }
			}
            offsetY += 75;
            
		}
	}

	public ArrayList<HexButton> getStartingLocations() {
		return startingLocations;
	}
}
