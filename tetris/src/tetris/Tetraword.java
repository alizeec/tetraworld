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

			  //test de la fonction descendre()
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
	  if (plateau.mode==Mode.ANAGRAMME){
		  
		  boolean result=false;
		  jeu.repaint();
		  if(plateau.motEnCours!=null){
			  if(anagramme.motfini(plateau.motEnCours)){
	
				try {
					result=anagramme.findWord(plateau.motEnCours);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(result){
					anagramme.resultatCorrect(plateau);
				}
				else{
					anagramme.resultatInCorrect();
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

		  if (plateau.tempsEcoule < 60*1000) {
		  jeu.repaint();
			  //System.out.println("Timer en marche : "+plateau.tempsEcoule);
			    //perform db poll/check
			  plateau.tempsEcoule = (new Date()).getTime() - plateau.instantDepart;
			  if(plateau.motEnCours!=null){
				  if(worddle.motfini(plateau.motEnCours)){
		
					try {
						result=worddle.findWord(plateau.motEnCours);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
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
					//plateau.mode=Mode.TETRIS;
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
	    	 /*plateau.pause=true;
			  WindowsParameters param = new WindowsParameters();
			  param.repaint();*/
	    	 jeu.repaint();
			  }

	  
	  /* nettoyage de l'Žcran*/
	   
	  /*
	   * Set the time that the loop finished.
	   */
	  sleepDuration = (1000L / (UPDATES_PER_SECOND + plateau.getNiveau())) - (System.currentTimeMillis() - start);
	   
	  /*
	   * If the sleep duration is greater than  0 milliseconds, attempt to sleep.
	   */
	  if(sleepDuration > 0) {
	   try {
	    Thread.sleep(sleepDuration);
	   } catch(Exception e) {
	    e.printStackTrace();
	   }
	  }
	 }
	}

	



	

	public static void main(String[] args) {
		Plateau plateau= new Plateau();
		FrameJeu framejeu = new FrameJeu(plateau);
		Tetraword jeu=new Tetraword();
		Mots worddle=new Mots();
		Mots anagramme=new Mots();


		jeu.startGame(plateau,framejeu, worddle, anagramme);
				
	}
		
		 
}
