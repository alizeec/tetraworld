package tetris;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;


public class EcouteurClavier implements KeyListener{
	Plateau plateau;
	FrameJeu frame;
	EcouteurClavier(Plateau plateau, FrameJeu frame){
		this.frame = frame;
		this.plateau = plateau;
	}
	public void keyPressed(KeyEvent e){//m�thode qui �coute lorsque l'on appui sur une touche
		System.out.println("touche");
		int touche = e.getKeyCode();
		
		switch (touche) {
		case KeyEvent.VK_RIGHT :
			//D�placer la pi�ce vers la droite
		break;
		case KeyEvent.VK_LEFT :
			//D�placer la pi�ce vers la gauche
		break;
		case KeyEvent.VK_DOWN :
			//Acc�l�rer la d�scente
		break;
		case KeyEvent.VK_SPACE :
			//Rotation
		break;
		case KeyEvent.VK_C :
			Brique b = plateau.creerBrique();
			System.out.println(b.getPosition().posY);
			plateau.placeBrique(b);
			
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
