package tetris;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.Serializable; // java.io.* concerne les transferts.
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

public class Plateau implements Serializable {
	/** tableau de cellule qui représente le plateau
	 * 
	 */
	Cellule tab[][];
	int LARGEUR = 10;
	int HAUTEUR = 20;
	private int coinSuppGauche;
	int points;
	/**
	 * taux de chaque types de lettre
	 */
	int TAUX_VOYELLES;
	int TAUX_CONSONNES;
	int TAUX_RARES;
	/**
	 * taux de chaque types de forme
	 */
	int TAUX_BLEUE;
	int TAUX_CYAN;
	int TAUX_JAUNE;
	int TAUX_MAGENTA;
	int TAUX_ORANGE;
	int TAUX_ROUGE;
	int TAUX_VERTE;

	/**
	 * ensemble des briques posées sur le plateau
	 */
	Map<Integer,Brique> briques;
	String nom;

	/**
	 * brique actuellement en mouvement
	 */
	Brique briqueActuelle;
	boolean perdu;
	/**
	 * forme de la prochaine brique
	 */
	Forme AVenir;
	private int niveau;
	/** nombre de lignes cassées depuis le dernier changement de niveau
	 *  
	 */
	int nbLignes;
	boolean pause;
	Mode mode;
	
	//sauvegarde mode de jeu
	public Mode SauvegardeMode;
	
/** pour le mode ANAGRAMME et WORDDLE
 * 
 */
	String motEnCours;
	/** pour le mode ANAGRAMME et WORDDLE
	 * retour utilisateur
	 */
	String message;
	/** pour le mode ANAGRAMME et WORDDLE
	 * nombre de point que vaut le mot
	 */
	int  totalMot;
	/** pour le mode ANAGRAMME
	 * ligne à casser
	 */
	int indexLigneSupp;
	int lignesCompletes[];
	int nbLignesCompletes;

	/** pour le mode WORDDLE
	 * position de la brique "centrale"
	 */	Cellule positionEnCours;
	LinkedList<Cellule> BriquesUtilisees;
	int nbConnexion;
	
	long instantDepart;
	long tempsEcoule;
	
	public Plateau(int position, String nom) {
		// TODO Auto-generated constructor stub
		this.tab = new Cellule[LARGEUR][HAUTEUR];
		this.briques = new HashMap<Integer, Brique>();
		setCoinSuppGauche(position);
		this.nom = nom;

		points=0;
		perdu=false;
		AVenir=Forme.getForme(2,  2,  2,  2,  2,  2,  2);
		niveau=0;
		nbLignes=0;
		pause=false;
		
		mode=Mode.TETRIS;
		motEnCours=null;
		message="";
		totalMot=0;
		
		SauvegardeMode =  this.mode;
		
		indexLigneSupp=0;
		nbLignesCompletes = 0;
		this.lignesCompletes = new int[20];
		nbConnexion=0;
		BriquesUtilisees = new LinkedList<Cellule>();
	}
	
	
	// GETTER et SETTER
	
	/**
	 * 
	 * @return int largeur
	 */
	public int getLargeur(){
		return LARGEUR;
	}
	
/**
 * 
 * @return int hauteur
 */
	public int getHauteur(){
		return HAUTEUR;
	}
	
	/**
	 * 
	 * @return int score
	 */
	public int getScore(){
		return points;
	}
	
	/**
	 * 
	 * @return int niveau
	 */
	public int getNiveau(){
		return niveau;
	}
	
	/**
	 * 
	 * @param String message
	 * retour utilisateur
	 */
	 public void setMessage(String message){
		 this.message=message;
	 }
	 
	 /**
	  * 
	  * @return String message
	  * retour utilisateur
	  */
	 public String getMessage(){
		 return this.message;
	 }
	 
	 
	 ///////////////////////
	
	 /**
	  * placement de la brique
	  * @param Brique brique
	  * @return boolean
	  */
	public boolean placeBrique(Brique brique){
		//rŽcupŽration de la position de la brique pour la placer sur le plateau
		int X=brique.getPosition().getPosX();
		int Y=brique.getPosition().getPosY();
		// ajout de la forme (niveau graphique) et de l'id (niveau physique) ˆ la cellule du plateau
		for (int i=0; i<4; ++i){
			for (int j=0; j<4 ; ++j){
				if(brique.tab[i][j]!=null){
					if(tab[X+j][Y+i] == null){
						tab[X+j][Y+i] = new Cellule(brique.getId(), brique.getPosition().getForme(), brique.tab[i][j].getLettre(), X+j, Y+i);
					}else if(tab[X+j][Y+i] != null && tab[X+j][Y+i].getId() != brique.getId()){
						tab[X+j][Y+i].setForme(brique.getPosition().getForme());
						tab[X+j][Y+i].setId(brique.getId());
						tab[X+j][Y+i].setLettre(brique.tab[i][j].getLettre());
					}
				}
			}
		}
		return true;
	}
	
