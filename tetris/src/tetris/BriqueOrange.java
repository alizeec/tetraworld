package tetris;

import java.util.Map;

public class BriqueOrange extends Brique {

	public BriqueOrange(Map<Integer,Cellule> cellules) {
		// TODO Auto-generated constructor stub
		super(Forme.ORANGE,cellules);
		//this.setForme(Forme.ORANGE);
		
		// on configure les tableaux des 4 rotations
		this.configurehaut();
		this.configuredroite();
		this.configurebas();
		this.configuregauche();
		// on met le tableau haut de base (sens normal)
		this.tab = this.haut;

		
	}
	

	public void configurehaut(){
		this.haut = new Cellule[4][4];
		
		this.haut[0][0]=null;
		this.haut[0][1]=cellules.get(0);
		this.haut[0][2]=cellules.get(1);
		this.haut[0][3]=null;


		this.haut[1][0]=null;
		this.haut[1][1]=cellules.get(2);
		this.haut[1][2]=cellules.get(3);
		this.haut[1][3]=null;

		this.haut[2][0]=null;
		this.haut[2][1]=null;
		this.haut[2][2]=null;
		this.haut[2][3]=null;
		
		this.haut[3][0]=null;
		this.haut[3][1]=null;
		this.haut[3][2]=null;
		this.haut[3][3]=null;
	}

	public void configuredroite(){
		this.droite = (Cellule[][])haut.clone();
	}
	
	public void configurebas(){
		this.bas = (Cellule[][])haut.clone();
	}
	
	public void configuregauche(){
		this.gauche = (Cellule[][])haut.clone();
	}

	
}
