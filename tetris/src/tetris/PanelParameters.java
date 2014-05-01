package tetris;

import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


@SuppressWarnings("serial")
public class PanelParameters extends JPanel {
	Image background;
	JLabel picture;	
	JButton play_song, stop_song, song_played, song_stoped, param, geek_gris, geek_jaune, girly_gris,girly_jaune;
	JLabel lblResult;
	Slider slider;

	public PanelParameters(){
		this.setLayout(new FlowLayout());
		//bt play musique
	    play_song = new JButton(new ImageIcon("sound_on_jaune.png"));
	    stop_song = new JButton(new ImageIcon("sound_off_jaune.png"));
	    song_played = new JButton(new ImageIcon("sound_on_gris.png"));
	    song_stoped = new JButton(new ImageIcon("sound_off_gris.png"));
	    geek_gris = new JButton(new ImageIcon("geek_gris.png"));
	    geek_jaune = new JButton(new ImageIcon("geek_jaune.png"));
	    girly_gris = new JButton(new ImageIcon("girly_gris.png"));
	    girly_jaune = new JButton(new ImageIcon("girly_jaune.png"));
	    param= new JButton(new ImageIcon("parametres_bt.gif" ));
	
	
	    //Add background       
	    background = new ImageIcon("fond_param.png").getImage();
	    
	    //Slider
	    slider = new Slider();
	      
    
}
	
	 public void paintComponent(Graphics g) {
		    super.paintComponent(g);
			g.drawImage(background,0,0,null);    
			play_song.setBounds(775, 200, 63, 93);
		    play_song.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		    play_song.setContentAreaFilled(false);
		    play_song.setBorderPainted(false);
		    add(play_song);
		    stop_song.setBounds(845, 197, 63, 93);
		    stop_song.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		    stop_song.setContentAreaFilled(false);
		    stop_song.setBorderPainted(false);
		    add(stop_song);
		    song_played.setBounds(775, 200, 63, 93);
		    song_played.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		    song_played.setContentAreaFilled(false);
		    song_played.setBorderPainted(false);
		    add(song_played);
		    song_stoped.setBounds(845, 197, 63, 93);
		    song_stoped.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		    song_stoped.setContentAreaFilled(false);
		    song_stoped.setBorderPainted(false);
		    add(song_stoped);
			geek_jaune.setBounds(770, 420, 74, 60);
			geek_jaune.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			geek_jaune.setContentAreaFilled(false);
			geek_jaune.setBorderPainted(false);
		    add(geek_jaune);
		    geek_gris.setBounds(770, 420, 74, 60);
		    geek_gris.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		    geek_gris.setContentAreaFilled(false);
		    geek_gris.setBorderPainted(false);
		    add(geek_gris);
		    girly_jaune.setBounds(855, 408, 54, 72);
		    girly_jaune.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		    girly_jaune.setContentAreaFilled(false);
		    girly_jaune.setBorderPainted(false);
		    add(girly_jaune);
		    girly_gris.setBounds(855,408, 54, 72);
		    girly_gris.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		    girly_gris.setContentAreaFilled(false);
		    girly_gris.setBorderPainted(false);
		    add(girly_gris);
			param.setBounds(950,10, 34, 34);
			param.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			param.setContentAreaFilled(false);
			param.setBorderPainted(false);
			add(param);/*
			slider.setBounds(500,500, 100, 100);
			slider.repaint();*/
     } 
	
}	
