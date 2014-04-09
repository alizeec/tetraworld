package tetris;
import java.util.HashMap;
import java.util.Map;

public class Plateau {
	Cellule tab[][];
	Map<Integer,Brique> briques;

	public Plateau() {
		// TODO Auto-generated constructor stub
		this.tab = new Cellule[10][20];
		this.briques = new HashMap();
		}
	
	public boolean placeBrique(Brique brique){
		//r�cup�ration de la position de la brique pour la placer sur le plateau
		int X=brique.getPosition().posX;
		int Y=brique.getPosition().posY;
		tab[X][Y]=brique.getPosition();
		// ajout de la forme (niveau graphique) et de l'id (niveau physique) � la cellule du plateau
		for (int i=0; i<3; ++i){
			for (int j=0; j<3 ; ++j){
				if(brique.tab[j][i]==true){
					tab[Y+j][X+i].forme=brique.getPosition().forme;
					tab[Y+j][X+i].id=brique.getId();

				}
			}
		}
		
		// ajout de la brique dans la map, avec son identifiant pour cl�
		briques.put(brique.getId(),brique);

		return true;
	}
	
	public boolean deplaceBrique(Brique brique, Cellule newposition){
		/*
		 * V�rifie si le d�placement est possible
		 * if (!verifMove(newposition)){
		 * 	// throw exception "d�placement pas possible
		 * return false
		 * }
		 */
		//r�cup�ration de la position de la brique pour la placer sur le plateau
		int X=brique.getPosition().posX;
		int Y=brique.getPosition().posY;
		tab[X][Y]=brique.getPosition();
		// ajout de la forme (niveau graphique) et de l'id (niveau physique) � la cellule du plateau
		for (int i=0; i<3; ++i){
			for (int j=0; j<3 ; ++j){
				if(brique.tab[j][i]==true){
					tab[Y+j][X+i].forme=brique.getPosition().forme;
					tab[Y+j][X+i].id=brique.getId();

				}
			}
		}
		/* if (action utilisateur){
		 * 	brique.updatePosition(Cellule newposition);	
		 * }
		 * else {
		 * 	brique.drop();
		 * }
		 * 	
		 */
		
		this.placeBrique(brique);	
		
		return true;
	}
	
	public boolean verifMove(Cellule newposition){
		return true;
	}
	
	public static void main(String[] args){
		// test de r�cup�ration de donn�es par cl�s = OK
		Plateau plateau = new Plateau();
		/*plateau.briques.put(1, "element 1");
		plateau.briques.put(2, "element 2");
		plateau.briques.put(3, "element 3");
		String element1 = (String) plateau.briques.get(3);*/
		
		

	}

}


	

		
