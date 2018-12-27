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
import javax.swing.JOptionPane;

public class Desktop implements ActionListener {

    // instance variables

    JFrame frame;    
    JPanel desktopPanel;
    JPanel taskbarPanel;

    String Calculator;
    String Sorter;
    String Cricket;
    String RockPaperScissors;
    String Clock;
    String Quiz;
    String BattleGame;
    String exit;

    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    JButton b5;
    JButton b6;
    JButton b7;

    JButton shutDownButton;

    Desktop(){    

        frame = new JFrame();
        desktopPanel = new JPanel();
        taskbarPanel = new JPanel();

        Calculator = "Calculator";
        Sorter = "Sorter";
        Cricket = "Cricket";
        RockPaperScissors = "RPS";
        Clock = "Clock";
        Quiz = "Quiz";
        BattleGame = "Battle";
        exit = "SHUT DOWN";

        // setting the frame size to fill the screen

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(screenSize.width, screenSize.height);

        // Resizing the images

        ImageIcon icon1 = new ImageIcon((getClass().getResource("calcul.png"))); // the icon of calculator
        Image cal_Image = icon1.getImage();
        Image calculator_Image = cal_Image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);

        ImageIcon icon2 = new ImageIcon((getClass().getResource("sort.jpg"))); // the icon of sorter
        Image s_Image = icon2.getImage();
        Image sort_Image = s_Image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);

        ImageIcon icon3 = new ImageIcon((getClass().getResource("cri.jpg"))); // the icon of cricket
        Image cri_Image = icon3.getImage();
        Image cricket_Image = cri_Image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);

        ImageIcon icon4 = new ImageIcon((getClass().getResource("rps.png"))); // the icon of rock, paper, scissors
        Image rps_Image = icon4.getImage();
        Image RPS_Image = rps_Image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);

        ImageIcon icon5 = new ImageIcon((getClass().getResource("watch.png"))); // the icon of watch
        Image cl_Image = icon5.getImage();
        Image clock_Image = cl_Image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);

        ImageIcon icon6 = new ImageIcon((getClass().getResource("quiz.png"))); // the icon of quiz
        Image q_Image = icon6.getImage();
        Image quiz_Image = q_Image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);

        ImageIcon icon7 = new ImageIcon((getClass().getResource("battleship.jpg"))); // the icon of battleship game
        Image b_Image = icon7.getImage();
        Image BattleShip_Image = b_Image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);

        ImageIcon wallpaper = new ImageIcon((getClass().getResource("background.jpg"))); // the icon of wallpaper
        Image wp = wallpaper.getImage();
        Image WallPaper = wp.getScaledInstance(screenSize.width, screenSize.height, Image.SCALE_SMOOTH);

        // create the buttons

        b1=new JButton(new ImageIcon(calculator_Image));  
        b2=new JButton(new ImageIcon(sort_Image));
        b3=new JButton(new ImageIcon(cricket_Image));
        b4=new JButton(new ImageIcon(RPS_Image));
        b5=new JButton(new ImageIcon(clock_Image));
        b6=new JButton(new ImageIcon(quiz_Image));
        b7=new JButton(new ImageIcon(BattleShip_Image));

        shutDownButton = new JButton(exit);

        //make only the icons visible

        b1.setBorderPainted(false);
        b1.setBorder(null);

        b2.setBorderPainted(false);
        b2.setBorder(null);

        b3.setBorderPainted(false);
        b3.setBorder(null);

        b4.setBorderPainted(false);
        b4.setBorder(null);

        b5.setBorderPainted(false);
        b5.setBorder(null);

        b6.setBorderPainted(false);
        b6.setBorder(null);

        b7.setBorderPainted(false);
        b7.setBorder(null);

        shutDownButton.setBackground(Color.GRAY);
        shutDownButton.setForeground(Color.BLACK);

        // set the action commands

        b1.setActionCommand(Calculator);
        b2.setActionCommand(Sorter);
        b3.setActionCommand(Cricket);
        b4.setActionCommand(RockPaperScissors);
        b5.setActionCommand(Clock);
        b6.setActionCommand(Quiz);
        b7.setActionCommand(BattleGame);

        shutDownButton.setActionCommand(exit);

        // add the action listener

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);

        shutDownButton.addActionListener(this);
        // add the wallpaper to the desktop
        JLabel desktop_Wallpaper = new JLabel(new ImageIcon(WallPaper));
        desktopPanel.setBackground(Color.black);

        // add the buttons to the Panel

        GridBagLayout gridbag = new GridBagLayout();

        desktopPanel.setLayout(gridbag);

        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.NONE;     
        c.gridwidth = GridBagConstraints.CENTER;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.insets = new Insets(20, 20, 20, 20);
        c.weightx = 0.001;
        desktopPanel.add(b1, c);

        c.fill = GridBagConstraints.NONE;
        c.gridwidth = GridBagConstraints.RELATIVE;
        c.weightx = 0.0;
        desktopPanel.add(b2, c);

        c.fill = GridBagConstraints.NONE;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.weightx = 0.1;
        c.weighty = 0.1;
        desktopPanel.add(b2, c);

        c.fill = GridBagConstraints.NONE;  
        c.gridwidth = GridBagConstraints.RELATIVE;
        c.weightx = 0.0;
        desktopPanel.add(b3, c);

        c.fill = GridBagConstraints.NONE;     
        c.gridwidth = GridBagConstraints.RELATIVE;
        desktopPanel.add(b4, c);

        c.fill = GridBagConstraints.NONE;     
        c.gridwidth = GridBagConstraints.REMAINDER;
        desktopPanel.add(b5, c); 

        c.fill = GridBagConstraints.NONE;
        c.gridwidth = GridBagConstraints.RELATIVE;
        desktopPanel.add(b6, c);

        c.fill = GridBagConstraints.NONE; 
        c.gridwidth = GridBagConstraints.RELATIVE;
        desktopPanel.add(b7, c);

        taskbarPanel.setLayout(new GridLayout(0, 8));

        taskbarPanel.add(shutDownButton);
        // put everything together
        //frame.setLayout(new GridLayout(2,1)); 
        frame.getContentPane().add(desktopPanel, BorderLayout.CENTER);
        frame.getContentPane().add(taskbarPanel, BorderLayout.SOUTH);

        frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });

        frame.setVisible(true);    
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    }

    public void actionPerformed(ActionEvent event) {

        if (event.getActionCommand().equals(Calculator)) {
            setTasks("Cal");
            return;
        }
        if (event.getActionCommand().equals(Sorter)) {
            setTasks("sorter");
            Sorter newSorter = new Sorter();
            return;
        }
        if (event.getActionCommand().equals(Cricket)) {
            setTasks("cricket");
            Cricket newCricket = new Cricket();
            return;
        }
        if (event.getActionCommand().equals(RockPaperScissors)) {
            setTasks("rps");
            RockPaperScissors newRPS = new RockPaperScissors();
            return;
        }
        if (event.getActionCommand().equals(Clock)) {
            setTasks("clock");
            clock newClock = new clock();
            return;
        }
        if (event.getActionCommand().equals(Quiz)) {
            setTasks("Quiz");
            return;
        }
        if (event.getActionCommand().equals(BattleGame)) {
            setTasks("BG");
            return;
        }
        if(event.getActionCommand().equals(exit)) {
            int reply = JOptionPane.showConfirmDialog(null, "Do You Really Want To Exit???", null, JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
            else {
                return;
            }
        }

    }

    private void setTasks(String name) {
        class ButtonTask implements Runnable {

            public void run() {

                if (name.equals("Cal")) {
                    Calculator newCal = new Calculator();
                    newCal.setVisible(true);
                    return;
                }
                if (name.equals("sorter")) {
                    Sorter newSort = new Sorter();
                    newSort.createAndShowGUI();
                    return;
                }
                if (name.equals("cricket")) {
                    Cricket newCricket = new Cricket();
                    newCricket.startPlaying();
                    return;
                }
                if (name.equals("rps")) {
                    RockPaperScissors newRPS = new RockPaperScissors();
                    newRPS.random();
                    newRPS.obj.button();
                    return;
                }
                if (name.equals("rps")) {
                    clock newClock = new clock();
                    return;
                }
                if (name.equals("Quiz")) {
                    Quiz newQuiz = new Quiz();
                    newQuiz.startQuiz();
                    return;
                }
                if (name.equals("BG")) {
                    BattleGameLauncher newBattleGame = new BattleGameLauncher();
                    newBattleGame.setUpGame();
                    return;
                }
            }// end run
        }// end ButtonTask
        Thread t = new Thread(new ButtonTask());
        t.start();
    }

    public static void main() {    
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        new Desktop(); 
        do {                    // This makes sure the program is running, so as to allow individual applications to 
            try {               // take input from the useer
                Thread.sleep(50000);
            } catch (Exception e) {
            }
        }while(true);
    } //end main

}   // end class 