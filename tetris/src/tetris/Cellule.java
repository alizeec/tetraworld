package tetris;

public class Cellule {
	int id;
	Forme forme;
	int posX;
	int posY;
	char lettre;

	public Cellule(int id, Forme forme, char lettre) {
		this.id = id;
		this.forme = forme;
		this.posX = 3;
		this.posY=0;
		this.lettre = lettre;
	}
	
	public Cellule(int X, int Y) { //Pour les cellules temporaires (pour vérifier les deplacements par exemple)
		this.id = 0;
		this.forme = null;
		this.posX = X;
		this.posY=Y;
		this.lettre = 'a';
	}
	
	public int getId(){
		return this.id;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
