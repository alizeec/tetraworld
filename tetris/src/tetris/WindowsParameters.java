package tetris;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class WindowsParameters extends JPanel {
	
    private PanelParameters panelParametres;
    private JPanel border;
	static Son musique_geek;
	static Son musique_girly;
	
	public WindowsParameters(){
	    
	    //création panel
	    /*border = new JPanel();
		border.setLayout(new BorderLayout());
		
		// panel = panelParameters
		panelParametres = new PanelParameters();
		panelParametres.setOpaque(false);
		panelParametres.setFocusable(true);
		panelParametres.requestFocus();
		panelParametres.stop_song.setVisible(false);
		panelParametres.song_played.setVisible(false);
	    border.add(panelParametres,BorderLayout.CENTER);
	    this.getContentPane().add(border);
	    setVisible(true);
	    
	    //musique	    
	    musique_geek = new Son("musique_tetris1"); 	    
	    musique_girly = new Son("musique_tetris2");
	    
	    //action boutons
	    panelParametres.play_song.addActionListener(this);
	    panelParametres.stop_song.addActionListener(this);
	    panelParametres.song_played.addActionListener(this);
	    panelParametres.song_stoped.addActionListener(this);*/
	}

	
	 public static void main(String[] args){
		 new WindowsParameters();
		 musique_geek.lecture();
	}
	 
	 public void actionPerformed(ActionEvent e) 
	    {
	        System.out.println(e.getSource());
	        System.out.println(e.getID());
	    	if(e.getSource() == panelParametres.play_song)
	        {            
	             musique_geek.stop();
	             panelParametres.stop_song.setVisible(true);
	             panelParametres.song_played.setVisible(true);
	             panelParametres.play_song.setVisible(false);
	             
	        }
	        else if(e.getSource() == panelParametres.stop_song)
	        {
	        	 musique_geek.lecture();
	             panelParametres.stop_song.setVisible(false);
	             panelParametres.play_song.setVisible(true);
	        }
	        else if(e.getSource() == panelParametres.song_stoped)
	        {
	        	 musique_geek.stop();
	             panelParametres.play_song.setVisible(false);
	             panelParametres.stop_song.setVisible(true);
	             panelParametres.song_played.setVisible(true);
	        }
	        else if(e.getSource() == panelParametres.song_played)
	        {
	        	 musique_geek.lecture();
	             panelParametres.stop_song.setVisible(false);
	             panelParametres.play_song.setVisible(true);
	             panelParametres.song_stoped.setVisible(true);
	        }
	    }
}
