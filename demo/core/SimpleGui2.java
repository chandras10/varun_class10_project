package demo.core;
import javax.swing.*;
import java.awt.*;

public class SimpleGui2 extends JPanel {
    
    public void paintComponent(Graphics g) {
        
        //g.setColor(Color.green);
        //g.fillRect(20, 50, 100, 100);
        //g.fillOval(20, 50, 200, 200);
        Image image = new ImageIcon("myPic.jpg").getImage();
        g.drawImage(image,10, 10,this);
    }
    
}