package demo.core;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class SimpleGui{
    
    JFrame frame;
    SimpleGui2 gui2;
    JButton button;
    int array[] = new int[5];
    
    public static void main() {
        SimpleGui gui = new SimpleGui();
        gui.go();
    }
    
    public void go() {
        
        frame = new JFrame();
        button = new JButton("move the bars");
        
        
        for(int i = 1; i < array.length; i++) {
            array[i] = i * 10;
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui2 = new SimpleGui2();
        frame.getContentPane().add(BorderLayout.CENTER,gui2);
        frame.setSize(500, 500);
        frame.setVisible(true);
        
    }
    
    public class SimpleGui2 extends JPanel {
        
        public void paintComponent(Graphics g) {
            
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            g.setColor(Color.orange);
            int k = 0;
            int w = this.getHeight() - 10;
            
            for (int a = 0; a < array.length; a++) {
                g.fillRect(k, w - array[a], 50, array[a]);
                k += 55;
            }
            
            frame.repaint();
        }    
    }    
}