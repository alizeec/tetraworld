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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
