package tetris;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EcouteurSourisDemarrage implements MouseListener{
	FrameJeu frame;

	EcouteurSourisDemarrage(FrameJeu frame){
		this.frame=frame;
	}

	   public void mouseClicked(MouseEvent e) {
		    if(e.getSource() == frame.getPanelDemarrage().bt_start){
		    	System.out.println("choix fait");
		    	Tetraword.gameStarted=true;
		    	//frame.setPanel(1);
		    	FrameJeu.musique_geek.lecture();
		    	
			    }
		    else if(e.getSource() == frame.getPanelDemarrage().bt_exit){
		    	System.exit(0);
		 	    }
		    else if(e.getSource() == frame.getPanelDemarrage().bt_multi){
		    	System.out.println("choix fait");

		    	Tetraword.gameStarted=true;
		    	Tetraword.multijoueur = true;
		    	FrameJeu.musique_geek.lecture();
		 	    }
	    }

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
