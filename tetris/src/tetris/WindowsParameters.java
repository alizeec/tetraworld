package tetris;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class WindowsParameters extends JFrame {
	
    private PanelParameters panelParametres;
    private JPanel border;
	static Son musique1;
	
	public WindowsParameters(){
		
		/*panelParametres = new PanelParameters();
	    this.setContentPane(panelParametres);*/
	    //this.getContentPane().repaint();
	    
	    this.setTitle("Parameters");        
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.setLocation(250,100);
	    this.setSize(1000,700);
	    this.setResizable(false);
	    
	    border = new JPanel();
		border.setLayout(new BorderLayout());
		
		panelParametres = new PanelParameters();
		panelParametres.setOpaque(false);
		panelParametres.setBackground(new Color(129,0,0));
		panelParametres.setFocusable(true);
		panelParametres.requestFocus();
	    border.add(panelParametres,BorderLayout.CENTER);
	    

		this.getContentPane().add(border);
	    setVisible(true);
	    
		
	    
	   	musique1 = new Son("musique_tetris2");
	   	
	   /* this.setVisible(true);*/
	}
	
	public PanelParameters getPanelParameters(){
		return panelParametres;
	}
	 public static void main(String[] args){
		 new WindowsParameters();
		 musique1.lecture();
	}
}
