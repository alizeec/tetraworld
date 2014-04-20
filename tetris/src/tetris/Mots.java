package tetris;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TimerTask;

public class Mots  {
	File file;

	public Mots() {
		// TODO Auto-generated constructor stub
		file=new File("src/tetris/mots.txt");

	}
	
	public boolean findWord(String word)  throws FileNotFoundException  {
		Scanner scanner = new Scanner(file);
		while (scanner.hasNextLine()) {
		    String nextToken = scanner.next();
		    if (nextToken.equalsIgnoreCase(word)){
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
	
	//on ajoute les points que valent les letttres + du niveau et on détruit la ligne
	public void resultatCorrect(Plateau plateau){
		plateau.suppLigne(plateau.indexLigneSupp);
		plateau.toutDescendre(plateau.indexLigneSupp);
		plateau.points+=plateau.totalMot;
		plateau.points+=plateau.getNiveau()+1;
		plateau.nbLignes++;
		plateau.changementNiveau();
		System.out.println("Bravo!");

	}
	
	// si le mot n'existe pas, on ne fait rien
	public void resultatInCorrect(){
		  System.out.println("BOOUUHHH tu sais pas parler la France");

	}
	




}
