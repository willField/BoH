package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SplashPanel extends JPanel{
	
	private JLabel title = new JLabel(),
			cc = new JLabel();

	SplashPanel(){
		this.setBackground(Color.BLACK);
		this.setLayout(new BorderLayout());
		try {
			title.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/title.png"))));
			//setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/cc.png"))));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.add(title, BorderLayout.CENTER);
		//this.add(cc, BorderLayout.SOUTH);
	}
}
