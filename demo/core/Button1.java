package demo.core;
import javax.swing.*;
import java.awt.event.*;

public class Button1 implements ActionListener {
    
    JButton button;
    
    public static void main() {
        Button1 gui = new Button1();
        gui.go();
    }
    
    public void go() {
        JFrame frame = new JFrame();
        button = new JButton("Open Calculator");
        
        button.addActionListener(this);
        
        frame.getContentPane().add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent event) {
      
        Calculator calculator = new Calculator();
        calculator.setVisible(true);
    
    }
}
