package tetris;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Windows extends JFrame implements ActionListener
{
    JButton startG,exitG;
    JPanel panel;   
    ImageIcon ii;
    JLabel picture;
    ImageIcon bt_exit; 
    ImageIcon bt_start; 
    
    public Windows()
    {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setOpaque(false);
        panel.setSize(400,700);
        getContentPane().add(panel);        
        
        //Start Game Button
        bt_start = new ImageIcon(this.getClass().getResource("../img/start.gif"));
        startG = new JButton(bt_start);
        startG.setBounds(110, 250, 177, 42);
        startG.setFocusable(false);
        panel.add(startG);
                
        
        //Exit Game Button
        bt_exit = new ImageIcon(this.getClass().getResource("../img/exit.gif"));
        exitG = new JButton(bt_exit);
        exitG.setBounds(110, 350, 177, 42);
        exitG.setFocusable(false);
        panel.add(exitG);
        
        //Add background       
        ii = new ImageIcon(this.getClass().getResource("../img/background.jpeg"));
        picture = new JLabel(new ImageIcon(ii.getImage()));
        add(picture);
        
        //Action button
        startG.addActionListener(this);
        exitG.addActionListener(this);
        
        //Windows
        setTitle("Tetra Word");        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(400,700);
        setResizable(false);
        setVisible(true);
    }
        
    public static void main(String agrs[])
    {
        new Windows();
    }
    
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == startG)
        {            
             System.out.println("New Game - button is working");
        }
        else if(e.getSource() == exitG)
        {
            System.out.println("Game is exiting - button is working");
            System.exit(0);
        }
    }

}