package demo.core;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class GridDrawer extends JFrame{

    JFrame frame;
    JComponent theCoords[] = new JComponent[7];
    
    public void go() {
        frame = new JFrame();  
        frame.setSize(400, 400);
        frame.setVisible(true);
        grid theGrid = new grid();
        frame.add(theGrid);
    }

    public class grid extends JPanel {
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
}