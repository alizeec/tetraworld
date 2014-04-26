package tetris;

import java.io.Serializable;

import javax.swing.JButton;

public class Cellule implements Serializable{
	int id;
	Forme forme;
	int posX;
	int posY;
	char lettre;
	boolean utilisee;

	public Cellule(int id, Forme forme, char lettre, int X, int Y) {
		this.id = id;
		this.forme = forme;
		this.posX = X;
		this.posY=Y;
		this.lettre = lettre;
		this.utilisee = false;
	}
	
	public Cellule(int X, int Y) { //Pour les cellules temporaires (pour vérifier les deplacements par exemple)
		this.id = 0;
		this.forme = null;
		this.posX = X;
		this.posY=Y;
		this.lettre = 'a';
	}
	
	public Cellule(int X, int Y, char lettre) { //Pour les cellules temporaires (pour vérifier les deplacements par exemple)
		this.id = 0;
		this.forme = null;
		this.posX = X;
		this.posY=Y;
		this.lettre = lettre;
	}

	
	public int getId(){
		return this.id;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
