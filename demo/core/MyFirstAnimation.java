package demo.core;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;

public class MyFirstAnimation{
    
    int x = 20;
    int y = 20;
    JFrame frame;
    CircleDrawer circleDrawing;
    
    public static void main() {
        MyFirstAnimation animation = new MyFirstAnimation();
        animation.go();
    }
    
    public void go() {
        frame = new JFrame();
        circleDrawing = new CircleDrawer();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.getContentPane().add(circleDrawing);
        frame.setVisible(true);
    }
    
    public class CircleDrawer extends JPanel{
        
        public void paintComponent(Graphics g) {
            
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            g.setColor(Color.green);
            
            for(int i = 0; i < 10; i++) {
                
                x += 1;
                y += 1;
                g.fillOval(x, y, 100, 100);
                circleDrawing.paint();
                
            }
            
        }
        
        public void paint() {
                            
            try {
                Thread.sleep(5);
            }catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }
            
            frame.repaint();
        }
    }
}