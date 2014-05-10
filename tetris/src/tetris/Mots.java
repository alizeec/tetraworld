
package tetris;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.TimerTask;
import java.util.Vector;

/**
 * 
 * pour les jeux de mots ANAGRAMME et WORDDLE
 *
 */
public class Mots  {
	File file;
	public Cellule positionActuelle;
	LinkedList<String> listMeilleursMots;



	public Mots() {
		// TODO Auto-generated constructor stub
		listMeilleursMots= new LinkedList();
	}
	
	
	/**
	 * Cherche un mot dans le dictionnaire
	 * @param String word
	 * @return
	 * @throws FileNotFoundException
	 */
	public boolean findWord(String word)  throws FileNotFoundException  {
		if(PanelParameters.choix_langue==1 || PanelParametersMultijoueur.choix_langue==1){
			file=new File("src/tetris/french.txt");
		}
		else if(PanelParameters.choix_langue==0 || PanelParametersMultijoueur.choix_langue==0){
			file=new File("src/tetris/english.txt");

		}

		String mot = word.substring(0, word.length()-1);
		Scanner scanner = new Scanner(file);
		while (scanner.hasNext()) {
		    String nextToken = scanner.next();
		    if (nextToken.equalsIgnoreCase(mot)){
		    	return true;
		    }
		}
		return false;

	}
	
	/**
	 * indique que le mot est terminé
	 * @param String word
	 * @return boolean
	 */
	public boolean motfini(String word){
		if(word.contains("\n")){
			System.out.println("Mot : "+word);
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * Si le résultat est correct en mode ANAGRAMME
	 * supprime la ligne et ajoute les points, change de niveau si nécessaire
	 * @param Plateau plateau
	 */
	public void resultatCorrect(Plateau plateau){
		plateau.suppLigne(plateau.indexLigneSupp);
		plateau.gravite();
		plateau.points+=plateau.totalMot;
		plateau.points+=plateau.getNiveau()+1;
		plateau.nbLignes++;
		plateau.changementNiveau();
		plateau.setMessage("Bravo!");


	}
	
	/**
	 * Si le résultat est correct en mode WORDDLE
	 * calcul le nombre de points gagné et detruit les briques utilisées
	 * @param Plateau plateau
	 */
	public void resultatCorrectWorddle(Plateau plateau){
		plateau.points+=plateau.totalMot;
		int taille=plateau.BriquesUtilisees.size();
		for (int i=0; i<taille; ++i){
			int X = plateau.BriquesUtilisees.get(i).getPosX();
			int Y = plateau.BriquesUtilisees.get(i).getPosY();
				plateau.tab[X][Y].utilisee = false;
		}
		plateau.setMessage("Bravo!");


	}
	
	/**
	 * supprime les lettres utilisées
	 * @param Plateau plateau
	 */
	public void supprLettresWorddle(Plateau plateau){
		System.out.println("Supp case");
		int taille=plateau.BriquesUtilisees.size();
		for (int i=0; i<taille; ++i){
			int X = plateau.BriquesUtilisees.get(0).getPosX();
			int Y = plateau.BriquesUtilisees.get(0).getPosY();
				plateau.briques.get(plateau.BriquesUtilisees.get(0).getId()).decrementeNbCellules();
				plateau.briques.get(plateau.BriquesUtilisees.get(0).getId()).suppCase(plateau.BriquesUtilisees.get(0).getNumero());
				plateau.tab[X][Y] = null;
				plateau.BriquesUtilisees.remove(0);
		}
		plateau.gravite();
	}
	
	/**
	 * si le mot est incorrect en mode WORDDLE ou ANAGRAMME
	 * @param Plateau plateau
	 */
	public void resultatInCorrect(Plateau plateau){
		plateau.setMessage("Perdu!");

	}
	
	/** 
	 * Cherche la cellule de départ parmis les briques présentes sur le plateau en mode WORDDLE
	 * @param Plateau plateau
	 */
	public void initialiseWorddle(Plateau plateau){
		/* pour avoir une position de départ aléatoire*/
	Vector<Cellule> positionsPossibles= new Vector<Cellule>();
	
	for(int i=0; i<plateau.LARGEUR; ++i){
		for (int j=0; j<plateau.HAUTEUR; ++j){
			if(plateau.tab[i][j]!=null && plateau.tab[i][j].getId() != plateau.briqueActuelle.getId()){
				positionsPossibles.add(new Cellule(i,j,plateau.tab[i][j].getLettre()));
			}
		}
	}
	
	int nbPositionsPossibles=positionsPossibles.size();
	Integer r = (int)(Math.random() * (nbPositionsPossibles-1)) + 1;
	plateau.positionEnCours=positionsPossibles.get(r);
	
	}
	

	

	
	

	 



}