	/**
	 * vidage des cellules contenant la brique avant son déplacement
	 * @param Brique brique
	 * @return boolean
	 */
	public boolean videCaseBrique(Brique brique){
		int X=brique.getPosition().getPosX();
		int Y=brique.getPosition().getPosY();
		// ajout de la forme (niveau graphique) et de l'id (niveau physique) ˆ la cellule du plateau
		for (int i=0; i<4; ++i){
			for (int j=0; j<4 ; ++j){
				if(X+j <= getLargeur()-1 && Y+i <= getHauteur()-1 && X+j >= 0){
					if(tab[X+j][Y+i] != null && tab[X+j][Y+i].getId() == brique.getId()){
						tab[X+j][Y+i] = null;
					}
				}
			}
		}
		return true;
	}
	
	/**
	 * en mode worddle, fait tomber les bouts de briques en suspension
	 */
	public void gravite(){
		System.out.println("gravité");
		for(int i=getHauteur()-1;i>=1;--i){
			for(int j=0;j<getLargeur();j++){
				if(tab[j][i]==null){
					for(int k=i-1;k>=1;--k){
						if(tab[j][k] != null && tab[j][k].getId()!= briqueActuelle.getId()){
							if(briques.get(tab[j][k].getId()).getNbCellules() < 4){ //Si la brique n'est pas entière
								int cpt = 1;
								int l = k;
								while(k+cpt < 20){
									if(tab[j][k+cpt] != null) break;
									tab[j][k+cpt] = new Cellule(tab[j][l].getId(), tab[j][l].getForme(), tab[j][l].getLettre(), j, l);
									tab[j][l] = null;
									cpt++;
									l++;
								}
							}else{
								Cellule newposition = new Cellule(briques.get(tab[j][k].getId()).getPosition().getPosX(), briques.get(tab[j][k].getId()).getPosition().getPosY()+1);
								if(verifMove(briques.get(tab[j][k].getId()), newposition)){
									deplaceBrique(briques.get(tab[j][k].getId()), newposition);
								}
							}
						}
					}
				}
			}
		}
		verifLignes();
	}
	
	/**
	 * indique que le jeu est perdu, pour stopper la boucle dans Tetraword
	 */
	public void JeuPerdu(){
		for (int i=1 ; i<getLargeur()-1; ++i){
			if (this.tab[i][0]!=null && this.tab[i][0].getId()!=0){
				//met l'Žtat du "jeu" ˆ perdu, pour que Tetraword sache qu'il faut arreter la boucle
				perdu=true;
			} 
		}

	}
	
	/**
	 * verification de possibilité pour la brique de se déplacer à droite/gauche/bas
	 * @param Brique brique
	 * @param Cellule newposition
	 * @return boolean
	 */
	//
	public boolean verifMove(Brique brique, Cellule newposition){
		int X=newposition.getPosX();
		int Y=newposition.getPosY();
		for (int i=0; i<4; ++i){
			for (int j=0; j<4 ; ++j){
				if(brique.tab[i][j]!=null){
					if(X+j > getLargeur()-1 || Y+i > getHauteur()-1 || X+j < 0){
						return false;
					}
					
					if(tab[X+j][Y+i] != null && tab[X+j][Y+i].getId() != brique.getId()){
						if(this.mode==Mode.TETRIS){
							this.JeuPerdu();
						}

						return false;
					}
					
				}
			}
		}
		return true;
	}
	
