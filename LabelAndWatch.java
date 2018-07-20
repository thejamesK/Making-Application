package etykiety;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class Main extends JFrame
{
    
    public Main()
    {
        super("Watch");
        setBounds(300, 300, 300, 200);
        
        initComponents();
        
        this.setDefaultCloseOperation(3);
    }
    
    public void initComponents()
    {
//        panel.add(label);
        panel.add(time);
        
        ActionListener stopWatch = new Watch();
        
        Timer watch = new Timer(1000, stopWatch);
        
        watch.start();
        
        this.getContentPane().add(panel);
        this.pack();
        
    }
    
    JPanel panel = new JPanel();
    JLabel label = new JLabel("Time: ");
    JLabel time = new JLabel(getTime());

    private class Watch implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) 
        {       
            time.setText(getTime());
        }
        
    }
    
    public String getTime()
    {
        GregorianCalendar calendar = new GregorianCalendar();
            
            String hour = "" + calendar.get(Calendar.HOUR_OF_DAY);
            String minute = "" + calendar.get(Calendar.MINUTE);
            String second = "" + calendar.get(Calendar.SECOND);
            
            if(Integer.parseInt(hour) < 10)
                hour = "0" + hour;
            if(Integer.parseInt(minute) < 10)
                minute = "0" + minute;
            if(Integer.parseInt(second) < 10)
                second = "0" + second;
            
        return ""+ hour + ":" + minute + ":" + second;
    }
    
    public static void main(String[] args) 
    {
        new Main().setVisible(true);
        
    }
    
}
