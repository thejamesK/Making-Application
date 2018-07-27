package paseknarzedzi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PasekNarzedzi extends JFrame
{
    public PasekNarzedzi()
    {
        initComponents();
    }
    
    public void initComponents()
    {
        setTitle("Toolbar");
        setBounds(300, 300, 500, 200);
        
        toolBar.add(new ColorButton(new ActionColor("Change color to green", new ImageIcon("green.png"), Color.GREEN)));
        toolBar.add(new ColorButton(new ActionColor("Change color to blue", new ImageIcon("blue.png"), Color.BLUE)));
        toolBar.add(new ColorButton(new ActionColor("Change color to red", new ImageIcon("red.png"), Color.RED)));
        toolBar.add(button);
        
        button.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                panel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                activ = null;
            }
        });
        
        panel.addMouseListener(new MouseAdapter() 
        {
            public void mousePressed(MouseEvent me) 
            {
                if(activ != null)
                    panel.setBackground((Color)activ.getAction().getValue("Color"));               
               
            }
        });
        this.getContentPane().setLayout(new GridLayout(2, 1));
        this.getContentPane().add(toolBar);
        this.getContentPane().add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private JToolBar toolBar = new JToolBar("New Frame Name");
    private JButton button = new JButton("End painting");
    private JPanel panel = new JPanel();
    private ColorButton activ = null;
    
    
    private class ActionColor extends AbstractAction
    {
        public ActionColor(String toolTip, Icon icon, Color color)
        {
            this.putValue(Action.SHORT_DESCRIPTION, toolTip);
            this.putValue(SMALL_ICON, icon);
            this.putValue("Color", color);
        }

        @Override
        public void actionPerformed(ActionEvent ae) 
        {
            activ = (ColorButton)ae.getSource();
            
        }
        
    }
    
    private class ColorButton extends JButton
    {

        private ColorButton(ActionColor actionColor) 
        {
            super(actionColor);
            
            this.addActionListener(new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent ae) 
                {
                    for(int i = 0; i < toolBar.getComponentCount(); i++)
                    {
                        if(toolBar.getComponent(i) instanceof ColorButton)
                        {
                            ColorButton tmp = (ColorButton)toolBar.getComponent(i);
                            tmp.setBackground(Color.WHITE);
                            tmp.setChecked(false);
                            panel.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon("cursor.png").getImage(), new Point(0, 0), "Our Cursor"));
                            
                        }
                    }
                    
                    
                    ten.setBackground((Color)actionColor.getValue("Color"));
                    ten.setChecked(true);
                }
            });
        }
        public void setChecked(boolean ch)
        {
            this.checked = ch;
        }
        ColorButton ten = this;
        boolean checked = false;

    }
    
    
    public static void main(String[] args) 
    {
        new PasekNarzedzi().setVisible(true);
    }
    
}
