package ramka``;

import javax.swing.*;
import java.awt.*;  //awt - abstract window toolkit

public class Ramka extends JFrame
{
    public Ramka()
    {
      /*  JFrame frame = new JFrame("Tytuł ramki");
//        frame.setTitle("Tytył ramki");

//        frame.setSize(300, 300);
////        frame.setSize(new Dimension(300, 300));
//
//        frame.setLocation(100, 50);
//        frame.setLocation(new Point(100, 50));

        frame.setBounds(100, 50, 300, 300); // ustaw granice
        
        frame.setResizable(false);
        
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("ikona.jpg"));

        
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
        */
        
        super("Tytuł ramki");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("ikona.jpg"));
        
        this.setBounds(100, 50, 300, 300);
        
        this.setDefaultCloseOperation(3);
//        this.pack();
    }
        
    public static void main(String[] args) 
    {
        new Ramka().setVisible(true);
    }
    
}
