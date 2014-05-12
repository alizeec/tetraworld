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


/**
 * affiche dans la fen�tre les �l�ments de jeu
 * 
 *
 */
public class PanelJeu extends JPanel{
	/**
	 * affichage des plateaux
	 */
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
	/**
	 * affichage du fond de plateau
	 */
	Image background_geek,background_girly,background;
	Image perdu, perduMulti1, perduMulti2;
	/** affichage des donn�es et des retours utilisateur
	 * 
	 */
	JLabel score;
	Image next1;
	Image next2;
	JLabel level;
	JButton finish;
	JButton valider_geek,supp_geek,valider_girly,supp_girly;
	JButton valider_geek_j2,supp_geek_j2,valider_girly_j2,supp_girly_j2;
	JButton paramJeu;
	Image fleche, fleche_girly;
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
		if(nbJoueurs==1){
			background_geek = new ImageIcon("tetris.gif").getImage();
			background_girly = new ImageIcon("tetris_girly.gif").getImage();
		}
		else if (nbJoueurs==2){
			background_girly = new ImageIcon("tetrisMultijoueurGirly.png").getImage();
			background_geek = new ImageIcon("tetrisMultijoueur.png").getImage();	
		}
		background = background_geek;
		perdu = new ImageIcon("GameOver.png").getImage();
		perduMulti1 = new ImageIcon("GameOverMultijoueur2.png").getImage();
		perduMulti2 = new ImageIcon("GameOverMultijoueur1.png").getImage();
		
		fleche = new ImageIcon("fleche.png").getImage();
		fleche_girly = new ImageIcon("fleche_girly.png").getImage();
		
		score = new JLabel();
		level=new JLabel();


