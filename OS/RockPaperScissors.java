import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.border.*;
import javax.*;
class RockPaperScissors extends JFrame 
{
   
    static RockPaperScissors call;
    

    static int count;
    static String r;

    static GUI obj = new GUI();

    static RockPaperScissors comp = new RockPaperScissors();
    static RockPaperScissors player = new RockPaperScissors();
    int score;

    public static void random()
    {
        int rr = (int)((Math.random()*(3-1)+1));

        if(rr == 1)
            r = "ROCK";
        else if(rr == 2)
            r= "PAPER";
        else if(rr == 3)
            r = "SCISSORS";
    }

   

    public static  void main()
    {
        call = new RockPaperScissors();
       

        call.random();
        obj.button();

    }

    
}