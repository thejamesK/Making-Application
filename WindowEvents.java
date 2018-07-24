package windowevents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Shabbadoo
 */
public class WindowEvents extends JFrame implements WindowListener
{
    
    public WindowEvents()
    {
        initComponents();
    }

    
    public void initComponents()
    {
        this.setTitle("Choose Field");
        this.setBounds(300, 300, 500, 300);
        
        this.addWindowListener(new WindowAdapter() 
        {
            
            public void windowOpened(WindowEvent we) 
            {
                JOptionPane.showMessageDialog(rootPane, "Hello! :)");
            }
            
        });
        
        
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
    public static void main(String[] args) 
    {
        new WindowEvents().setVisible(true);
    }

    @Override
    public void windowOpened(WindowEvent we) 
    {
        JOptionPane.showMessageDialog(this, "Hello! :)");
    }

    @Override
    public void windowClosing(WindowEvent we) 
    {
        int option = JOptionPane.showConfirmDialog(this, "Do you really wanna close this program? :(");
        if(option == 0)
            this.dispose();        
    }

    @Override
    public void windowClosed(WindowEvent we) 
    {
        System.out.println("Progress saved!");
    }

    @Override
    public void windowIconified(WindowEvent we) 
    {
        System.out.println("I'm minimalized");
    }

    @Override
    public void windowDeiconified(WindowEvent we) 
    {
        System.out.println("I'm maximized");
    }

    @Override
    public void windowActivated(WindowEvent we) 
    {
       System.out.println("I'm active"); 
    }

    @Override
    public void windowDeactivated(WindowEvent we) 
    {
        System.out.println("I'm deactive");
    }
    
}
