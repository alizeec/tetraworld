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
			  System.out.println("Bravo, tu connais la langue française");

	    	return true;
	}

	}
	  System.out.println("BOOUUHHH tu sais pas parler la France");

	return false;
	}
	
	public boolean motfini(String word){
		if(word.contains("\n")){
			return true;
		}
		else{
			return false;
		}
	}
	




}
