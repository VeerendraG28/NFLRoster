package organizer;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Window extends Canvas {
		
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 3282742541605325000L;
	
	static JButton button2;
	
	public static int speed;
	
	static boolean value = false;
	
	public static int number;
		
	public Window(int width, int height, String title, NFLTeams nflTeams) {
		
		String path = "cardinals.png";
        File file = new File(path);
        BufferedImage image;
		try {
			image = ImageIO.read(file);
	        JLabel label = new JLabel(new ImageIcon(image));
	        JFrame f = new JFrame();
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        f.getContentPane().add(label);
	        f.pack();
	        f.setLocation(200,200);
	        f.setVisible(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static class Action implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			JFrame frame2 = new JFrame("Clicked");
			frame2.setVisible(true);
			frame2.setSize(900,90);
			JLabel label = new JLabel("Welcome to NFL Roster Organizer!");
			JLabel label2 = new JLabel("There are all 32 teams alphabetically organized under in which you can find the starting player for each individual position.");
			JPanel panel = new JPanel();
			frame2.add(panel);
			panel.add(label);
			panel.add(label2);
			
		}
	}
		
}