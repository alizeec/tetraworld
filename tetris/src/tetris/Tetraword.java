package tetris;





public class Tetraword {
	

	private static final int UPDATES_PER_SECOND = 10;

	
	public void startGame(Plateau plateau) {

	 long start = 0L;
	 long sleepDuration = 0L;


	 while(true) {

	  /*
	   * dŽbut de la boucle
	   */
	  start = System.currentTimeMillis();
	  
	  /*
	   * Update the game.
	   */
	  //test de la fonction descendre()
	  if(plateau.briqueActuelle != null){
		  plateau.briqueActuelle.descendre();
	  }

	  /*affichage*/
	  
	  /* nettoyage de l'Žcran*/
	   
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
		jeu.startGame(plateau);
		
	}
		
		 
}
