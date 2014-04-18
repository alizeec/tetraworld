package tetris;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;

public class Plateau {
	Cellule tab[][];
	int LARGEUR = 10;
	int HAUTEUR = 20;
	int points;
	Map<Integer,Brique> briques;
	Brique briqueActuelle;
	boolean perdu;
	Forme AVenir;
	private int niveau;
	int nbLignes;
	boolean pause;

	public Plateau() {
		// TODO Auto-generated constructor stub
		this.tab = new Cellule[LARGEUR][HAUTEUR];
		this.briques = new HashMap();
		points=0;
		perdu=false;
		AVenir=Forme.ORANGE;
		niveau=0;
		nbLignes=0;
		pause=false;
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
	
	public void JeuPerdu(){
		for (int i=1 ; i<getLargeur()-1; ++i){
			if (this.tab[i][0]!=null && this.tab[i][0].getId()!=0){
				//met l'état du "jeu" à perdu, pour que Tetraword sache qu'il faut arreter la boucle
				perdu=true;
			} 
		}

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
					
					// si on met juste tab tab[X+j][Y+i].id == 0 ça suffit pas?
					if(tab[X+j][Y+i] != null && tab[X+j][Y+i].id != brique.getId()){
						this.JeuPerdu();

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
						points+=niveau+1;
						nbLignes++;
						changementNiveau();
						System.out.println(niveau);
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
	
	public int changementNiveau(){
		if(nbLignes==3){
			niveau++;
			nbLignes=0;
		}
		
		return niveau;
	}
	
	public int getNiveau(){
		return niveau;
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
		 	brique.descendre(getNiveau()+1);
		 /*}
		 * 	
		 */
		
		this.placeBrique(brique);	
		
		return true;
	}
	
	
	public Brique creerBrique(){
		// valeurs à générer aléatoirement, MAGENTA et a pour les tests
		Forme forme = AVenir;
		AVenir = Forme.getForme();
		char lettre = 'a';
		Brique b = null;
		switch(forme){
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


	

		
