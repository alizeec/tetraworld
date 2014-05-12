package tetris;

import java.util.Random;

/**
 * 
 * les différentes formes possibles
 *
 */
public enum Forme {
	ROUGE,
	BLEU,
	VERT,
	ORANGE,
	MAGENTA,
	CYAN,
	JAUNE;
	
	/**
	 * donne une forme par tirage aléatoire
	 * @return Forme
	 */
	public static Forme getForme(int b, int c, int j, int m, int o, int r, int v) {
		Forme forme = null;
		// génération aléatoire pondérée de la lettre
				Integer quotient = (int)(Math.random() * (14-1)) + 1;
				if(quotient < b){
					forme = Forme.BLEU; 
				}
		        else if(quotient < b+c){
		    		forme = Forme.CYAN;
		    		
		        }
		        else if(quotient < b+c+j){
		        	forme = Forme.JAUNE;	
		        	
		        }
		        else if(quotient < b+c+j+m){
		        	forme = Forme.MAGENTA;
		        	
		        }
		        else if(quotient < b+c+j+m+o){
		        	forme = Forme.ORANGE;
		        	
		        }
		        else if(quotient < b+c+j+m+o+r){
		        	forme = Forme.ROUGE;
		        	
		        }
		        else if(quotient <= b+c+j+m+o+r+v){
		        	forme = Forme.VERT;	
		        	
		        }

				if(forme==null){
					forme=Forme.VERT;
				}
				return forme;
    }

}
