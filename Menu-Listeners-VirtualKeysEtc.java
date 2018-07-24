package wlasnemenu;

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
        
        this.setTitle("My own Menu");
        this.setBounds(300, 300, 300, 200);
        
        
        panelMenu.setLayout(new GridLayout(3, 1));
        panelMenu.add(menu1);
        panelMenu.add(menu2);
        panelMenu.add(menu3);
        
        container.add(panelMenu);
        this.setDefaultCloseOperation(3);
    }
    
    private Container container = this.getContentPane();
    private JPanel panelMenu = new JPanel();
    MenuButton menu1 = new MenuButton("1. Add");
    MenuButton menu2 = new MenuButton("2. Remove");
    MenuButton menu3 = new MenuButton("3. Change");
    private int i = 0;
    
    
    private class MenuButton extends JButton implements FocusListener, ActionListener
    {
        public MenuButton(String name)
        {
            super(name);
            
            this.addFocusListener(this);
            this.addActionListener(this);
            this.addKeyListener(new KeyAdapter() 
            {
                @Override
                public void keyPressed(KeyEvent ke) 
                {
                    keyPressedHandler(ke);
                }

            });
            this.setBackground(cDefault);
        }

        @Override
        public void focusGained(FocusEvent fe) 
        {
            this.setBackground(cFocusGained);
        }

        @Override
        public void focusLost(FocusEvent fe) 
        {
            this.setBackground(cDefault);
        }
        
        private void keyPressedHandler(KeyEvent ke)
        {
            int dlMenu = panelMenu.getComponentCount();
            
            if (i==0) i = 10*dlMenu;
            if(ke.getKeyCode() == KeyEvent.VK_DOWN)
            {
                //System.out.println(++i);
                panelMenu.getComponent(++i%dlMenu).requestFocus();
            }
            else if(ke.getKeyCode() == KeyEvent.VK_UP)
            {
                //System.out.println(--i);
                panelMenu.getComponent(--i%dlMenu).requestFocus();
            }
            else if(ke.getKeyCode() == KeyEvent.VK_ENTER)
            {
                //MenuButton tmp = (MenuButton)ke.getSource();
                ((MenuButton)ke.getSource()).doClick();
            }
        }
        
        @Override
        public void actionPerformed(ActionEvent ae) 
        {
            JOptionPane.showMessageDialog(this, ((MenuButton)ae.getSource()).getText());
        }

        private Color cFocusGained = Color.RED;
        private Color cDefault = Color.BLUE;

    }

    public static void main(String[] args) 
    {
        new Main().setVisible(true);

    }
    
}
