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
	
	public void setBoard(HexButton[][] board) {
		this.board = board;
	}

	private int boardSize;
	private Boolean coords;
	private ArrayList<HexButton> startingLocations = new ArrayList<HexButton>();
	private ArrayList<HexButton> pieceLocations;
	private GameTextArea textArea = new GameTextArea();
	private HexButton focus;

	public GamePanel(JFrame frame, int boardSize, Boolean coords, MenuListener ml){
		this.coords = coords;
		this.frame = frame;
		this.boardSize = boardSize;
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

		int visStart;
		boolean left = true;
		int middle;
		
		// TODO: Board crop: (only works for boardSize 9 currently)
		// only odd values of boardSize will work, needs adjusting for 5, 7, 11, 13, 15

		System.out.println("Board Size: " + boardSize);

		if(boardSize % 2 != 0) {
			System.out.println("Odd");
			visStart = Math.round(boardSize / 2);
			if(visStart % 2 != 0) {
				left = false;
			}
			middle =  visStart;
		}
		else {
			System.out.println("Even");
			visStart = boardSize / 2;
			middle = visStart - 1;
			for(int i = 0; i < boardSize; i++) {
				System.out.println("In loop");
				board[boardSize - 1][i].setVisible(false);
			}
		}

		System.out.println("Middle Board: " + middle);
		System.out.println("Left: " + left);


		int piecesRemoved = 0;
		int piecesNeedRemove = 1;


		for(int i = middle - 1; i >= 0; i--) {
			int leftSide = 0;
			int rightSide = 0;
			System.out.println("i: " + i);
			System.out.println("Left: " + left);
			if(left == true) {
				while(piecesRemoved != piecesNeedRemove) {
					if(piecesRemoved % 2 == 0) {
						System.out.println("leftSide: " + leftSide);
						board[i][leftSide].setVisible(false);
						piecesRemoved++;
						leftSide++;
					}
					else {
						System.out.println("rightSide: " + rightSide);
						board[i][(boardSize - 1) - rightSide].setVisible(false);
						piecesRemoved++;
						rightSide++;
					}
				}
			}
			else if(left == false) {
				while(piecesRemoved != piecesNeedRemove) {
					if(piecesRemoved % 2 == 0) {
						System.out.println("rightSide: " + rightSide);
						board[i][(boardSize - 1) - rightSide].setVisible(false);
						piecesRemoved++;
						rightSide++;
					}
					else {
						System.out.println("leftSide: " + leftSide);
						board[i][leftSide].setVisible(false);
						piecesRemoved++;
						leftSide++;
					}
				}
			}
			piecesRemoved = 0;
			piecesNeedRemove++;
		}

		piecesRemoved = 0;
		piecesNeedRemove = 1;
		System.out.println("Left: " + left);

		for(int i = middle + 1; i < boardSize; i++) {
			int leftSide = 0;
			int rightSide = 0;
			System.out.println("i: " + i);
			System.out.println("Left: " + left);

			if (left == true) {
				while (piecesRemoved != piecesNeedRemove) {
					if (piecesRemoved % 2 == 0) {
						System.out.println("leftSide: " + leftSide);
						board[i][leftSide].setVisible(false);
						piecesRemoved++;
						leftSide++;
					} else {
						System.out.println("rightSide: " + rightSide);
						board[i][(boardSize - 1) - rightSide].setVisible(false);
						piecesRemoved++;
						rightSide++;
					}
				}
			} else if(left == false) {
				while (piecesRemoved != piecesNeedRemove) {
					if (piecesRemoved % 2 == 0) {
						System.out.println("rightSide: " + rightSide);
						board[i][(boardSize - 1) - rightSide].setVisible(false);
						piecesRemoved++;
						rightSide++;
					} else {
						System.out.println("leftSide: " + leftSide);
						board[i][leftSide].setVisible(false);
						piecesRemoved++;
						leftSide++;
					}
				}
			}
			piecesRemoved = 0;
			piecesNeedRemove++;
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
		for(int i = 0; i < boardSize; i++) {
			for(int j = 0; j < boardSize; j++) {
				if(board[i][j].isVisible() && (i == 0 || i == boardSize-1)) {
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
	
	
	
	
}
