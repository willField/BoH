package view;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import controllers.MovementControl;
import controllers.TurnControl;

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
			MovementControl mc = new MovementControl(gp, tc);
			mc.movePiece(button, check);
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		check.setColor(Color.BLUE);

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		check.setColor(Color.MAGENTA);

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
