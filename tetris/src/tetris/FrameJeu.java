package tetris;


import javax.swing.JFrame;

public class FrameJeu extends JFrame{
	private PanelJeu panelJeu;
	private Plateau plateau;
	
	public FrameJeu(Plateau plateau){
		setTitle("Tetra Word");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setLocationRelativeTo(null);
	    setSize(400,700);
	    setResizable(false);
	    this.plateau = plateau;
	    panelJeu = new PanelJeu(this.plateau);
	    panelJeu.setFocusable(true);
	    panelJeu.requestFocus();
	    panelJeu.addKeyListener(new EcouteurClavier(this.plateau, this));
	    this.getContentPane().add(panelJeu);
	    setVisible(true);
	}
	
}
