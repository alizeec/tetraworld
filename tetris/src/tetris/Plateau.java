package tetris;
import java.util.HashMap;
import java.util.Map;

public class Plateau {
	Cellule tab[][];
	int LARGEUR = 10;
	int HAUTEUR = 20;
	Map<Integer,Brique> briques;
	Brique briqueActuelle;

	public Plateau() {
		// TODO Auto-generated constructor stub
		this.tab = new Cellule[LARGEUR][HAUTEUR];
		this.briques = new HashMap();
	}
	
	public int getLargeur(){
		return LARGEUR;
	}
	
	public int getHauteur(){
		return HAUTEUR;
	}
	
	public boolean placeBrique(Brique brique){
		//récupération de la position de la brique pour la placer sur le plateau
		int X=brique.getPosition().posX;
		int Y=brique.getPosition().posY;
		//tab[X][Y]=brique.getPosition();
		// ajout de la forme (niveau graphique) et de l'id (niveau physique) à la cellule du plateau
		for (int i=0; i<4; ++i){
			for (int j=0; j<4 ; ++j){
				if(brique.tab[i][j]==true){
					if(tab[X+j][Y+i] == null){
						tab[X+j][Y+i] = new Cellule(brique.getId(), brique.getPosition().forme, brique.getPosition().lettre);
					}else if(tab[X+j][Y+i] != null && tab[X+j][Y+i].id != brique.getId()){
						tab[X+j][Y+i].forme=brique.getPosition().forme;
						tab[X+j][Y+i].id=brique.getId();
					}

				}
			}
		}
		
		// ajout de la brique dans la map, avec son identifiant pour clé
		//briques.put(brique.getId(),brique);

		return true;
	}
	
	public boolean videCaseBrique(Brique brique){
		int X=brique.getPosition().posX;
		int Y=brique.getPosition().posY;
		//tab[X][Y]=brique.getPosition();
		// ajout de la forme (niveau graphique) et de l'id (niveau physique) à la cellule du plateau
		for (int i=0; i<4; ++i){
			for (int j=0; j<4 ; ++j){
				if(X+j <= getLargeur()-1 && Y+i <= getHauteur()-1 && X+j >= 0){
					if(tab[X+j][Y+i] != null && tab[X+j][Y+i].id == brique.getId()){
						tab[X+j][Y+i] = null;
					}
				}
			}
		}
		
		return true;
	}
	
	public boolean verifMove(Brique brique, Cellule newposition){
		int X=newposition.posX;
		int Y=newposition.posY;
		//tab[X][Y]=brique.getPosition();
		// ajout de la forme (niveau graphique) et de l'id (niveau physique) à la cellule du plateau
		for (int i=0; i<4; ++i){
			for (int j=0; j<4 ; ++j){
				if(brique.tab[i][j]==true){
					System.out.println(X+j);
					if(X+j > getLargeur()-1 || Y+i > getHauteur()-1 || X+j < 0){
						return false;
						//Y+i > getHauteur() || tab[X+j][Y+i] != null){
					}
					if(tab[X+j][Y+i] != null && tab[X+j][Y+i].id != brique.getId()){
						return false;
					}
					
				}
			}
		}
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
			videCaseBrique(brique);
		/* if (action utilisateur){*/
		 	brique.updatePosition(newposition);	
		/* 	
		 * }
		 * else {
		 */
		 	brique.descendre();
		 /*}
		 * 	
		 */
		
		this.placeBrique(brique);	
		
		return true;
	}
	
	
	public Brique creerBrique(){
		// valeurs à générer aléatoirement, MAGENTA et a pour les tests
		Forme formeAleatoire = Forme.getForme();
		char lettre = 'a';
		Brique b = null;
		switch(formeAleatoire){
			case MAGENTA:
				 b = new BriqueMagenta(lettre);
			break;
			case BLEU:
				 b = new BriqueBleue(lettre);
			break;
			case CYAN:
				 b = new BriqueCyan(lettre);
			break;
			case JAUNE:
				 b = new BriqueJaune(lettre);
			break;
			case ORANGE:
				 b = new BriqueOrange(lettre);
			break;
			case ROUGE:
				 b = new BriqueRouge(lettre);
			break;
			case VERT:
				 b = new BriqueVerte(lettre);
			break;
		}
		// ajouter une exception pour verifier que b n'est pas null
		this.briqueActuelle=b;
		this.briques.put(b.getId(), b);
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
		
		/*System.out.println("HAUT");
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
		b.afficher();*/

	}

}


	

		