		finish=new JButton();
		valider_geek= new JButton(new ImageIcon("bt_ok_geek.png" ));
		supp_geek= new JButton(new ImageIcon("bt_suppr_geek.png" ));
		valider_girly= new JButton(new ImageIcon("bt_ok_girly.png" ));
		supp_girly= new JButton(new ImageIcon("bt_suppr_girly.png" ));
		valider_geek_j2= new JButton(new ImageIcon("bt_ok_geek.png" ));
		supp_geek_j2= new JButton(new ImageIcon("bt_suppr_geek.png" ));
		valider_girly_j2= new JButton(new ImageIcon("bt_ok_girly.png" ));
		supp_girly_j2= new JButton(new ImageIcon("bt_suppr_girly.png" ));
		paramJeu= new JButton(new ImageIcon("parametres_bt.gif" ));

	}
	
	/**
	 * pour placer verticalement les cellules
	 * @param int i
	 * @param Plateau plateau
	 * @return int
	 */
	public int getPixelX(int i, Plateau plateau){
		int x = (int)(plateau.getCoinSuppGauche() + 300 / plateau.getLargeur()*i);
		return x;
	}

	/**
	 * pour placer horizontalement les cellules
	 * @param int j
	 * @return int
	 */
	public int getPixelY(int j){
		int y=0;
		if(nbJoueurs==1){
			y = (int)(45 + 600 / plateau.getHauteur()*j);
		}
		else if(nbJoueurs==2){
			y = (int)(115 + 600 / plateau.getHauteur()*j);

		}
		return y;
	}
	
	/**
	 * pour afficher les cellules magenta
	 * @param Graphics g
	 * @param int i position verticale
	 * @param int j position horizontale
	 * @param char lettre lettre de la brique
	 * @param Plateau plateau
	 */
	public void afficherCelluleMagenta(Graphics g, int i, int j, char lettre, Plateau plateau){
		int x = (getPixelX(j, plateau));
		int y = (getPixelY(i));
		g.drawImage(imageBriqueMagenta, x, y, null);
		g.drawString(""+lettre, x+7, y+20);
	}
	
	/**
	 * pour afficher les cellules bleu
	 * @param Graphics g
	 * @param int i position verticale
	 * @param int j position horizontale
	 * @param char lettre lettre de la brique
	 * @param Plateau plateau
	 */
	public void afficherCelluleBleu(Graphics g, int i, int j, char lettre, Plateau plateau){
		int x = (getPixelX(j, plateau));
		int y = (getPixelY(i));
		g.drawImage(imageBriqueBleu, x, y, null);
		g.drawString(""+lettre, x+7, y+20);
	}
	
	/**
	 * pour afficher les cellules cyan
	 * @param Graphics g
	 * @param int i position verticale
	 * @param int j position horizontale
	 * @param char lettre lettre de la brique
	 * @param Plateau plateau
	 */
	public void afficherCelluleCyan(Graphics g, int i, int j, char lettre, Plateau plateau){
		int x = (getPixelX(j, plateau));
		int y = (getPixelY(i));
		g.drawImage(imageBriqueCyan, x, y, null);
		g.drawString(""+lettre, x+7, y+20);
	}
	
	/**
	 * pour afficher les cellules jaune
	 * @param Graphics g
	 * @param int i position verticale
	 * @param int j position horizontale
	 * @param char lettre lettre de la brique
	 * @param Plateau plateau
	 */
	public void afficherCelluleJaune(Graphics g, int i, int j, char lettre, Plateau plateau){
		int x = (getPixelX(j,plateau));
		int y = (getPixelY(i));
		g.drawImage(imageBriqueJaune, x, y, null);
		g.drawString(""+lettre, x+7, y+20);
	}
	
	/**
	 * pour afficher les cellules orange
	 * @param Graphics g
	 * @param int i position verticale
	 * @param int j position horizontale
	 * @param char lettre lettre de la brique
	 * @param Plateau plateau
	 */
	public void afficherCelluleOrange(Graphics g, int i, int j, char lettre, Plateau plateau){
		int x = (getPixelX(j, plateau));
		int y = (getPixelY(i));
		g.drawImage(imageBriqueOrange, x, y, null);
		g.drawString(""+lettre, x+7, y+20);
	}
	
	/**
	 * pour afficher les cellules rouge
	 * @param Graphics g
	 * @param int i position verticale
	 * @param int j position horizontale
	 * @param char lettre lettre de la brique
	 * @param Plateau plateau
	 */
	public void afficherCelluleRouge(Graphics g, int i, int j, char lettre, Plateau plateau){
		int x = (getPixelX(j,plateau));
		int y = (getPixelY(i));
		g.drawImage(imageBriqueRouge, x, y, null);
		g.drawString(""+lettre, x+7, y+20);
	}
	
	/**
	 * pour afficher les cellules vertes
	 * @param Graphics g
	 * @param int i position verticale
	 * @param int j position horizontale
	 * @param char lettre lettre de la brique
	 * @param Plateau plateau
	 */
	public void afficherCelluleVert(Graphics g, int i, int j, char lettre, Plateau plateau){
		int x = (getPixelX(j, plateau));
		int y = (getPixelY(i));
		g.drawImage(imageBriqueVert, x, y, null);
		g.drawString(""+lettre, x+7, y+20);
	}
	
	/**
	 * pour afficher les cellules gris�es (mode worddle)
	 * @param Graphics g
	 * @param int i position verticale
	 * @param int j position horizontale
	 * @param char lettre lettre de la brique
	 * @param Plateau plateau
	 */
	public void afficherCelluleGris(Graphics g, int i, int j, char lettre, Plateau plateau){
		int x = (getPixelX(j, plateau));
		int y = (getPixelY(i));
		g.drawImage(imageBriqueGris, x, y, null);
		g.drawString(""+lettre, x+7, y+15);
	}
	
