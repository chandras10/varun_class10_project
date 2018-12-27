package OS;

import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import java.awt.Image;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.RenderingHints;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Test2{

    public void scaleImage() {

        ImageIcon icon = new ImageIcon((getClass().getResource("sort.jpg")));
        Image i = icon.getImage();
        Image newImage = i.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        JFrame frame = new JFrame();
        
        JButton b1 = new JButton(new ImageIcon(newImage));
        b1.setBorderPainted(false);
        b1.setBorder(null);
        
        frame.add(b1);
        frame.setSize(1000, 1000);
        frame.setVisible(true);

    }
    
    public static void main() {
        new Test2().scaleImage();
    }
}