package tetris;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.LinkedList;
import java.util.Map;
import java.util.Timer;



/**
 * boucle principale. Jeu en lui-même
 * 
 *
 */

public class Tetraword extends Thread{
	

	private static final int UPDATES_PER_SECOND = 3;
	boolean game=true;
	
	Plateau joueur;
	static boolean multijoueur = false;
	static boolean gameStarted = false;
	




	/**
	 * boucle principale
	 * @param joueurs liste des joueurs
	 * @param jeu fenêtre
	 * @param worddle pour le mode WORDDLE
	 * @param anagramme pour le mode ANAGRAMME
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	
	public void startGame(LinkedList<Plateau> joueurs , FrameJeu jeu, Mots worddle, Mots anagramme) throws FileNotFoundException, IOException {
	
	 long start = 0L;
	 long sleepDuration = 0L;

	  Plateau plateau = joueurs.get(0);
	  Plateau plateau2 = null;
	  Brique b = plateau.creerBrique();
	  plateau.placeBrique(b);
	  if(joueurs.size()>1){
		   plateau2 = joueurs.get(1);
		   Brique b2 = plateau2.creerBrique();
			plateau2.placeBrique(b2);
	  }
	  
	 while(game) {
	  /*
	   * dŽbut de la boucle
	   */
	  start = System.currentTimeMillis();
	  
	  /*
	   * Update the game.
	   */

	  if(plateau.pause==false && plateau.mode==Mode.TETRIS){
			  if(plateau.briqueActuelle != null){
				  int X = plateau.briqueActuelle.getPosition().getPosX();
				  int Y = plateau.briqueActuelle.getPosition().getPosY();
				  Cellule newposition = new Cellule(X, Y+1);
				  if(plateau.verifMove(plateau.briqueActuelle, newposition)){
					  plateau.videCaseBrique(plateau.briqueActuelle);
					  plateau.briqueActuelle.descendre();
					  plateau.placeBrique(plateau.briqueActuelle);
				  }else{
					  if(plateau.verifLignes()==true){
						  plateau.mode = Mode.ANAGRAMME;
					  }
					  plateau.briqueActuelle = null;
					  Brique newBrique = plateau.creerBrique();
					  plateau.briqueActuelle = newBrique;
		
					  plateau.placeBrique(newBrique);
				  }
			  }
		
			  /*affichage*/
			  jeu.repaint();
			  if(plateau.perdu==true){
				  game=false;
			  }
	  }	 
	  if(joueurs.size()>1){
	  if(plateau2.pause==false && plateau2.mode==Mode.TETRIS){
		  if(plateau2.briqueActuelle != null){
			  int X = plateau2.briqueActuelle.getPosition().getPosX();
			  int Y = plateau2.briqueActuelle.getPosition().getPosY();
			  Cellule newposition = new Cellule(X, Y+1);
			  if(plateau2.verifMove(plateau2.briqueActuelle, newposition)){
				  plateau2.videCaseBrique(plateau2.briqueActuelle);
				  plateau2.briqueActuelle.descendre();
				  plateau2.placeBrique(plateau2.briqueActuelle);
			  }else{
				  if(plateau2.verifLignes()==true){
					  plateau2.mode = Mode.ANAGRAMME;
				  }
				  plateau2.briqueActuelle = null;
				  Brique newBrique = plateau2.creerBrique();
				  plateau2.briqueActuelle = newBrique;
	
				  plateau2.placeBrique(newBrique);
			  }
		  }

		  /*affichage*/
		  jeu.repaint();
		  if(plateau2.perdu==true){
			  game=false;
		  }
  }	
	  }
	  
	  
	  
	  if (plateau.mode==Mode.ANAGRAMME || (plateau2!=null && plateau2.mode==Mode.ANAGRAMME)){
		  if(plateau.mode==Mode.ANAGRAMME){
			  anagramme( plateau,  anagramme,  jeu);
		  }
		  
		  if(plateau2!=null && plateau2.mode==Mode.ANAGRAMME){
			  anagramme( plateau2,  anagramme,  jeu);
		  }

	  }
	  
