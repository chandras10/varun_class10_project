package demo.core;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class SimpleGui{
    
    JFrame frame;
    int array[] = new int[6];
    
    public static void main() {
        SimpleGui gui = new SimpleGui();
        gui.go();
    }
    
    public void go() {
        
        frame = new JFrame();
        
        for(int i = 0; i < array.length; i++) {
            array[i] = i * 10;
        }
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SimpleGui2 gui2 = new SimpleGui2();
        frame.getContentPane().add(BorderLayout.CENTER,gui2);
        frame.setSize(500, 500);
        frame.setVisible(true);
        
    }
    
    public class SimpleGui2 extends JPanel {
        
        public void paintComponent(Graphics g) {
            
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            g.setColor(Color.orange);
            int k = 0;
            
            for (int a = 0; a < array.length; a++) {
                g.fillRect(k, 300, 50, array[a]);
                k += 55;
                frame.repaint();
            }
        }
        
    }
}