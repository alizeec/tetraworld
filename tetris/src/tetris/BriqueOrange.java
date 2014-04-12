package tetris;

public class BriqueOrange extends Brique {

	public BriqueOrange(char lettre) {
		// TODO Auto-generated constructor stub
		super(lettre);
		this.setForme(Forme.ORANGE);
		
		// on configure les tableaux des 4 rotations
		this.configurehaut();
		this.configuredroite();
		this.configurebas();
		this.configuregauche();
		// on met le tableau haut de base (sens normal)
		this.tab = this.haut;

		
	}
	

	public void configurehaut(){
		this.haut = new boolean[4][4];
		
		this.haut[0][0]=false;
		this.haut[0][1]=true;
		this.haut[0][2]=true;
		this.haut[0][3]=false;


		this.haut[1][0]=false;
		this.haut[1][1]=true;
		this.haut[1][2]=true;
		this.haut[1][3]=false;

		this.haut[2][0]=false;
		this.haut[2][1]=false;
		this.haut[2][2]=false;
		this.haut[2][3]=false;
		
		this.haut[3][0]=false;
		this.haut[3][1]=false;
		this.haut[3][2]=false;
		this.haut[3][3]=false;
	}

	public void configuredroite(){
		this.droite = (boolean[][])haut.clone();
	}
	
	public void configurebas(){
		this.bas = (boolean[][])haut.clone();
	}
	
	public void configuregauche(){
		this.gauche = (boolean[][])haut.clone();
	}

	
}
