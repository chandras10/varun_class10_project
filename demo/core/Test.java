package demo.core;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.lang.Math.*;

public class Test {
 
    public static void main() {
        SortArray array = new SortArray(100);
        
        JFrame frame = new JFrame("test");
        JScrollPane scrollPane = new JScrollPane(array);
        scrollPane.setViewportView(array);
        scrollPane.setSize(100,100);
        
        frame.setPreferredSize(new Dimension(array.length() * 2, 300));
        array.setPreferredSize(new Dimension(200, 200));
        
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setSize(new Dimension(500, 500));
        array.swap(2, 7);
        
        frame.setVisible(true);
    }

}