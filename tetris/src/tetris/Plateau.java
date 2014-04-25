package tetris;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

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
	Mode mode;
	
	//pour le mode ANAGRAMME et WORDDLE
	String motEnCours;
	int  totalMot;
	int indexLigneSupp;
	int lignesCompletes[];
	int nbLignesCompletes;

	Cellule positionEnCours;
	LinkedList<Cellule> BriquesUtilisees;
	int nbConnexion;
	
	public Plateau() {
		// TODO Auto-generated constructor stub
		this.tab = new Cellule[LARGEUR][HAUTEUR];
		this.briques = new HashMap();

		points=0;
		perdu=false;
		AVenir=Forme.getForme();
		niveau=0;
		nbLignes=0;
		pause=false;
		
		mode=Mode.TETRIS;
		motEnCours=null;
		totalMot=0;
		
		indexLigneSupp=0;
		nbLignesCompletes = 0;
		this.lignesCompletes = new int[20];
		nbConnexion=0;
		BriquesUtilisees = new LinkedList<Cellule>();
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
		//rŽcupŽration de la position de la brique pour la placer sur le plateau
		int X=brique.getPosition().posX;
		int Y=brique.getPosition().posY;
		// ajout de la forme (niveau graphique) et de l'id (niveau physique) ˆ la cellule du plateau
		for (int i=0; i<4; ++i){
			for (int j=0; j<4 ; ++j){
				if(brique.tab[i][j]==true){
					if(tab[X+j][Y+i] == null){
						tab[X+j][Y+i] = new Cellule(brique.getId(), brique.getPosition().forme, brique.getLettre(), X+j, Y+i);
					}else if(tab[X+j][Y+i] != null && tab[X+j][Y+i].id != brique.getId()){
						tab[X+j][Y+i].forme=brique.getPosition().forme;
						tab[X+j][Y+i].id=brique.getId();
						tab[X+j][Y+i].lettre=brique.getLettre();
					}

				}
			}
		}
		
		// ajout de la brique dans la map, avec son identifiant pour clŽ
		//briques.put(brique.getId(),brique);

		return true;
	}
	
	public boolean videCaseBrique(Brique brique){

		int X=brique.getPosition().posX;
		int Y=brique.getPosition().posY;
		// ajout de la forme (niveau graphique) et de l'id (niveau physique) ˆ la cellule du plateau
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
	
	public void gravite(){
		for(int i=getHauteur()-1;i>=1;--i){
			for(int j=0;j<getLargeur();j++){
				if(tab[j][i]==null){
					for(int k=i-1;k>=1;--k){
						if(tab[j][k] != null){
							if(briques.get(tab[j][k].getId()).nbCellules < 4){ //Si la brique n'est pas entière
								System.out.println("Incomplet");
								tab[j][i] = new Cellule(tab[j][k].getId(), tab[j][k].forme, tab[j][k].lettre, j, k);
								tab[j][k] = null;
							}else{
								System.out.println("Complet");
								Cellule newposition = new Cellule(briques.get(tab[j][k].getId()).getPosition().posX, briques.get(tab[j][k].getId()).getPosition().posY+1);
								if(verifMove(briques.get(tab[j][k].getId()), newposition)){
									deplaceBrique(briques.get(tab[j][k].getId()), newposition);
								}
							}
						}/*else{
							if(tab[j][k+1] !=null){
								if(briques.get(tab[j][k+1].getId()).nbCellules < 4){
									tab[j][k+1] = null;
								}
							}
						}*/
					}
				}
			}
		}
	}
	
	public void JeuPerdu(){
		for (int i=1 ; i<getLargeur()-1; ++i){
			if (this.tab[i][0]!=null && this.tab[i][0].getId()!=0){
				//met l'Žtat du "jeu" ˆ perdu, pour que Tetraword sache qu'il faut arreter la boucle
				perdu=true;
			} 
		}

	}
	
	public boolean verifMove(Brique brique, Cellule newposition){
		int X=newposition.posX;
		int Y=newposition.posY;
		//tab[X][Y]=brique.getPosition();
		// ajout de la forme (niveau graphique) et de l'id (niveau physique) ˆ la cellule du plateau
		for (int i=0; i<4; ++i){
			for (int j=0; j<4 ; ++j){
				if(brique.tab[i][j]==true){
					if(X+j > getLargeur()-1 || Y+i > getHauteur()-1 || X+j < 0){
						return false;
					}
					
					// si on met juste tab tab[X+j][Y+i].id == 0 �a suffit pas?
					if(tab[X+j][Y+i] != null && tab[X+j][Y+i].id != brique.getId()){
						//this.JeuPerdu();

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
		nbLignesCompletes = 0;
		for (int i=0; i<4; ++i){
				if(brique.tab[i][0]==true || brique.tab[i][1]==true || brique.tab[i][2]==true || brique.tab[i][3]==true){
					if(verfiUneLigne(Y+i)){
						lignesCompletes[nbLignesCompletes] = Y+i;
						nbLignesCompletes++;
					}
					
				}
		}
		if(nbLignesCompletes > 0){
			indexLigneSupp = lignesCompletes[0];
			this.mode=Mode.ANAGRAMME;
		}
	}
	
	public void suppLigne(int index){
		for(int i=0; i<getLargeur();++i){
			briques.get(tab[i][index].getId()).nbCellules--;
			if(briques.get(tab[i][index].getId()).nbCellules <= 0 ){
				briques.remove(tab[i][index].getId());
			}
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
		 * VŽrifie si le dŽplacement est possible
		 * if (!verifMove(newposition)){
		 * 	// throw exception "dŽplacement pas possible
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
		 /*}
		 * 	
		 */
		
		this.placeBrique(brique);	
		
		return true;
	}
	
	
	public Brique creerBrique(){
		// valeurs ˆ gŽnŽrer alŽatoirement, MAGENTA et a pour les tests
		Forme forme = AVenir;
		AVenir = Forme.getForme();
		Integer quotient = (int)(Math.random() * (10-1)) + 1;
		final String consonnes = "bcdfghjlmnpqrst"; 
		final String rares = "kvwxyz"; 

		final String voyelles = "aeiou"; 
		final int number_voyelles = 5; 
		final int number_consonnes = 15; 
		final int number_rares = 6; 

		char lettre='p';
		int point=0;

		Random r = new Random();

		if(quotient < 3){
		lettre = rares.charAt (r.nextInt (number_rares)); //20%
		point=3;
		}
        else if(quotient < 7){
    		lettre = consonnes.charAt (r.nextInt (number_consonnes)); //40%

			point=2;
        }
        else if(quotient < 11){
    		lettre = voyelles.charAt (r.nextInt (number_voyelles)); //40%

			point=1;
        }

		Brique b = null;
		switch(forme){
			case MAGENTA:
				 b = new BriqueMagenta(lettre,point);
			break;
			case BLEU:
				 b = new BriqueBleue(lettre,point);
			break;
			case CYAN:
				 b = new BriqueCyan(lettre,point);
			break;
			case JAUNE:
				 b = new BriqueJaune(lettre,point);
			break;
			case ORANGE:
				 b = new BriqueOrange(lettre,point);
			break;
			case ROUGE:
				 b = new BriqueRouge(lettre,point);
			break;
			case VERT:
				 b = new BriqueVerte(lettre,point);
			break;
		}
		// ajouter une exception pour verifier que b n'est pas null
		this.briqueActuelle=b;
		this.briques.put(b.getId(), b);

		return b;

	}
	

}


	

		
