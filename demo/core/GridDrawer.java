package demo.core;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class GridDrawer extends JPanel{

    JFrame frame;
    int columns = 7;
    int rows = 7;
    
    boolean state[][] = new boolean[columns][rows];

    public void setUpGrid() {
        
        frame = new JFrame();  
        frame.setSize(400, 400);

        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                state[i][j] = false;
            }
        }

        frame.add(this);
        frame.setVisible(true);
    }

    public void setState(boolean theState, String theGuess) {
        
        char ch = theGuess.charAt(0);
        char num = theGuess.charAt(1);

        int c = (int)ch - 97;
        int n = (int)num - 48;

        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                state[c][n] = theState;
            }
        }
        
        this.repaint();
        
    }
    
    public void paintComponent (Graphics g) {
        
        g.setColor(Color.black);
        int width = this.getWidth();
        int height = this.getHeight();

        int gap = 0;
        int circleWidth = 30;
        int YGap = 0;

        int numbersX[] = {0, 1, 2, 3, 4, 5, 6};
        String alphabets[] = {"a", "b", "c", "d", "e", "f", "h"};

        g.fillRect(0, 0, width, height);
        g.setColor(Color.white);

        for (int j = 0; j < numbersX.length; j++) {

            for (int i = 0; i < numbersX.length; i++) {

                if (state[j][i] == false) {
                    g.setColor(Color.white);
                } else if (state[j][i] == true) {
                    g.setColor(Color.orange);
                }

                g.fillOval((numbersX[i] + 1 * 10) + gap, (((numbersX[j] + 1) * 10)) + YGap, circleWidth, 30);
                gap += 50;
            }

            g.drawString(alphabets[j], (numbersX[j] + 1 * 10) + gap, ((numbersX[j] + 1) * 10) + YGap + 20);
            YGap += 40;
            gap = 0;
        }

        for (int k = 0; k < numbersX.length; k ++) {
            gap += 50;
            g.drawString(Integer.toString(numbersX[k]),(numbersX[k] + 1 * 10) + gap - 40, YGap + 80);
        }
    }

}