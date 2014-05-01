package tetris;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextArea;
import java.util.LinkedList;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.xml.ws.handler.Handler;



public class PanelJeu extends JPanel{
	Image imageBriqueMagenta;
	Image imageBriqueBleu;
	Image imageBriqueCyan;
	Image imageBriqueJaune;
	Image imageBriqueOrange;
	Image imageBriqueRouge;
	Image imageBriqueVert;
	Image imageBriqueGris;
	LinkedList<Plateau> joueurs;
	int nbJoueurs; 
	Plateau plateau;
	Image background_geek,background_girly, background;
	Image perdu;
	JLabel score;
	Image next;
	JLabel level;
	JButton finish;
	JButton valider;
	JButton supp;
	JButton paramJeu;
	Image fleche;
	JLabel message;

	
	int x;
	int y;
	
	PanelJeu(LinkedList<Plateau> joueurs){
		this.joueurs = joueurs;
		nbJoueurs = this.joueurs.size();
		this.plateau = joueurs.get(0);
		imageBriqueMagenta = new ImageIcon("cellule_magenta.png").getImage();
		imageBriqueBleu = new ImageIcon("cellule_bleu.png").getImage();
		imageBriqueCyan = new ImageIcon("cellule_cyan.png").getImage();
		imageBriqueJaune = new ImageIcon("cellule_jaune.png").getImage();
		imageBriqueOrange = new ImageIcon("cellule_orange.png").getImage();
		imageBriqueRouge = new ImageIcon("cellule_rouge.png").getImage();
		imageBriqueVert = new ImageIcon("cellule_vert.png").getImage();
		imageBriqueGris = new ImageIcon("cellule_gris.png").getImage();
		background_geek = new ImageIcon("tetris.gif").getImage();
		background_girly = new ImageIcon("tetris_girly.gif").getImage();
		background = background_geek;
		perdu = new ImageIcon("perdu.png").getImage();
		
		fleche = new ImageIcon("fleche.png").getImage();

		score = new JLabel();
		level=new JLabel();


		finish=new JButton();
		valider= new JButton(new ImageIcon("bt_ok.png" ));
		supp= new JButton(new ImageIcon("bt_supp.png" ));
		paramJeu= new JButton(new ImageIcon("parametres_bt.gif" ));

	}
	
	public int getPixelX(int i, Plateau plateau){
		int x = (int)(plateau.coinSuppGauche + 300 / plateau.getLargeur()*i);
		return x;
	}

	public int getPixelY(int j){
		int y = (int)(45 + 600 / plateau.getHauteur()*j);
		return y;
	}
	
	public void afficherCelluleMagenta(Graphics g, int i, int j, char lettre, Plateau plateau){
		int x = (getPixelX(j, plateau));
		int y = (getPixelY(i));
		g.drawImage(imageBriqueMagenta, x, y, null);
		g.drawString(""+lettre, x+7, y+15);
	}
	
	public void afficherCelluleBleu(Graphics g, int i, int j, char lettre, Plateau plateau){
		int x = (getPixelX(j, plateau));
		int y = (getPixelY(i));
		g.drawImage(imageBriqueBleu, x, y, null);
		g.drawString(""+lettre, x+7, y+15);
	}
	
	public void afficherCelluleCyan(Graphics g, int i, int j, char lettre, Plateau plateau){
		int x = (getPixelX(j, plateau));
		int y = (getPixelY(i));
		g.drawImage(imageBriqueCyan, x, y, null);
		g.drawString(""+lettre, x+7, y+15);
	}
	
	public void afficherCelluleJaune(Graphics g, int i, int j, char lettre, Plateau plateau){
		int x = (getPixelX(j,plateau));
		int y = (getPixelY(i));
		g.drawImage(imageBriqueJaune, x, y, null);
		g.drawString(""+lettre, x+7, y+15);
	}
	
	public void afficherCelluleOrange(Graphics g, int i, int j, char lettre, Plateau plateau){
		int x = (getPixelX(j, plateau));
		int y = (getPixelY(i));
		g.drawImage(imageBriqueOrange, x, y, null);
		g.drawString(""+lettre, x+7, y+15);
	}
	
	public void afficherCelluleRouge(Graphics g, int i, int j, char lettre, Plateau plateau){
		int x = (getPixelX(j,plateau));
		int y = (getPixelY(i));
		g.drawImage(imageBriqueRouge, x, y, null);
		g.drawString(""+lettre, x+7, y+15);
	}
	
