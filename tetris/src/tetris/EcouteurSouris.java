package tetris;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.Vector;

/**
 * 
 * récupère les actions souris de l'utilisateur
 *
 */
public class EcouteurSouris implements MouseListener
{
	/**
	 * liste des joueurs
	 */
	LinkedList<Plateau> joueurs;
	FrameJeu frame;
	Mots anagramme;
	String background;
	
	EcouteurSouris(LinkedList<Plateau> joueurs, FrameJeu frame){
		this.frame = frame;
		this.joueurs = joueurs;
	}
	


	@Override
	/**
	 * récupère les click de l'utilisateur et agit en conséquence
	 */
    public void mouseClicked(MouseEvent e) 
    {
   
    if(e.getSource() == frame.getPanelJeu().paramJeu){
    	if(joueurs.size()==1){    
    	frame.setPanel(2);
    	}else if (joueurs.size()==2){
    		frame.setPanel(3);
    	}
    		joueurs.get(0).mode=Mode.PARAMETRES;
    		joueurs.get(0).pause=true;
    		if(joueurs.size()>1){
        		joueurs.get(1).pause=true;

    		}
    	}
    

    if(e.getSource() == frame.getPanelDemarrage().bt_start){
    	frame.setPanel(1);
    	FrameJeu.musique_geek.lecture();
	    }
    else if(e.getSource() == frame.getPanelDemarrage().bt_exit){
    	System.exit(0);
 	    }
    else if(e.getSource() == frame.getPanelDemarrage().bt_multi){
    	Tetraword.multijoueur = true;
    	frame.setPanel(1);
 	    }
    //clic param mode solo
    if(e.getSource() == frame.getPanelParametres().param || e.getSource() == frame.getPanelParametresMultijoueur().param){
    	
    		 Tetraword.setTauxLettres(PanelParameters.valeur_taux_consonnes, PanelParameters.valeur_taux_voyelles, PanelParameters.valeur_taux_rares, joueurs.get(0));
    		 Tetraword.setTauxFormes(PanelParameters.valeur_taux_bleu, PanelParameters.valeur_taux_cyan, PanelParameters.valeur_taux_jaune,PanelParameters.valeur_taux_magenta, PanelParameters.valeur_taux_orange, PanelParameters.valeur_taux_rouge, PanelParameters.valeur_taux_vert, joueurs.get(0));
    	
    	 if(joueurs.size()>1){
	    	Tetraword.setTauxLettres(PanelParametersMultijoueur.valeur_taux_consonnes, PanelParametersMultijoueur.valeur_taux_voyelles, PanelParametersMultijoueur.valeur_taux_rares, joueurs.get(1));
		    Tetraword.setTauxFormes(PanelParametersMultijoueur.valeur_taux_bleu, PanelParametersMultijoueur.valeur_taux_cyan, PanelParametersMultijoueur.valeur_taux_jaune,PanelParametersMultijoueur.valeur_taux_magenta, PanelParametersMultijoueur.valeur_taux_orange, PanelParametersMultijoueur.valeur_taux_rouge, PanelParametersMultijoueur.valeur_taux_vert, joueurs.get(1));
			Tetraword.setTauxLettres(PanelParametersMultijoueur.valeur_taux_consonnes, PanelParametersMultijoueur.valeur_taux_voyelles, PanelParametersMultijoueur.valeur_taux_rares, joueurs.get(0));
		    Tetraword.setTauxFormes(PanelParametersMultijoueur.valeur_taux_bleu, PanelParametersMultijoueur.valeur_taux_cyan, PanelParametersMultijoueur.valeur_taux_jaune,PanelParametersMultijoueur.valeur_taux_magenta, PanelParametersMultijoueur.valeur_taux_orange, PanelParametersMultijoueur.valeur_taux_rouge, PanelParametersMultijoueur.valeur_taux_vert, joueurs.get(0));
		  }
    	frame.setPanel(1);
    	// a changer, mode TETRIS par modeSauvegarde
	    joueurs.get(0).mode=Mode.TETRIS;

	    joueurs.get(0).pause=false;

		if(joueurs.size()>1){
		    joueurs.get(1).mode=Mode.TETRIS;
		    joueurs.get(1).pause=false;

	 }
	}
    
    		
    if(e.getSource() == frame.getPanelJeu().valider){
    	joueurs.get(0).motEnCours+="\n";
	}
    
    if(e.getSource() == frame.getPanelJeu().valider2){
    	joueurs.get(1).motEnCours+="\n";
	}
    
    if(e.getSource() == frame.panelParametres.play_song || e.getSource() == frame.panelParametresMulti.play_song)
    {           
    	frame. musique_geek.stop();
    	frame.panelParametres.stop_song.setVisible(true);
    	frame.panelParametres.song_played.setVisible(true);
    	frame.panelParametres.play_song.setVisible(false);
    	frame.panelParametresMulti.stop_song.setVisible(true);
    	frame.panelParametresMulti.song_played.setVisible(true);
    	frame.panelParametresMulti.play_song.setVisible(false);
         
    }
    else if(e.getSource() == frame.panelParametres.stop_song || e.getSource() == frame.panelParametresMulti.stop_song)
    {System.out.println("coucou");      
    	frame.musique_geek.lecture();
    	frame.panelParametres.stop_song.setVisible(false);
    	frame.panelParametres.play_song.setVisible(true);
      	frame.panelParametresMulti.stop_song.setVisible(false);
    	frame.panelParametresMulti.play_song.setVisible(true);
    }
    else if(e.getSource() == frame.panelParametres.song_stoped || e.getSource() == frame.panelParametresMulti.song_stoped)
    {System.out.println("coucou");      
    	frame.musique_geek.stop();
    	frame.panelParametres.play_song.setVisible(false);
    	frame.panelParametres.stop_song.setVisible(true);
    	frame.panelParametres.song_played.setVisible(true);
       	frame.panelParametresMulti.play_song.setVisible(false);
    	frame.panelParametresMulti.stop_song.setVisible(true);
    	frame.panelParametresMulti.song_played.setVisible(true);
    }
    else if(e.getSource() == frame.panelParametres.song_played || e.getSource() == frame.panelParametresMulti.song_played)
    {System.out.println("coucou");      
    	frame.musique_geek.lecture();
    	frame.panelParametres.stop_song.setVisible(false);
    	frame.panelParametres.play_song.setVisible(true);
    	frame.panelParametres.song_stoped.setVisible(true);
    	frame.panelParametresMulti.stop_song.setVisible(false);
    	frame.panelParametresMulti.play_song.setVisible(true);
    	frame.panelParametresMulti.song_stoped.setVisible(true);
    }
    
    //bt bg
    if(e.getSource() == frame.panelParametres.geek_jaune || e.getSource() == frame.panelParametresMulti.geek_jaune)
    {            
    	frame.musique_geek.stop();
    	frame.musique_girly.lecture();
    	frame.panelParametres.geek_jaune.setVisible(false);
    	frame.panelParametres.geek_gris.setVisible(true);
    	frame.panelParametres.girly_jaune.setVisible(true);
    	frame.panelParametres.girly_gris.setVisible(false);
    	frame.panelParametresMulti.geek_jaune.setVisible(false);
    	frame.panelParametresMulti.geek_gris.setVisible(true);
    	frame.panelParametresMulti.girly_jaune.setVisible(true);
    	frame.panelParametresMulti.girly_gris.setVisible(false);
    	frame.getPanelJeu().background = frame.getPanelJeu().background_girly;
    	
         
    }
    else if(e.getSource() == frame.panelParametres.geek_gris || e.getSource() == frame.panelParametresMulti.geek_gris)
    {
    	//frame.musique_geek.lecture();
    	frame.panelParametres.geek_gris.setVisible(false);
    	frame.panelParametres.geek_jaune.setVisible(true);
    	frame.panelParametres.girly_jaune.setVisible(false);
    	frame.panelParametres.girly_gris.setVisible(true);
    	frame.panelParametresMulti.geek_gris.setVisible(false);
    	frame.panelParametresMulti.geek_jaune.setVisible(true);
    	frame.panelParametresMulti.girly_jaune.setVisible(false);
    	frame.panelParametresMulti.girly_gris.setVisible(true);
    	frame.getPanelJeu().background = frame.getPanelJeu().background_geek;
    	
    }
    else if(e.getSource() == frame.panelParametres.girly_gris || e.getSource() == frame.panelParametresMulti.girly_gris)
    {
    	//frame.musique_geek.stop();
    	frame.panelParametres.girly_gris.setVisible(false);
    	frame.panelParametres.girly_jaune.setVisible(true);
    	frame.panelParametres.geek_jaune.setVisible(false);
    	frame.panelParametres.geek_gris.setVisible(true);
    	frame.panelParametresMulti.girly_gris.setVisible(false);
    	frame.panelParametresMulti.girly_jaune.setVisible(true);
    	frame.panelParametresMulti.geek_jaune.setVisible(false);
    	frame.panelParametresMulti.geek_gris.setVisible(true);
    	frame.getPanelJeu().background = frame.getPanelJeu().background_girly;
    	frame.musique_geek.stop();
    	frame.musique_girly.lecture();
    	
    }
    else if(e.getSource() == frame.panelParametres.girly_jaune || e.getSource() == frame.panelParametresMulti.girly_jaune)
    {
    	//frame.musique_geek.lecture();
    	frame.panelParametres.girly_jaune.setVisible(false);
    	frame.panelParametres.girly_gris.setVisible(true);
    	frame.panelParametres.geek_jaune.setVisible(true);
    	frame.panelParametres.geek_gris.setVisible(false);
     	frame.panelParametresMulti.girly_jaune.setVisible(false);
    	frame.panelParametresMulti.girly_gris.setVisible(true);
    	frame.panelParametresMulti.geek_jaune.setVisible(true);
    	frame.panelParametresMulti.geek_gris.setVisible(false);
    	frame.getPanelJeu().background = frame.getPanelJeu().background_geek;
    }
    
    //bt langue
    if(e.getSource() == frame.panelParametres.en_gris || e.getSource() == frame.panelParametresMulti.en_gris)
    {           
    	frame.panelParametres.en_gris.setVisible(false);
    	frame.panelParametres.en.setVisible(true);
    	frame.panelParametres.fr_gris.setVisible(true);
    	frame.panelParametres.fr.setVisible(false);
     	frame.panelParametresMulti.en_gris.setVisible(false);
    	frame.panelParametresMulti.en.setVisible(true);
    	frame.panelParametresMulti.fr_gris.setVisible(true);
    	frame.panelParametresMulti.fr.setVisible(false);
    	frame.panelParametres.choix_langue = 0;
    	frame.panelParametresMulti.choix_langue = 0;
         
    }
    else if(e.getSource() == frame.panelParametres.en || e.getSource() == frame.panelParametresMulti.en_gris)
    {
    	frame.panelParametres.en.setVisible(false);
    	frame.panelParametres.en_gris.setVisible(true);
    	frame.panelParametres.fr_gris.setVisible(false);
    	frame.panelParametres.fr.setVisible(true);
    	frame.panelParametresMulti.en.setVisible(false);
    	frame.panelParametresMulti.en_gris.setVisible(true);
    	frame.panelParametresMulti.fr_gris.setVisible(false);
    	frame.panelParametresMulti.fr.setVisible(true);
    	frame.panelParametres.choix_langue = 1;
    	frame.panelParametresMulti.choix_langue = 1;
    	
    }
    else if(e.getSource() == frame.panelParametres.fr || e.getSource() == frame.panelParametresMulti.en_gris)
    {
    	frame.panelParametres.fr.setVisible(false);
    	frame.panelParametres.fr_gris.setVisible(true);
    	frame.panelParametres.en_gris.setVisible(false);
    	frame.panelParametres.en.setVisible(true);
    	frame.panelParametresMulti.fr.setVisible(false);
    	frame.panelParametresMulti.fr_gris.setVisible(true);
    	frame.panelParametresMulti.en_gris.setVisible(false);
    	frame.panelParametresMulti.en.setVisible(true);
    	frame.panelParametres.choix_langue = 0;
    	frame.panelParametresMulti.choix_langue = 0;

    	
    }
    else if(e.getSource() == frame.panelParametres.fr_gris || e.getSource() == frame.panelParametresMulti.en_gris)
    {
    	frame.panelParametres.fr_gris.setVisible(false);
    	frame.panelParametres.fr.setVisible(true);
    	frame.panelParametres.en_gris.setVisible(true);
    	frame.panelParametres.en.setVisible(false);
    	frame.panelParametresMulti.fr_gris.setVisible(false);
    	frame.panelParametresMulti.fr.setVisible(true);
    	frame.panelParametresMulti.en_gris.setVisible(true);
    	frame.panelParametresMulti.en.setVisible(false);
    	frame.panelParametres.choix_langue = 1;
    	frame.panelParametresMulti.choix_langue = 1;
    }
		
		
		if(e.getSource() == frame.getPanelJeu().supp){
			joueurs.get(0).motEnCours = joueurs.get(0).motEnCours.substring(0, joueurs.get(0).motEnCours.length()-1);
			if(joueurs.get(0).mode==Mode.WORDDLE && joueurs.get(0).nbConnexion>=1){
				joueurs.get(0).nbConnexion--;
			}
		}
		
		if(e.getSource() == frame.getPanelJeu().supp2){
			joueurs.get(1).motEnCours = joueurs.get(1).motEnCours.substring(0, joueurs.get(1).motEnCours.length()-1);
			if(joueurs.get(1).mode==Mode.WORDDLE && joueurs.get(1).nbConnexion>=1){
				joueurs.get(1).nbConnexion--;
			}
		}
		
    	if (e.getButton()==MouseEvent.BUTTON1){
    		
    		if(joueurs.size()==1){
        	//verifie qu'on est dans le tableau
        	if(e.getX()<349 || e.getX()>650 || e.getY()<42 || e.getY()>647){
                System.out.printf("hors du  tableau \n ");
        	}
        	else{
        		//pour avoir la cellule correspondante
                 int X = (e.getX()-349)/30;
                 int Y = (e.getY() - 42)/30;
                
                if(joueurs.get(0).mode==Mode.ANAGRAMME){
                	modeAnagramme(X,Y, joueurs.get(0));
                }
                                
                if(joueurs.get(0).mode==Mode.WORDDLE){
                	modeWorddle(X,Y,joueurs.get(0));
                }
                                
        	}
        }
    		
    	if(joueurs.size()==2){
    		if(joueurs.get(0).mode==Mode.ANAGRAMME || joueurs.get(0).mode==Mode.WORDDLE){
            	//verifie qu'on est dans le tableau
            	if(e.getX()<254 || e.getX()>555 || e.getY()<110 || e.getY()>715){
                    System.out.printf("hors du  tableau \n ");
            	}
            	else{
            		//pour avoir la cellule correspondante
                     int X = (e.getX()-254)/30;
                     int Y = (e.getY() - 110)/30;
                    
                    if(joueurs.get(0).mode==Mode.ANAGRAMME){
                    	modeAnagramme(X,Y, joueurs.get(0));
                    }
                                    
                    if(joueurs.get(0).mode==Mode.WORDDLE){
                    	modeWorddle(X,Y,joueurs.get(0));
                    }
                                    
            	}
    		}
    		if(joueurs.get(1).mode==Mode.ANAGRAMME || joueurs.get(1).mode==Mode.WORDDLE){
            	//verifie qu'on est dans le tableau
            	if(e.getX()<715 || e.getX()>1016 || e.getY()<110 || e.getY()>715){
                    System.out.printf("hors du  tableau \n ");
            	}
            	else{
            		//pour avoir la cellule correspondante
                     int X = (e.getX()-715)/30;
                     int Y = (e.getY() - 110)/30;
                    
                    if(joueurs.get(1).mode==Mode.ANAGRAMME){
                    	modeAnagramme(X,Y, joueurs.get(1));
                    }
                                    
                    if(joueurs.get(1).mode==Mode.WORDDLE){
                    	modeWorddle(X,Y,joueurs.get(1));
                    }
                                    
            	}
    		}
        }
    		
    	
    }
    }
    
