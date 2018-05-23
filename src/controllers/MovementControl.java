package controllers;

import java.awt.Color;
import java.util.ArrayList;

import view.GameBoardUtilities;
import view.GamePanel;
import view.HexButton;
import view.MovementListener;

public class MovementControl {

	private GamePanel gp;
	private TurnControl tc;

	public MovementControl(GamePanel gp, TurnControl tc) {
		this.gp = gp;
		this.tc = tc;
		gp.setMc(this);
	}
	

	public void movePiece(HexButton button, HexButton next) {

		button.getPiece().setStrength(0);
		button.getPiece().setMoves(0);
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
		for (int i = -1 - button.getPiece().getMoves(); i < 2 + button.getPiece().getMoves(); i++) {

			if (button.getHexX() % 2 == 1 && i == 0) {
				maxX = 1 + button.getPiece().getMoves();
			} 
			
			else if (button.getHexX() % 2 == 1 && i == -1) {
				minX = -1 - button.getPiece().getMoves();
				
			}
			
			else if (button.getHexX() % 2 == 1 && i == 1) {
				minX = -1 - button.getPiece().getMoves();
				maxX = 0 + button.getPiece().getMoves();
			}
			
			else if (button.getHexX() % 2 == 1) {
				minX = -1;
				maxX = 0 + button.getPiece().getMoves();
			}
			
			if (button.getHexX() % 2 == 0 && i == 0) {
				minX = -1 - button.getPiece().getMoves();

			}
			else if (button.getHexX() % 2 == 0 && (i == 2 || i == -2)) {
				maxX = 0 + button.getPiece().getMoves();
				minX = 0 - button.getPiece().getMoves();
			}

			else if (button.getHexX() % 2 == 0) {
				minX = 0 - button.getPiece().getMoves();
				maxX = 1 + button.getPiece().getMoves();
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
				int count = 0;
				for(HexButton friendly : getSurrounding(check, gp)) {
					if(friendly.getPiece() != null) {
						if(friendly.getPiece().getPlayer() == button.getPiece().getPlayer()) {
							count++;
						}
					}
				}
				if(count > 2 - button.getPiece().getStrength()) {
					check.setColor(Color.MAGENTA);
					check.setBorderColor(Color.WHITE);
					MovementListener ml = new MovementListener(button, check, gp, tc);
					check.addMouseListener(ml);
				}
				
			}

		}
	}
}
