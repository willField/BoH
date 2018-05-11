package view;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class ButtonHover implements MouseListener{

	private JButton button;
	private Color colorHover, color;
	
	ButtonHover(JButton button, Color color){
		this.color = color;
		this.button = button;
		colorHover = new Color((float)color.getRed()/255, (float)color.getGreen()/255,
				(float)color.getBlue()/255, 0.3f);
	}
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		button.setBackground(colorHover);
		button.setForeground(Color.WHITE);
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		button.setBackground(null);
		button.setForeground(color);
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}

}
