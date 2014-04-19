package tetris;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class EcouteurSouris implements MouseListener
{
	Plateau plateau;
	FrameJeu frame;
	
	EcouteurSouris(Plateau plateau, FrameJeu frame){
		this.frame = frame;
		this.plateau = plateau;
	}
	
    @Override
    public void mouseClicked(MouseEvent e) 
    {
        if (e.getButton()==MouseEvent.BUTTON1){
        	if(e.getX()<349 || e.getX()>650 || e.getY()<42 || e.getY()>647){
                System.out.printf("hors du  tableau \n ");



        	}
        	else{
                System.out.printf("dans le tableau \n");
                int X = (e.getX()-349)/30;
                int Y = (e.getY() - 42)/30;
                System.out.printf("X repère tableau: "+X + "Y: "+Y);
                if(plateau.tab[X][Y]!=null){
                	int id=plateau.tab[X][Y].getId();
                	char lettre=plateau.briques.get(id).getLettre();
                    System.out.println("lettre: "+lettre);

                }
                else{
                    System.out.println("il n'y a rien ici");

                }

        	}
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}

