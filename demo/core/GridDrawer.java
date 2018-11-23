package demo.core;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GridDrawer extends JFrame{

    JFrame frame;

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
            int circleY = 10;
            int circleX = 20;

            int numbers[] = {0, 1, 2, 3, 4, 5, 6};
            String alphabets[] = {"a", "b", "c", "d", "e", "f", "h"};

            g.fillRect(0, 0, width, height);
            g.setColor(Color.white);
            for (int j = 0; j < 7; j++) {
                for (int i = 0; i < 7; i++) {
                    g.fillOval(circleX + gap, circleY, circleWidth, 30);
                    gap += 50;
                }

                g.drawString(alphabets[j], circleX + gap, circleY + 20);
                circleY += 50;
                circleX = 20;
                gap = 0;
            }

            for (int k = 0; k < numbers.length; k ++) {
                gap += 50;
                g.drawString(Integer.toString(numbers[k]), circleX + gap - 40, circleY);
            }
        }

    }
}