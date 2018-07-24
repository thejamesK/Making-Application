package borders;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Shabbadoo
 */
public class Borders extends JFrame
{
    
    public Borders()
    {
        initComponents();
    }
    
    public void initComponents()
    {
        this.setTitle("Borders");
        this.setBounds(300, 300, 500, 200);
        
        addSwitch("CreateEtachedBorder", BorderFactory.createEtchedBorder());
        addSwitch("CreateLoweredBevelBorder", BorderFactory.createLoweredBevelBorder());
        
        //panelRadio.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        
        panelRadio.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED), "Borders", TitledBorder.RIGHT, TitledBorder.BOTTOM));
        
        
        this.getContentPane().setLayout(new GridLayout(2, 1));
        
        
        this.getContentPane().add(panelRadio);
        this.getContentPane().add(panelBorder);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private JPanel panelRadio = new JPanel();
    private JPanel panelBorder = new JPanel();
    private ButtonGroup radioGroup = new ButtonGroup();
    
    public void addSwitch(String name, Border b)
    {
        JRadioButton radioSwitch = new JRadioButton(name);
        
        radioSwitch.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                panelBorder.setBorder(BorderFactory.createTitledBorder(b, name));
            }
        });
               
    radioGroup.add(radioSwitch);
    panelRadio.add(radioSwitch);
    
    
    }

    
    
    

    public static void main(String[] args) 
    {
        new Borders().setVisible(true);
        
    }
    
}
