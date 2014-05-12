package tetris;

import java.util.Map;

public class BriqueVerte extends Brique {

	public BriqueVerte(Map<Integer,Cellule> cellules) {
		// TODO Auto-generated constructor stub
		super(Forme.VERT,cellules);
		//this.setForme(Forme.VERT);
		
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
		this.haut[0][2]=null;
		this.haut[0][3]=null;


		this.haut[1][0]=null;
		this.haut[1][1]=cellules.get(1);
		this.haut[1][2]=cellules.get(2);
		this.haut[1][3]=null;

		this.haut[2][0]=null;
		this.haut[2][1]=cellules.get(3);
		this.haut[2][2]=null;
		this.haut[2][3]=null;
		
		this.haut[3][0]=null;
		this.haut[3][1]=null;
		this.haut[3][2]=null;
		this.haut[3][3]=null;
	}

	public void configuredroite(){
		this.droite = new Cellule[4][4];
		this.droite[0][0]=null;
		this.droite[0][1]=cellules.get(3);
		this.droite[0][2]=cellules.get(1);
		this.droite[0][3]=cellules.get(0);


		this.droite[1][0]=null;
		this.droite[1][1]=null;
		this.droite[1][2]=cellules.get(2);
		this.droite[1][3]=null;

		this.droite[2][0]=null;
		this.droite[2][1]=null;
		this.droite[2][2]=null;
		this.droite[2][3]=null;
		
		this.droite[3][0]=null;
		this.droite[3][1]=null;
		this.droite[3][2]=null;
		this.droite[3][3]=null;	
	}
	
	public void configurebas(){
		this.bas = new Cellule[4][4];
		this.bas[0][0]=null;
		this.bas[0][1]=null;
		this.bas[0][2]=null;
		this.bas[0][3]=cellules.get(3);


		this.bas[1][0]=null;
		this.bas[1][1]=null;
		this.bas[1][2]=cellules.get(2);
		this.bas[1][3]=cellules.get(1);

		this.bas[2][0]=null;
		this.bas[2][1]=null;
		this.bas[2][2]=null;
		this.bas[2][3]=cellules.get(0);
		
		this.bas[3][0]=null;
		this.bas[3][1]=null;
		this.bas[3][2]=null;
		this.bas[3][3]=null;	}
	
	public void configuregauche(){
		this.gauche = new Cellule[4][4];
		this.gauche[0][0]=null;
		this.gauche[0][1]=null;
		this.gauche[0][2]=null;
		this.gauche[0][3]=null;


		this.gauche[1][0]=null;
		this.gauche[1][1]=null;
		this.gauche[1][2]=cellules.get(2);
		this.gauche[1][3]=null;

		this.gauche[2][0]=null;
		this.gauche[2][1]=cellules.get(0);
		this.gauche[2][2]=cellules.get(1);
		this.gauche[2][3]=cellules.get(3);
		
		this.gauche[3][0]=null;
		this.gauche[3][1]=null;
		this.gauche[3][2]=null;
		this.gauche[3][3]=null;
		
		}

	public void suppCase(int numero){
		System.out.println("classebriqueOrange");
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
			cellules.get(2).setIndependant(true);
			cellules.get(3).setIndependant(true);
		}
	}
	
	
	public  BriqueVerte clone(){
		BriqueVerte b = new BriqueVerte(this.cellules);
		b.bas=this.bas;
		b.droite=this.droite;
		b.gauche=this.gauche;
		b.haut=this.haut;
		b.setId(this.getId());

		b.setForme(this.getForme());
		b.setPosition(this.getPosition());
		b.setRotation(this.getRotation());
		return b;
	}
	
}
