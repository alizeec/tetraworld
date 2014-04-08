package tetris;
import java.util.HashMap;
import java.util.Map;

public class Plateau {
	Cellule tab[][];
	Map briques;

	public Plateau() {
		// TODO Auto-generated constructor stub
		this.tab = new Cellule[10][20];
		this.briques = new HashMap();
		}
	
	public boolean placeBrick(Brique brique){
		//récupération de la position de la brique pour la placer sur le plateau
		int weight=brique.getPosition().weight;
		int height=brique.getPosition().height;
		tab[weight][height]=brique.getPosition();
		// ajout de la forme (niveau graphique) et de l'id (niveau physique) à la cellule du plateau
		for (int i=0; i<3; ++i){
			for (int j=0; j<3 ; ++j){
				if(brique.tab[i][j]==true){
					tab[weight+i][height+j].forme=brique.getPosition().forme;
					tab[weight+i][height+j].id=brique.getId();

				}
			}
		}
		
		// ajout de la brique dans la map, avec son identifiant pour clé
		briques.put(brique.getId(),brique);

		return true;
	}
	
	public boolean deplaceBrick(Brique brique, Cellule newposition){
		/*
		 * Vérifie si le déplacement est possible
		 * if (!verifMove(brique)){
		 * 	// throw exception "déplacement pas possible
		 * return false
		 * }
		 */
		//récupération de la position de la brique pour la placer sur le plateau
		int weight=brique.getPosition().weight;
		int height=brique.getPosition().height;
		// ajout de la forme (niveau graphique) et de l'id (niveau physique) à la cellule du plateau
		for (int i=0; i<3; ++i){
			for (int j=0; j<3 ; ++j){
				if(brique.tab[i][j]==true){
					tab[weight+i][height+j].forme=0;
					tab[weight+i][height+j].id=0;

				}
			}
		}			
		/* ????? PAS COMPRIS ????*/
		
		/* if (action utilisateur){
		 * 	brique.updatePosition(Cellule newposition);	
		 * }
		 * else {
		 * 	brique.drop();
		 * }
		 * 	
		 */
		
		this.placeBrick(brique);	
		
		return true; //POURQUOI BOOLEAN ?
	}
	
	public boolean verifMove(Cellule newposition){
		return true;
	}
		
	
	public static void main(String[] args){
		// test de récupération de données par clés = OK
		Plateau plateau = new Plateau();
		plateau.briques.put(1, "element 1");
		plateau.briques.put(2, "element 2");
		plateau.briques.put(3, "element 3");
		String element1 = (String) plateau.briques.get(3);
		System.out.println(element1);
		//

	}

}
