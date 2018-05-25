package controllers;

import java.awt.Color;
import java.util.ArrayList;

import view.GameBoardUtilities;
import view.GamePanel;
import view.HexButton;

public class MovementControl {

	private GamePanel gp;
	private TurnControl tc;

	public MovementControl(GamePanel gp, TurnControl tc) {
		this.gp = gp;
		this.tc = tc;
		gp.setMc(this);
	}
	

	public void movePiece(HexButton button, HexButton next) {

		
		next.setPiece(button.getPiece());
		button.setPiece(null);

		GameBoardUtilities gu = new GameBoardUtilities(gp);
		gu.removeAllListeners();
		gu.recolor();
		gu.transferFocus();
		tc.finishedTurn();

	}

	public ArrayList<HexButton> getSurrounding(HexButton button, GamePanel gp) {
		int minX = 0, maxX = 0;
		ArrayList<HexButton> surrounding = new ArrayList<HexButton>();
		int moves = button.getPiece().getMoves();
		for (int i = -1 - moves; i < 2 + moves; i++) {

			if (button.getHexX() % 2 == 1 && i == 0) {
				maxX = 1 + moves;
			} 
			
			else if (button.getHexX() % 2 == 1 && i == -1) {
				minX = -1 - moves;
				
			}
			
			else if (button.getHexX() % 2 == 1 && i == 1) {
				minX = -1 - moves;
				maxX = 0 + moves;
			}
			
			else if (button.getHexX() % 2 == 1) {
				minX = -1;
				maxX = 0 + moves;
			}
			
			if (button.getHexX() % 2 == 0 && i == 0) {
				minX = -1 - moves;

			}
			else if (button.getHexX() % 2 == 0 && (i == 2 || i == -2)) {
				maxX = 0 + moves;
				minX = 0 - moves;
			}

			else if (button.getHexX() % 2 == 0) {
				minX = 0 - moves;
				maxX = 1 + moves;
			}

			for (int j = minX; j <= maxX; j++) {
				try {
					HexButton check = gp.getBoard()[button.getHexX() + i][button.getHexY() + j];
					surrounding.add(check);
				} catch (ArrayIndexOutOfBoundsException e) {
					
				}

			}
		}
		return surrounding;
	}

	public void addMoveListen(HexButton check, MovementListener ml) {
		check.setColor(Color.MAGENTA);
		check.setBorderColor(Color.WHITE);
		check.addMouseListener(ml);
	}
	
	public void showAvailableMoves(HexButton button, GamePanel gp) {

		gp.setFocus(button);
		for (HexButton check : getSurrounding(button, gp)) {

			if (check.getPiece() == null) {
				check.setColor(Color.MAGENTA);
				MovementListener ml = new MovementListener(button, check, gp, tc);
				check.addMouseListener(ml);

			} 
			
			
			// Basic capture functionality, the piece you wish to capture must be
			// surrounded by three of your units.
			
			
			
			else if (check.getPiece().getPlayer() != button.getPiece().getPlayer()) {
				int power = 0;
				for(HexButton friendly : getSurrounding(check, gp)) {
					if(friendly.getPiece() != null) {
						if(friendly.getPiece().getPlayer() == button.getPiece().getPlayer()) {
							power = power + friendly.getPiece().getStrength();
						}
					}
				}
				MovementListener ml = new MovementListener(button, check, gp, tc);
				if(power >= check.getPiece().getHealth()) {
					this.addMoveListen(check, ml);
				}	
			}
			
			else if(check.getPiece() != null) {
				check.addMouseListener(new InfoListener(check));
			}

		}
	}
}
