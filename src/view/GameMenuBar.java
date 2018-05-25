package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;

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
	private JButton rewind = new JButton("Undo");
	private JButton strength = new JButton("Strength");
	private JButton movement = new JButton("Movement");
	private JButton save = new JButton("Save Game");
	private JButton replay = new JButton("Replay");
	private JButton load = new JButton("Load");
	private GameTimer gameTimer;
	
	GameMenuBar(JFrame frame, GamePanel panel, MenuListener ml){
		JToolBar tb = new JToolBar();
		gameTimer = new GameTimer(ml);
		panel.setGt(gameTimer);
		JPanel options = new JPanel();
		GridBagConstraints a = new GridBagConstraints();
		a.insets = new Insets(5,5,5,5);
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5,5,5,5);
		options.setBackground(null);
		options.setLayout(new GridBagLayout());
		options.setBorder(new CompoundBorder(new LineBorder(Color.BLUE),
				new EmptyBorder(10,10,10,10)));
		
		back.setToolTipText("Exit to the Main Menu");
		back.setBorder(new CompoundBorder(new LineBorder(Color.RED),
				new EmptyBorder(10,10,10,10)));
		back.setFocusable(false);
		back.setBackground(null);
		back.setForeground(Color.RED);
		back.addActionListener(new MenuListener(frame , panel));
		back.addMouseListener(new ButtonHover(back, Color.RED));
		
		
		
		
		
		rewind.setBorder(new CompoundBorder(new LineBorder(Color.CYAN),
				new EmptyBorder(10,10,10,10)));
		rewind.setFocusable(false);
		rewind.setBackground(null);
		rewind.setForeground(Color.CYAN);
		rewind.addActionListener(ml);
		rewind.addMouseListener(new ButtonHover(rewind, Color.CYAN));
		
		replay.setBorder(new CompoundBorder(new LineBorder(Color.RED),
				new EmptyBorder(10,10,10,10)));
		replay.setFocusable(false);
		replay.setBackground(null);
		replay.setForeground(Color.RED);
		replay.addActionListener(ml);
		replay.addMouseListener(new ButtonHover(replay, Color.RED));
		
		save.setBorder(new CompoundBorder(new LineBorder(Color.RED),
				new EmptyBorder(10,10,10,10)));
		save.setFocusable(false);
		save.setBackground(null);
		save.setForeground(Color.RED);
		save.addActionListener(ml);
		save.addMouseListener(new ButtonHover(save, Color.RED));
		
		load.setBorder(new CompoundBorder(new LineBorder(Color.BLUE),
				new EmptyBorder(10,10,10,10)));
		load.setFocusable(false);
		load.setBackground(null);
		load.setForeground(Color.BLUE);
		load.addActionListener(ml);
		load.addMouseListener(new ButtonHover(load, Color.BLUE));
		
		a.gridx = 0;
		a.gridy = 0;
		
		options.add(back, a);
		
		
		a.gridx = 1;
		options.add(save, a);
		
		
		a.gridx = 2;
		options.add(rewind, a);
		
		a.gridy = 1;
		a.gridx = 0;
		a.gridwidth = 3;
		
		JLabel optionsLabel = new JLabel("Game Options");
		optionsLabel.setForeground(Color.WHITE);
		options.add(optionsLabel, a);
		
		JPanel unitModes = new JPanel();
		unitModes.setBackground(null);
		unitModes.setLayout(new GridBagLayout());
		unitModes.setBorder(new CompoundBorder(new LineBorder(Color.BLUE),
				new EmptyBorder(10,10,10,10)));
		

		strength.setToolTipText("UNIT MODE: Strength allows the unit to \ncount as two when capturing an enemy piece.");
		strength.setBorder(new CompoundBorder(new LineBorder(Color.RED),
				new EmptyBorder(10,10,10,10)));
		strength.setFocusable(false);
		strength.setBackground(null);
		strength.setForeground(Color.RED);
		strength.addActionListener(new MenuListener(panel));
		strength.addMouseListener(new ButtonHover(strength, Color.RED));
		strength.setMnemonic(KeyEvent.VK_A);
		
		movement.setToolTipText("UNIT MODE: Movement doubles the range \nin which a unit can move this turn.");
		movement.setBorder(new CompoundBorder(new LineBorder(Color.GREEN),
				new EmptyBorder(10,10,10,10)));
		movement.setFocusable(false);
		movement.setBackground(null);
		movement.setForeground(Color.GREEN);
		movement.addActionListener(new MenuListener(panel));
		movement.addMouseListener(new ButtonHover(movement, Color.GREEN));
		movement.setMnemonic(KeyEvent.VK_S);
		
		c.gridx = 0;
		c.gridy = 0;
		
		
		unitModes.add(strength, c);
		
		c.gridx = 1;
		
		unitModes.add(movement, c);
		
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 1;
		
		JLabel modesLabel = new JLabel("Unit Modes");
		modesLabel.setForeground(Color.WHITE);
		unitModes.add(modesLabel, c);
		
		//tb.setLayout(new FlowLayout());
		tb.setBackground(Color.BLACK);
		tb.setBorderPainted(false);
		tb.setBorder(new EmptyBorder(10,10,10,10));
		this.setBackground(Color.BLACK);
		tb.setRollover(true);
		//tb.add(back);
		//tb.addSeparator();
		tb.add(options);
		//tb.addSeparator();
		//tb.add(replay);
		//tb.addSeparator();
		//tb.add(rewind);
		tb.addSeparator();
		
		tb.add(unitModes);
		tb.addSeparator();
		tb.add(gameTimer);
		tb.setFloatable(false);
		this.add(tb);
		this.setBorderPainted(false);
	}
}