	/**
	 * vérifie si une ligne en particulier est complète
	 * @param int indexLigne
	 * @return boolean
	 */
	public boolean verfiUneLigne(int indexLigne){
		for(int i=0; i<getLargeur();++i){
			if(tab[i][indexLigne] == null){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * vérifie si une ligne dans tout le tableau est complète
	 * 
	 */
	
	public boolean verifLignes(){
		System.out.println("vérification");
		nbLignesCompletes = 0;
		for(int i=getHauteur()-1; i>0; --i){
					if(verfiUneLigne(i)){
						indexLigneSupp = i;
						return true;
						/*lignesCompletes[nbLignesCompletes] = i;
						nbLignesCompletes++;*/
					}
		}
		return false;
		/*if(nbLignesCompletes > 0){
			indexLigneSupp = lignesCompletes[0];
			this.mode=Mode.ANAGRAMME;
		}*/
	}
	
	
	/**
	 * supprime une ligne
	 * @param int index
	 */
	public void suppLigne(int index){
		for(int i=0; i<getLargeur();++i){
			briques.get(tab[i][index].getId()).decrementeNbCellules();
			if(briques.get(tab[i][index].getId()).getNbCellules() <= 0 ){
				briques.remove(tab[i][index].getId());
			}
			tab[i][index]= null;
		}
	}
	
	/**
	 * fait descendre les briques restante après la suppression d'une ligne
	 * @param int index
	 */
	public void toutDescendre(int index){
		for(int i=index;i>=1;--i){
			for(int j=0;j<getLargeur();++j){
				tab[j][i] = tab[j][i-1];
			}
			
		}
	}
	
	/**
	 * passe au niveau supérieur au bout de 3 lignes cassées
	 * @return int niveau
	 */
	public int changementNiveau(){
		if(nbLignes==3){
			niveau++;
			nbLignes=0;
		}
		
		return niveau;
	}
	


	/**
	 * déplace une brique
	 * @param Brique brique
	 * @param Brique newposition
	 * @return boolean
	 */
	public boolean deplaceBrique(Brique brique, Cellule newposition){
		videCaseBrique(brique);
		brique.updatePosition(newposition);	
		this.placeBrique(brique);	
		return true;
	}
	
	/** 
	 * crée une brique avec une forme et une lettre aléatoire (suivant certains taux)verification de possibilité pour la brique de se déplacer à droite/gauche/bas
	 * @param taux_voyelles
	 * @param taux_consonnes
	 * @param taux_rares
	 * @return
	 */
	public Brique creerBrique(){
		Forme forme = AVenir;
		Map<Integer,Cellule> tmp_cellules = new HashMap();
		AVenir = Forme.getForme( TAUX_BLEUE,  TAUX_CYAN,  TAUX_JAUNE,  TAUX_MAGENTA,  TAUX_ORANGE,  TAUX_ROUGE,  TAUX_VERTE);
		// génération aléatoire pondérée de la lettre
		for(int i =0; i<4; ++i){
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
	
			if(quotient < this.TAUX_RARES){
			lettre = rares.charAt (r.nextInt (number_rares)); 
			point=3;
			}
	
	        else if(quotient < TAUX_RARES+TAUX_CONSONNES){
	    		lettre = consonnes.charAt (r.nextInt (number_consonnes)); 
	
				point=2;
	        }
	        else if(quotient < TAUX_RARES+TAUX_CONSONNES+TAUX_VOYELLES){
	    		lettre = voyelles.charAt (r.nextInt (number_voyelles)); 
	
				point=1;
	        }
			tmp_cellules.put(i,  new Cellule(lettre, i, point));
		}
		////////

		Brique b = null;
		switch(forme){
			case MAGENTA:
				 b = new BriqueMagenta(tmp_cellules);
			break;
			case BLEU:
				 b = new BriqueBleue(tmp_cellules);
			break;
			case CYAN:
				 b = new BriqueCyan(tmp_cellules);
			break;
			case JAUNE:
				 b = new BriqueJaune(tmp_cellules);
			break;
			case ORANGE:
				 b = new BriqueOrange(tmp_cellules);
			break;
			case ROUGE:
				 b = new BriqueRouge(tmp_cellules);
			break;
			case VERT:
				 b = new BriqueVerte(tmp_cellules);
			break;
		}
		this.briqueActuelle=b;
		this.briques.put(b.getId(), b);
		return b;

	}
	
	public void timer(){
		instantDepart = System.currentTimeMillis();
		tempsEcoule = 0L;
	}
	
	
	
	/**
	 * sauvegarde un plateau
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void sauvegarder()throws FileNotFoundException, IOException {
        Sauvegarde sauvegarde = new Sauvegarde();
        sauvegarde.plateau = this;
        FileOutputStream sortieDeFicher = sortieDeFicher = new FileOutputStream("MaSauvegarde.sa");
        ObjectOutputStream sortieDObjet = new ObjectOutputStream(sortieDeFicher);
        sortieDObjet.writeObject(sauvegarde);
        sortieDObjet.close();
        System.out.println("sauvegarde");

    }
	
	/**
	 * change la plateau en cours par le plateau chargé
	 * @param Plateau plateau
	 */
	public void transformeEn(Plateau plateau){
		tab= plateau.tab.clone();
		points= plateau.points;
		briques= new HashMap<Integer,Brique>(plateau.briques);

		briqueActuelle=plateau.briqueActuelle;
		niveau= plateau.niveau;
		nbLignes = plateau.nbLignes;
		
		//pour le mode ANAGRAMME et WORDDLE
		motEnCours = plateau.motEnCours;
		totalMot= plateau.totalMot;
		lignesCompletes = plateau.lignesCompletes;
		nbLignesCompletes= plateau.nbLignesCompletes;
		mode = plateau.mode;

		positionEnCours=null;

	}
	
	/**
	 * charge une sauvegarde
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	 public void charger() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream entreeDeFicher  = new FileInputStream("MaSauvegarde.sa");
        ObjectInputStream entreeDObjet = new ObjectInputStream(entreeDeFicher);
        Sauvegarde sauvegarde = (Sauvegarde) entreeDObjet.readObject();
        entreeDObjet.close();
        this.transformeEn(sauvegarde.plateau);
        System.out.println("chargement");
     }


	public int getCoinSuppGauche() {
		return coinSuppGauche;
	}


	public void setCoinSuppGauche(int coinSuppGauche) {
		this.coinSuppGauche = coinSuppGauche;
	}
	 
	 
	 
	 


}


	

		
