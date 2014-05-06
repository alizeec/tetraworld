package tetris;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * affiche le panel des param�tres
 * 
 *
 */
@SuppressWarnings("serial")
public class PanelParameters extends JPanel {
	Image background;
	JLabel picture, totalBriques, regleTotalBriques, totalLettres, regleTotalLettres;	
	JButton bt_verif_letters, croix_rouge, play_song, stop_song, song_played, song_stoped, param, geek_gris, geek_jaune, girly_gris,girly_jaune,en,en_gris,fr,fr_gris;
	JLabel lblResult;
	int total_briques, total_lettres;
	JTextField taux_rouge, taux_vert, taux_bleu, taux_cyan,taux_orange, taux_magenta, taux_jaune,taux_total_briques, taux_voyelles, taux_consonnes, taux_rares, taux_total_lettres;
	JCheckBox facile, normal, difficile;
	static public int valeur_taux_voyelles, valeur_taux_consonnes, valeur_taux_rares, difficulte_anagramme ;
	ButtonGroup bg = new ButtonGroup();
	
	public PanelParameters(){
		this.setLayout(new FlowLayout());
		//bt play musique
	    play_song = new JButton(new ImageIcon("sound_on_jaune.png"));
	    stop_song = new JButton(new ImageIcon("sound_off_jaune.png"));
	    song_played = new JButton(new ImageIcon("sound_on_gris.png"));
	    song_stoped = new JButton(new ImageIcon("sound_off_gris.png"));
	    // bt background
	    geek_gris = new JButton(new ImageIcon("geek_gris.png"));
	    geek_jaune = new JButton(new ImageIcon("geek_jaune.png"));
	    girly_gris = new JButton(new ImageIcon("girly_gris.png"));
	    girly_jaune = new JButton(new ImageIcon("girly_jaune.png"));
	    //bt param
	    param= new JButton(new ImageIcon("parametres_bt.gif" ));
	    // bt langue
	    en= new JButton(new ImageIcon("en.png" ));
	    en_gris= new JButton(new ImageIcon("en_gris.png" ));
	    fr= new JButton(new ImageIcon("fr.png" ));
	    fr_gris= new JButton(new ImageIcon("fr_gris.png" ));
	    
	    //taux briques
	    taux_rouge = new JTextField("2");
	    taux_orange = new JTextField("1");
	    taux_jaune = new JTextField("2");
	    taux_vert = new JTextField("1");
	    taux_bleu = new JTextField("1");
	    taux_cyan = new JTextField("2");
	    taux_magenta = new JTextField("1");
	    total_briques = Integer.valueOf(taux_rouge.getText()) + Integer.valueOf(taux_orange.getText()) + Integer.valueOf(taux_jaune.getText())+ Integer.valueOf(taux_vert.getText())+ Integer.valueOf(taux_bleu.getText())+ Integer.valueOf(taux_cyan.getText())+ Integer.valueOf(taux_magenta.getText());
	    taux_total_briques = new JTextField();
	    taux_total_briques.setText(String.valueOf(total_briques));
	    totalBriques =  new JLabel("Total");
	    regleTotalBriques =  new JLabel("Le total doit valoir 10");
	    
	    //taux lettres
	    taux_consonnes = new JTextField("5");
	    taux_voyelles = new JTextField("3");
	    taux_rares = new JTextField("2");
	    total_lettres = Integer.valueOf(taux_consonnes.getText()) + Integer.valueOf(taux_voyelles.getText()) + Integer.valueOf(taux_rares.getText());
	    taux_total_lettres = new JTextField();
	    taux_total_lettres.setText(String.valueOf(total_lettres));
	    totalLettres =  new JLabel("Total");
	    regleTotalLettres =  new JLabel("Le total doit valoir 10");
	    valeur_taux_voyelles = 3;
   	    valeur_taux_consonnes = 5;
   	    valeur_taux_rares = 2;
	    croix_rouge = new JButton(new ImageIcon("croix_rouge.png"));
	    croix_rouge.setVisible(false);
	    
	   
	    
	    bt_verif_letters = new JButton("OK");
	
	    
	    bt_verif_letters.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	          valeur_taux_voyelles = Integer.valueOf(taux_voyelles.getText());
	     	  valeur_taux_consonnes = Integer.valueOf(taux_voyelles.getText());
	     	  valeur_taux_rares = Integer.valueOf(taux_voyelles.getText());
	          total_lettres = Integer.valueOf(taux_consonnes.getText()) + Integer.valueOf(taux_voyelles.getText()) + Integer.valueOf(taux_rares.getText());
	          taux_total_lettres.setText(String.valueOf(total_lettres));
	          
	  	    if ( total_lettres !=10){
	  	      	  param.setVisible(false);
	  	      	  croix_rouge.setVisible(true);
	  	      	  
	  	        }
	        }
	      });
	    
	
	    
	    //Niveau
	    facile = new JCheckBox("easy");
	    normal = new JCheckBox("normal");
	    difficile = new JCheckBox("hard");
	    normal.setSelected(true);
	    bg.add(facile);
	    bg.add(normal);
	    bg.add(difficile);
	    
	    //Add background       
	    background = new ImageIcon("fond_param.png").getImage();
	    
	
	  	      
    
}	
	/**
	 * affiche tout
	 */
	 public void paintComponent(Graphics g) {
		    super.paintComponent(g);
			g.drawImage(background,0,0,null);    
			play_song.setBounds(775, 200, 63, 93);
		    play_song.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		    play_song.setContentAreaFilled(false);
		    play_song.setBorderPainted(false);
		    add(play_song);
		    stop_song.setBounds(845, 197, 63, 93);
		    stop_song.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		    stop_song.setContentAreaFilled(false);
		    stop_song.setBorderPainted(false);
		    add(stop_song);
		    song_played.setBounds(775, 200, 63, 93);
		    song_played.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		    song_played.setContentAreaFilled(false);
		    song_played.setBorderPainted(false);
		    add(song_played);
		    song_stoped.setBounds(845, 197, 63, 93);
		    song_stoped.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		    song_stoped.setContentAreaFilled(false);
		    song_stoped.setBorderPainted(false);
		    add(song_stoped);
			geek_jaune.setBounds(770, 420, 74, 60);
			geek_jaune.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			geek_jaune.setContentAreaFilled(false);
			geek_jaune.setBorderPainted(false);
		    add(geek_jaune);
		    geek_gris.setBounds(770, 420, 74, 60);
		    geek_gris.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		    geek_gris.setContentAreaFilled(false);
		    geek_gris.setBorderPainted(false);
		    add(geek_gris);
		    girly_jaune.setBounds(855, 408, 54, 72);
		    girly_jaune.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		    girly_jaune.setContentAreaFilled(false);
		    girly_jaune.setBorderPainted(false);
		    add(girly_jaune);
		    girly_gris.setBounds(855,408, 54, 72);
		    girly_gris.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		    girly_gris.setContentAreaFilled(false);
		    girly_gris.setBorderPainted(false);
		    add(girly_gris);
		    en.setBounds(855,550, 54, 72);
		    en.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		    en.setContentAreaFilled(false);
		    en.setBorderPainted(false);
		    add(en);
		    en_gris.setBounds(855,550, 54, 72);
		    en_gris.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		    en_gris.setContentAreaFilled(false);
		    en_gris.setBorderPainted(false);
		    add(en_gris);
		    fr.setBounds(790,550, 54, 72);
		    fr.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		    fr.setContentAreaFilled(false);
		    fr.setBorderPainted(false);
		    add(fr);
		    fr_gris.setBounds(790,550, 54, 72);
		    fr_gris.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		    fr_gris.setContentAreaFilled(false);
		    fr_gris.setBorderPainted(false);
		    add(fr_gris);
			param.setBounds(950,10, 34, 34);
			param.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			param.setContentAreaFilled(false);
			param.setBorderPainted(false);
			add(param);
			taux_rouge.setBounds(150,215, 60, 25);
			add(taux_rouge);
			taux_vert.setBounds(150,285, 60, 25);
			add(taux_vert);
			taux_cyan.setBounds(150,350, 60, 25);
			add(taux_cyan);
			taux_magenta.setBounds(150,400, 60, 25);
			add(taux_magenta);
			taux_orange.setBounds(150,450, 60, 25);
			add(taux_orange);
			taux_jaune.setBounds(150,500, 60, 25);
			add(taux_jaune);
			taux_bleu.setBounds(150,560, 60, 25);
			add(taux_bleu);
			taux_total_briques.setBounds(150,620, 60, 25);
			add(taux_total_briques);
			totalBriques.setBounds(100,620, 60, 25);
			totalBriques.setForeground(new Color(255,255,255));
			add(totalBriques);
			regleTotalBriques.setBounds(95,650, 150, 25);
			regleTotalBriques.setForeground(new Color(255,255,255));
			add(regleTotalBriques);
			taux_voyelles.setBounds(500,210, 60, 25);
			add(taux_voyelles);
			taux_consonnes.setBounds(500,250, 60, 25);
			add(taux_consonnes);		
			taux_rares.setBounds(500,290, 60, 25);
			add(taux_rares);
			taux_total_lettres.setBounds(500,330, 60, 25);
			add(taux_total_lettres);
			totalLettres.setBounds(450,330, 60, 25);
			totalLettres.setForeground(new Color(255,255,255));
			add(totalLettres);
			regleTotalLettres.setBounds(570,330, 150, 25);
			regleTotalLettres.setForeground(new Color(255,255,255));
			add(regleTotalLettres);
			facile.setBounds(370,580, 60, 25);	
			facile.setOpaque(false);
			facile.setForeground(new Color(255,255,255));
			add(facile);
			normal.setBounds(470,580, 70, 25);	
			normal.setOpaque(false);
			normal.setForeground(new Color(255,255,255));
			add(normal);
			difficile.setBounds(570,580, 70, 25);	
			difficile.setOpaque(false);
			difficile.setForeground(new Color(255,255,255));
			add(difficile);
		    if(facile.isSelected()==true){
		    	difficulte_anagramme = 10;
		    }else if (normal.isSelected()==true){
		    	difficulte_anagramme =30;
		    }else if (difficile.isSelected()==true){
		    	difficulte_anagramme =60;
		    }
		    bt_verif_letters.setBounds(300,580, 70, 25);	
		    add(bt_verif_letters);
		    croix_rouge.setBounds(300,500, 37, 35);	
		    croix_rouge.setOpaque(false);
		    add(croix_rouge);
     } 
	
}	
