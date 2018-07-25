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
        menuFile.setMnemonic('F');
        

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
        //
        
        Action actionSave = new ActionSave("Save", "Save file on disk", "ctrl S", new ImageIcon("save.jpg"), KeyEvent.VK_S);
        JMenuItem underMenuSave = menuFile.add(actionSave);
        saveButton = new JButton(actionSave);
        
        actionSave.setEnabled(false);
        /*
        underMenuSave.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                System.out.println("Saving!");
                underMenuSave.setEnabled(textAreaFlag = false);
            }
        });
        
        
        underMenuSave.setToolTipText("Save file on disk");
        underMenuSave.setMnemonic('S');
        underMenuSave.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
        //underMenuSave.setAccelerator(KeyStroke.getKeyStroke(KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.CTRL_MASK));
        //
        */
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
                    actionSave.setEnabled(false);
                else
                    actionSave.setEnabled(textAreaFlag);
            }
        });
        
        
        JMenu menuHelp = menuBar.add(new JMenu ("Help"));
        
        menuHelp.add(new JMenuItem ("FAQ"));
        
        textArea.addKeyListener(new KeyAdapter() 
        {
            public void keyTyped(KeyEvent ke) 
            {
                if(readOnly.isSelected())
                    ke.consume();
            }
            
            public void keyPressed(KeyEvent ke) 
            {
                if(readOnly.isSelected())
                    ke.consume();
                else if(!(textArea.getText() + ke.getKeyChar()).equals(beforeChangeInTextArea) && isThisAscii(ke.getKeyChar()))
                {
                    beforeChangeInTextArea = textArea.getText() + ke.getKeyChar();
                    
                    actionSave.setEnabled(textAreaFlag = true);
                }      
            }       
            
        } );

        
        
        this.getContentPane().setLayout(new GridLayout(2, 1));
        this.getContentPane().add(textArea);
        this.getContentPane().add(saveButton);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    

    private JMenuBar menuBar = new JMenuBar();
    
    private JCheckBoxMenuItem readOnly = new JCheckBoxMenuItem("Read Only");
    
    private JRadioButtonMenuItem radio = new JRadioButtonMenuItem("Radio");
    
    private JTextArea textArea = new JTextArea();
    
    private boolean textAreaFlag = false;
    
    private String beforeChangeInTextArea = "";
    
    private JButton saveButton;
    
    private class ActionSave extends AbstractAction 
    {
        public ActionSave(String name, String hint, String keyShortcut, Icon icon, int mnemonicKey)
        {
           this.putValue(Action.NAME, name);
           this.putValue(Action.SHORT_DESCRIPTION, hint);
           this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(keyShortcut));
           this.putValue(Action.SMALL_ICON, icon);
           this.putValue(Action.MNEMONIC_KEY, mnemonicKey);
        }
        @Override
        public void actionPerformed(ActionEvent ae) 
        {
            System.out.println("Saving!");
            this.setEnabled(textAreaFlag = false);
        }
    }
        
    private boolean isThisAscii(char ch)
    {
        for (int i = 0; i < 256; i++)
            if(ch == i)
                return true;
        
        return false;
    }
    
    
    
    public static void main(String[] args) 
    {
        new TaskbarMenu().setVisible(true);
    }
    
}
