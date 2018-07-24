package sliders;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Shabbadoo
 */
public class Sliders extends JFrame
{
    public Sliders()
    {
        initComponents();
    }
    
    public void initComponents()
    {
        this.setTitle("Sliders");
        this.setBounds(300, 300, 500, 200);
        sliderValue.setEditable(false);
        
        slider.setMajorTickSpacing(5);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setSnapToTicks(true);

        slider.addChangeListener(new ChangeListener() 
        {
            @Override
            public void stateChanged(ChangeEvent ce) 
            {
                sliderValue.setText("" + ((JSlider)ce.getSource()).getValue());
                
                text.setFont(new Font(text.getFont().getFontName(), text.getFont().getStyle(), ((JSlider)ce.getSource()).getValue()));
           }
            
        });
        
        this.getContentPane().add(slider, BorderLayout.NORTH);
        this.getContentPane().add(text, BorderLayout.CENTER);
        this.getContentPane().add(sliderValue, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 30, 5);
    JTextField sliderValue = new JTextField("" + slider.getValue());
    JLabel text = new JLabel("Something");

    public static void main(String[] args) 
    {
        new Sliders().setVisible(true);

    }
    
}
