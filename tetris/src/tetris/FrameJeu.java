package tetris;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * création de la fenêtre de jeu
 *
 */
public class FrameJeu extends JFrame{
	private PanelJeu panelJeu;
	PanelParameters panelParametres;
	private Plateau plateau1;
	private LinkedList<Plateau> joueurs;

	private JLabel labelscore;
	private JPanel border;
	ImageIcon background;
	JLabel picture;
	
	static Son musique_geek;
	static Son musique_girly;
	
	/**
	 * création de la fenêtre en fonction du nombre de joueurs
	 * @param LinkedList<Plateau> joueurs liste des joueurs
	 */
	public FrameJeu(LinkedList<Plateau> joueurs){
		this.setTitle("TetraWord");        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLocation(250,100);
        if(joueurs.size()==1){
        	this.setSize(1000,700);

        }
        else if(joueurs.size()==2){
        	this.setSize(1276,794);
        }
        this.setResizable(false);
        
        border = new JPanel();
		border.setLayout(new BorderLayout());
		
 
	    
	    this.plateau1 = joueurs.get(0);

	    panelJeu = new PanelJeu(joueurs);
	    panelJeu.setOpaque(false);
	    panelJeu.setBackground(new Color(129,0,0));
	    panelJeu.setFocusable(true);
	    panelJeu.requestFocus();
	    panelJeu.addKeyListener(new EcouteurClavier(joueurs, this));
        panelJeu.addMouseListener(new EcouteurSouris(joueurs,this));
        panelJeu.valider.addMouseListener(new EcouteurSouris(joueurs,this));
        panelJeu.supp.addMouseListener(new EcouteurSouris(joueurs,this));
        panelJeu.valider2.addMouseListener(new EcouteurSouris(joueurs,this));
        panelJeu.supp2.addMouseListener(new EcouteurSouris(joueurs,this));
	    panelJeu.paramJeu.addMouseListener(new EcouteurSouris(joueurs,this));
	    
	    


	    
	    panelParametres = new PanelParameters();
		panelParametres.setOpaque(false);
		panelParametres.setFocusable(true);
		panelParametres.requestFocus();
		panelParametres.stop_song.setVisible(false);
		panelParametres.song_played.setVisible(false);
		panelParametres.geek_gris.setVisible(false);
		panelParametres.girly_jaune.setVisible(false);
		panelParametres.en.setVisible(false);
		
		panelParametres.param.addMouseListener(new EcouteurSouris(joueurs,this));
		
		//musique	    
	    musique_geek = new Son("musique_tetris1"); 	    
	    musique_girly = new Son("musique_tetris2");
	    musique_geek.lecture();
	    
	    //action boutons
	    panelParametres.play_song.addMouseListener(new EcouteurSouris(joueurs,this));
	    panelParametres.addMouseListener(new EcouteurSouris(joueurs,this));
	    panelParametres.song_played.addMouseListener(new EcouteurSouris(joueurs,this));
	    panelParametres.song_stoped.addMouseListener(new EcouteurSouris(joueurs,this));
	    panelParametres.stop_song.addMouseListener(new EcouteurSouris(joueurs,this));
	    panelParametres.geek_jaune.addMouseListener(new EcouteurSouris(joueurs,this));
	    panelParametres.geek_gris.addMouseListener(new EcouteurSouris(joueurs,this));
	    panelParametres.girly_jaune.addMouseListener(new EcouteurSouris(joueurs,this));
	    panelParametres.girly_gris.addMouseListener(new EcouteurSouris(joueurs,this));
	    panelParametres.en.addMouseListener(new EcouteurSouris(joueurs,this));
	    panelParametres.fr.addMouseListener(new EcouteurSouris(joueurs,this));
	    panelParametres.en_gris.addMouseListener(new EcouteurSouris(joueurs,this));
	    panelParametres.fr_gris.addMouseListener(new EcouteurSouris(joueurs,this));
	    
	    
	    
	    

	    //border.add(panelJeu,BorderLayout.CENTER);
	    
	    this.setPanel(1);
	  	
		//this.getContentPane().add(border);
	    setVisible(true);
	}
	
	/**
	 * 
	 * @return PanelJeu panelJeu
	 */
	public PanelJeu getPanelJeu(){
			return panelJeu;
	}
	
	/**
	 * 
	 * @return PanelParameters panelParametres
	 */
	public PanelParameters getPanelParametres(){
		return panelParametres;
}
	
	/**
	 * charge le bon panel (jeu ou paramètres)
	 * @param int panel
	 */
	public void setPanel(int panel){
		if(panel == 1){//Si PanelJeu
			this.setContentPane(panelJeu);
		}else if(panel==2){//Si PanelParameters
			this.setContentPane(panelParametres);
		}
		setVisible(true);
	}
	

	
	
}
