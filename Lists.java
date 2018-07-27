package lists;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Lists extends JFrame
{
    public Lists()
    {
        initComponents();
    }
    
    public void initComponents()
    {
        this.setTitle("List");
        this.setBounds(300, 300, 500, 200);
        //String [] name = new String[] ("lala", "hmm");
        
        
        itemList.setVisibleRowCount(4);
        itemList.setFixedCellHeight(40);
        itemList.setFixedCellWidth(70);
        itemList.setBackground(Color.BLUE);
        itemList.setSelectionForeground(Color.GREEN);
        
        
        //itemList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        itemList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        
        itemList.addListSelectionListener(new ListSelectionListener() 
        {
            @Override
            public void valueChanged(ListSelectionEvent lse) 
            {
                System.out.println("Im changed " +(++i));
                
                if(lse.getValueIsAdjusting()) 
                    System.out.println("Im holding mouse button");
                else
                    System.out.println("Im released mouse button");
                
                if(!lse.getValueIsAdjusting())
                {
                    Object [] valuesInList = ((JList)lse.getSource()).getSelectedValues();
                    
                    String items = "";
                    
                    for (int i = 0; i < valuesInList.length; i++)
                    {
                        items += (String)valuesInList[i] + " "; 
                    }
                    System.out.println(items);
                    
                    comunicat.setText("I don't like: "+ items);
                }
            }
        });
        
        
        DefaultListModel modelList = new DefaultListModel();
        String[] text = new String[] {"Maths", "Physics", "Informatics", "Chemistry", "Biology", "History"};
        

        modelList.addElement("k");
        modelList.addElement("g");
        modelList.addElement("h");
        
        JList list2 = new JList(modelList);
        
        modelList.addElement("la");
        
        
        list2.addListSelectionListener(new ListSelectionListener() 
        {
            @Override
            public void valueChanged(ListSelectionEvent lse) 
            {
                for (int i = 0; i < text.length; i++)
                {       
                    modelList.addElement(text[i]);
                }
                //modelList.removeAllElements(0);
            }
        });
        
        
        
        
        panelList.add(scrollList);
        comunicationPanel.add(comunicat);
        
        
        this.getContentPane().add(panelList, BorderLayout.NORTH);
        this.getContentPane().add(comunicationPanel, BorderLayout.CENTER);
        this.getContentPane().add(list2, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    private int i = 0;
    private JList itemList = new JList(new String[] {"Maths", "Physics", "Informatics", "Chemistry", "Biology", "History"});
    private JScrollPane scrollList = new JScrollPane(itemList);
    private JPanel panelList = new JPanel();
    
    private JPanel comunicationPanel = new JPanel();
    private JLabel comunicat = new JLabel();
    
    public static void main(String[] args) 
    {
        new Lists().setVisible(true);
    }
    
}
