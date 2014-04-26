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
	public void keyPressed(KeyEvent e){//m�thode qui �coute lorsque l'on appui sur une touche
		int touche = e.getKeyCode();
		
		switch (touche) {
		case KeyEvent.VK_RIGHT :
			X = plateau.briqueActuelle.getPosition().posX;
			Y = plateau.briqueActuelle.getPosition().posY;
			newposition = new Cellule(X+1, Y);
			if(plateau.verifMove(plateau.briqueActuelle, newposition)){
				plateau.deplaceBrique(plateau.briqueActuelle, newposition);
			}
			//D�placer la pi�ce vers la droite
		break;
		case KeyEvent.VK_LEFT :
			//D�placer la pi�ce vers la gauche
			X = plateau.briqueActuelle.getPosition().posX;
			Y = plateau.briqueActuelle.getPosition().posY;
			newposition = new Cellule(X-1, Y);
			if(plateau.verifMove(plateau.briqueActuelle, newposition)){
				plateau.deplaceBrique(plateau.briqueActuelle, newposition);
			}
		break;
		case KeyEvent.VK_DOWN :
			//Acc�l�rer la d�scente
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
		case KeyEvent.VK_C :
			if(plateau.mode != Mode.WORDDLE){
				Brique b = plateau.creerBrique();
				plateau.placeBrique(b);
			}
			
		break;
		case KeyEvent.VK_P:
			if(plateau.mode != Mode.WORDDLE){
				plateau.pause=true;
			}
		break;
		case KeyEvent.VK_O:
			if(plateau.mode != Mode.WORDDLE){
				plateau.pause=false;
			}
		break;
		case KeyEvent.VK_W:
			if(plateau.mode != Mode.WORDDLE){
				plateau.mode=Mode.WORDDLE;
				
			}
			plateau.timer();
		break;
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
