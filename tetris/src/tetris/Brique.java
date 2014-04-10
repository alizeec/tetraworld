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
	private int rotation;
	private char lettre;
	static int cpt =0;
	
	
	public Brique (char lettre){
		this.id=this.cpt;
		cpt++;
		this.position=new Cellule();
		this.rotation = 0;
		this.lettre=lettre;
		
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
	
	public int getRotation(){
		return this.rotation;
	}
	
	public char getLettre(){
		return this.lettre;
	}
	
	public boolean descendre(){
		this.position.posY--;
		return true;
	}


	public void setForme(Forme forme) {
		this.forme = forme;
	}


	
	public void tournerBrique(Rotation rotation){
		switch(rotation){
			case HAUT:
				this.tab = this.haut;
			break;
			case DROITE:
				this.tab = this.droite;
			break;
			case BAS:
				this.tab=this.bas;
			break;
			case GAUCHE:
				this.tab = this.gauche;
			break;
			default:
				// à remplacer par une exception
				System.out.println(" la rotation est inconnnue");
			break;
		}
	}

	// pour le débug
	public void afficher(){
		int i, j;
		for(i=0; i<this.tab.length; i++) {
			System.out.println("   ");

			for(j=0; j<this.tab[i].length; j++) {
				System.out.println(this.tab[i][j]);
			}
		}
	}
	
	



}

