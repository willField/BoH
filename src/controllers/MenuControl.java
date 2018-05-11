package controllers;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.GameEngine;
import model.Player;
import view.GamePanel;
import view.MenuPanel;
import view.NewGamePanel;
import view.SettingsPanel;

public class MenuControl implements ActionListener{

	private JFrame frame;
	private JPanel panel;
	private NewGamePanel ngp;
	private String p1Name, p2Name;
	private int gameSize, numPieces;
	
	public MenuControl(JFrame frame, JPanel panel){
		this.frame= frame;
		this.panel = panel;
	}
	
	public MenuControl(JFrame frame, NewGamePanel ngp) {
		this.frame = frame;
		this.ngp = ngp;
		this.panel = (JPanel)ngp;
	}
	
	public void changePanel(JPanel newPanel) {
		frame.getContentPane().remove(panel);
		frame.getContentPane().add(newPanel, BorderLayout.CENTER);
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("New Game")) {
			changePanel(new NewGamePanel(frame));
		}
		
		if(arg0.getActionCommand().equals("Start Game")) {	
			
			GameEngine ge = new GameEngine(ngp.getGameSize(),ngp.getNumPieces());
			ge.addPlayer(new Player(ngp.getP1Name()));
			ge.addPlayer(new Player(ngp.getP2Name()));
			GamePanel gp = new GamePanel(frame, ngp.getGameSize(), ngp.getCoords());
			new GameControl(ge, gp);
			changePanel(gp);
		}
		
		if(arg0.getActionCommand().equals("Settings")) {
			changePanel(new SettingsPanel(frame));
		}
		
		if(arg0.getActionCommand().equals("Full Screen Mode")) {
			if(frame.getExtendedState() == JFrame.MAXIMIZED_BOTH) {
				frame.setExtendedState(0);
			}
			else {
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		}
		
		if(arg0.getActionCommand().equals("Back")) {
			changePanel(new MenuPanel(frame));
			frame.setSize(500, 500);
			frame.setLocationRelativeTo(null);
		}
		
		if(arg0.getActionCommand().equals("coords")) {
			if(ngp.getCoords()) {
				ngp.setCoords(false);
			}
			else {
				ngp.setCoords(true);
			}
		}
		
		if(arg0.getActionCommand().equals("Exit")) {
			System.exit(0);
		}
	}

}
