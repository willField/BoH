package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
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
		back.setToolTipText("Exit to the Main Menu");
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
		
		
		JPanel unitModes = new JPanel();
		unitModes.setBackground(null);
		unitModes.setLayout(new GridBagLayout());
		unitModes.setBorder(new CompoundBorder(new LineBorder(Color.BLUE),
				new EmptyBorder(10,10,10,10)));
		
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5,5,5,5);
		strength.setToolTipText("UNIT MODE: Strength allows the unit to \ncount as two when capturing an enemy piece.");
		strength.setBorder(new CompoundBorder(new LineBorder(Color.RED),
				new EmptyBorder(10,10,10,10)));
		strength.setFocusable(false);
		strength.setBackground(null);
		strength.setForeground(Color.RED);
		strength.addActionListener(new MenuListener(panel));
		strength.addMouseListener(new ButtonHover(strength, Color.RED));
		
		movement.setToolTipText("UNIT MODE: Movement doubles the range \nin which a unit can move this turn.");
		movement.setBorder(new CompoundBorder(new LineBorder(Color.GREEN),
				new EmptyBorder(10,10,10,10)));
		movement.setFocusable(false);
		movement.setBackground(null);
		movement.setForeground(Color.GREEN);
		movement.addActionListener(new MenuListener(panel));
		movement.addMouseListener(new ButtonHover(movement, Color.GREEN));
		
		c.gridx = 0;
		c.gridy = 0;
		
		
		unitModes.add(strength, c);
		
		c.gridx = 1;
		
		unitModes.add(movement, c);
		
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 1;
		
		JLabel modesLabel = new JLabel("Unit Modes");
		modesLabel.setForeground(Color.BLUE);
		unitModes.add(modesLabel, c);
		
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
		
		tb.add(unitModes);
		tb.setFloatable(false);
		this.add(tb);
		this.setBorderPainted(false);
	}
}
