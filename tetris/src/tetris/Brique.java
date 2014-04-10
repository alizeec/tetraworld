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

	public Brique creerBrique(){
		// valeurs à générer aléatoirement, MAGENTA et a pour les tests
		Forme forme = Forme.MAGENTA;
		char lettre = 'a';
		Brique b = null;
		switch(forme){
			case MAGENTA:
				 b = new BriqueMagenta(lettre);
				 break;				
		}
		// ajouter une exception pour verifier que b n'est pas null
		return b;

	}



}
