package demo.core;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rectangle extends JPanel {
    
    int numbers[] = {0, 1, 2, 3, 4, 5, 6};
    String alphabets[] = {"a", "b", "c", "d", "e", "f", "h"};
    
    public void paintComponent (Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.white);
        int gap = 0;
        int circleWidth = 30;
        int circleY = 10;
        int circleX = 20;
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