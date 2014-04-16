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
public class FrameJeu extends JFrame{
	private PanelJeu panelJeu;
	private Plateau plateau;
	private JPanel panelBackground; 
	private ImageIcon background;
	private JLabel picture;
	private int recupScore = 521;
	
	public FrameJeu(Plateau plateau){
		
		// Affichage Plateau
	    this.plateau = plateau;
	    panelJeu = new PanelJeu(this.plateau);
	    panelJeu.setFocusable(true);
	    panelJeu.requestFocus();
	    panelJeu.addKeyListener(new EcouteurClavier(this.plateau, this));
	    this.getContentPane().add(panelJeu);
	    
        //Affichage du score 
        Container cont = this.getContentPane();	        
        JLabel score = new JLabel();
        score.setForeground(Color.white);
        score.setFont(new Font("Serif", Font.BOLD, 30));
        score.setText(String.valueOf(recupScore));
	    cont.add(score, BorderLayout.SOUTH);
	    
	    //Affichage du background 
	    panelBackground = new JPanel();
	    panelBackground.setOpaque(true);
        background = new ImageIcon(this.getClass().getResource("../img/tetris.gif"));
        picture = new JLabel(new ImageIcon(background.getImage()));
        panelBackground.add(picture); 
        
        // Fenetre
        this.setTitle("TetraWord");        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLocation(250,100);
        this.setSize(1000,700);
        this.setResizable(false);
        this.setVisible(true);
		this.add(panelBackground, BorderLayout.SOUTH);
	}
}