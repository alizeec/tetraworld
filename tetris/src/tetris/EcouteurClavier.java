package tetris;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.JPanel;


public class EcouteurClavier implements KeyListener{
	Plateau plateau1;
	Plateau plateau2=null;

	LinkedList<Plateau> joueurs;
	FrameJeu frame;
	int X;
	int Y;
	Cellule newposition;
	
	EcouteurClavier(LinkedList<Plateau> joueurs, FrameJeu frame){
		this.frame = frame;
		this.plateau1 = joueurs.get(0);
		if(joueurs.size()>1){
			this.plateau2 = joueurs.get(1);
		}
	}
	
	public void keyPressed(KeyEvent e){//mÈthode qui Ècoute lorsque l'on appui sur une touche
		int touche = e.getKeyCode();
		
		switch (touche) {
		case KeyEvent.VK_RIGHT :
			X = plateau1.briqueActuelle.getPosition().posX;
			Y = plateau1.briqueActuelle.getPosition().posY;
			newposition = new Cellule(X+1, Y);
			if(plateau1.verifMove(plateau1.briqueActuelle, newposition)){
				plateau1.deplaceBrique(plateau1.briqueActuelle, newposition);
			}
			//DÈplacer la piËce vers la droite
		break;
		
		case KeyEvent.VK_LEFT :
			//DÈplacer la piËce vers la gauche
			X = plateau1.briqueActuelle.getPosition().posX;
			Y = plateau1.briqueActuelle.getPosition().posY;
			newposition = new Cellule(X-1, Y);
			if(plateau1.verifMove(plateau1.briqueActuelle, newposition)){
				plateau1.deplaceBrique(plateau1.briqueActuelle, newposition);
			}
		break;
		
		case KeyEvent.VK_DOWN :
			//AccÈlÈrer la dÈscente
			X = plateau1.briqueActuelle.getPosition().posX;
			Y = plateau1.briqueActuelle.getPosition().posY;
			newposition = new Cellule(X, Y+1);
			if(plateau1.verifMove(plateau1.briqueActuelle, newposition)){
				plateau1.deplaceBrique(plateau1.briqueActuelle, newposition);
			}
		break;
		
		case KeyEvent.VK_UP :
			plateau1.briqueActuelle.tourner();
			plateau1.deplaceBrique(plateau1.briqueActuelle, plateau1.briqueActuelle.getPosition());
			//Rotation
		break;
		
		//joueur2
		case KeyEvent.VK_H :
			X = plateau2.briqueActuelle.getPosition().posX;
			Y = plateau2.briqueActuelle.getPosition().posY;
			newposition = new Cellule(X+1, Y);
			if(plateau2.verifMove(plateau2.briqueActuelle, newposition)){
				plateau2.deplaceBrique(plateau2.briqueActuelle, newposition);
			}
			//DÈplacer la piËce vers la droite
		break;
		
		case KeyEvent.VK_G :
			//DÈplacer la piËce vers la gauche
			X = plateau2.briqueActuelle.getPosition().posX;
			Y = plateau2.briqueActuelle.getPosition().posY;
			newposition = new Cellule(X-1, Y);
			if(plateau2.verifMove(plateau2.briqueActuelle, newposition)){
				plateau2.deplaceBrique(plateau2.briqueActuelle, newposition);
			}
		break;
		
		case KeyEvent.VK_B:
			//AccÈlÈrer la dÈscente
			X = plateau2.briqueActuelle.getPosition().posX;
			Y = plateau2.briqueActuelle.getPosition().posY;
			newposition = new Cellule(X, Y+1);
			if(plateau2.verifMove(plateau2.briqueActuelle, newposition)){
				plateau2.deplaceBrique(plateau2.briqueActuelle, newposition);
			}
		break;
		
		case KeyEvent.VK_SPACE :
			plateau2.briqueActuelle.tourner();
			plateau2.deplaceBrique(plateau2.briqueActuelle, plateau2.briqueActuelle.getPosition());
			//Rotation
		break;
		
		
		
		
		
		
		//crée la première brique
		case KeyEvent.VK_C :
				Brique b = plateau1.creerBrique(plateau1.TAUX_VOYELLES, plateau1.TAUX_CONSONNES, plateau1.TAUX_RARES);
				plateau1.placeBrique(b);
				if(plateau2!=null){
					Brique b2 = plateau2.creerBrique(plateau2.TAUX_VOYELLES, plateau2.TAUX_CONSONNES, plateau2.TAUX_RARES);
					plateau2.placeBrique(b2);
				}
		break;
		
		// met en pause
		case KeyEvent.VK_P:
				plateau1.pause=true;
		break;
		
		// reprend la partie
		case KeyEvent.VK_O:
				plateau1.pause=false;
		break;
		
		// lance le mode worddle
		case KeyEvent.VK_W:
			if(plateau1.mode != Mode.WORDDLE){
				plateau1.mode=Mode.WORDDLE;
				
			}
			plateau1.timer();
		break;
		
		//sauvegarde
		case KeyEvent.VK_S:
			try {
				plateau1.sauvegarder();
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
				plateau1.charger();
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
