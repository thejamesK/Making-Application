package bookmarks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Bookmarks extends JFrame
{
    public Bookmarks()
    {
        initComponents();
    }
    
    public void initComponents()
    {
       this.setTitle("Bookmarks");
       this.setBounds(300, 300, 500, 200);
       
       
       bookmark.addTab("Tab 1", new JLabel("This is first"));
       bookmark.setMnemonicAt(0, KeyEvent.VK_T);
       
       JPanel panel = new JPanel();
       panel.add(new JButton("test"));
       
       bookmark.addTab("Tab 2", new ImageIcon("icon.jpg"), panel, "test");
       
       
       bookmark.addTab("Tab 3", createPanel);
       createPanel.add(new JLabel("Create new file named: "));
       JTextField newTabName = new JTextField(7);
       createPanel.add(newTabName);
       JButton createTab = new JButton("Create");
       createPanel.add(createTab);
       
       
       createTab.addActionListener((ActionEvent ae) -> 
       {
           JPanel textPanel = new JPanel();
           textPanel.setLayout(new GridLayout(1, 1));
           JTextArea textArea = new JTextArea();
           textPanel.add(new JScrollPane(textArea));
           
           bookmark.addTab(newTabName.getText() + ".txt", textPanel);
           bookmark.setSelectedIndex(bookmark.getTabCount() - 1);
           
           
           textArea.addKeyListener(new KeyAdapter() 
           {
                public void keyPressed(KeyEvent ke) 
                {
                    if(!(tabTitle + ke.getKeyChar()).equals(beforeChangeInTextArea) && isThisAscii(ke.getKeyChar()) && saveFlag == true)
                {
                    beforeChangeInTextArea = tabTitle + ke.getKeyChar();
                    bookmark.setTitleAt(tabIndex, tabTitle + "*");
                    saveFlag = false;
                    System.out.println("test");
                }
                    
                    else if(ke.isControlDown() && ke.getKeyCode() == KeyEvent.VK_S && !saveFlag)
                    {
                        bookmark.setTitleAt(tabIndex, tabTitle);
                        System.out.println("Saving!");
                        saveFlag = true;

                    }
                   
                }
                
                private boolean isThisAscii(char ch)
                {
                    for (int i = 0; i < 255; i++)
                        if(ch == i)
                            return true;
        
                    return false;
                }
                
                String beforeChangeInTextArea = "";
                
                int tabIndex = bookmark.getSelectedIndex();
                String tabTitle = bookmark.getTitleAt(tabIndex);
                boolean saveFlag = true;
                
            });
       });
       

       bookmark.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
       this.getContentPane().add(bookmark);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    
    private final JTabbedPane bookmark = new JTabbedPane();
    private JPanel createPanel = new JPanel();

    public static void main(String[] args) 
    {
        
        new Bookmarks().setVisible(true);

    }
    
}
