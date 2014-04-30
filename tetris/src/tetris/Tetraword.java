package tetris;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.LinkedList;
import java.util.Map;
import java.util.Timer;





public class Tetraword {
	

	private static final int UPDATES_PER_SECOND = 3;
	boolean game=true;
	int cpt = 0;
	int TAUX_ANAGRAMME = 30;
	static int TAUX_VOYELLES=5;
	static int TAUX_CONSONNES=4;
	static int TAUX_RARES=2;


	
	
	public void startGame(Plateau plateau , FrameJeu jeu, Mots worddle, Mots anagramme) {

	 long start = 0L;
	 long sleepDuration = 0L;


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
				  int X = plateau.briqueActuelle.getPosition().posX;
				  int Y = plateau.briqueActuelle.getPosition().posY;
				  Cellule newposition = new Cellule(X, Y+1);
				  if(plateau.verifMove(plateau.briqueActuelle, newposition)){
					  plateau.videCaseBrique(plateau.briqueActuelle);
					  plateau.briqueActuelle.descendre();
					  plateau.placeBrique(plateau.briqueActuelle);
				  }else{
					  plateau.verifLignes(plateau.briqueActuelle);
					  plateau.briqueActuelle = null;
					  Brique newBrique = plateau.creerBrique(TAUX_VOYELLES, TAUX_CONSONNES, TAUX_RARES);
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
	  if (plateau.mode==Mode.ANAGRAMME){
		  
		  boolean result=false;
		  jeu.repaint();
		  if(plateau.motEnCours!=null){
			  if(anagramme.motfini(plateau.motEnCours)){
	
				try {
					result=anagramme.findWord(plateau.motEnCours);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				if(result && plateau.motEnCours.length()>=calculPourcentage(TAUX_ANAGRAMME)+1){
					anagramme.resultatCorrect(plateau);
				}
				else{
					anagramme.resultatInCorrect(plateau);
				}
				plateau.motEnCours=null;
				plateau.totalMot=0;
				plateau.nbLignesCompletes--;
				cpt++;
				if(plateau.nbLignesCompletes > 0){
					plateau.indexLigneSupp = plateau.lignesCompletes[cpt];
				}else{
					plateau.mode=Mode.TETRIS;
				}

			  }
		  }
	  }
	  
	  if(plateau.mode==Mode.WORDDLE){
		  boolean result=false;
		  if(plateau.positionEnCours==null){
				worddle.initialiseWorddle( plateau);
				System.out.println("partez de la brique : "+plateau.positionEnCours.posX+" Y:"+ plateau.positionEnCours.posY);
			}

		  if (plateau.tempsEcoule < 30*1000) {
			  jeu.repaint();
			  plateau.tempsEcoule = (new Date()).getTime() - plateau.instantDepart;
			  if(plateau.motEnCours!=null){
				  if(worddle.motfini(plateau.motEnCours)){
		
					try {
						result=worddle.findWord(plateau.motEnCours);
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
					if(!result){
						worddle.resultatCorrectWorddle(plateau);
					}else{
						worddle.resultatCorrectWorddle(plateau);
					}
					System.out.println("fini");
					plateau.motEnCours=null;
					plateau.totalMot=0;
					plateau.nbConnexion=0;
					plateau.positionEnCours=null;
				  }
			  }
			  
		  }else{
			  System.out.println("temps ecoulé");
			  worddle.supprLettresWorddle(plateau);
			  plateau.mode=Mode.TETRIS;
		  }
	  }
	  
	     if (plateau.mode==Mode.PARAMETRES){
	    	 jeu.repaint();
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
	
//// FIN DE LA BOUCLE PRINCIPALE

	
	public  int calculPourcentage(int taux){
		System.out.println((10*taux)/100);
		return (10*taux)/100;
	}

	// pour le panneau de conf
	public static void setLettersRates(Plateau plateau){
		plateau.TAUX_CONSONNES =TAUX_CONSONNES;
		plateau.TAUX_VOYELLES =TAUX_VOYELLES;
		plateau.TAUX_RARES =TAUX_RARES;

	}

	

	public static void main(String[] args) {
		Plateau plateau= new Plateau();
		FrameJeu framejeu = new FrameJeu(plateau);
		Tetraword jeu=new Tetraword();
		Mots worddle=new Mots();
		Mots anagramme=new Mots();
		setLettersRates(plateau);


		jeu.startGame(plateau,framejeu, worddle, anagramme);
				
	}
		
		 
}
