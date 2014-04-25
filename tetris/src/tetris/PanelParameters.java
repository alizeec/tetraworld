package tetris;

import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class PanelParameters extends JPanel{
	Image background;
	JLabel picture;	
	JButton play_song;

	public PanelParameters(){
		this.setLayout(new FlowLayout());
		//bt play musique
	      play_song = new JButton(new ImageIcon("sound_off_gris.png"));
	
	      //Add background       
	      background = new ImageIcon("param.gif").getImage();
	}
	
	 public void paintComponent(Graphics g) {
		    super.paintComponent(g);
		    System.out.print("merde");
			g.drawImage(background,0,0,null);    
			play_song.setBounds(50, 50, 63, 93);
		    play_song.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		    play_song.setContentAreaFilled(false);
		    play_song.setBorderPainted(false);
		    add(play_song);
     } 
}	
