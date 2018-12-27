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

        JLabel label = new JLabel("@@@@");
        JOptionPane.showMessageDialog( label,  "Do you really want to exit?");
        JFrame frame = new JFrame();
        frame.setSize(1000, 1000);
        frame.setVisible(true);

    }
    
    public static void main() {
        new Test2().scaleImage();
    }
}