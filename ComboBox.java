package listykombinowane;

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
        this.setTitle("Combo List");
        this.setBounds(300, 300, 500, 300);
        
        combo.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                //colorHandler handler = (colorHandler)((JComboBox)ae.getSource()).getSelectedItem();
                
                ((JComboBox)ae.getSource()).setBackground(((colorHandler)((JComboBox)ae.getSource()).getSelectedItem()).getColor());

            }
        });
        
        panel.add(combo);
        
        combo.addItem(new colorHandler("Black", Color.BLACK));
        combo.addItem(new colorHandler("Green", Color.GREEN));
        combo.addItem(new colorHandler("Blue", Color.BLUE));
        combo.addItem(new colorHandler("Yellow", Color.YELLOW));
        combo.addItem(new colorHandler("Red", Color.RED));
        
        
        
        this.getContentPane().add(panel);
        this.setDefaultCloseOperation(3);
    }
    
    private class colorHandler
    {
        public colorHandler(String colorName, Color color)
        {
            this.color = color;
            this.colorName = colorName;
        }
        
        @Override
        public String toString()
        {
            return this.colorName;
        }
        public Color getColor()
        {
            return this.color;
        }
        private Color color;
        private String colorName;
    }
    private JPanel panel = new JPanel();
    JComboBox combo = new JComboBox();

    public static void main(String[] args) 
    {
        new Main().setVisible(true);
        
        
    }
    
}
