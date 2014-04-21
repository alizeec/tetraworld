package tetris;


import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrameJeu extends JFrame{
	private PanelJeu panelJeu;
	private Plateau plateau;
	private JLabel labelscore;
	private JLabel labelpreview;
	private JPanel border;
	ImageIcon background;
	 JLabel picture;
	 GestionBoutons ecouteur;
	
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
	    //ecouteur = new GestionBoutons(this.plateau, this);
	    panelJeu = new PanelJeu(this.plateau);
	    panelJeu.setOpaque(false);
	    panelJeu.setBackground(new Color(129,0,0));
	    panelJeu.setFocusable(true);
	    panelJeu.requestFocus();
	    panelJeu.addKeyListener(new EcouteurClavier(this.plateau, this));
        panelJeu.addMouseListener(new EcouteurSouris(this.plateau,this));
        panelJeu.valider.addActionListener(ecouteur);
        panelJeu.supp.addActionListener(ecouteur);
	    border.add(panelJeu,BorderLayout.CENTER);
	    

	    
		
		
		
		this.getContentPane().add(border);
	    setVisible(true);
	}
	
	public PanelJeu getPanel(){
		return panelJeu;
	}
	
	
}
