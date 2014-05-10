package tetris;
 
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
 
/**
 * affiche le panel d'accueil
 *
 *
 */
@SuppressWarnings("serial")
public class PanelDemarrage extends JPanel {
        Image background;
        JButton bt_start, bt_multi, bt_exit;
       
       
        public PanelDemarrage(){
            
        	this.setLayout(new FlowLayout());
            //boutons
            bt_start = new JButton(new ImageIcon("start.png"));
            bt_multi = new JButton(new ImageIcon("multi.png"));
            bt_exit = new JButton(new ImageIcon("exit.png"));
           
            //Add background      
            background = new ImageIcon("demarrage.png").getImage();
           
   
}      
        /**
         * affiche tout
         */
         public void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(background,0,0,null);
                    bt_start.setBounds(150, 200, 271, 77);
                    bt_start.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    bt_start.setBorderPainted(false);
                    bt_start.setContentAreaFilled(false);
                    add(bt_start);
                    bt_multi.setBounds(150, 325, 271, 77);
                    bt_multi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    bt_multi.setBorderPainted(false);
                    bt_multi.setContentAreaFilled(false);
                    add(bt_multi);
                    bt_exit.setBounds(150, 450, 271, 77);
                    bt_exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    bt_exit.setBorderPainted(false);
                    bt_exit.setContentAreaFilled(false);
                    add(bt_exit);
                   
     }
       
}