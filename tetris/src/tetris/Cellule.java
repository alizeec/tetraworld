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
	boolean independant;

	/**
	 * Utilisé pour les cellules du plateau
	 * @param int id
	 * @param Forme forme
	 * @param char lettre
	 * @param int point
	 * @param int numero
	 * @param boolean independant
	 * @param int X
	 * @param int Y
	 */
	public Cellule(int id, Forme forme, char lettre, int point, int numero, boolean independant, int X, int Y) {
		this.id = id;
		this.setForme(forme);
		this.setPosX(X);
		this.setPosY(Y);
		this.lettre = lettre;
		this.point = point;
		this.numero = numero;
		this.utilisee = false;
		this.independant = independant;
	}
	
	/**
	 * Utilisé pour la position d'un brique
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
	 * @param int X
	 * @param int Y
	 */
	public Cellule(int X, int Y) { 
		this.id = 0;
		this.setForme(null);
		this.setPosX(X);
		this.setPosY(Y);
		this.independant = false;
	}
	
	/**
	 * Utilisée pour les cellules temporaires
	 * @param X
	 * @param Y
	 * @param char lettre
	 */
	public Cellule(int X, int Y, char lettre) { 
		this.id = 0;
		this.setForme(null);
		this.setPosX(X);
		this.setPosY(Y);
		this.lettre = lettre;
		this.independant = false;
	}
	
	/**
	 * Utilisée pour les cellules des briques qui n'ont pas besoin de position car celle ci est calculé en fonction de la position de la brique
	 * @param char lettre
	 * @param int numero
	 * @param int point
	 */
	public Cellule(char lettre, int numero, int point, Forme forme){
		this.lettre = lettre;
		this.numero = numero;
		this.setPoint(point);
		this.forme = forme;
		this.independant = false;
	}

	/**
	 * 
	 * @return int id
	 */
	int getId(){
		return this.id;
	}
	
	/**
	 * modifie l'id
	 * @param int
	 */
	public void setId(int valeur){
		this.id=valeur;
	}
	
	/**
	 * donne la lettre
	 * @return char
	 */
	public char getLettre(){
		return lettre;
	}
	
	/**
	 * modifie la lettre
	 * @param char
	 */
	public void setLettre(char l){
		this.lettre=l;
	}

	/**
	 * donne le numéro (dans une brique)
	 * @return int
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * modifie le numéro (dans une brique)
	 * @param int
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * donne la forme
	 * @return Forme
	 */
	public Forme getForme() {
		return forme;
	}

	/**
	 * modifie la forme
	 * @param Forme
	 */
	public void setForme(Forme forme) {
		this.forme = forme;
	}

	/**
	 * donne la position en X
	 * @return int
	 */
	public int getPosX() {
		return posX;
	}

	/**
	 * modifie la position en X
	 * @param int
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}

	/**
	 * donne la position en Y
	 * @return int
	 */
	public int getPosY() {
		return posY;
	}

	/**
	 * modifie la position en Y
	 * @param int
	 */
	public void setPosY(int posY) {
		this.posY = posY;
	}

	/**
	 * donne le point de la cellule
	 * @return int
	 */
	public int getPoint() {
		return point;
	}

	/**
	 * modifie le point
	 * @param int
	 */
	public void setPoint(int point) {
		this.point = point;
	}
	
	/**
	 * permet de savoir si la cellule est indépendante ou non
	 * @return boolean
	 */
	public boolean getIndependant(){
		return independant;
	}
	
	/**
	 * permet de dire si la cellule est indépendante ou non
	 * @return boolean
	 */
	public void setIndependant(boolean independant){
		this.independant = independant;
	}


}
