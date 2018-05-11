package view;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

public class GUI {
	
	private JFrame frame = new JFrame("Battle of Hastings");
	private Container contentPane = frame.getContentPane();
	private SplashPanel splash = new SplashPanel();
	private MenuPanel menu;
	
	public GUI() {
		// create frame

		frame.setUndecorated(true);
		frame.setMinimumSize(new Dimension(500, 500));
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		// load splash
		try {
			contentPane.add(splash);
			frame.setVisible(true);
			Thread.sleep(2000l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		contentPane.remove(splash);
		
		// load menu
		menu = new MenuPanel(frame);
		contentPane.add(menu);
		frame.pack();
		frame.setVisible(true);
	}
}
