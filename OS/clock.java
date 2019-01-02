package OS;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.text.*;
class clock implements Runnable
{
    Thread t=null;
    int hrs=0,min=0,sec=0;
    String timeString="null";
    JLabel label;
    clock()
    {
        t=new Thread(this);
        t.start();
        label=new JLabel();
    }

    public void run()
    {
        try{
            while(true)
            {
                Calendar cal=Calendar.getInstance();
                hrs=cal.get(Calendar.HOUR_OF_DAY);
                if(hrs>12)
                {
                    hrs-=12;
                }
                min=cal.get(Calendar.MINUTE);
                sec=cal.get(Calendar.SECOND);
                SimpleDateFormat formatter=new SimpleDateFormat("hh:mm:ss");
                Date date=cal.getTime();
                timeString=formatter.format(date);
                display();
                t.sleep(1000);
            }
        }
        catch(Exception e){}
    }

    public void display()
    {
        label.setText(timeString + "   ");
    }
}

