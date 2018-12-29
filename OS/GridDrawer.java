package OS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class GridDrawer extends JPanel{

    JFrame frame;
    int columns = 7;
    int rows = 7;

    boolean state[][] = new boolean[columns][rows];

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public void setUpGrid() {

        frame = new JFrame();  
        // setting the frame size to fill the screen

        frame.setSize(screenSize.width, screenSize.height);

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
        int circleWidth = (width / 9) / 2;
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

                g.fillOval(width/100 + gap, height/100 + YGap, circleWidth, circleWidth);
                gap += width/7;
            }

            gap = (width/7) * 6;

            g.drawString(alphabets[j], (width/100) + gap + (circleWidth*2), height/100 + YGap + (circleWidth/2));
            YGap += (height/7);
            gap = 0;
        }

        for (int k = 0; k < numbersX.length; k ++) {
            gap += width/7;
            g.drawString(Integer.toString(numbersX[k]),(int)(width/100 + gap - (circleWidth*2.15)), height/100 + YGap - circleWidth/5);
        }
    }

}