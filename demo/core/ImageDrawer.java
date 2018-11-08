package demo.core;
import javax.swing.*;
import java.awt.*;

public class ImageDrawer extends JPanel {
    
    public void paintComponent(Graphics g) {
        Image image = new ImageIcon("myPic.jpg").getImage();
        g.drawImage(image, 3, 4, this);
    }
    
}