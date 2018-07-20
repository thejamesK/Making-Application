package zdarzenia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Main extends JFrame
{
    public Main()
    {
        super("Events");
        this.setBounds(300, 300, 300, 200);
        
        initComponents();
        
        this.setDefaultCloseOperation(3);
    }
    
    public void initComponents()
    {
        
        redColor = new JButton("Red");
        blackColor = new JButton("Black");
        
        redColor.addActionListener(new colorListener(Color.RED));
//        blackColor.addActionListener(new colorListener(Color.BLACK));
        
        
        panel.add(redColor);
        panel.add(blackColor);
        
//        blackColor.addActionListener((ActionEvent ae) -> {
//            panel.setBackground(Color.BLACK);
//        });
        
        
        buildButton("Green", Color.GREEN);
        
        this.getContentPane().add(panel);
        
    }
    
    
    
    JPanel panel = new JPanel();
    JButton redColor;
    JButton blackColor;
    
    public void buildButton(String name, Color c)
    {
        JButton button = new JButton(name);
        button.addActionListener((ActionEvent ae) -> {
            panel.setBackground(c);
        });
                
        panel.add(button);
    }
    
    
    private class colorListener implements ActionListener
    {
        public colorListener(Color c)
        {
            this.color = c;
        }
        
        @Override
        public void actionPerformed(ActionEvent ae) 
        {
            panel.setBackground(color);
        }
        
        Color color;
        
    }

    public static void main(String[] args) 
    {
        new Main().setVisible(true);

        
    }
    
}
