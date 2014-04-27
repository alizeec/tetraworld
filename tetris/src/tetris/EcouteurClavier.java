package tetris;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JPanel;


public class EcouteurClavier implements KeyListener{
	Plateau plateau;
	FrameJeu frame;
	int X;
	int Y;
	Cellule newposition;
	
	EcouteurClavier(Plateau plateau, FrameJeu frame){
		this.frame = frame;
		this.plateau = plateau;
	}
	
	public void keyPressed(KeyEvent e){//mÈthode qui Ècoute lorsque l'on appui sur une touche
		int touche = e.getKeyCode();
		
		switch (touche) {
		case KeyEvent.VK_RIGHT :
			X = plateau.briqueActuelle.getPosition().posX;
			Y = plateau.briqueActuelle.getPosition().posY;
			newposition = new Cellule(X+1, Y);
			if(plateau.verifMove(plateau.briqueActuelle, newposition)){
				plateau.deplaceBrique(plateau.briqueActuelle, newposition);
			}
			//DÈplacer la piËce vers la droite
		break;
		
		case KeyEvent.VK_LEFT :
			//DÈplacer la piËce vers la gauche
			X = plateau.briqueActuelle.getPosition().posX;
			Y = plateau.briqueActuelle.getPosition().posY;
			newposition = new Cellule(X-1, Y);
			if(plateau.verifMove(plateau.briqueActuelle, newposition)){
				plateau.deplaceBrique(plateau.briqueActuelle, newposition);
			}
		break;
		
		case KeyEvent.VK_DOWN :
			//AccÈlÈrer la dÈscente
			X = plateau.briqueActuelle.getPosition().posX;
			Y = plateau.briqueActuelle.getPosition().posY;
			newposition = new Cellule(X, Y+1);
			if(plateau.verifMove(plateau.briqueActuelle, newposition)){
				plateau.deplaceBrique(plateau.briqueActuelle, newposition);
			}
		break;
		
		case KeyEvent.VK_SPACE :
			plateau.briqueActuelle.tourner();
			plateau.deplaceBrique(plateau.briqueActuelle, plateau.briqueActuelle.getPosition());
			//Rotation
		break;
		
		//crée la première brique
		case KeyEvent.VK_C :
				Brique b = plateau.creerBrique(plateau.TAUX_VOYELLES, plateau.TAUX_CONSONNES, plateau.TAUX_RARES);
				plateau.placeBrique(b);	
		break;
		
		// met en pause
		case KeyEvent.VK_P:
				plateau.pause=true;
		break;
		
		// reprend la partie
		case KeyEvent.VK_O:
				plateau.pause=false;
		break;
		
		// lance le mode worddle
		case KeyEvent.VK_W:
			if(plateau.mode != Mode.WORDDLE){
				plateau.mode=Mode.WORDDLE;
				
			}
			plateau.timer();
		break;
		
		//sauvegarde
		case KeyEvent.VK_S:
			try {
				plateau.sauvegarder();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		break;
		
		//charge une sauvegarde
		case KeyEvent.VK_D:
			try {
				plateau.charger();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		break;


		}
		frame.repaint();
	}
	


	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
