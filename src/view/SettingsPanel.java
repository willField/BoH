package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controllers.MenuControl;

public class SettingsPanel extends JPanel{

	private JFrame frame;
	private JCheckBox fullscreen = new JCheckBox("Full Screen Mode");
	private JButton back = new JButton("Back");
	
	public SettingsPanel(JFrame frame) {
		this.frame = frame;
		MenuControl ml = new MenuControl(frame, this);
		
		this.setBackground(Color.BLACK);
		this.setBorder(new EmptyBorder(100,100,100,100));
		this.setLayout(new BorderLayout());
		if(frame.getExtendedState() == JFrame.MAXIMIZED_BOTH) {
			fullscreen.setSelected(true);
		}
		fullscreen.setFocusable(false);
		fullscreen.addActionListener(ml);
		fullscreen.setBackground(null);
		fullscreen.setForeground(Color.GREEN);
		
		this.add(fullscreen, BorderLayout.NORTH);
		this.add(createButton("Back", Color.GRAY), BorderLayout.SOUTH);	
	}
	
	private JButton createButton(String title, Color color) {
		JButton button = new JButton(title);
		MenuControl ml = new MenuControl(frame, this);
		ButtonHover bh = new ButtonHover(button, color);
		button.setBackground(null);
		button.setForeground(color);
		button.setBorder(new LineBorder(color));
		button.setFocusable(false);
		button.addActionListener(ml);
		button.addMouseListener(bh);
		button.setPreferredSize(new Dimension(0, 50));
		return button;
	}
	
}
