package demo.core;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonExample {
 
    //  instance variables
    
    JFrame frame;
    JButton button1;
    JButton button2;
    JButton button3;
    
    //  methods
    
    public static void main() {
        ButtonExample buttons = new ButtonExample();
        buttons.go();
    } // end main
    
    public void go() {
        
        frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(700, 600);
        frame.setLayout(new GridBagLayout());
        button1 = new JButton("Rock");
        button2 = new JButton("Paper");
        button3 = new JButton("Scissors");
        
        GridBagConstraints c = new GridBagConstraints();// makes a grid [ starts with 0 cells ]
        c.fill = GridBagConstraints.HORIZONTAL;// this adds the next horizontal cell in the grid
        c.gridx = 0; // add to the first cell on the x axis
        c.gridy = 0;
        c.insets = new Insets(20, 5, 5, 5); //this increases the gap
        frame.add(button1, c);// adds the button to the grid
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;// add to the next cell on the x axis
        c.gridy = 0;
        c.insets = new Insets(20, 5, 5, 5);
        frame.add(button2, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;// add to the next cell on the x axis
        c.gridy = 0;
        c.insets = new Insets(20, 5, 5, 5);
        frame.add(button3, c);
        
    }// end go method
}// end class