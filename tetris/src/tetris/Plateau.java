package tetris;
import java.util.HashMap;
import java.util.Map;

public class Plateau {
	Cellule tab[][];
	Map briques;

	public Plateau() {
		// TODO Auto-generated constructor stub
		this.tab = new Cellule[10][20];
		this.briques = new HashMap();
		}
	
	
	
	public static void main(String[] args){
		// test de récupération de données par clés = OK
		Plateau plateau = new Plateau();
		plateau.briques.put(1, "element 1");
		plateau.briques.put(2, "element 2");
		plateau.briques.put(3, "element 3");
		String element1 = (String) plateau.briques.get(3);
		System.out.println(element1);
		//

	}

}
