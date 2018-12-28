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

        try {
            JFrame message = new JFrame();
            JLabel goodbye_Message = new JLabel();
            goodbye_Message.setText("Goodbye...");
            //goodbye_Message.setForeground(Color.green);
            message.add(goodbye_Message, BorderLayout.CENTER);
            message.setSize(200, 100);
            message.setAlwaysOnTop(true);
            message.setVisible(true);
            Thread.sleep(1000);
            System.exit(0);
        } catch (Exception e) {
        }

    }

    public static void main() {
        new Test2().scaleImage();
    }
}