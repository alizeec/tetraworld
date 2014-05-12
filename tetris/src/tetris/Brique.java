package tetris;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * classe abstraite qui représente toutes les briques. 
 * On instancie ses fils selon la forme de la brique demandée
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
	 * donne l'id de la brique
	 * @return int 
	 */
	public int getId(){
		return this.id;
	}
	
	/**
	 * 
	 * @param int
	 */
	public void setId(int id){
		this.id=id;
	}
	
	/**
	 * donne la forme
	 * @return Forme
	 */
	public Forme getForme(){
		return this.forme;
	}
	
	/**
	 * donne le nombre de points que vaut la brique
	 * @return int
	 */
	public int getPoints(){
		return this.point;
	}
	
	/**
	 * retourne le nombre de cellules qu'a la brique
	 * @return int
	 */
	public int getNbCellules(){
		return this.nbCellules;
	}
	
	/**
	 * décrémente le nombre de cellule
	 */
	public void decrementeNbCellules(){
		nbCellules--;
	}
	
	/**
	 * donne la position du coin supérieur gauche
	 * @return Cellule 
	 */
	public Cellule getPosition(){
		return this.position;
	}
	
	/**
	 * modifie la position du coin supérieur gauche
	 * @param Cellule
	 */
	public void setPosition(Cellule p){
		this.position=p;
	}
	
	/**
	 * donne la rotation de la brique(HAUT, GAUCHE, BAS, DROITE)
	 * @return Rotation 
	 */
	public Rotation getRotation(){
		return this.rotation;
	}
	
	/**
	 * modifie la rotation
	 * @param Rotation
	 */
	public void setRotation(Rotation r){
		this.rotation=r;
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
	 * modifie la forme
	 * @param Forme 
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
		this.getPosition().setPosX(newposition.getPosX());
		this.getPosition().setPosY(newposition.getPosY());
		/*for(int i=0; i<4;++i){
			for(int j=0; j<4;++j){
				if(tab[i][j]!=null && tab[i][j].getIndependant()==false){
					tab[i][j].setPosX(newposition.getPosX()+i);
					tab[i][j].setPosY(newposition.getPosY()+j);
				}
			}	
		}*/
	}
	
	/**
	 * supprime une cellule de la brique
	 * @param int
	 */
	public void suppCase(int numero){
		System.out.println("Lettre : "+cellules.get(0).getLettre()+"numero :"+numero);
		for(int i=0; i<4;++i){
			for(int j=0; j<4;++j){
				if(this.haut[i][j] == null){
					System.out.print("x");
				}else{
					System.out.print(this.haut[i][j].getNumero());
				}
			}
			System.out.println("\n");
		}
		for(int i=0; i<4;++i){
			for(int j=0; j<4;++j){
				if(this.haut[i][j] != null){
					if(this.haut[i][j].getNumero() == numero){
						System.out.println("Numero suppr :"+this.haut[i][j].getNumero());
						this.haut[i][j] = null;
					}
				}
				if(this.droite[i][j] != null){
					if(this.droite[i][j].getNumero() == numero){
						this.droite[i][j] = null;
					}
				}
				if(this.bas[i][j] != null){
					if(this.bas[i][j].getNumero() == numero){
						this.bas[i][j] = null;
					}
				}
				if(this.gauche[i][j] != null){
					if(this.gauche[i][j].getNumero() == numero){
						this.gauche[i][j] = null;
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
		for(int i=0; i<4;++i){
			for(int j=0; j<4;++j){
				if(this.haut[i][j] == null){
					System.out.print("x");
				}else{
					if(this.haut[i][j].getIndependant() == true){
						System.out.print(this.haut[i][j].getNumero()+"i");
					}else{
						System.out.print(this.haut[i][j].getNumero()+"d");
					}
				}
			}
			System.out.println("\n");
		}
	}
	
	protected abstract Brique clone();


}

