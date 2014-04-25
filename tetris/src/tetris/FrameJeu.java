package tetris;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class FrameJeu extends JFrame{
	private PanelJeu panelJeu;
	PanelParameters panelParametres;
	private Plateau plateau;
	private JLabel labelscore;
	private JPanel border;
	ImageIcon background;
	JLabel picture;
	JTextArea text;
	
	static Son musique_geek;
	static Son musique_girly;
	
	public FrameJeu(Plateau plateau){
		this.setTitle("TetraWord");        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLocation(250,100);
        this.setSize(1000,700);
        this.setResizable(false);
        
        border = new JPanel();
		border.setLayout(new BorderLayout());
		
		/*background = new ImageIcon(this.getClass().getResource("tetris.gif"));
        picture = new JLabel(new ImageIcon(background.getImage()));*/
       // add(picture);
        //border.add(picture); 
	    
	    this.plateau = plateau;

	    panelJeu = new PanelJeu(this.plateau);
	    panelJeu.setOpaque(false);
	    panelJeu.setBackground(new Color(129,0,0));
	    panelJeu.setFocusable(true);
	    panelJeu.requestFocus();
	    panelJeu.addKeyListener(new EcouteurClavier(this.plateau, this));
        panelJeu.addMouseListener(new EcouteurSouris(this.plateau,this));
        panelJeu.valider.addMouseListener(new EcouteurSouris(this.plateau,this));
        panelJeu.supp.addMouseListener(new EcouteurSouris(this.plateau,this));
	    panelJeu.param.addMouseListener(new EcouteurSouris(this.plateau,this));
	    
	    panelParametres = new PanelParameters();
		panelParametres.setOpaque(false);
		panelParametres.setFocusable(true);
		panelParametres.requestFocus();
		panelParametres.stop_song.setVisible(false);
		panelParametres.song_played.setVisible(false);
		
		//musique	    
	    musique_geek = new Son("musique_tetris1"); 	    
	    musique_girly = new Son("musique_tetris2");
	    
	    //action boutons
	    panelParametres.play_song.addMouseListener(new EcouteurSouris(this.plateau,this));
	    panelParametres.addMouseListener(new EcouteurSouris(this.plateau,this));
	    panelParametres.song_played.addMouseListener(new EcouteurSouris(this.plateau,this));
	    panelParametres.song_stoped.addMouseListener(new EcouteurSouris(this.plateau,this));
	    //border.add(panelJeu,BorderLayout.CENTER);
	    
	    this.setPanel(1);
	  	
		//this.getContentPane().add(border);
	    setVisible(true);
	}
	
	public PanelJeu getPanel(){
		return panelJeu;
	}
	
	public void setPanel(int panel){
		if(panel == 1){//Si PanelJeu
			this.setContentPane(panelJeu);
		}else if(panel==2){//Si PanelParameters
			this.setContentPane(panelParametres);
		}
		setVisible(true);
	}
	
	
}
