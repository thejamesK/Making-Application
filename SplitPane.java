package podzieleniepaneli;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
        
public class PodzieleniePaneli extends JFrame
{
    public PodzieleniePaneli()
    {
        initComponents();
    }
    
    public void initComponents()
    {
        this.setTitle("Split Pane");
        this.setBounds(300, 300, 500, 200);
        
        listPanel.add(list);
        imagePanel.add(image);
        descriptionPanel.add(description);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.addListSelectionListener(new ListSelectionListener() 
        {
            @Override
            public void valueChanged(ListSelectionEvent lse) 
            {
                if(!lse.getValueIsAdjusting())
                {
                    Image img = (Image)((JList)lse.getSource()).getSelectedValue();
                    
                    image.setIcon(img.getImage());
                    description.setText(img.getDescription());
                }
            }
        });
        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, listPanel, imagePanel);
        
        JSplitPane mainSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, split, descriptionPanel);
        
        
        this.getContentPane().add(mainSplit);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
        
    JPanel listPanel = new JPanel();
    JPanel imagePanel = new JPanel();
    JPanel descriptionPanel = new JPanel();
    
    JList list = new JList(
            new Image[] {
                
                
                new Image("blue", "beautiful blue color"),
                new Image("green", "beautiful green color"),
                new Image("red", "beautiful red color"),
            });
    
    
    JLabel image = new JLabel();
    JLabel description = new JLabel();
 
    private class Image
    {
        public Image(String name, String description)
        {
            this.name = name;
            this.description = description;
            
            image = new ImageIcon(name + ".gif");
        }
        
        public String toString()
        {
            return name;
        }
        
        public ImageIcon getImage()
        {
            return image;
        }
        
        public String getDescription()
        {
            return description;
        }
                    
        String name, description;
        ImageIcon image;
    }
    
    public static void main(String[] args) 
    {
        new PodzieleniePaneli().setVisible(true);
        
    }
    
}