/**
 * pour tout afficher
 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		setBackground(new Color (155, 204, 234, 0));//modifie la couleur de fond
		g.drawImage(background, 0, 0, null);
		g.setColor(Color.WHITE);

			// SOLO
			if(nbJoueurs==1){
				g.setFont(new Font("Helevetica", Font.PLAIN, 25)); 
				afficherPlateau(g);
				if(background == background_geek){
					valider_girly.setVisible(false);
					valider_geek.setVisible(true);
					valider_geek.setBounds(150, 130, 62, 29);
					valider_geek.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					valider_geek.setContentAreaFilled(false);
					valider_geek.setBorderPainted(false);
					add(valider_geek);
					supp_girly.setVisible(false);
					supp_geek.setVisible(true);
					supp_geek.setBounds(220, 130, 62, 29);
					supp_geek.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					supp_geek.setContentAreaFilled(false);
					supp_geek.setBorderPainted(false);
					add(supp_geek);
				} else if(background == background_girly){
					valider_geek.setVisible(false);
					valider_girly.setVisible(true);
					valider_girly.setBounds(150, 130, 62, 29);
					valider_girly.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					valider_girly.setContentAreaFilled(false);
					valider_girly.setBorderPainted(false);
					add(valider_girly);
					supp_geek.setVisible(false);
					supp_girly.setVisible(true);
					supp_girly.setBounds(220, 130, 62, 29);
					supp_girly.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					supp_girly.setContentAreaFilled(false);
					supp_girly.setBorderPainted(false);
					add(supp_girly);
				}
				paramJeu.setBounds(950,10, 34, 34);
				paramJeu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				paramJeu.setContentAreaFilled(false);
				paramJeu.setBorderPainted(false);
				add(paramJeu);
				
				g.drawString(String.valueOf(joueurs.get(0).getScore()), 200, 635);
				g.drawString(String.valueOf(joueurs.get(0).getNiveau()), 770, 635);
				next1 = getNext(joueurs.get(0)).getImage();
				g.drawImage(next1, 720, 80, null);
				
				if(!joueurs.get(0).getMessage().equals("Perdu!") && !joueurs.get(0).getMessage().equals("Bravo!")){
					g.setFont(new Font("Helevetica", Font.PLAIN, 15)); 
					g.drawString(String.valueOf(joueurs.get(0).getMessage()), 50, 190);
		
				}
				if(joueurs.get(0).getMessage().equals("Perdu!") || joueurs.get(0).getMessage().equals("Bravo!")){
					g.setFont(new Font("Helevetica", Font.PLAIN, 25)); 
					g.drawString(String.valueOf(joueurs.get(0).getMessage()), 200, 190);
		
				}
				g.setFont(new Font("Helevetica", Font.PLAIN, 25)); 
				
				
				if(joueurs.get(0).mode==Mode.ANAGRAMME){
					if(background == background_geek){
						g.drawImage(fleche, 310, getPixelY(joueurs.get(0).indexLigneSupp)+4, null);
					}
					else if(background == background_girly){
						g.drawImage(fleche_girly, 310, getPixelY(joueurs.get(0).indexLigneSupp)+4, null);
					}
					if(joueurs.get(0).motEnCours!=null){
						g.drawString(joueurs.get(0).motEnCours, 177, 107);
					}
				}
				
				if(joueurs.get(0).mode==Mode.WORDDLE){
					
					if(joueurs.get(0).positionEnCours!=null){
						if(background == background_geek){
							g.drawImage(fleche, getPixelX(joueurs.get(0).positionEnCours.getPosX(),joueurs.get(0)), getPixelY(joueurs.get(0).positionEnCours.getPosY())+4, null);
						}
						else if(background == background_girly){
							g.drawImage(fleche_girly, getPixelX(joueurs.get(0).positionEnCours.getPosX(),joueurs.get(0)), getPixelY(joueurs.get(0).positionEnCours.getPosY())+4, null);
						}
						if(joueurs.get(0).motEnCours!=null){
							g.drawString(joueurs.get(0).motEnCours, 177, 107);
						}
					}
					int temps = (int)(60 -( joueurs.get(0).tempsEcoule/1000));
					g.drawString("Temps restant : "+temps, 100, 220);
				}
			}
			//MULTIJOUEUR
			else if(nbJoueurs==2){

				//Joueur 1
				g.setFont(new Font("Helevetica", Font.PLAIN, 25)); 
				afficherPlateau(g);
				if(background == background_geek){
					valider_girly.setVisible(false);
					valider_geek.setVisible(true);
					valider_geek.setBounds(30, 380, 62, 29);
					valider_geek.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					valider_geek.setContentAreaFilled(false);
					valider_geek.setBorderPainted(false);
					add(valider_geek);
					supp_girly.setVisible(false);
					supp_geek.setVisible(true);
					supp_geek.setBounds(120, 380, 62, 29);
					supp_geek.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					supp_geek.setContentAreaFilled(false);
					supp_geek.setBorderPainted(false);
					add(supp_geek);
				}
				if(background == background_girly){
					valider_geek.setVisible(false);
					valider_girly.setVisible(true);
					valider_girly.setBounds(30, 380, 62, 29);
					valider_girly.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					valider_girly.setContentAreaFilled(false);
					valider_girly.setBorderPainted(false);
					add(valider_girly);
					supp_geek.setVisible(false);
					supp_girly.setVisible(true);
					supp_girly.setBounds(120, 380, 62, 29);
					supp_girly.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					supp_girly.setContentAreaFilled(false);
					supp_girly.setBorderPainted(false);
					add(supp_girly);
				}			
				paramJeu.setBounds(600,10, 34, 34);
				paramJeu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				paramJeu.setContentAreaFilled(false);
				paramJeu.setBorderPainted(false);
				add(paramJeu);
				
				g.drawString(String.valueOf(joueurs.get(0).getScore()), 100, 605);
				g.drawString(String.valueOf(joueurs.get(0).getNiveau()), 100, 700);
				next1 = getNext(joueurs.get(0)).getImage();
				
				if(!joueurs.get(0).getMessage().equals("Perdu!") && !joueurs.get(0).getMessage().equals("Bravo!")){
					g.setFont(new Font("Helevetica", Font.PLAIN, 15)); 
					g.drawString(String.valueOf(joueurs.get(0).getMessage()), 5, 470);
		
				}
				if(joueurs.get(0).getMessage().equals("Perdu!") || joueurs.get(0).getMessage().equals("Bravo!")){
					g.setFont(new Font("Helevetica", Font.PLAIN, 25)); 
					g.drawString(String.valueOf(joueurs.get(0).getMessage()), 90, 470);
		
				}
				g.setFont(new Font("Helevetica", Font.PLAIN, 25)); 
				
				if(joueurs.get(0).mode==Mode.ANAGRAMME){
					g.drawImage(fleche, 220, getPixelY(joueurs.get(0).indexLigneSupp)+4, null);
					if(joueurs.get(0).motEnCours!=null){
						g.drawString(joueurs.get(0).motEnCours, 100, 342);
					}
				}
				
				if(joueurs.get(0).mode==Mode.WORDDLE){
					if(joueurs.get(0).positionEnCours!=null){
						g.drawImage(fleche, getPixelX(joueurs.get(0).positionEnCours.getPosX(),joueurs.get(0)), getPixelY(joueurs.get(0).positionEnCours.getPosY())+4, null);
						if(joueurs.get(0).motEnCours!=null){
							g.drawString(joueurs.get(0).motEnCours, 100, 342);
						}
					}
					int temps = (int)(60 -( joueurs.get(0).tempsEcoule/1000));
					g.drawString("Temps restant : "+temps, 100, 54);
				}
				
				
				// Joueur2
				g.setFont(new Font("Helevetica", Font.PLAIN, 25));
				if(background == background_geek){
					valider_girly_j2.setVisible(false);
					valider_geek_j2.setVisible(true);
					valider_geek_j2.setBounds(1060, 380, 62, 29);
					valider_geek_j2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					valider_geek_j2.setContentAreaFilled(false);
					valider_geek_j2.setBorderPainted(false);
					add(valider_geek_j2);
					supp_girly_j2.setVisible(false);
					supp_geek_j2.setVisible(true);
					supp_geek_j2.setBounds(1170, 380, 62, 29);
					supp_geek_j2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					supp_geek_j2.setContentAreaFilled(false);
					supp_geek_j2.setBorderPainted(false);
					add(supp_geek_j2);
					} 
					else if(background == background_girly){
						valider_geek_j2.setVisible(false);
						valider_girly_j2.setVisible(true);
						valider_girly_j2.setBounds(1060, 380, 62, 29);
						valider_girly_j2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						valider_girly_j2.setContentAreaFilled(false);
						valider_girly_j2.setBorderPainted(false);
						add(valider_girly_j2);
						supp_geek_j2.setVisible(false);
						supp_girly_j2.setVisible(true);
						supp_girly_j2.setBounds(1170, 380, 62, 29);
						supp_girly_j2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						supp_girly_j2.setContentAreaFilled(false);
						supp_girly_j2.setBorderPainted(false);
						add(supp_girly_j2);
					}
				
				g.drawImage(next1, 50, 150, null);
				g.drawString(String.valueOf(joueurs.get(1).getScore()), 1144, 605);
				g.drawString(String.valueOf(joueurs.get(1).getNiveau()), 1144, 700);
				next2 = getNext(joueurs.get(1)).getImage();
				g.drawImage(next2, 1100, 150, null);
				
				if(!joueurs.get(1).getMessage().equals("Perdu!") && !joueurs.get(1).getMessage().equals("Bravo!")){
					g.setFont(new Font("Helevetica", Font.PLAIN, 15)); 
					g.drawString(String.valueOf(joueurs.get(1).getMessage()), 1020, 470);
		
				}
				if(joueurs.get(1).getMessage().equals("Perdu!") || joueurs.get(1).getMessage().equals("Bravo!")){
					g.setFont(new Font("Helevetica", Font.PLAIN, 25)); 
					g.drawString(String.valueOf(joueurs.get(1).getMessage()), 1122, 470);
		
				}
				g.setFont(new Font("Helevetica", Font.PLAIN, 25)); 
				
				if(joueurs.get(1).mode==Mode.ANAGRAMME){
					g.drawImage(fleche, 680, getPixelY(joueurs.get(1).indexLigneSupp)+4, null);
					if(joueurs.get(1).motEnCours!=null){
						g.drawString(joueurs.get(1).motEnCours, 1084, 342);
					}
				}
				
				if(joueurs.get(1).mode==Mode.WORDDLE){
					
					if(joueurs.get(1).positionEnCours!=null){
						g.drawImage(fleche, getPixelX(joueurs.get(1).positionEnCours.getPosX(),joueurs.get(1)), getPixelY(joueurs.get(1).positionEnCours.getPosY())+4, null);
						if(joueurs.get(1).motEnCours!=null){
							g.drawString(joueurs.get(1).motEnCours, 1084, 342);
						}
					}
					int temps = (int)(60 -( joueurs.get(1).tempsEcoule/1000));
					g.drawString("Temps restant : "+temps, 1034, 54);
				}
				
			}
			

			if(joueurs.get(0).perdu==true){
				g.drawImage(perdu, 0, 0, null);
				valider_geek.setVisible(false);
				valider_girly.setVisible(false);
				paramJeu.setVisible(false);
				supp_geek.setVisible(false);
				supp_girly.setVisible(false);
			}

			if(joueurs.size()>1 && joueurs.get(0).perdu==true){
				g.drawImage(perduMulti1, 0, 0, null);
				valider_geek.setVisible(false);
				valider_girly.setVisible(false);
				valider_geek_j2.setVisible(false);
				valider_girly_j2.setVisible(false);
				paramJeu.setVisible(false);
				supp_geek.setVisible(false);
				supp_girly.setVisible(false);
				supp_geek_j2.setVisible(false);
				supp_girly_j2.setVisible(false);
			}
			else if (joueurs.size()>1 && joueurs.get(1).perdu==true){
				g.drawImage(perduMulti2, 0, 0, null);
				valider_geek.setVisible(false);
				valider_girly.setVisible(false);
				valider_geek_j2.setVisible(false);
				valider_girly_j2.setVisible(false);
				paramJeu.setVisible(false);
				supp_geek.setVisible(false);
				supp_girly.setVisible(false);
				supp_geek_j2.setVisible(false);
				supp_girly_j2.setVisible(false);
			}
			

		
		
		

	}


	public void printTab(){
		String str = "";
		for(int i=0;i<plateau.getHauteur();i++){		
			for(int j=0;j<plateau.getLargeur();j++){
				if(plateau.tab[j][i] != null){
					if(plateau.tab[j][i].getForme() == Forme.MAGENTA){
						str += "M";
					}
					if(plateau.tab[j][i].getForme() == Forme.BLEU){
						str += "B";
					}
					if(plateau.tab[j][i].getForme() == Forme.CYAN){
						str += "C";
					}
					if(plateau.tab[j][i].getForme() == Forme.JAUNE){
						str += "J";
					}
					if(plateau.tab[j][i].getForme() == Forme.ORANGE){
						str += "O";
					}
					if(plateau.tab[j][i].getForme() == Forme.ROUGE){
						str += "R";
					}
					if(plateau.tab[j][i].getForme() == Forme.VERT){
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
	
	/*public void printTabLettres(){
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
	}*/
	
	/**
	 * pour afficher les plateaux
	 * @param Graphics g
	 */
	public void afficherPlateau(Graphics g){//affiche le monde dans le panel.
		for(int k=0; k<nbJoueurs; ++k){
			for(int i=0;i<joueurs.get(k).getHauteur();i++){		
				for(int j=0;j<joueurs.get(k).getLargeur();j++){
					if(joueurs.get(k).tab[j][i] != null){
						if(joueurs.get(k).tab[j][i].utilisee == true){
							afficherCelluleGris(g,i,j, joueurs.get(k).tab[j][i].getLettre(), joueurs.get(k));
						}else{
							if(joueurs.get(k).tab[j][i].getForme() == Forme.MAGENTA){
								afficherCelluleMagenta(g,i,j, joueurs.get(k).tab[j][i].getLettre(), joueurs.get(k));
							}
							if(joueurs.get(k).tab[j][i].getForme() == Forme.BLEU){
								afficherCelluleBleu(g,i,j, joueurs.get(k).tab[j][i].getLettre(), joueurs.get(k));
							}
							if(joueurs.get(k).tab[j][i].getForme() == Forme.CYAN){
								afficherCelluleCyan(g,i,j, joueurs.get(k).tab[j][i].getLettre() ,joueurs.get(k));
							}
							if(joueurs.get(k).tab[j][i].getForme() == Forme.JAUNE){
								afficherCelluleJaune(g,i,j, joueurs.get(k).tab[j][i].getLettre() ,joueurs.get(k));
							}
							if(joueurs.get(k).tab[j][i].getForme() == Forme.ORANGE){
								afficherCelluleOrange(g,i,j, joueurs.get(k).tab[j][i].getLettre() ,joueurs.get(k));
							}
							if(joueurs.get(k).tab[j][i].getForme() == Forme.ROUGE){
								afficherCelluleRouge(g,i,j, joueurs.get(k).tab[j][i].getLettre(), joueurs.get(k));
							}
							if(joueurs.get(k).tab[j][i].getForme() == Forme.VERT){
								afficherCelluleVert(g,i,j, joueurs.get(k).tab[j][i].getLettre(), joueurs.get(k));
							}
						}
					}
				}
			}
		}
	}
	
	/**
	 * pour avoir et afficher la pochaine forme de brique
	 * @param Plateau plateau
	 * @return ImageIcon
	 */
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
