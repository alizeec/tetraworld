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

public class Mots  {
	File file;
	public Cellule positionActuelle;


	public Mots() {
		// TODO Auto-generated constructor stub
		file=new File("src/tetris/mots.txt");
	}
	
	
	public boolean findWord(String word)  throws FileNotFoundException  {
		String mot = word.substring(0, word.length()-1);
		Scanner scanner = new Scanner(file);
		while (scanner.hasNextLine()) {
		    String nextToken = scanner.next();
		    if (nextToken.equalsIgnoreCase(mot)){
		    	return true;
		    }
		}
		return false;
	}
	
	public boolean motfini(String word){
		if(word.contains("\n")){
			System.out.println("Mot : "+word);
			return true;
		}
		else{
			return false;
		}
	}
	
	//on ajoute les points que valent les letttres + du niveau et on d�truit la ligne
	public void resultatCorrect(Plateau plateau){
		plateau.suppLigne(plateau.indexLigneSupp);
		plateau.gravite();
		//plateau.toutDescendre(plateau.indexLigneSupp);
		plateau.points+=plateau.totalMot;
		plateau.points+=plateau.getNiveau()+1;
		plateau.nbLignes++;
		plateau.changementNiveau();
		System.out.println("Bravo!");


	}
	
	public void resultatCorrectWorddle(Plateau plateau){
		plateau.points+=plateau.totalMot;
		int taille=plateau.BriquesUtilisees.size();
		for (int i=0; i<taille; ++i){
			int X = plateau.BriquesUtilisees.get(i).posX;
			int Y = plateau.BriquesUtilisees.get(i).posY;
				plateau.tab[X][Y].utilisee = false;
		}
		System.out.println("Bravo!");

	}
	
	public void supprLettresWorddle(Plateau plateau){
		int taille=plateau.BriquesUtilisees.size();
		for (int i=0; i<taille; ++i){
			int X = plateau.BriquesUtilisees.get(0).posX;
			int Y = plateau.BriquesUtilisees.get(0).posY;
				plateau.briques.get(plateau.BriquesUtilisees.get(0).getId()).nbCellules--;
				plateau.tab[X][Y] = null;
				plateau.BriquesUtilisees.remove(0);
		}
		plateau.gravite();
	}
	
	// si le mot n'existe pas, on ne fait rien
	public void resultatInCorrect(){
		  System.out.println("BOOUUHHH tu sais pas parler la France");

	}
	
	public void initialiseWorddle(Plateau plateau){
		/* pour avoir une position de d�part al�atoire*/
	Vector<Cellule> positionsPossibles= new Vector();
	
	for(int i=0; i<plateau.LARGEUR; ++i){
		for (int j=0; j<plateau.HAUTEUR; ++j){
			if(plateau.tab[i][j]!=null && plateau.tab[i][j].getId() != plateau.briqueActuelle.getId()){
				positionsPossibles.add(new Cellule(i,j,plateau.tab[i][j].lettre));
			}
		}
	}
	
	int nbPositionsPossibles=positionsPossibles.size();
	Integer r = (int)(Math.random() * (nbPositionsPossibles-1)) + 1;
	System.out.println(r);
	plateau.positionEnCours=positionsPossibles.get(r);

	
	
	


	
	}
	

	



}
