package tetris;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;

public class Plateau {
	Cellule tab[][];
	int LARGEUR = 10;
	int HAUTEUR = 20;
	int points = 0;
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
	
	public int getScore(){
		return points;
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
	
	public boolean verfiUneLigne(int indexLigne){
		for(int i=0; i<getLargeur();++i){
			if(tab[i][indexLigne] == null){
				return false;
			}
		}
		return true;
	}
	
	public void verifLignes(Brique brique){
		int X=brique.getPosition().posX;
		int Y=brique.getPosition().posY;
		int cpt = 0;
		for (int i=0; i<4; ++i){
			for (int j=0; j<4 ; ++j){
				if(brique.tab[i][0]==true || brique.tab[i][1]==true || brique.tab[i][2]==true || brique.tab[i][3]==true){
					if(verfiUneLigne(Y+i)){
						suppLigne(Y+i);
						toutDescendre(Y+i);
						points++;
						//System.out.println(points);
					}
					
				}
			}
		}
	}
	
	public void suppLigne(int index){
		for(int i=0; i<getLargeur();++i){
			tab[i][index]= null;
			
		}
	}
	
	public void toutDescendre(int index){
		for(int i=index;i>=1;--i){
			for(int j=0;j<getLargeur();++j){
				tab[j][i] = tab[j][i-1];
			}
			
		}
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
	

}


	

		
