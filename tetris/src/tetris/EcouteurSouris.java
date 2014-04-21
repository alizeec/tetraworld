package tetris;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class EcouteurSouris implements MouseListener
{
	Plateau plateau;
	FrameJeu frame;
	Mots anagramme;
	
	EcouteurSouris(Plateau plateau, FrameJeu frame){
		this.frame = frame;
		this.plateau = plateau;
	}
	
    @Override
    public void mouseClicked(MouseEvent e) 
    {

    if(e.getSource() == frame.getPanel().valider){
			plateau.motEnCours+="\n";
	}
		
		if(e.getSource() == frame.getPanel().supp){
			plateau.motEnCours = plateau.motEnCours.substring(0, plateau.motEnCours.length()-1);
		}
    	if (e.getButton()==MouseEvent.BUTTON1){
        	//verifie qu"on est dans le tableau
        	if(e.getX()<349 || e.getX()>650 || e.getY()<42 || e.getY()>647){
                System.out.printf("hors du  tableau \n ");
        	}
        	else{
        		//pour avoir la cellule correspondante
                int X = (e.getX()-349)/30;
                int Y = (e.getY() - 42)/30;
                
                
                /*   MODE ANAGRAMME   */
                if(plateau.mode==Mode.ANAGRAMME){
                	if(Y==plateau.indexLigneSupp){
                		StringBuffer tmp = new StringBuffer();
                		if(plateau.tab[X][Y]!=null){
                			//rŽcupŽration de la brique et de sa lettre
                        	int id=plateau.tab[X][Y].getId();
                        	char lettre=plateau.briques.get(id).getLettre();
                        	
                        	//formation du mot
                        	tmp=tmp.append(lettre);
                        	if(plateau.motEnCours==null){
                        		plateau.motEnCours=tmp.toString();
                        	}
                        	else{
                        		plateau.motEnCours=plateau.motEnCours+tmp.toString();
                        	}
                        	// rŽcupŽration du total de point que vaut le mot
                        	plateau.totalMot+=plateau.briques.get(id).point; 	                		
                		}

                	}
            		else{
            			System.out.println("Vous devez cliquer sur la ligne compl�te");
            		}
                }
                
                /* MODE WORDDLE  */
                
                if(plateau.mode==Mode.WORDDLE){
                		StringBuffer tmp = new StringBuffer();
                		if(plateau.tab[X][Y]!=null){
                			//rŽcupŽration de la brique et de sa lettre
                        	int id=plateau.tab[X][Y].getId();
                        	char lettre=plateau.briques.get(id).getLettre();
                        	
                        	//formation du mot
                        	tmp=tmp.append(lettre);
                        	if(plateau.motEnCours==null){
                        		plateau.motEnCours=tmp.toString();
                        	}
                        	else{
                        		plateau.motEnCours=plateau.motEnCours+tmp.toString();
                        	}
                        	// rŽcupŽration du total de point que vaut le mot
                        	plateau.totalMot+=plateau.briques.get(id).point; 	                		
                		}
                		else{
                			System.out.println("Il n'y a rien ici");
                		}
                		
                	
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

