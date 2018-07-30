package insideframes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;


public class InsideFrames extends JFrame
{
    public InsideFrames()
    {
        initComponents();
    }
    
    public void initComponents()
    {
        this.setTitle("Inside Frames");
        this.setBounds(300, 300, 500, 200);
        
        JInternalFrame internalFrame = new JInternalFrame("Frame Title", true, true, true, true);
        
        internalFrame.add(new JButton("Test"), BorderLayout.NORTH);
        internalFrame.setVisible(true);
        internalFrame.pack();
        //internalFrame.setFrameIcon(new ImageIcon("icon.jpg");
        
        JInternalFrame internalFrame2 = new JInternalFrame("Frame Title", true, true, true, true);
        
        internalFrame2.add(new JLabel("Another Test"), BorderLayout.NORTH);
        internalFrame2.setVisible(true);
        internalFrame2.pack();
        
        internalFrame.setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE);
       
        
        internalFrame.addInternalFrameListener(new InternalFrameListener() {
            @Override
            public void internalFrameOpened(InternalFrameEvent ife) {
                System.out.println("Opened");
            }

            @Override
            public void internalFrameClosing(InternalFrameEvent ife) {
                String answer = JOptionPane.showInternalInputDialog(ife.getInternalFrame(), "Type 'Exit' to close program or 'Close' to close frame");
                
                if(answer != null)
                    if(answer.equals("Exit"))
                        System.exit(0);
                    else if (answer.equals("Close"))
                        ife.getInternalFrame().dispose();
            }

            @Override
            public void internalFrameClosed(InternalFrameEvent ife) {
                System.out.println("Closed");
            }

            @Override
            public void internalFrameIconified(InternalFrameEvent ife) {
                System.out.println("Minimalized");
            }

            @Override
            public void internalFrameDeiconified(InternalFrameEvent ife) {
                System.out.println("Maximalized");
            }

            @Override
            public void internalFrameActivated(InternalFrameEvent ife) {
                System.out.println("Activated");
            }

            @Override
            public void internalFrameDeactivated(InternalFrameEvent ife) {
                System.out.println("Deactivated");
            }
        });
        
        
        desktopPane.add(internalFrame);
        desktopPane.add(internalFrame2);
        
        this.getContentPane().add(desktopPane, BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JDesktopPane desktopPane = new JDesktopPane();
    public static void main(String[] args) 
    {
        new InsideFrames().setVisible(true);
    }
    
}
