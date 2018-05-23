package view;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controllers.MenuListener;

public class GameMenuBar extends JMenuBar{

	private JButton back = new JButton("Back");
	private JButton rewind = new JButton("Rewind");
	private JButton strength = new JButton("Strength");
	private JButton movement = new JButton("Movement");
	
	
	GameMenuBar(JFrame frame, GamePanel panel){
		JToolBar tb = new JToolBar();
		back.setBorder(new CompoundBorder(new LineBorder(Color.RED),
				new EmptyBorder(10,10,10,10)));
		back.setFocusable(false);
		back.setBackground(null);
		back.setForeground(Color.RED);
		back.addActionListener(new MenuListener(frame , panel));
		back.addMouseListener(new ButtonHover(back, Color.RED));
		
		rewind.setBorder(new CompoundBorder(new LineBorder(Color.RED),
				new EmptyBorder(10,10,10,10)));
		rewind.setFocusable(false);
		rewind.setBackground(null);
		rewind.setForeground(Color.RED);
		rewind.addActionListener(new MenuListener(frame , panel));
		rewind.addMouseListener(new ButtonHover(rewind, Color.RED));
		
		strength.setBorder(new CompoundBorder(new LineBorder(Color.RED),
				new EmptyBorder(10,10,10,10)));
		strength.setFocusable(false);
		strength.setBackground(null);
		strength.setForeground(Color.RED);
		strength.addActionListener(new MenuListener(panel));
		strength.addMouseListener(new ButtonHover(strength, Color.RED));
		
		movement.setBorder(new CompoundBorder(new LineBorder(Color.RED),
				new EmptyBorder(10,10,10,10)));
		movement.setFocusable(false);
		movement.setBackground(null);
		movement.setForeground(Color.RED);
		movement.addActionListener(new MenuListener(panel));
		movement.addMouseListener(new ButtonHover(movement, Color.RED));
		
		tb.setLayout(new FlowLayout());
		tb.setBackground(Color.BLACK);
		tb.setBorderPainted(false);
		tb.setBorder(new EmptyBorder(10,10,10,10));
		this.setBackground(Color.BLACK);
		tb.setRollover(true);
		tb.add(back);
		tb.addSeparator();
		tb.add(rewind);
		tb.addSeparator();
		tb.add(strength);
		tb.addSeparator();
		tb.add(movement);
		tb.setFloatable(false);
		this.add(tb);
		this.setBorderPainted(false);
	}
}
