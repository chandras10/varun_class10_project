package demo.core;
import javax.swing.*;
import java.awt.*;

public class ImageDrawer extends JPanel {
    
    public void paintComponent(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g;
        GradientPaint gradient = new GradientPaint(70, 70, Color.blue, 150, 150, Color.orange);
        
        //g.fillRect(0, 0, this.getWidth(), this.getHeight());
        
        //int red = (int) (Math.random() * 255);
        //int blue = (int) (Math.random() * 255);
        //int green = (int) (Math.random() * 255);
        
        //Color randomColor = new Color(red, green, blue);
        g2d.setPaint(gradient);
        g2d.fillOval(70, 70, 100, 100);
    }
    
}