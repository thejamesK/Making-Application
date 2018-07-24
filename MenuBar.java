package taskbarmenu;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Shabbadoo
 */
public class TaskbarMenu extends JFrame
{
    public TaskbarMenu()
    {
        initComponents();
    }
    
    public void initComponents()
    {
        this.setTitle("Taskbar Menu");
        this.setBounds(300, 300, 500, 200);
        this.setJMenuBar(menuBar);
        
        JMenu menuFile = menuBar.add(new JMenu("File"));
        JMenuItem underMenuNew = menuFile.add(new JMenuItem ("New"));
        underMenuNew.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                System.out.println("Here is code with creates new file");
            }
        });
        menuFile.addSeparator();
        JMenuItem underMenuSave = menuFile.add(new JMenuItem ("Save"));
        menuFile.add(new JMenuItem ("Open"));
        menuFile.addSeparator();
        
        JMenu menuOptions = new JMenu("Options");
        menuFile.add(menuOptions);
        menuOptions.add(new JMenuItem ("Option 1"));
        menuOptions.add(new JMenuItem ("Option 2"));
        menuOptions.add(readOnly);
         
        readOnly.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                if (readOnly.isSelected())
                    underMenuSave.setEnabled(false);
                else
                    underMenuSave.setEnabled(true);
            }
        });
        
        JMenu menuHelp = menuBar.add(new JMenu ("Help"));
        
        menuHelp.add(new JMenuItem ("FAQ"));
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JMenuBar menuBar = new JMenuBar();
    
    private JCheckBoxMenuItem readOnly = new JCheckBoxMenuItem("Read Only");
    
    private JRadioButtonMenuItem radio = new JRadioButtonMenuItem("Radio");
    
    
    

    public static void main(String[] args) 
    {
        new TaskbarMenu().setVisible(true);
    }
    
}
