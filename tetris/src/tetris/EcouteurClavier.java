package tetris;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.JPanel;

/**
 * 
 * rŽcup�re les actions clavier de l'utilisateur
 *
 */
public class EcouteurClavier implements KeyListener{
	/**
	 * Plateaux des joueurs
	 */
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
	public void keyPressed(KeyEvent e){//méthode qui écoute lorsque l'on appui sur une touche
		int touche = e.getKeyCode();
		
		switch(touche){
		case KeyEvent.VK_RIGHT :
			X = plateau1.briqueActuelle.getPosition().getPosX();
			Y = plateau1.briqueActuelle.getPosition().getPosY();
			newposition = new Cellule(X+1, Y);
			if(plateau1.verifMove(plateau1.briqueActuelle, newposition)){
				plateau1.deplaceBrique(plateau1.briqueActuelle, newposition);
			}
		break;
		
		/**
		 * aller ˆ gauche pour le joueur1
		 */
		case KeyEvent.VK_LEFT :
			X = plateau1.briqueActuelle.getPosition().getPosX();
			Y = plateau1.briqueActuelle.getPosition().getPosY();
			newposition = new Cellule(X-1, Y);
			if(plateau1.verifMove(plateau1.briqueActuelle, newposition)){
				plateau1.deplaceBrique(plateau1.briqueActuelle, newposition);
			}
		break;
		
		/**
		 * accŽl�re la descente pour le joueur1
		 */
		case KeyEvent.VK_DOWN :
			X = plateau1.briqueActuelle.getPosition().getPosX();
			Y = plateau1.briqueActuelle.getPosition().getPosY();
			newposition = new Cellule(X, Y+1);
			if(plateau1.verifMove(plateau1.briqueActuelle, newposition)){
				plateau1.deplaceBrique(plateau1.briqueActuelle, newposition);
			}
		break;
		
		/**
		 * tourne la brique pour le joueur1
		 */
		case KeyEvent.VK_UP :
			plateau1.briqueActuelle.tourner();
			plateau1.deplaceBrique(plateau1.briqueActuelle, plateau1.briqueActuelle.getPosition());
		break;
		
		/**
		 * aller ˆ droite pour le joueur2
		 */
		//joueur2
		case KeyEvent.VK_H :
			if(plateau2 != null){
				X = plateau2.briqueActuelle.getPosition().getPosX();
				Y = plateau2.briqueActuelle.getPosition().getPosY();
				newposition = new Cellule(X+1, Y);
				if(plateau2.verifMove(plateau2.briqueActuelle, newposition)){
					plateau2.deplaceBrique(plateau2.briqueActuelle, newposition);
				}
			}
		break;
		
		/**
		 * aller ˆ gauche pour le joueur2
		 */
		case KeyEvent.VK_G :
			if(plateau2 != null){
				X = plateau2.briqueActuelle.getPosition().getPosX();
				Y = plateau2.briqueActuelle.getPosition().getPosY();
				newposition = new Cellule(X-1, Y);
				if(plateau2.verifMove(plateau2.briqueActuelle, newposition)){
					plateau2.deplaceBrique(plateau2.briqueActuelle, newposition);
				}
			}
		break;
		
		/** accŽl�re la descente pour le joueur2
		 * 
		 */
		case KeyEvent.VK_B:
			if(plateau2 != null){
				X = plateau2.briqueActuelle.getPosition().getPosX();
				Y = plateau2.briqueActuelle.getPosition().getPosY();
				newposition = new Cellule(X, Y+1);
				if(plateau2.verifMove(plateau2.briqueActuelle, newposition)){
					plateau2.deplaceBrique(plateau2.briqueActuelle, newposition);
				}
			}
		break;
		
		/**
		 * fait tourner la brique pour le joueur2
		 */
		case KeyEvent.VK_SPACE :
			if(plateau2 != null){
			plateau2.briqueActuelle.tourner();
			plateau2.deplaceBrique(plateau2.briqueActuelle, plateau2.briqueActuelle.getPosition());
			}
		break;
		
		
		/**
		 * met en pause
		 */
		case KeyEvent.VK_P:
				plateau1.pause=true;
				if(plateau2!=null)
				plateau2.pause=true;
		break;
		
		/**
		 * reprend la partie
		 */
		case KeyEvent.VK_O:
				plateau1.pause=false;
				if(plateau2!=null)
				plateau2.pause=false;

		break;
		
		/**
		 * lance le mode WORDDLE pour le joueur1
		 */
		case KeyEvent.VK_W:
			if(plateau2 == null ||plateau2.mode != Mode.WORDDLE){
				plateau1.mode=Mode.WORDDLE;
				
			}
			else{
				System.out.println("Votre adversaire est deja en mode worddle");
			}
			plateau1.timer();
		break;
		
		/**
		 * lance le mode WORDDLE pour le joueur2
		 */
		case KeyEvent.VK_X:
			if(plateau2 != null && plateau1.mode != Mode.WORDDLE){
				plateau2.mode=Mode.WORDDLE;
				
			}
			else{
				System.out.println("Votre adversaire est deja en mode worddle");
			}
			plateau2.timer();
		break;
		
		/**
		 * sauvegarde l'Žtat en cours du joueur1
		 */
		case KeyEvent.VK_S:
			try {
				plateau1.sauvegarder(1);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		break;
		

		
		/** charge la derni�re sauvegarde du joueur1
		 * 
		 */
		case KeyEvent.VK_D:
			try {
				plateau1.charger(1);
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
		
		/**
		 * sauvegarde l'�tat en cours du joueur2
		 */
		case KeyEvent.VK_L:
			try {
				plateau2.sauvegarder(2);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		break;
		
		/** charge la derni�re sauvegarde du joueur2
		 * 
		 */
		case KeyEvent.VK_M:
			try {
				plateau2.charger(2);
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
