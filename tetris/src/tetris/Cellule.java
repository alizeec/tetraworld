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
	private int id;
	private int numero;
	private Forme forme;
	private int posX;
	private int posY;
	private char lettre;
	private int point;
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
		this.setForme(forme);
		this.setPosX(X);
		this.setPosY(Y);
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
		this.setForme(null);
		this.setPosX(X);
		this.setPosY(Y);
		this.lettre = 'a';
	}
	
	/**
	 * Utilisée pour les cellules temporaires
	 * @param X
	 * @param Y
	 */
	public Cellule(int X, int Y, char lettre) { 
		this.id = 0;
		this.setForme(null);
		this.setPosX(X);
		this.setPosY(Y);
		this.lettre = lettre;
	}
	
	public Cellule(char lettre, int numero, int point){
		this.lettre = lettre;
		this.setNumero(numero);
		this.setPoint(point);
	}

	/**
	 * 
	 * @return int id
	 */
	int getId(){
		return this.id;
	}
	
	public void setId(int valeur){
		this.id=valeur;
	}
	
	public char getLettre(){
		return lettre;
	}
	
	public void setLettre(char l){
		this.lettre=l;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Forme getForme() {
		return forme;
	}

	public void setForme(Forme forme) {
		this.forme = forme;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}



}
