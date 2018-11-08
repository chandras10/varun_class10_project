package demo.core;
import javax.swing.*;
import java.awt.*;

public class ABC {
    
    public static void main() {
        ABC letters = new ABC();
        letters.go();
    }
    
    public void go() {
        JFrame frame = new JFrame();
        ImageDrawer imageDrawing = new ImageDrawer();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.getContentPane().add(imageDrawing);
        frame.setVisible(true);
        imageDrawing.setVisible(true);
    }
}