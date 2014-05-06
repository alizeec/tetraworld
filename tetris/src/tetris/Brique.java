package tetris;

import java.io.Serializable;

/**
 * 
 * classe abstraite qui représente toutes les briques. 
 * On instancie ses fils selon la forme de la brique demandée
 * 
 *
 */


public abstract class Brique implements Serializable{
	//tableau courant (haut de base)
	boolean tab[][];
	// toutes les rotations possibles
	boolean haut[][];
	boolean droite[][];
	boolean bas[][];
	boolean gauche[][];
	private int id;
	private Forme forme;
	//position de la case en haut à gauche
	private Cellule position;
	private Rotation rotation;
	private char lettre;
	static int cpt =0;
	int point;
	int nbCellules;
	
	/**
	 * 
	 * @param Forme forme
	 * @param char lettre
	 * @param int point
	 */
	public Brique (Forme forme, char lettre, int point){
		this.id=this.cpt;
		cpt++;
		this.position=new Cellule(this.id, forme, this.lettre, 3, 0);
		this.rotation = Rotation.HAUT;
		this.lettre=lettre;
		this.forme = forme;
		this.point=point;
		this.nbCellules = 4;
		
	}
	
	/**
	 * 
	 * @return int id
	 */
	public int getId(){
		return this.id;
	}
	
	/**
	 * 
	 * @return Forme
	 */
	public Forme getForme(){
		return this.forme;
	}
	
	
	/**
	 * 
	 * @return Cellule position du coin supérieur gauche
	 */
	public Cellule getPosition(){
		return this.position;
	}
	
	/**
	 * 
	 * @return Rotation rotation de la brique(HAUT, GAUCHE, BAS, DROITE)
	 */
	public Rotation getRotation(){
		return this.rotation;
	}
	
	/**
	 * 
	 * @return char lettre de la brique
	 */
	public char getLettre(){
		return this.lettre;
	}
	
	/**
	 * 
	 * @return boolean
	 * fait descendre la brique d'une case
	 */
	public boolean descendre(){
		this.getPosition().posY += 1;
		this.updatePosition(this.getPosition());
		return true;
	}


	/**
	 * 
	 * @param Forme forme
	 */
	public void setForme(Forme forme) {
		this.forme = forme;
	}

	/**
	 * fait tourner la brique
	 */
	public void tourner(){
		switch(this.rotation){
			case HAUT:
				this.rotation = Rotation.DROITE;
				this.tab = this.droite;
			break;
			
			case DROITE:
				this.rotation = Rotation.BAS;
				this.tab = this.bas;
			break;
			
			case BAS:
				this.rotation = Rotation.GAUCHE;
				this.tab = this.gauche;
			
			break;
			
			case GAUCHE:
				this.rotation = Rotation.HAUT;
				this.tab = this.haut;
				
			break;
		}
	}
	
	
	/**
	 * Prend en paramètre une cellule qui est la nouvelle position du coin supérieur gauche de la brique
	 * @param Cellule newposition
	 */
	public void updatePosition(Cellule newposition){
		this.getPosition().posX=newposition.posX;
		this.getPosition().posY=newposition.posY;
	}


	
	



}

