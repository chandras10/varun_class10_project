package demo.core;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class SimpleGui extends JPanel implements ActionListener {
    
    JButton button;
    JFrame frame;
    
    public static void main() {
        SimpleGui gui = new SimpleGui();
        gui.go();
    }
    
    public void actionPerformed(ActionEvent event) {
        
        button.setVisible(false);
        
    }
    
    public void go() {
        
        frame = new JFrame();
        //button = new JButton("click me");
        SimpleGui2 gui2 = new SimpleGui2();
        //button.addActionListener(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.getContentPane().add(button);
        frame.getContentPane().add(gui2);
        frame.setSize(300, 300);
        frame.setVisible(true);
        
    }
}