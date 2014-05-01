package tetris;

public  class Multijoueur  extends Thread {
	
	Plateau plateau;
	
public Multijoueur(Plateau plateau ){
	this. plateau = plateau;
}
    // surcharge de la méthode run() de la classe Thread
    public  void run() {
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
				  Brique newBrique = plateau.creerBrique(plateau.TAUX_VOYELLES, plateau.TAUX_CONSONNES, plateau.TAUX_RARES);
				  plateau.briqueActuelle = newBrique;
	
				  plateau.placeBrique(newBrique);
			  }
    	}
    }
}

