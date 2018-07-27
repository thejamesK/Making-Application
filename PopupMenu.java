package contextmenu;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ContextMenu extends JFrame
{
    public ContextMenu()
    {
        initComponents();
    }
    
    public void initComponents()
    {
        this.setTitle("Context Menu");
        this.setBounds(300, 300, 500, 200);
        
        JPopupMenu popupMenu = new JPopupMenu();
        
        popupMenu.add(new JMenuItem (new AbstractAction("Close") 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                System.exit(0);
            }
        }));
        popupMenu.add(new JMenuItem ("Copy"));
        popupMenu.add(new JMenuItem ("Paste"));
        
        
        
        this.getContentPane().addMouseListener(new MouseAdapter() 
        {
            
            
            
            @Override
            public void mouseReleased(MouseEvent me) {
                 System.out.println("Relased");
                 
                 if(me.getClickCount() == 3 && me.getButton() == MouseEvent.BUTTON1 && me.isShiftDown())
                     JOptionPane.showMessageDialog(rootPane, "You made some clicks! on left mouse key");
                 
//                 if(me.getButton() == MouseEvent.BUTTON3)
                    if(me.isPopupTrigger())
                     popupMenu.show(me.getComponent(), me.getX(), me.getY());
            }
            
        });
//            @Override
//            public void mouseClicked(MouseEvent me) {
//                System.out.println("Click");
//            }
//
//            @Override
//            public void mousePressed(MouseEvent me) {
//                 System.out.println("Pressed");
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent me) {
//                 System.out.println("Relased");
//                 
//                 if(me.getClickCount() == 3 && me.getButton() == MouseEvent.BUTTON1 && me.isShiftDown())
//                     JOptionPane.showMessageDialog(rootPane, "You made some clicks! on left mouse key");
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent me) {
//                 System.out.println("Im In");
//            }
//
//            @Override
//            public void mouseExited(MouseEvent me) {
//                 System.out.println("Im Out");
//            }
//        });
//        
        
        this.getContentPane().add(test, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
    
    private JButton test = new JButton("Test");
    public static void main(String[] args) 
    {
        new ContextMenu().setVisible(true);
    }
    
}
