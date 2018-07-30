package spinner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Date;


public class Spinner extends JFrame
{
    public Spinner()
    {
        initComponents();
    }
    
    public void initComponents()
    {
        this.setTitle("Spinners");
        this.setBounds(300, 300, 500, 200);
        
        String [] months = new DateFormatSymbols().getMonths();
        
        System.out.println(months.length);
//        for(int i = 0; i < months.length; i++)
//            System.out.println(months[i]);
        

        MySpinnerListModel monthsModel = new MySpinnerListModel(cutArray(months,0 , 11));
        
        JSpinner spinner = new JSpinner(monthsModel);
//        spinner.setEditor(new JTextArea("lalal"));
        SpinnerNumberModel numberModel = new SpinnerNumberModel(1, 1, 5, 1);
        
        
        
        JSpinner spinner2 = new JSpinner(numberModel);
        
        Calendar calendar = Calendar.getInstance();
        
        Date startValue = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, -20);
        Date minimumValue = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, 40);
        Date maximumValue = calendar.getTime();
        
        
        SpinnerDateModel dateModel = new SpinnerDateModel(startValue, minimumValue, maximumValue, Calendar.DAY_OF_MONTH);
        
        
        JSpinner spinner3 = new JSpinner(dateModel);
                        
        JPanel panel = new JPanel();
        panel.add(spinner);
        panel.add(spinner2);
        panel.add(spinner3);
        
        this.getContentPane().add(panel, BorderLayout.NORTH);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private class MySpinnerListModel extends SpinnerListModel
    {
        public MySpinnerListModel(Object[] values)
        {
            super(values);
            firstValue = values[0];
            lastValue = values[values.length - 1];
        }
        @Override
        public Object getNextValue()
        {
            if(super.getNextValue() == null)
            {
                return firstValue;
            }
            else
            return super.getNextValue();
        }
        @Override
        public Object getPreviousValue()
        {
            if(super.getPreviousValue() == null)
            {
                return lastValue;
            }
            else
            return super.getPreviousValue();
        }
        Object firstValue, lastValue;
    }
    /**
     * Cut tab from <code>start</code> to <code>end</code>
     * @param operated tab which will be cut
     * @param start index where to start
     * @param end index where to end
     * @return operated tab (tmp)
     */
    private Object[] cutArray(Object[] operated, int start, int end)
    {
        end = end > operated.length - 1 || end < 0 ? operated.length - 1 : end;
        start = start < 0 || start > end ? 0 : start;
        
        Object[] tmp = new Object[end + 1 - start];
        for(int i = start, j = 0; i < end + 1; i++, j++)
        {
            tmp[j] = operated[i];
        }
        
        return tmp;
    }
    public static void main(String[] args) 
    {
        
        new Spinner().setVisible(true);
        

    }
    
}
