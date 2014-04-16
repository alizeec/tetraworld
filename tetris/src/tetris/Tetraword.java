package tetris;





public class Tetraword {
	

	private static final int UPDATES_PER_SECOND = 3;

	
	public void startGame(Plateau plateau , FrameJeu jeu) {

	 long start = 0L;
	 long sleepDuration = 0L;


	 while(true) {
	  /*
	   * d�but de la boucle
	   */
	  start = System.currentTimeMillis();
	  
	  /*
	   * Update the game.
	   */
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
	  
	  /* nettoyage de l'�cran*/
	   
	  /*
	   * Set the time that the loop finished.
	   */
	  sleepDuration = (1000L / UPDATES_PER_SECOND) - (System.currentTimeMillis() - start);
	   
	  /*
	   * If the sleep duration is greater than 0 milliseconds, attempt to sleep.
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
		jeu.startGame(plateau,framejeu);
		
	}
		
		 
}
