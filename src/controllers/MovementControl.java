package controllers;

import java.awt.Color;

import view.GamePanel;
import view.GameBoardUtilities;
import view.HexButton;
import view.MovementListener;

public class MovementControl {
	
	private GamePanel gp;
	private TurnControl tc;
	
	public MovementControl(GamePanel gp, TurnControl tc){
		this.gp = gp;
		this.tc = tc;
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

	public void showAvailableMoves(HexButton button, GamePanel gp) {
		
		int minX = 0, maxX = 0;

		for (int i = -1; i < 2; i++) {

			if (button.getHexX() % 2 == 1 && i == 0) {
				maxX = 1;
			} else if (button.getHexX() % 2 == 1) {
				minX = -1;
				maxX = 0;
			}
			if (button.getHexX() % 2 == 0 && i == 0) {
				minX = -1;
			}

			else if (button.getHexX() % 2 == 0) {
				minX = 0;
				maxX = 1;
			}

			for (int j = minX; j <= maxX; j++) {

				try {

					HexButton check = gp.getBoard()[button.getHexX() + i]
							[button.getHexY() + j];

					if (check.getPiece() == null) {
						check.setColor(Color.MAGENTA);
						MovementListener ml = new MovementListener(button, check, gp, tc);
						check.addMouseListener(ml);
						
					}

				} catch (ArrayIndexOutOfBoundsException e) {

				}
			}

		}
	}
}
