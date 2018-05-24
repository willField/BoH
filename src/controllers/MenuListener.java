package controllers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.GameEngine;
import model.GameState;
import model.Player;
import view.GameBoardUtilities;
import view.GamePanel;
import view.MenuPanel;
import view.NewGamePanel;
import view.SettingsPanel;

public class MenuListener implements ActionListener{

	private JFrame frame;
	private JPanel panel;
	private NewGamePanel ngp;
	private GamePanel gp;
	private GameEngine ge;
	
	public MenuListener(JFrame frame, JPanel panel){
		this.frame= frame;
		this.panel = panel;
	}
	
	public MenuListener(JFrame frame, NewGamePanel ngp) {
		this.frame = frame;
		this.ngp = ngp;
		this.panel = (JPanel)ngp;
	}
	
	public MenuListener(GamePanel gp) {
		this.gp = gp;
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
			if(ngp.getP1Name().equals("")|| ngp.getP2Name().equals("")) {
				JOptionPane.showMessageDialog(ngp, "Please enter names for the players.",
						"Player Names", JOptionPane.ERROR_MESSAGE);
			}
			
			else {
				ge = new GameEngine(ngp.getGameSize(),ngp.getNumPieces());
				ge.addPlayer(new Player(ngp.getP1Name()));
				ge.addPlayer(new Player(ngp.getP2Name()));
				gp = new GamePanel(frame, ngp.getGameSize(), ngp.getCoords(), this);
				ge.setGc(new GameControl(ge, gp, frame));
				changePanel(gp);
			}
			
		}
		
		if(arg0.getActionCommand().equals("Load Game")) {
			try {
				FileInputStream fis = new FileInputStream("BoHSave.data");
				ObjectInputStream ois = new ObjectInputStream(fis);
				GameState gs = (GameState) ois.readObject();
				ge = gs.loadGameEngine();
				gp = new GamePanel(frame, gs.getSize(), false, this);
				ge.setGc(new GameControl(ge, gp, frame, gs));
				changePanel(gp);
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
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
		
		if(arg0.getActionCommand().equals("Strength")) {
			if(gp.getFocus() == null) {
				JOptionPane.showMessageDialog(ngp, "You must select a piece before changing mode.",
						"Unit Mode", JOptionPane.ERROR_MESSAGE);
			}
			else if(gp.getFocus().getPiece().getStrength() == 0){
				gp.getFocus().getPiece().setStrength(1);
				gp.getMc().showAvailableMoves(gp.getFocus(), gp);
				GameBoardUtilities gu = new GameBoardUtilities(gp);
				gu.transferFocus();
			}
			else{
				GameBoardUtilities gu = new GameBoardUtilities(gp);
				gp.getFocus().getPiece().setStrength(0);
				gu.recolor();
				gu.removeNonPieceListeners();
				gu.removeNonPlayerPieceListeners(gp.getFocus().getPiece().getPlayer());
				gp.getFocus().setColor(Color.BLUE);
				gp.getMc().showAvailableMoves(gp.getFocus(), gp);
				gu.transferFocus();
			}
		}
		
		if(arg0.getActionCommand().equals("Movement")) {
			if(gp.getFocus() == null) {
				JOptionPane.showMessageDialog(ngp, "You must select a piece before changing mode.",
						"Unit Mode", JOptionPane.ERROR_MESSAGE);
			}
			else if(gp.getFocus().getPiece().getMoves() == 0){
				gp.getFocus().getPiece().setMoves(1);
				gp.getMc().showAvailableMoves(gp.getFocus(), gp);
				GameBoardUtilities gu = new GameBoardUtilities(gp);
				gu.transferFocus();
			}
			else{
				GameBoardUtilities gu = new GameBoardUtilities(gp);
				gp.getFocus().getPiece().setMoves(0);
				gu.recolor();
				gu.removeNonPieceListeners();
				gp.getFocus().setColor(Color.BLUE);
				gp.getMc().showAvailableMoves(gp.getFocus(), gp);
				gu.transferFocus();
			}
		}
		
		if(arg0.getActionCommand().equals("Rewind")) {
			if(ge.getHistory().size() == 0) {
				JOptionPane.showMessageDialog(ngp, "There are no turns left to undo.",
						"Rewind", JOptionPane.ERROR_MESSAGE);
			}
			else {
				GameState gs = ge.getHistory().get(ge.getHistory().size()-1);
				ge = gs.loadGameEngine();
				frame.getContentPane().remove(gp);
				gp = new GamePanel(frame, gs.getSize(), false, this);
				ge.setGc(new GameControl(ge, gp, frame, gs));
				changePanel(gp);
			}
		}
		
		if(arg0.getActionCommand().equals("Save Game")) {
			try(ObjectOutputStream oos = new ObjectOutputStream(
	                new FileOutputStream(new File("BoHSave.data")))) {
				GameState gs = new GameState();
				gs.saveData(gp, ge);
	            oos.writeObject(gs);
	            oos.flush();
	        } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
