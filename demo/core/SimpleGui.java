package demo.core;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class SimpleGui{
    
    JFrame frame;
    JLabel label;
    
    public static void main() {
        SimpleGui gui = new SimpleGui();
        gui.go();
    }
    
    public void actionPerformed(ActionEvent event) {
        frame.repaint();
    }
    
    public void go() {
        
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton colorButton = new JButton("change colours");
        JButton labelButton = new JButton("change label");
        label = new JLabel("I'm a label");
        SimpleGui2 gui2 = new SimpleGui2();
        colorButton.addActionListener(new ColorListener());
        labelButton.addActionListener(new LabelListener());
        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.CENTER,gui2);
        frame.getContentPane().add(BorderLayout.WEST,label);
        frame.setSize(500, 500);
        frame.setVisible(true);
        
    }
    
    class LabelListener implements ActionListener {
        
        public void actionPerformed(ActionEvent event) {
            label.setText("I've been clicked");
        }
        
    }
    
    class ColorListener implements ActionListener {
        
        public void actionPerformed(ActionEvent event) {
            frame.repaint();
        }
        
    }
}