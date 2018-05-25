package controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.HexButton;

public class InfoListener implements MouseListener{
	
	private HexButton hex;

	InfoListener(HexButton hex){
		this.hex = hex;
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		hex.setIcon(null);
		String info = hex.getPiece().toString().substring(13) +"\nSTR: " 
		+ hex.getPiece().getStrength()+"\nLIFE: " + hex.getPiece().getHealth();
		hex.setText("<html><center>" + info.replaceAll("\\n", "<br>") + "</center></html>");
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		hex.setIcon(hex.getPiece().getIcon());
		hex.setText(null);
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
