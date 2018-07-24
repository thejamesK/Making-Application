package przeszukiwacztekstu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Shabbadoo
 */
public class Main extends JFrame
{
    public Main()
    {
        initComponents();
    }
    
    public void initComponents()
    {
        this.setTitle("Text Search");
        this.setBounds(300, 300, 600, 200);
        
        searchPanel.add(find);
        searchPanel.add(searched);
        searchPanel.add(labelAnd);
        searchPanel.add(change);
        searchPanel.add(labelFor);
        searchPanel.add(newText);  
        
        
        //textArea.selectAll(); // zaznacza caly tekst
        //textArea.select(0, 2); // zaznacza obszar podany od kad do kad
        //textArea.replaceSelection("lala "); // zamienia obszar ktory jest aktualnie zaznaczony
        //textArea.replaceRange("lala ", 0, 5); // podmieniamy na dany string w danym miejscu
        //textArea.insert("Something ", 18);
        //textArea.append("added to end");
        //textArea.select(textArea.getText().indexOf("test"), textArea.getText().indexOf("test")+"test".length());

        find.addActionListener(new findHandler());
        change.addActionListener(new changeHandler());
        this.getContentPane().add(scrollArea, BorderLayout.NORTH);
        this.getContentPane().add(searchPanel, BorderLayout.CENTER);
                
        this.setDefaultCloseOperation(3);
    }
        private class findHandler implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) 
        {
            searchBeginning = textArea.getText().indexOf(searched.getText(), searchBeginning + searched.getText().length());
            
            System.out.println(searchBeginning);
            if(searchBeginning == -1)
            {
                searchBeginning = textArea.getText().indexOf(searched.getText());
            }
            
            
            if(searchBeginning >= 0 && searched.getText().length() > 0)
            {
                textArea.requestFocus();
                textArea.select(searchBeginning, searchBeginning + searched.getText().length());
            }
        }
        private int searchBeginning = 0;
        
    }
    private class changeHandler implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) 
        {
            if(textArea.getSelectionStart() != textArea.getSelectionEnd())
            {
                changeText();
            }
            else
            {
                find.doClick(0);
                if(textArea.getSelectionStart() != textArea.getSelectionEnd())
                    changeText();
            }
            
        }
        
        private void changeText()
        {
            textArea.requestFocus();
            int option = JOptionPane.showConfirmDialog(rootPane, "Do you want to change \"" + searched.getText() + "\" for \"" + newText.getText() + "\"", "Warning! There will be change!", JOptionPane.YES_NO_OPTION);
            if(option == 0)
            textArea.replaceRange(newText.getText(), textArea.getSelectionStart(), textArea.getSelectionEnd());
        }
        
        
    }
    private JTextArea textArea = new JTextArea("This is test text! This is test text! This is test text! This is test text!", 7, 10);
    private JScrollPane scrollArea = new JScrollPane(textArea);
    
    private JPanel searchPanel = new JPanel();
    private JButton find = new JButton("Find");
    private JLabel labelAnd = new JLabel("and");
    private JButton change = new JButton("Change");
    private JLabel labelFor = new JLabel("for");
    
    private JTextField searched = new JTextField(4);
    private JTextField newText = new JTextField(4);

    public static void main(String[] args) 
    {
        new Main().setVisible(true);
    }
    
}
