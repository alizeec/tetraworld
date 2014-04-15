package tetris;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class PanelJeu extends JPanel{
	Image imageBriqueMagenta;
	Image imageBriqueBleu;
	Image imageBriqueCyan;
	Image imageBriqueJaune;
	Image imageBriqueOrange;
	Image imageBriqueRouge;
	Image imageBriqueVert;
	Plateau plateau;
	int x;
	int y;
	
	PanelJeu(Plateau plateau){
		this.plateau = plateau;
		imageBriqueMagenta = new ImageIcon("cellule_magenta.png").getImage();
		imageBriqueBleu = new ImageIcon("cellule_bleu.png").getImage();
		imageBriqueCyan = new ImageIcon("cellule_cyan.png").getImage();
		imageBriqueJaune = new ImageIcon("cellule_jaune.png").getImage();
		imageBriqueOrange = new ImageIcon("cellule_orange.png").getImage();
		imageBriqueRouge = new ImageIcon("cellule_rouge.png").getImage();
		imageBriqueVert = new ImageIcon("cellule_vert.png").getImage();
		
		JPanel panelPlateau = new JPanel();//Créé un panel
		panelPlateau.setBackground(new Color (155, 204, 234));//modifie la couleur de fond
	}
	
	public int getPixelX(int i){
		int x = (int)(200 / plateau.getLargeur()*i);
		return x;
	}

	public int getPixelY(int j){
		int y = (int)(400 / plateau.getHauteur()*j);
		return y;
	}
	
	public void afficherCelluleMagenta(Graphics g, int i, int j){
		int x = (getPixelX(j));
		int y = (getPixelY(i));
		g.drawImage(imageBriqueMagenta, x, y, null);
	}
	
	public void afficherCelluleBleu(Graphics g, int i, int j){
		int x = (getPixelX(j));
		int y = (getPixelY(i));
		g.drawImage(imageBriqueBleu, x, y, null);
	}
	
	public void afficherCelluleCyan(Graphics g, int i, int j){
		int x = (getPixelX(j));
		int y = (getPixelY(i));
		g.drawImage(imageBriqueCyan, x, y, null);
	}
	
	public void afficherCelluleJaune(Graphics g, int i, int j){
		int x = (getPixelX(j));
		int y = (getPixelY(i));
		g.drawImage(imageBriqueJaune, x, y, null);
	}
	
	public void afficherCelluleOrange(Graphics g, int i, int j){
		int x = (getPixelX(j));
		int y = (getPixelY(i));
		g.drawImage(imageBriqueOrange, x, y, null);
	}
	
	public void afficherCelluleRouge(Graphics g, int i, int j){
		int x = (getPixelX(j));
		int y = (getPixelY(i));
		g.drawImage(imageBriqueRouge, x, y, null);
	}
	
	public void afficherCelluleVert(Graphics g, int i, int j){
		int x = (getPixelX(j));
		int y = (getPixelY(i));
		g.drawImage(imageBriqueVert, x, y, null);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		setBackground(new Color (155, 204, 234));//modifie la couleur de fond
		afficherPlateau(g);
		//printTab();
	}
	
	
	
	public void printTab(){
		String str = "";
		for(int i=0;i<plateau.getHauteur();i++){		
			for(int j=0;j<plateau.getLargeur();j++){
				if(plateau.tab[j][i] != null){
					if(plateau.tab[j][i].forme == Forme.MAGENTA){
						str += "M";
					}
					if(plateau.tab[j][i].forme == Forme.BLEU){
						str += "B";
					}
					if(plateau.tab[j][i].forme == Forme.CYAN){
						str += "C";
					}
					if(plateau.tab[j][i].forme == Forme.JAUNE){
						str += "J";
					}
					if(plateau.tab[j][i].forme == Forme.ORANGE){
						str += "O";
					}
					if(plateau.tab[j][i].forme == Forme.ROUGE){
						str += "R";
					}
					if(plateau.tab[j][i].forme == Forme.VERT){
						str += "V";
					}
				}else{
					str += "0";
				}
			}
			str += "\n";
		}
		System.out.println(str);
	}
	
	public void afficherPlateau(Graphics g){//affiche le monde dans le panel.
		for(int i=0;i<plateau.getHauteur();i++){		
			for(int j=0;j<plateau.getLargeur();j++){
				if(plateau.tab[j][i] != null){
					if(plateau.tab[j][i].forme == Forme.MAGENTA){
						afficherCelluleMagenta(g,i,j);
					}
					if(plateau.tab[j][i].forme == Forme.BLEU){
						afficherCelluleBleu(g,i,j);
					}
					if(plateau.tab[j][i].forme == Forme.CYAN){
						afficherCelluleCyan(g,i,j);
					}
					if(plateau.tab[j][i].forme == Forme.JAUNE){
						afficherCelluleJaune(g,i,j);
					}
					if(plateau.tab[j][i].forme == Forme.ORANGE){
						afficherCelluleOrange(g,i,j);
					}
					if(plateau.tab[j][i].forme == Forme.ROUGE){
						afficherCelluleRouge(g,i,j);
					}
					if(plateau.tab[j][i].forme == Forme.VERT){
						afficherCelluleVert(g,i,j);
					}
				}else{
				}
			}
		}
	}
}
