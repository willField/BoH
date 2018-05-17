package view;

import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class GameTextArea extends JTextArea{
	
	GameTextArea(){
		super(5,0);
		this.setEditable(false);
		this.setAutoscrolls(true);
		this.setBackground(Color.BLACK);
		this.setForeground(Color.WHITE);
		this.setBorder(new EmptyBorder(10,10,10,10));
		JScrollPane pane = new JScrollPane(this);
	}

}
