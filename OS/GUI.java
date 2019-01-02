package OS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class GUI extends JFrame 
{
    private JButton button1 = new JButton("ROCK");
    private JButton button2 = new JButton("PAPER");
    private JButton button3 = new JButton("SCISSORS");

    JFrame frame = new JFrame();
    static RockPaperScissors call;
    private static final int FRAME_X = 150;
    private static final int FRAME_Y = 100;

    static RockPaperScissors call1 = new RockPaperScissors();

    
    JLabel noTimes = new JLabel("MATCHES: 0");

    JLabel PlayerScore = new JLabel("   YOUR SCORE: 0");
    JLabel end = new JLabel("");
    JLabel CompScore = new JLabel("COMP SCORE: 0");
    JLabel beg = new JLabel ("HELLO! THIS WILL BE A BEST OF 10 MATCHES.");
    JLabel Comp = new JLabel("        COMP:");
    JLabel Player = new JLabel("      YOU:");

    public GUI()
    {
        //frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);    

        frame.setTitle("Rock Paper Scissors");

        frame.setLayout(new FlowLayout(3,10,10));

        frame.setLocation(FRAME_X,FRAME_Y);
        frame.add(beg);
        frame.add(noTimes);
        frame.add(PlayerScore);
        frame.add(CompScore);
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(Player);
        frame.add(Comp);
        frame.add(end);

        frame.setResizable(false);

        frame.setSize(340,190);
        frame.setVisible(true);

    }
    public void button()
    {

        button1.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e)
                {
                    if (call1.r.equals("PAPER"))
                        call1.comp.score++;

                    if(call1.r.equals("SCISSORS"))
                        call1.player.score++;

                    beg.setText("");
                    noTimes.setText("MATCHES: "+(++call1.count));    
                    PlayerScore.setText("   YOUR SCORE: "+call1.player.score);
                    CompScore.setText("     COMP SCORE: "+call1.comp.score);
                    Player.setText("      YOU: ROCK");
                    Comp.setText("        COMP: "+call1.r);
                    if(call1.count == 10)
                    {
                        button1.setEnabled(false);
                        button2.setEnabled(false);
                        button3.setEnabled(false);

                        if(call1.player.score>call1.comp.score)
                            end.setText("AND THE WINNER IS...YOU!!!!");

                        else if(call1.comp.score > call1.player.score)
                            end.setText("AND THE WINNER ...IS NOT YOU!!!MUHAHAHA");

                        else if(call1.comp.score == call1.player.score)
                            end.setText("DRAW!!!!");
                    }
                    call1.random();

                }
            });
        button2.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e)
                {
                    if(call1.r.equals("ROCK"))
                        call1.player.score++;

                    if(call1.r.equals("SCISSORS"))
                        call1.comp.score++;

                    beg.setText("");
                    noTimes.setText("MATCHES: "+(++call1.count));
                    PlayerScore.setText("   YOUR SCORE: "+call1.player.score);
                    CompScore.setText("     COMP SCORE: "+call1.comp.score);
                    Player.setText("      YOU: PAPER");
                    Comp.setText("        COMP:"+call1.r);
                    if(call1.count == 10)
                    {
                        button1.setEnabled(false);
                        button2.setEnabled(false);
                        button3.setEnabled(false);

                        if(call1.player.score>call1.comp.score)
                            end.setText("AND THE WINNER IS...YOU!!!!");

                        else if(call1.comp.score > call1.player.score)
                            end.setText("AND THE WINNER...IS NOT YOU!!MUHAHAHA");

                        else if(call1.comp.score == call1.player.score)
                            end.setText("DRAW!!!!");
                    }
                    call1.random();
                }
            });
        button3.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    if(call1.r.equals("PAPER"))
                        call1.player.score++;

                    if(call1.r.equals("ROCK"))
                        call1.comp.score++;

                    beg.setText("");
                    noTimes.setText("MATCHES: "+(++call1.count));
                    PlayerScore.setText("   YOUR SCORE: "+call1.player.score);
                    CompScore.setText("     COMP SCORE: "+call1.comp.score);
                    Player.setText("      YOU: SCISSORS");
                    Comp.setText("        COMP:"+call1.r);
                    if(call1.count == 10)
                    {
                        button1.setEnabled(false);
                        button2.setEnabled(false);
                        button3.setEnabled(false);

                        if(call1.player.score>call1.comp.score)
                            end.setText("AND THE WINNER IS...YOU!!!!");

                        else if(call1.comp.score > call1.player.score)
                            end.setText("AND THE WINNER...IS NOT YOU!!!MUHAHAHA");

                        else if(call1.comp.score == call1.player.score)
                            end.setText("DRAW!!!!");
                    }

                    call1.random();
                }
            });

    }

}