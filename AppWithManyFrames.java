package appwithmanyframes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Shabbadoo
 */
public class AppWithManyFrames extends JFrame
{
    public AppWithManyFrames()
    {
        initComponents();
    }
    
    public void initComponents()
    {
        this.setTitle("App with many frames");
        this.setBounds(300, 300, 500, 300);
        
        
        newFrame.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                new Dialog(thisFrame).setVisible(true);
            }
        });
        this.getContentPane().add(newFrame);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    private JFrame thisFrame = this;
    private JButton newFrame = new JButton("Make Frame");
    public static void main(String[] args) 
    {
        
        new AppWithManyFrames().setVisible(true);
        
    }
    
}
