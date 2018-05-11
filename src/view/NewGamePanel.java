package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.MenuListener;

import controllers.MenuControl;

public class NewGamePanel extends JPanel{
	
	static final int MAX_GAME_SIZE = 15;
	static final int MIN_GAME_SIZE = 5;
	static final int GAME_SIZE_INIT = 9;
	
	private Boolean coords = false;
	private JTextField p1Name, p2Name;
	private JSlider gameSize, numPieces;
	private JFrame frame;
	private JCheckBox showCoords = new JCheckBox();

	public String getP1Name() {
		return p1Name.getText();
	}

	public int getGameSize() {
		return gameSize.getValue();
	}

	public int getNumPieces() {
		return numPieces.getValue();
	}

	public String getP2Name() {
		return p2Name.getText();
	}

	public NewGamePanel(JFrame frame){
		this.frame = frame;
		
		this.setBorder(new EmptyBorder(90,90,90,90));
		this.setBackground(Color.BLACK);
		this.setLayout(new GridLayout(6,2,20,20));
		
		MenuControl ml = new MenuControl(frame, this);
		showCoords.setFocusable(false);
		showCoords.setActionCommand("coords");
		showCoords.addActionListener(ml);
		showCoords.setBackground(null);
		showCoords.setForeground(Color.GREEN);
		
		if(coords == true) {
			showCoords.setSelected(true);
		}
		
		
		this.add(createLabel("Player 1 Name: ", Color.GREEN));
		this.add(createField("p1Name", Color.GREEN));
		this.add(createLabel("Player 2 Name: ", Color.BLUE));
		this.add(createField("p2Name", Color.BLUE));
		this.add(createLabel("Board Size: ", Color.RED));
		this.add(createSlider("gameSize", Color.RED));
		this.add(createLabel("Number of Pieces: ", Color.RED));
		this.add(createSlider("numPieces", Color.RED));
		this.add(createLabel("Show Coords: ", Color.CYAN));
		this.add(showCoords);
		this.add(createButton("Back", Color.GRAY));
		this.add(createButton("Start Game", Color.MAGENTA));
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
		return button;
	}
	
	private JLabel createLabel(String title, Color color) {
		JLabel label = new JLabel(title);
		
		label.setForeground(color);
		label.setBackground(null);
		return label;
	}
	
	private JTextField createField(String title, Color color) {
		JTextField tf = new JTextField();
		MenuControl ml = new MenuControl(frame, this);
		tf.setActionCommand(title);
		tf.setCaretColor(color);
		tf.setBackground(null);
		tf.setForeground(color);
		tf.addActionListener(ml);
		tf.setBorder(new CompoundBorder(new LineBorder(color), new EmptyBorder(5,5,5,5)));
		
		if(title == "p1Name") {
			p1Name = tf;
		}
		else if(title == "p2Name") {
			p2Name = tf;
		}
		return tf;
	}
	
	private JSlider createSlider(String title, Color color) {
		JSlider slider = new JSlider(JSlider.HORIZONTAL, MIN_GAME_SIZE,
			MAX_GAME_SIZE, GAME_SIZE_INIT);
		
		slider.setBackground(null);
		slider.setForeground(Color.RED);
		slider.setMajorTickSpacing(4);
		slider.setMinorTickSpacing(2);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		
		if(title == "gameSize") {
			gameSize = slider;
		}
		else if(title == "numPieces") {
			numPieces = slider;
		}
		return slider;
	}

	public Boolean getCoords() {
		return coords;
	}

	public void setCoords(Boolean coords) {
		this.coords = coords;
	}
}
