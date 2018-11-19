package demo.core;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.lang.Math.*;

public class Test {
 
    public static void main() {
        
        
        JFrame frame = new JFrame("test");
        frame.setSize(new Dimension(500, 500));

        
        SortArray array = new SortArray(20,frame.getWidth(), frame.getHeight());
        JScrollPane scrollPane = new JScrollPane(array);
        scrollPane.setViewportView(array);
        
        frame.getContentPane().add(scrollPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setVisible(true);
        
        SortAlgorithm algo = new SelectionSort();
        array.shuffle();
        algo.sort(array);
    }

}