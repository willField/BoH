package view;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import controllers.MovementControl;
import controllers.TurnControl;

public class TurnListener implements MouseListener {

	private HexButton hex;
	private ArrayList<HexButton> hexes;
	private GamePanel gp;
	private GameBoardUtilities gu;
	private TurnControl tc;
	
	public TurnListener(HexButton hex, ArrayList<HexButton> hexes, GamePanel gp, TurnControl tc){
		this.hex = hex;
		this.hexes = hexes;
		this.gp = gp;
		this.tc = tc;
		gu = new GameBoardUtilities(gp);
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {

		if (hex.getColor() != Color.BLUE) {
			hex.setColor(Color.GREEN);
		} 
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {

		
		if(hex.getColor() == Color.BLUE) {
			gu.recolor();
			gu.transferFocus();
			gu.removeNonPieceListeners();
			gu.removeNonPlayerPieceListeners(hex.getPiece().getPlayer());
			hex.setColor(Color.GREEN);
		}
		else {
			for(HexButton other : hexes) {
				// no idea what this is for
				
				gu.recolor();
				gu.transferFocus();
				gu.removeNonPieceListeners();
				
			}
			
			gp.setFocus(hex);
			gu.removeNonPieceListeners();
			gu.removeNonPlayerPieceListeners(hex.getPiece().getPlayer());
			hex.setColor(Color.BLUE);
			MovementControl mc = new MovementControl(gp, tc);
			mc.showAvailableMoves(hex, gp);
		}
	}

	@Override
	public void mouseExited(MouseEvent arg0) {

		if (hex.getColor() != Color.BLUE) {
			hex.setColor(Color.RED);
		}
	}

	@Override
	public void mousePressed(MouseEvent arg0) {}

	@Override
	public void mouseReleased(MouseEvent arg0) {}

}
