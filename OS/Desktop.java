package OS;

import java.net.URL;    
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JToolBar;

public class Desktop implements ActionListener {

    JFrame frame;    

    String Calculator;
    String Sorter;
    String Cricket;
    String RockPaperScissors;
    String Clock;
    String Quiz;
    String BattleGame;

    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    JButton b5;
    JButton b6;
    JButton b7;

    Desktop(){    
        frame = new JFrame();

        Calculator = "Calculator";
        Sorter = "Sorter";
        Cricket = "Cricket";
        RockPaperScissors = "RPS";
        Clock = "Clock";
        Quiz = "Quiz";
        BattleGame = "Battle";

        // create the buttons

        b1=new JButton(new ImageIcon(getClass().getResource("calcul.png")));  
        b2=new JButton(new ImageIcon(getClass().getResource("sort.jpg")));
        b3=new JButton(new ImageIcon(getClass().getResource("cri.jpg")));
        b4=new JButton(new ImageIcon(getClass().getResource("rps.png")));
        b5=new JButton(new ImageIcon(getClass().getResource("watch.png")));
        b6=new JButton(new ImageIcon(getClass().getResource("quiz.png")));
        b7=new JButton(new ImageIcon(getClass().getResource("battleship.jpg")));

        // set the action commands
        b1.setActionCommand(Calculator);
        b2.setActionCommand(Sorter);
        b3.setActionCommand(Cricket);
        b4.setActionCommand(RockPaperScissors);
        b5.setActionCommand(Clock);
        b6.setActionCommand(Quiz);
        b7.setActionCommand(BattleGame);

        // add the action listener
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);

        // add the buttons to the frame

        frame.add(b1); 
        frame.add(b2);
        frame.add(b3);
        frame.add(b4);
        frame.add(b5); 
        frame.add(b6);
        frame.add(b7);

        frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });

        frame.setSize(10000,10000);    
        frame.setLayout(new GridLayout(2,3));    
        frame.setVisible(true);    
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    }

    public void actionPerformed(ActionEvent event) {

        System.out.println(event.getActionCommand());

        if (event.getActionCommand().equals(Calculator)) {
            //Calculator newCalculator = new Calculator();
            sortDemo("Cal");
            return;
        }
        if (event.getActionCommand().equals(Sorter)) {
            Sorter newSorter = new Sorter();
            return;
        }
        if (event.getActionCommand().equals(Cricket)) {
            Cricket newCricket = new Cricket();
            return;
        }
        if (event.getActionCommand().equals(RockPaperScissors)) {
            RockPaperScissors newRPS = new RockPaperScissors();
            return;
        }
        if (event.getActionCommand().equals(Clock)) {
            clock newClock = new clock();
            return;
        }
        if (event.getActionCommand().equals(Quiz)) {
            //Quiz newQuiz = new Quiz();
            sortDemo("Quiz");
            return;
        }
        if (event.getActionCommand().equals(BattleGame)) {
            //BattleGameLauncher newBattleGame = new BattleGameLauncher();
            sortDemo("BG");
        }

    }

    private void sortDemo(String name) {
        class SortTask implements Runnable {

            public void run() {

                if (name == "Cal") {
                    Calculator newCalculator = new Calculator();
                    newCalculator.main();
                }
                if (name == "BG") {
                    BattleGameLauncher newBattleGame = new BattleGameLauncher();
                    newBattleGame.main();
                }
            }
        }
        Thread t = new Thread(new SortTask());
        t.start();
    }

    public static void main() {    
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        new Desktop(); 
        do {
            try {
                Thread.sleep(50000);
            } catch (Exception e) {
            }
        }while(true);
    }
}    