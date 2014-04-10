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
		//récupération de la position de la brique pour la placer sur le plateau
		int X=brique.getPosition().posX;
		int Y=brique.getPosition().posY;
		tab[X][Y]=brique.getPosition();
		// ajout de la forme (niveau graphique) et de l'id (niveau physique) à la cellule du plateau
		for (int i=0; i<3; ++i){
			for (int j=0; j<3 ; ++j){
				if(brique.tab[j][i]==true){
					tab[Y+j][X+i].forme=brique.getPosition().forme;
					tab[Y+j][X+i].id=brique.getId();

				}
			}
		}
		
		// ajout de la brique dans la map, avec son identifiant pour clé
		briques.put(brique.getId(),brique);

		return true;
	}
	
	public boolean deplaceBrique(Brique brique, Cellule newposition){
		/*
		 * Vérifie si le déplacement est possible
		 * if (!verifMove(newposition)){
		 * 	// throw exception "déplacement pas possible
		 * return false
		 * }
		 */
		//récupération de la position de la brique pour la placer sur le plateau
		int X=brique.getPosition().posX;
		int Y=brique.getPosition().posY;
		tab[X][Y]=brique.getPosition();
		// ajout de la forme (niveau graphique) et de l'id (niveau physique) à la cellule du plateau
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
	
	public Brique creerBrique(){
		// valeurs à générer aléatoirement, MAGENTA et a pour les tests
		Forme forme = Forme.MAGENTA;
		char lettre = 'a';
		Brique b = null;
		switch(forme){
			case MAGENTA:
				 b = new BriqueMagenta(lettre);
				 break;				
		}
		// ajouter une exception pour verifier que b n'est pas null
		return b;

	}
	
	public static void main(String[] args){
		// test de récupération de données par clés = OK
		Plateau plateau = new Plateau();
		/*plateau.briques.put(1, "element 1");
		plateau.briques.put(2, "element 2");
		plateau.briques.put(3, "element 3");
		String element1 = (String) plateau.briques.get(3);*/
		
		//test de rotation = OK
		System.out.println("HAUT");
		Brique b= plateau.creerBrique();
		b.afficher();
		
		System.out.println("DROITE");
		b.tournerBrique(Rotation.DROITE);
		b.afficher();
		
		System.out.println("BAS");
		b.tournerBrique(Rotation.BAS);
		b.afficher();

		System.out.println("GAUCHE");
		b.tournerBrique(Rotation.GAUCHE);
		b.afficher();

	}

}


	

		