    public void modeAnagramme(int X, int Y,Plateau plateau){
    	if(Y==plateau.indexLigneSupp){
			plateau.setMessage("");
    		StringBuffer tmp = new StringBuffer();
    		if(plateau.tab[X][Y]!=null){
    			//récupération de la brique et de sa lettre
            	int id=plateau.tab[X][Y].getId();
            	char lettre=plateau.tab[X][Y].getLettre();
            	
            	//formation du mot
            	tmp=tmp.append(lettre);
            	if(plateau.motEnCours==null){
            		plateau.motEnCours=tmp.toString();
            	}
            	else{
            		plateau.motEnCours=plateau.motEnCours+tmp.toString();
            	}
            	// récupération du total de point que vaut le mot
            	plateau.totalMot+=plateau.briques.get(id).getPoints(); 
    		}

    	}
		else{
			plateau.setMessage("Vous devez cliquer sur la ligne complète");
		}
    }
    
    public void modeWorddle(int X, int Y,Plateau plateau){
		StringBuffer tmp = new StringBuffer();
		if(((plateau.positionEnCours.getPosY()-Y)<=1 && (plateau.positionEnCours.getPosY()-Y)>=-1 )  && ((plateau.positionEnCours.getPosX()-X)<=1 && (plateau.positionEnCours.getPosX()-X)>=-1 ) )
		{
			if((plateau.positionEnCours.getPosY()==Y  && plateau.positionEnCours.getPosX()==X)){
				plateau.setMessage("Il faut cliquer sur une case autour");
			}
			else if(plateau.nbConnexion>7){
				plateau.setMessage("Le mot est trop long");

			}
			else{
				plateau.setMessage("");

        		if(plateau.tab[X][Y]!=null && plateau.tab[X][Y].utilisee == false){
        			//récupération de la brique et de sa lettre
                	int id=plateau.tab[X][Y].getId();
                	char lettre=plateau.tab[X][Y].getLettre();
                	plateau.tab[X][Y].utilisee = true;
                	//formation du mot
                	tmp=tmp.append(lettre);
                	if(plateau.motEnCours==null){
                		plateau.motEnCours=tmp.toString();
                	}
                	else{
                		plateau.motEnCours=plateau.motEnCours+tmp.toString();
                	}
                	// récupération du total de point que vaut le mot
                	plateau.totalMot+=plateau.briques.get(id).getPoints(); 
            		plateau.positionEnCours.setPosY(Y);
            		plateau.positionEnCours.setPosX(X);
            		plateau.nbConnexion++;
            		boolean existe = false;
            		for (int i=0; i<plateau.BriquesUtilisees.size(); ++i){
            			if(plateau.BriquesUtilisees.get(i).getPosX() == X && plateau.BriquesUtilisees.get(i).getPosY() == Y){
            				existe = true;
            				break;
            			}
            		}
            		if(existe == false){
            			plateau.BriquesUtilisees.add(plateau.tab[X][Y]);
            		}
        		}
        		else{
        			System.out.println("rien dans cette case");

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

