package centerframe;

import javax.swing.*;
import java.awt.*;

public class CenterFrame extends JFrame
{
    public CenterFrame()
    {
      
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        
        this.setSize(width/2, height/2);
//        this.setLocation(width/4, height/4);
        
        int frameWidth = this.getSize().width;
        int frameHeight = this.getSize().height;
        
        this.setLocation((width - frameWidth)/2, (height - frameHeight)/2);
        
        this.setDefaultCloseOperation(3);
        
    }
       
    

    public static void main(String[] args) 
    {
        new CenterFrame().setVisible(true);
    }
    
}
