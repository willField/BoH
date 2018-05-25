package controllers;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.GamePanel;
import view.HexButton;

public class MovementListener implements MouseListener {

	private HexButton button, check;
	private GamePanel gp;
	private TurnControl tc;
	
	public MovementListener(HexButton button, HexButton check, GamePanel gp, TurnControl tc) {
		this.button = button;
		this.check = check;
		this.gp = gp;
		this.tc = tc;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		if(button.getColor() == Color.BLUE) {
			button.setColor(Color.RED);
			check.setText(null);
			MovementControl mc = new MovementControl(gp, tc);
			mc.movePiece(button, check);
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		check.setColor(Color.BLUE);
		if(check.getIcon()!= null) {
			check.setIcon(null);
			String info = check.getPiece().toString().substring(13) +"\nSTR: " 
			+ check.getPiece().getStrength()+"\nLIFE: " + check.getPiece().getHealth();
			check.setText("<html><center>" + info.replaceAll("\\n", "<br>") + "</center></html>");
		}

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		check.setColor(Color.MAGENTA);
		check.setText(null);
		if(check.getPiece() != null) {
			check.setIcon(check.getPiece().getIcon());
			check.setText(null);
		}

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
