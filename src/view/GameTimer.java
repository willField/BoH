package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controllers.MenuListener;

public class GameTimer extends JPanel{
	
	private JLabel timeLabel = new JLabel("Time Left");
	private JLabel time = new JLabel("15");
	private int timeMax = 16;
	private Timer timer;

	public Timer getTimer() {
		return timer;
	}

	private MenuListener ml;
	
	GameTimer(MenuListener ml){
		this.ml = ml;
		this.setBackground(null);
		this.setLayout(new GridBagLayout());
		this.setBorder(new CompoundBorder(new LineBorder(Color.BLUE),
				new EmptyBorder(10,10,10,10)));
		timeLabel.setForeground(Color.WHITE);
		time.setForeground(Color.WHITE);
		time.setFont(new Font("Courier", Font.PLAIN, 30));
		this.add(time);
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5,5,5,5);
		c.gridx = 0;
		c.gridy = 0;
		timer = new Timer(1000, ml);
		timer.setActionCommand("timer");
		
		this.add(time, c);
		c.gridy = 1;
		this.add(timeLabel, c);
	}
	
	public void setTimerML(MenuListener ml) {
		timer = null;
		timer = new Timer(1000, ml);
		timer.setActionCommand("timer");
	}
	
	public void resetTimer() {
		timeMax = 16;
		time.setForeground(Color.WHITE);
		time.setFont(new Font("Courier", Font.PLAIN, 30));
	}
	
	public void startTimer() {
		
		
		timer.start();
	}
	
	
	
	public int getTime() {
		return timeMax; 
	}
	
	public void timeWarning() {
		time.setForeground(Color.RED);
		time.setFont(new Font("Courier", Font.BOLD, 30));
	}
	public void reduceTime() {
		if(timeMax > 0) {
			timeMax--;
			time.setText(Integer.toString(timeMax));
		}
		else {
			timer.stop();
		}
	}

	public void setTime(JLabel time) {
		this.time = time;
	}
}