	  if(plateau.mode==Mode.WORDDLE || (plateau2!=null && plateau2.mode==Mode.WORDDLE)){
		  
		  if(plateau.mode==Mode.WORDDLE){

			  worddle( plateau,  worddle,  jeu);
		  }
		  if(plateau2!=null && plateau2.mode==Mode.WORDDLE){
			  worddle( plateau2,  worddle,  jeu);
		  }
		 
	  }
	  
	     if (plateau.mode==Mode.PARAMETRES){

	     }
	  
	     if(joueurs.size()>1){
	    	 plateau.sauvegarderModificateur(1);
	    	 plateau2.sauvegarderModificateur(2);

	     }
	  
	  sleepDuration = (1000L / (UPDATES_PER_SECOND + plateau.getNiveau())) - (System.currentTimeMillis() - start);
	  
	  if(sleepDuration > 0) {
	   try {
	    Thread.sleep(sleepDuration);
	   } catch(Exception e) {
	    e.printStackTrace();
	   }
	  }
	 }
	}
	
	





	/**  mode ANAGRAMME
	 * 
	 * @param Plateau plateau
	 * @param Mots anagramme
	 * @param FrameJeu jeu
	 */
	public void anagramme(Plateau plateau, Mots anagramme, FrameJeu jeu){
		  boolean result=false;
		  jeu.repaint();
		  if(plateau.motEnCours!=null){
			  if(anagramme.motfini(plateau.motEnCours)){

				try {
					System.out.println(plateau.motEnCours);
					result=anagramme.findWord(plateau.motEnCours);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				if(result && plateau.motEnCours.length()>=PanelParameters.difficulte_anagramme){
					anagramme.resultatCorrectAnagramme(plateau);
					plateau.BriquesUtiliseesEnCours.clear();
				}
				else{
					anagramme.resultatInCorrect(plateau);
					plateau.lignesPerdues[plateau.nbLignesPerdues] = plateau.indexLigneSupp;
					plateau.nbLignesPerdues++;
					for(int i=0; i<plateau.BriquesUtiliseesEnCours.size(); ++i){
						int X = plateau.BriquesUtiliseesEnCours.get(i).getPosX();
						int Y = plateau.BriquesUtiliseesEnCours.get(i).getPosY();
						plateau.tab[X][Y].utilisee = false;
						
					}
					plateau.BriquesUtiliseesEnCours.clear();
				}
				plateau.motEnCours=null;
				plateau.totalMot=0;
				if(plateau.verifLignes()==false){
					for(int i=0;i<plateau.nbLignesPerdues;++i){
						plateau.lignesPerdues[i] = 0;
					}
					plateau.nbLignesPerdues = 0;
					plateau.mode=Mode.TETRIS;
				}

			  }
		  }
	}
	
	/**  mode WORDDLE
	 * 
	 * @param Plateau plateau
	 * @param Mots anagramme
	 * @param FrameJeu jeu
	 */
	public void worddle(Plateau plateau, Mots worddle, FrameJeu jeu){
		  boolean result=false;
		  if(plateau.positionEnCours==null){
				worddle.initialiseWorddle( plateau);
				System.out.println("partez de la brique : "+plateau.positionEnCours.getPosX()+" Y:"+ plateau.positionEnCours.getPosY());
			}

		  if (plateau.tempsEcoule < 30*1000) {
			  jeu.repaint();
			  plateau.tempsEcoule = (new Date()).getTime() - plateau.instantDepart;
			  if(plateau.motEnCours!=null){
				  if(worddle.motfini(plateau.motEnCours)){
		
					try {
						System.out.println(plateau.motEnCours);
						result=worddle.findWord(plateau.motEnCours);
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
					if(!result){
						worddle.resultatInCorrect(plateau);
						for(int i=0; i<plateau.BriquesUtiliseesEnCours.size(); ++i){
							int X = plateau.BriquesUtiliseesEnCours.get(i).getPosX();
							int Y = plateau.BriquesUtiliseesEnCours.get(i).getPosY();
							plateau.tab[X][Y].utilisee = false;
							
						}
						plateau.BriquesUtiliseesEnCours.clear();
					}else{
						worddle.resultatCorrectWorddle(plateau);
					}
					plateau.motEnCours=null;
					plateau.totalMot=0;
					plateau.nbConnexion=0;
					plateau.positionEnCours=null;

				  }
			  }
			  
		  }else{
				plateau.motEnCours=null;
				plateau.totalMot=0;
				plateau.nbConnexion=0;
				plateau.positionEnCours=null;
				worddle.supprLettresWorddle(plateau);

				plateau.BriquesUtilisees.clear();
				for(int i=0; i<plateau.BriquesUtiliseesEnCours.size(); ++i){
					int X = plateau.BriquesUtiliseesEnCours.get(i).getPosX();
					int Y = plateau.BriquesUtiliseesEnCours.get(i).getPosY();
					plateau.tab[X][Y].utilisee = false;
					
				}
				plateau.BriquesUtiliseesEnCours.clear();

			  plateau.mode=Mode.TETRIS;
		  }
	}
	
	/**
	 * définie les taux pour chaques types de lettres (consonnes, voyelles, rares)
	 * @param plateau
	 */
	public static void setTauxLettres(int consonnes, int voyelles, int rares, Plateau plateau){
		plateau.TAUX_CONSONNES=consonnes;
		plateau.TAUX_VOYELLES=voyelles;
		plateau.TAUX_RARES=rares;
	}
	
	/**
	 * définie les taux pour chaques types de briques 
	 * @param plateau
	 */
	public static void setTauxFormes(int bleue, int cyan, int jaune,int magenta, int orange, int rouge, int verte, Plateau plateau){
		plateau.TAUX_BLEUE=bleue;
		plateau.TAUX_CYAN=cyan;
		plateau.TAUX_JAUNE=jaune;
		plateau.TAUX_MAGENTA=magenta;
		plateau.TAUX_ORANGE=orange;
		plateau.TAUX_ROUGE=rouge;
		plateau.TAUX_VERTE=verte;

	}

	
/**
 * main principal
 * @param args
 * @throws IOException 
 * @throws FileNotFoundException 
 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		LinkedList<Plateau> joueurs = new LinkedList<Plateau>();
		FrameJeu framejeu = new FrameJeu();
		
		while(!gameStarted){
			System.out.println("choix du mode");

		}
		System.out.println(multijoueur);

		if(!multijoueur){
		Plateau plateau= new Plateau(349, "Joueur 1");
		joueurs.add(plateau);
		setTauxLettres(3, 5, 2, plateau);

		setTauxFormes(2, 2, 2,2, 2, 2, 2,plateau);

		}
		else if(multijoueur){
		Plateau plateau= new Plateau(716, "Joueur 1");

		Plateau plateau2= new Plateau(256, "Joueur 2");
		joueurs.add(plateau);
		joueurs.add(plateau2);

		setTauxLettres(3, 5, 2, plateau);
		setTauxLettres(3, 5, 2, plateau2);
		
		setTauxFormes(2, 2, 2,2, 2, 2, 2,plateau);
		setTauxFormes(2, 2, 2,2, 2, 2, 2,plateau2);


		}

		
		framejeu.setJoueurs(joueurs);
		framejeu.setPanel(1);
		
		Mots worddle=new Mots();
		Mots anagramme=new Mots();


		Tetraword jeu = new Tetraword();

		 


		jeu.startGame(joueurs,framejeu, worddle, anagramme);
				
	}




		
		 
}
