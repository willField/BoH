package view;

import java.awt.Color;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import model.Player;

public class GameBoardUtilities {

	private GamePanel gp;
	private int boardSize;

	public GameBoardUtilities(GamePanel gp) {
		this.gp = gp;
		this.boardSize = gp.getBoardSize();

	}

	public JLabel addNameLabels(String name) {
		JLabel nameLabel = new JLabel(name);
		nameLabel.setBackground(Color.BLACK);
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
		return nameLabel;
	}

	public void removeAllListeners() {
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				MouseListener ml[] = gp.getBoard()[i][j].getMouseListeners();
				for (int k = 1; k < ml.length; k++) {
					gp.getBoard()[i][j].removeMouseListener(ml[k]);

				}

			}
		}
	}

	public void removeNonPlayerPieceListeners(Player player) {
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				if (gp.getBoard()[i][j].getPiece() != null) {
					if (gp.getBoard()[i][j].getPiece().getPlayer() != player) {
						MouseListener ml[] = gp.getBoard()[i][j].getMouseListeners();
						for (int k = 1; k < ml.length; k++) {
							gp.getBoard()[i][j].removeMouseListener(ml[k]);

						}
					}
				}
			}
		}

	}

	public void removeNonPieceListeners() {
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				if (gp.getBoard()[i][j].getPiece() == null) {
					MouseListener ml[] = gp.getBoard()[i][j].getMouseListeners();
					for (int k = 1; k < ml.length; k++) {
						gp.getBoard()[i][j].removeMouseListener(ml[k]);

					}
				}

			}
		}

	}

	public void transferFocus() {
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				gp.getBoard()[i][j].transferFocus();
			}
		}
	}

	public void recolor() {
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				gp.getBoard()[i][j].setColor(Color.RED);
				gp.getBoard()[i][j].setBorderColor(Color.DARK_GRAY);
			}
		}
	}
}
