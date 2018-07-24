package appwithmanyframes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Shabbadoo
 */
public class NewClass extends JFrame
{
    public NewClass(JFrame parent)
    {
        initComponents();
        
        int width = (int)parent.getBounds().getWidth(); //500
        int height = (int)parent.getBounds().getHeight();//200
        
//        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
//        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        
        int frameWidth = this.getSize().width; // 350
        int frameHeight = this.getSize().height; // 75
        
        this.setLocation(parent.getBounds().x + (width - frameWidth)/2, parent.getBounds().y + (height - frameHeight)/2);
    }
    
    public void initComponents() 
    {
        this.setTitle("This is frame number " +(++i));
        this.setBounds(300, 300, 350, 75);
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
    }

    public static void main(String[] args) 
    {
        
        new AppWithManyFrames().setVisible(true);
        
    }
    static int i = 0;
}
