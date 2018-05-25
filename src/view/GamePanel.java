package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controllers.MenuListener;
import controllers.MovementControl;

public class GamePanel extends JPanel{
	
	private JFrame frame;
	private HexButton[][] board;
	private MovementControl mc;
	private GameTimer gt;
	
	public void setBoard(HexButton[][] board) {
		this.board = board;
	}

	private int boardSize, numPieces;
	private Boolean coords;
	private ArrayList<HexButton> startingLocations = new ArrayList<HexButton>();
	private ArrayList<HexButton> pieceLocations;
	private GameTextArea textArea = new GameTextArea();
	private HexButton focus;

	public GamePanel(JFrame frame, int boardSize, Boolean coords, MenuListener ml){
		this.coords = coords;
		this.frame = frame;
		this.boardSize = boardSize;
		numPieces = ml.getNumPieces() ;
		board = new HexButton[boardSize][boardSize];
		this.setBorder(new CompoundBorder(new EmptyBorder(10,10,10,10), new LineBorder(Color.RED)));
		this.setBackground(Color.BLACK);
		this.setLayout(new BorderLayout());
		loadBoard();
		cropBoard();
		this.add(new GameMenuBar(frame, this, ml), BorderLayout.NORTH);
		this.add(textArea, BorderLayout.SOUTH);
				
		frame.setSize(new Dimension(boardSize*91+45, boardSize * 88 + 80));
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	private void cropBoard() {
		
		int xAStart = 0;
		int xVisibleLength = (boardSize + 1 ) / 2;
		int xVisibleStart = (boardSize - xVisibleLength)/2;
		int xBStart = xVisibleLength + xVisibleStart;
		
		// TODO: Board crop: (only works for boardSize 9 currently)
		// only odd values of boardSize will work, needs adjusting for 5, 7, 11, 13, 15
		
		for(int i = 0; i < boardSize; i++) {
			for(int j = 0; j < boardSize; j++) {
				if((j == 0 || (j == boardSize - 1 && i%2 == 0))&& i != (boardSize)/2) {
            		board[i][j].setVisible(false);
            	}
            	if((j == 1 || j == boardSize - 1) && (i < boardSize/4 || i > 3*boardSize/4)) {
            		board[i][j].setVisible(false);
            	}
            	if(j == boardSize - 2 && (i == 0 || i == boardSize -1)) {
            		board[i][j].setVisible(false);
            	}
			}
		}
	}
	public int getBoardSize() {
		return boardSize;
	}
	
	public HexButton[][] getBoard() {
		return board;
	}


	private void loadBoard() {
		
		int offsetX = 20; 
		int offsetY = 140;
		
		if(boardSize % 4 == 3) {
			offsetX = 45;
		}
		
		for(int i = 0; i<boardSize; i++) {
			for(int j = 0; j < boardSize; j++){
				
				HexButton button = new HexButton(offsetX, offsetY, i , j, coords);
				offsetX += 90;
				
				button.setHexX(i);
				button.setHexY(j);
            	this.add(button);
            	board[i][j] = button;
			}
			if(boardSize % 4 != 3) {

				if(i%2 == 0) {
	                offsetX = -25;
	            } else {
	                offsetX = 20;
	            }
			}
			else {
				if(i%2 == 0) {
	                offsetX = 20;
	            } else {
	                offsetX = 65;
	            }
			}
            offsetY += 75;
            
		}
	}
	
	public ArrayList<HexButton> getPieceLocations() {
		pieceLocations = new ArrayList<HexButton>();
		for(int i = 0; i < boardSize; i++) {
			for(int j = 0; j < boardSize; j++) {
				if(board[i][j].getPiece() != null) {
					pieceLocations.add(board[i][j]);
				}
			}
		}
		return pieceLocations;
	}

	public ArrayList<HexButton> getStartingLocations() {
		int extraRow = 0;
		if(numPieces == 2) {
			extraRow = 1;
		}
		for(int i = 0; i < boardSize; i++) {
			for(int j = 0; j < boardSize; j++) {
				if(board[i][j].isVisible() && (i == 0 || i == extraRow || 
						i == boardSize-1 || i == boardSize-1-extraRow)) {
					startingLocations.add(board[i][j]);
				}
			}
		}
		return startingLocations;
	}
	
	public GameTextArea getTextArea() {
		return textArea;
	}

	public HexButton getFocus() {
		return focus;
	}

	public void setFocus(HexButton focus) {
		this.focus = focus;
	}

	public MovementControl getMc() {
		return mc;
	}

	public void setMc(MovementControl mc) {
		this.mc = mc;
	}

	public GameTimer getGt() {
		return gt;
	}

	public void setGt(GameTimer gt) {
		this.gt = gt;
	}
	
	
	
	
}
