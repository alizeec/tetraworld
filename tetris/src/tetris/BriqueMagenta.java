package tetris;

public class BriqueMagenta extends Brique {

	public BriqueMagenta(char lettre, int point) {
		// TODO Auto-generated constructor stub
		super(Forme.MAGENTA, lettre,point);
		this.setForme(Forme.MAGENTA);
		
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
		this.haut[0][2]=false;
		this.haut[0][3]=false;


		this.haut[1][0]=false;
		this.haut[1][1]=true;
		this.haut[1][2]=false;
		this.haut[1][3]=false;

		this.haut[2][0]=false;
		this.haut[2][1]=true;
		this.haut[2][2]=false;
		this.haut[2][3]=false;
		
		this.haut[3][0]=false;
		this.haut[3][1]=true;
		this.haut[3][2]=false;
		this.haut[3][3]=false;
	}

	public void configuredroite(){
		this.droite = new boolean[4][4];
		this.droite[0][0]=true;
		this.droite[0][1]=true;
		this.droite[0][2]=true;
		this.droite[0][3]=true;


		this.droite[1][0]=false;
		this.droite[1][1]=false;
		this.droite[1][2]=false;
		this.droite[1][3]=false;

		this.droite[2][0]=false;
		this.droite[2][1]=false;
		this.droite[2][2]=false;
		this.droite[2][3]=false;
		
		this.droite[3][0]=false;
		this.droite[3][1]=false;
		this.droite[3][2]=false;
		this.droite[3][3]=false;
	}
	
	public void configurebas(){
		this.bas = (boolean[][])haut.clone();
	}
	
	public void configuregauche(){
		this.gauche = (boolean[][])droite.clone();
	}
	


	
}
