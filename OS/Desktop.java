package OS;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JToolBar;

public class Desktop {
    Desktop(){    
        JFrame f=new JFrame("OS");
        JToolBar toolbar=new JToolBar(JToolBar.TOP);
        toolbar.setRollover(false);  
        JButton button = new JButton("File");  
        toolbar.add(button);  
        toolbar.addSeparator();  
        toolbar.add(new JButton("Edit"));
        Container contentPane = f.getContentPane();
        contentPane.add(toolbar);

        JButton b=new JButton("Calculator",new ImageIcon(getClass().getResource("calcul.png")));  
        JButton b1=new JButton("Sorter", new ImageIcon(getClass().getResource("sort.jpg")));
        JButton b2=new JButton("Cricket",new ImageIcon(getClass().getResource("cri.jpg")));
        JButton b3=new JButton("Rock Paper Scissors", new ImageIcon(getClass().getResource("rps.png")));
        JButton b4=new JButton("Clock",new ImageIcon(getClass().getResource("watch.png")));
        JButton b5=new JButton("Quiz",new ImageIcon(getClass().getResource("quiz.png")));
        JButton b6=new JButton("Battle Game",new ImageIcon(getClass().getResource("battleship.jpg")));
        f.add(b); 
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);
        f.add(b6);
        f.setSize(10000,10000);    
        f.setLayout(new GridLayout(2,3));    
        f.setVisible(true);    
        //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   

        //action listener
        b.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent arg0) {
                    Calculator.main();		
                }          
            });

        b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    Sorter.main();
                }
            });
        b2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    Cricket.main();
                }
            });
        b3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    RockPaperScissors.main();
                }
            });
        b4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0){
                    clock.main();
                }
            });
        b5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0){
                    Quiz.main();
                }
            });
        b6.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0){
                    BattleGameLauncher.main();
                }
            });

    }

    public static void main() {    
        new Desktop();    
    }    
}