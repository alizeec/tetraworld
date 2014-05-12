package tetris;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * classe abstraite qui reprŽsente toutes les briques. 
 * On instancie ses fils selon la forme de la brique demandŽe
 * 
 *
 */


public abstract class Brique implements Serializable{
	//tableau courant (haut de base)
	Cellule tab[][];
	// toutes les rotations possibles
	Cellule haut[][];
	Cellule droite[][];
	Cellule bas[][];
	Cellule gauche[][];
	private int id;
	private Forme forme;
	//position de la case en haut à gauche
	Map<Integer,Cellule> cellules;
	private Cellule position;
	private Rotation rotation;
	static int cpt =0;
	private int point;
	private int nbCellules;
	
	
	public Brique (Forme forme, Map<Integer,Cellule> cellules){
		this.id=this.cpt;
		cpt++;
		this.position=new Cellule(this.id, forme, cellules.get(0).getLettre(), 3, 0);
		this.cellules = new HashMap<Integer, Cellule>();
		this.cellules = cellules;
		this.rotation = Rotation.HAUT;
		this.forme = forme;
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
	
	public int getPoints(){
		return this.point;
	}
	
	public int getNbCellules(){
		return this.nbCellules;
	}
	
	public void decrementeNbCellules(){
		nbCellules--;
	}
	
	/**
	 * 
	 * @return Cellule position du coin supŽrieur gauche
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
	 * @return boolean
	 * fait descendre la brique d'une case
	 */
	public boolean descendre(){
		this.getPosition().setPosY(this.getPosition().getPosY() + 1);
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
	 * Prend en param�tre une cellule qui est la nouvelle position du coin supŽrieur gauche de la brique
	 * @param Cellule newposition
	 */
	public void updatePosition(Cellule newposition){
		this.getPosition().setPosX(newposition.getPosX());
		this.getPosition().setPosY(newposition.getPosY());
		for(int i=0; i<4;++i){
			for(int j=0; j<4;++j){
				if(tab[i][j]!=null && tab[i][j].getIndependant()==false){
					tab[i][j].setPosX(newposition.getPosX()+i);
					tab[i][j].setPosY(newposition.getPosY()+j);
				}
			}	
		}
	}
	
	public void suppCase(int numero){
		for(int i=0; i<4;++i){
			for(int j=0; j<4;++j){
				if(this.haut[j][i] != null){
					if(this.haut[j][i].getNumero() == numero){
						this.haut[j][i] = null;
					}
				}
				if(this.droite[j][i] != null){
					if(this.droite[j][i].getNumero() == numero){
						this.droite[j][i] = null;
					}
				}
				if(this.bas[j][i] != null){
					if(this.bas[j][i].getNumero() == numero){
						this.bas[j][i] = null;
					}
				}
				if(this.gauche[j][i] != null){
					if(this.gauche[j][i].getNumero() == numero){
						this.gauche[j][i] = null;
					}
				}
			}
			
		}
		if(numero == 1){
			cellules.get(0).setIndependant(true);
		}
		if(numero == 2){
			cellules.get(3).setIndependant(true);
		}
	}
	



}

