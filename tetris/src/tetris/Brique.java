package tetris;




public abstract class Brique {
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
	
	
	public int getId(){
		return this.id;
	}
	
	public Forme getForme(){
		return this.forme;
	}
	
	public Cellule getPosition(){
		return this.position;
	}
	
	public Rotation getRotation(){
		return this.rotation;
	}
	
	public char getLettre(){
		return this.lettre;
	}
	
	public boolean descendre(){
		this.getPosition().posY += 1;
		this.updatePosition(this.getPosition());
		return true;
	}


	public void setForme(Forme forme) {
		this.forme = forme;
	}

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
	
	
	
	public void updatePosition(Cellule newposition){
		this.getPosition().posX=newposition.posX;
		this.getPosition().posY=newposition.posY;
	}

	// pour le débug
	public void afficher(){
		int i, j;
		for(i=0; i<this.tab.length; i++) {

			for(j=0; j<this.tab[i].length; j++) {
				System.out.println("aaa"+this.tab[i][j]);
			}
		}
	}
	
	



}

