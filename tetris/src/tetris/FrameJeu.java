package tetris;


import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrameJeu extends JFrame{
	private PanelJeu panelJeu;
	private Plateau plateau;
	private JLabel labelscore;
	private JPanel border;
	
	public FrameJeu(Plateau plateau){
		setTitle("Tetra Word");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setLocationRelativeTo(null);
	    setSize(200,600);
	    setResizable(false);
	    
	    border = new JPanel();
		border.setLayout(new BorderLayout());
	    
	    this.plateau = plateau;
	    panelJeu = new PanelJeu(this.plateau);
	    panelJeu.setFocusable(true);
	    panelJeu.requestFocus();
	    panelJeu.addKeyListener(new EcouteurClavier(this.plateau, this));
	    border.add(panelJeu,BorderLayout.CENTER);
	    
	    
	    JPanel panelscore = new JPanel();
	    System.out.println(plateau.getScore());
		labelscore = new JLabel("Score : "+plateau.getScore());
		panelscore.add(labelscore);
		panelscore.setBackground(new Color(183,141,110));
		panelscore.setBorder(BorderFactory.createLineBorder(Color.black));
		border.add(panelscore,BorderLayout.NORTH);
		
		
		this.getContentPane().add(border);
	    setVisible(true);
	}
	
}
