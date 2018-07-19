package layout;

import javax.swing.*;
import java.awt.*;

public class Layout extends JFrame
{
    public Layout()
    {
        super("This is Layout");
        this.setBounds(300, 320, 300, 200);
        
        initComponets();
//        this.pack();
        
        this.setDefaultCloseOperation(3);
    }
    
    
    public void initComponets()
    {
        center = new JButton("Cancel");
        top = new JButton("Im on top!");
        bottom = new JButton("Im on bottom!");
        east = new JButton("Im on east!");
        west = new JButton("Im on west!");
                      
        
        Container container = this.getContentPane();
//        top.setSize(100, 400);
        
//        container.add(center, BorderLayout.CENTER);
//        container.add(top, BorderLayout.PAGE_START);
//        container.add(bottom, BorderLayout.PAGE_END);
//        container.add(east, BorderLayout.EAST);
//        container.add(west, BorderLayout.WEST);
        
        center.setLocation(210, 125);
        center.setSize(center.getPreferredSize());
        container.setLayout(null);
        container.add(center);

        
        
    }
    
    
    JButton center;
    JButton top;
    JButton bottom;
    JButton east;
    JButton west;
    
    
    public static void main(String[] args) 
    {
        new Layout().setVisible(true);
    }
    
}