	public void afficherCelluleVert(Graphics g, int i, int j, char lettre, Plateau plateau){
		int x = (getPixelX(j, plateau));
		int y = (getPixelY(i));
		g.drawImage(imageBriqueVert, x, y, null);
		g.drawString(""+lettre, x+7, y+15);
	}
	public void afficherCelluleGris(Graphics g, int i, int j, char lettre, Plateau plateau){
		int x = (getPixelX(j, plateau));
		int y = (getPixelY(i));
		g.drawImage(imageBriqueGris, x, y, null);
		g.drawString(""+lettre, x+7, y+15);
	}
	
	 	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		setBackground(new Color (155, 204, 234, 0));//modifie la couleur de fond
		g.drawImage(background, 0, 0, null);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Helevetica", Font.PLAIN, 25)); 
		afficherPlateau(g);
		valider.setBounds(150, 130, 62, 29);
		valider.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		valider.setContentAreaFilled(false);
		valider.setBorderPainted(false);
		add(valider);
		supp.setBounds(220, 130, 62, 29);
		supp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		supp.setContentAreaFilled(false);
		supp.setBorderPainted(false);
		add(supp);
		paramJeu.setBounds(950,10, 34, 34);
		paramJeu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		paramJeu.setContentAreaFilled(false);
		paramJeu.setBorderPainted(false);
		add(paramJeu);
		
		
		for (int i=0; i<nbJoueurs; ++i){
			g.drawString(String.valueOf(joueurs.get(i).getScore()), 200, 635);
			g.drawString(String.valueOf(joueurs.get(i).getNiveau()), 770, 635);
			
			if(!joueurs.get(i).getMessage().equals("Perdu!") && !joueurs.get(i).getMessage().equals("Bravo!")){
				g.setFont(new Font("Helevetica", Font.PLAIN, 15)); 
				g.drawString(String.valueOf(joueurs.get(i).getMessage()), 50, 190);
	
			}
			if(joueurs.get(i).getMessage().equals("Perdu!") || joueurs.get(i).getMessage().equals("Bravo!")){
				g.setFont(new Font("Helevetica", Font.PLAIN, 25)); 
				g.drawString(String.valueOf(joueurs.get(i).getMessage()), 200, 190);
	
			}
			g.setFont(new Font("Helevetica", Font.PLAIN, 25)); 
	
	
			
			next = getNext(joueurs.get(i)).getImage();
	
	
			
			
			g.drawImage(next, 720, 80, null);
			if(joueurs.get(i).perdu==true){
				g.drawImage(perdu, 0, 0, null);
				valider.setVisible(false);
			}
			if(joueurs.get(i).mode==Mode.ANAGRAMME){
				g.drawImage(fleche, 310, getPixelY(joueurs.get(i).indexLigneSupp)+4, null);
				if(joueurs.get(i).motEnCours!=null){
					g.drawString(joueurs.get(i).motEnCours, 177, 107);
				}
			}
			if(joueurs.get(i).mode==Mode.WORDDLE){
				
				if(joueurs.get(i).positionEnCours!=null){
					g.drawImage(fleche, getPixelX(joueurs.get(i).positionEnCours.posX,joueurs.get(i)), getPixelY(joueurs.get(i).positionEnCours.posY)+4, null);
					if(joueurs.get(i).motEnCours!=null){
						g.drawString(joueurs.get(i).motEnCours, 177, 107);
					}
				}
				int temps = (int)(60 -( joueurs.get(i).tempsEcoule/1000));
				g.drawString("Temps restant : "+temps, 120, 220);
			}
		}
		
		

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
	
	public void printTabLettres(){
		String str = "";
		for(int i=0;i<plateau.getHauteur();i++){		
			for(int j=0;j<plateau.getLargeur();j++){
				if(plateau.tab[j][i] != null){
					str+=plateau.tab[j][i].lettre;
				}else{
					str += "0";
				}
			}
			str += "\n";
		}
		System.out.println(str);
	}
	
	public void afficherPlateau(Graphics g){//affiche le monde dans le panel.
		for(int k=0; k<nbJoueurs; ++k){
			for(int i=0;i<plateau.getHauteur();i++){		
				for(int j=0;j<plateau.getLargeur();j++){
					if(plateau.tab[j][i] != null){
						if(plateau.tab[j][i].utilisee == true){
							afficherCelluleGris(g,i,j, plateau.tab[j][i].lettre, joueurs.get(k));
						}else{
							if(plateau.tab[j][i].forme == Forme.MAGENTA){
								afficherCelluleMagenta(g,i,j, plateau.tab[j][i].lettre, joueurs.get(k));
							}
							if(plateau.tab[j][i].forme == Forme.BLEU){
								afficherCelluleBleu(g,i,j, plateau.tab[j][i].lettre, joueurs.get(k));
							}
							if(plateau.tab[j][i].forme == Forme.CYAN){
								afficherCelluleCyan(g,i,j, plateau.tab[j][i].lettre ,joueurs.get(k));
							}
							if(plateau.tab[j][i].forme == Forme.JAUNE){
								afficherCelluleJaune(g,i,j, plateau.tab[j][i].lettre ,joueurs.get(k));
							}
							if(plateau.tab[j][i].forme == Forme.ORANGE){
								afficherCelluleOrange(g,i,j, plateau.tab[j][i].lettre ,joueurs.get(k));
							}
							if(plateau.tab[j][i].forme == Forme.ROUGE){
								afficherCelluleRouge(g,i,j, plateau.tab[j][i].lettre, joueurs.get(k));
							}
							if(plateau.tab[j][i].forme == Forme.VERT){
								afficherCelluleVert(g,i,j, plateau.tab[j][i].lettre, joueurs.get(k));
							}
						}
					}
				}
			}
		}
	}
	
	
	public ImageIcon getNext(Plateau plateau){
		ImageIcon icon=null;

		switch(plateau.AVenir){
			case MAGENTA:
				icon= new ImageIcon("briqueMagenta.png");
			break;
			case BLEU:
				icon= new ImageIcon("briqueBleu.png");
			break;
			case CYAN:
				icon= new ImageIcon("briqueCyan.png");
			break;
			case ORANGE:
				icon= new ImageIcon("briqueOrange.png");
			break;
			case ROUGE:
				icon= new ImageIcon("briqueRouge.png");
			break;
			case VERT:
				icon= new ImageIcon("briqueVerte.png");
			break;
			case JAUNE:
				icon= new ImageIcon("briqueJaune.png");
			break;
			
		}
		return icon;
	}
}
