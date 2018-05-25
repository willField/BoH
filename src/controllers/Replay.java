package controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

import model.GameEngine;
import model.GameState;
import model.pieces.Piece;
import view.GameBoardUtilities;
import view.GamePanel;

public class Replay {
	
	private ArrayList<GameState> history = new ArrayList<GameState>();
	private JFrame frame;
	private GamePanel gp;

	public Replay(ArrayList<GameState> history, JFrame frame, GamePanel gp) {
		this.history = history;
		this.frame = frame;
		this.gp = gp;
		for(int i = 0; i < history.size(); i++) {
			iterateHistory(history.get(i));
		}
		
		
	}
	
	static int seconds = 0;
	
	public void iterateHistory(GameState gs) {
		Timer timer = new Timer();
		frame.getContentPane().remove(gp);
		TimerTask task = new TimerTask() {
			
	        private final int MAX_SECONDS = 6;
	        
	        @Override
	        public void run() { 
	            if (seconds < MAX_SECONDS) {
	            	GameEngine ge = gs.loadGameEngine();
	            	gp = new GamePanel(frame, gs.getSize(), false, null);
	        		restorePlayerPieceLocations(gs, ge);
	        		GameBoardUtilities gu = new GameBoardUtilities(gp);
	        		
	        		frame.getContentPane().remove(gp);
	        		frame.getContentPane().add(gp);
	        		frame.setVisible(true);
	        		gu.transferFocus();
	                seconds++;
	            } else {
	                cancel();
	            }
	        }
	    };
	    timer.schedule(task, 0, 1000);
	    
		
	}
	
	
	public void restorePlayerPieceLocations(GameState gs, GameEngine ge){
		ArrayList<int[]> xyLocations = gs.getPlayer1PieceLocations();
		xyLocations.addAll(gs.getPlayer2PieceLocations());
		
		Iterator<Piece> pieceIterator = ge.getAllPlayerPieces().iterator();
		Iterator<int[]> xyIterator = xyLocations.iterator();
		
		while(pieceIterator.hasNext() && xyIterator.hasNext()) {
			int xy[] = xyIterator.next();
			gp.getBoard()[xy[0]][xy[1]].setPiece(pieceIterator.next());
		}
		
	}
}
