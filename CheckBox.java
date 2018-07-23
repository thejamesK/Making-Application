package polewyboru;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame
{
    public Main()
    {
        initComponents();
        
    }
    
    
    public void initComponents() 
    {
       this.setTitle("Checkbox");
       this.setBounds(300, 300, 300, 200);
       
       label.setFont(new Font("Monospaced", Font.PLAIN, 18));
       
       ActionListener listener = new CheckBoxHandler();
       boldCheckbox.addActionListener(listener);
       italicCheckbox.addActionListener(listener);
       panel1.add(boldCheckbox);
       panel1.add(italicCheckbox);
       
       panel2.add(label);
              
       this.getContentPane().add(panel1, BorderLayout.NORTH);
       this.getContentPane().add(panel2, BorderLayout.CENTER);
       
       
                     
       this.setDefaultCloseOperation(3);
    }
    
    
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    
    JCheckBox boldCheckbox = new JCheckBox("Bold");
    JCheckBox italicCheckbox = new JCheckBox("Italic");
    
    JLabel label = new JLabel("I'm beautiful");
    
    
    
    public class CheckBoxHandler implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) 
        {
            
            int style = Font.PLAIN;
            if (boldCheckbox.isSelected())
                style += Font.BOLD;
            if(italicCheckbox.isSelected())
                style += Font.ITALIC;
            
            label.setFont(new Font(label.getFont().getFamily(), style, label.getFont().getSize()));
        }
        
    }
    public static void main(String[] args) 
    {
        
        new Main().setVisible(true);
        
    }
    
    
    
    
}
