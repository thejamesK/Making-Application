package przelaczniki;

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
        this.setTitle("Radio Switche's Group");
        this.setBounds(300, 300, 300, 200);
        panel2.add(label);
        
//        JRadioButton smallSwitch = new JRadioButton("Small");
//        JRadioButton mediumSwitch = new JRadioButton("Medium");
//        JRadioButton bigSwitch = new JRadioButton("Big");
//        
//        smallSwitch.addActionListener((ActionEvent ae) -> {
//            label.setFont(new Font("Monospaced", Font.BOLD, 25));
//        });
//        
//        groupSize.add(smallSwitch);
//        groupSize.add(mediumSwitch);
//        groupSize.add(bigSwitch);
//        
//        panel.add(smallSwitch);
//        panel.add(mediumSwitch);
//        panel.add(bigSwitch);
               
        
        buildSwitchSize("Small", 15);
        buildSwitchSize("Medium", 25);
        buildSwitchSize("Big", 35);
        
        buildSwitchColor("Green", Color.GREEN);
        buildSwitchColor("Red", Color.RED);
        buildSwitchColor("Blue", Color.BLUE);
        
        this.getContentPane().add(panel, BorderLayout.NORTH);
        this.getContentPane().add(panel2, BorderLayout.SOUTH);
        this.getContentPane().add(panel3, BorderLayout.CENTER);
        
        this.setDefaultCloseOperation(3);
    }
    
    public void buildSwitchSize(String name, int size)
    {
        JRadioButton radioswitch = new JRadioButton(name);
        
        radioswitch.addActionListener((ActionEvent ae) -> 
        {
            label.setFont(new Font("Monospaced", Font.PLAIN, size));
        });
        
        
        groupSize.add(radioswitch);
        panel.add(radioswitch);
    }
    
        public void buildSwitchColor(String name, Color c)
    {
        JRadioButton radioswitch = new JRadioButton(name);
        
        radioswitch.addActionListener((ActionEvent ae) -> 
        {
            label.setForeground(c);
        });
        
        
        groupColor.add(radioswitch);
        panel3.add(radioswitch);
    }
    
    
    
    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JLabel label = new JLabel("Something");
    
    
    ButtonGroup groupSize = new ButtonGroup();
    ButtonGroup groupColor = new ButtonGroup();
    
    
    

    public static void main(String[] args) 
    {
        
        new Main().setVisible(true);
        

    }
    
}
