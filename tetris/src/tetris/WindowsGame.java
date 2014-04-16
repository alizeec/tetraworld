package tetris;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class WindowsGame extends JFrame{
	
	 JPanel panel; 
	 ImageIcon background;
	 JLabel picture;
	 int recupScore = 521;
	 
	 public WindowsGame()
	    {
	        panel = new JPanel();
	        panel.setOpaque(true);
	       /* panel.setOpaque(false);
	        panel.setSize(400,700);*/
	        		 	     	        
	        //Display score 
	        Container cont = this.getContentPane();	        
	        JLabel score = new JLabel();
	        score.setForeground(Color.white);
	        score.setFont(new Font("Serif", Font.BOLD, 30));
	        score.setText(String.valueOf(recupScore));
		    cont.add(score, BorderLayout.SOUTH);
	        
			       
	        //Add background       
	        background = new ImageIcon(this.getClass().getResource("../img/tetris.jpg"));
	        picture = new JLabel(new ImageIcon(background.getImage()));
	       // add(picture);
	        panel.add(picture); 
	      	        
	        	        
	        //Windows
	        this.setTitle("TetraWord");        
	        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	        this.setLocationRelativeTo(null);
	        this.setLocation(250,100);
	        this.setSize(1000,700);
	        this.setResizable(false);
	        this.setVisible(true);
			this.add(panel, BorderLayout.SOUTH);
	     
			
			
	    }
	 
	 public static void main(String agrs[])
	    {
	        new WindowsGame();
	    }
}