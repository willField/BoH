package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controllers.MenuControl;

public class GameMenuBar extends JMenuBar{

	private JButton back = new JButton("Back");
	private JButton back3 = new JButton("Back 3 Turns");
	
	GameMenuBar(JFrame frame, JPanel panel){
		JToolBar tb = new JToolBar();
		back.setBorder(new CompoundBorder(new LineBorder(Color.RED),
				new EmptyBorder(10,10,10,10)));
		back.setFocusable(false);
		back.setBackground(null);
		back.setForeground(Color.RED);
		back.addActionListener(new MenuControl(frame , panel));
		back.addMouseListener(new ButtonHover(back, Color.RED));
		back3.setBorder(new CompoundBorder(new LineBorder(Color.RED),
				new EmptyBorder(10,10,10,10)));
		back3.setFocusable(false);
		back3.setBackground(null);
		back3.setForeground(Color.RED);
		back3.addActionListener(new MenuControl(frame , panel));
		back3.addMouseListener(new ButtonHover(back3, Color.RED));
		tb.setBackground(Color.BLACK);
		tb.setBorderPainted(false);
		tb.setBorder(new EmptyBorder(10,10,10,10));
		this.setBackground(Color.BLACK);
		tb.setRollover(true);
		tb.add(back);
		tb.addSeparator();
		tb.add(back3);
		tb.setFloatable(false);
		this.add(tb);
		this.setBorderPainted(false);
	}
}
