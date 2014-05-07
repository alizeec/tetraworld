package tetris;

import java.io.Serializable;

import javax.swing.JButton;

/**
 * 
 * Une cellule représente une unité carré.
 * Le tableau de jeu est composé de 200 cellules, et les briques de 4 cellules.
 *
 */
public class Cellule implements Serializable{
	int id;
	int numero;
	Forme forme;
	int posX;
	int posY;
	char lettre;
	int point;
	boolean utilisee;

	/**
	 * 
	 * @param int id
	 * @param Forme forme
	 * @param char lettre
	 * @param int X
	 * @param int Y
	 */
	public Cellule(int id, Forme forme, char lettre, int X, int Y) {
		this.id = id;
		this.forme = forme;
		this.posX = X;
		this.posY=Y;
		this.lettre = lettre;
		this.utilisee = false;
	}
	
	/**
	 * Utilisée pour les cellules temporaires
	 * @param X
	 * @param Y
	 */
	public Cellule(int X, int Y) { 
		this.id = 0;
		this.forme = null;
		this.posX = X;
		this.posY=Y;
		this.lettre = 'a';
	}
	
	/**
	 * Utilisée pour les cellules temporaires
	 * @param X
	 * @param Y
	 */
	public Cellule(int X, int Y, char lettre) { 
		this.id = 0;
		this.forme = null;
		this.posX = X;
		this.posY=Y;
		this.lettre = lettre;
	}
	
	public Cellule(char lettre, int numero, int point){
		this.lettre = lettre;
		this.numero= numero;
		this.point = point;
	}

	/**
	 * 
	 * @return int id
	 */
	public int getId(){
		return this.id;
	}
	
	public char getLettre(){
		return lettre;
	}

}
