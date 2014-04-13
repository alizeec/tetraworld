package tetris;
import java.util.HashMap;
import java.util.Map;

public class Plateau {
	Cellule tab[][];
	int LARGEUR = 10;
	int HAUTEUR = 20;
	Map<Integer,Brique> briques;

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
		//r�cup�ration de la position de la brique pour la placer sur le plateau
		int X=brique.getPosition().posX;
		int Y=brique.getPosition().posY;
		//tab[X][Y]=brique.getPosition();
		// ajout de la forme (niveau graphique) et de l'id (niveau physique) � la cellule du plateau
		for (int i=0; i<4; ++i){
			for (int j=0; j<4 ; ++j){
				if(brique.tab[i][j]==true){
					if(tab[X+j][Y+i] == null){
						tab[X+j][Y+i] = new Cellule(brique.getId(), brique.getPosition().forme, brique.getPosition().lettre);
					}else{
						tab[X+j][Y+i].forme=brique.getPosition().forme;
						tab[X+j][Y+i].id=brique.getId();
					}

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
	
	public Brique creerBrique(){
		// valeurs � g�n�rer al�atoirement, MAGENTA et a pour les tests
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
		return b;

	}
	
	public static void main(String[] args){
		// test de r�cup�ration de donn�es par cl�s = OK
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


	

		
