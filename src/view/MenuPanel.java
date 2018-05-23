package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controllers.MenuListener;

public class MenuPanel extends JPanel{
	
	private JFrame frame;
	
	public MenuPanel(JFrame frame){
		this.frame = frame;
		this.setBackground(Color.BLACK);
		this.setBorder(new EmptyBorder(100,100,100,100));
		this.setLayout(new GridLayout(4,1,20,20));
		
		
		// Create menu buttons with action listeners
		
		this.add(createButton("New Game", Color.GREEN));
		this.add(createButton("Load Game", Color.BLUE));
		this.add(createButton("Settings", Color.RED));
		this.add(createButton("Exit", Color.GRAY));
	}
	
	private JButton createButton(String title, Color color) {
		JButton button = new JButton(title);
		MenuListener ml = new MenuListener(frame, this);
		ButtonHover bh = new ButtonHover(button, color);
		button.setBackground(null);
		button.setForeground(color);
		button.setBorder(new LineBorder(color));
		button.setFocusable(false);
		button.addActionListener(ml);
		button.addMouseListener(bh);
		return button;
		
	}
}
