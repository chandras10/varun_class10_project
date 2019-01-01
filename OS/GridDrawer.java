package OS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class GridDrawer extends JPanel{

    JFrame frame;
    JPanel panel, panel2;
    
    Grid g1;
    Grid g2;

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public void setUpGrid() {

        frame = new JFrame(); 
        panel = new JPanel();
        panel2 = new JPanel();

        frame.setLayout(new GridBagLayout());
        // setting the frame size to fill the screen

        frame.setSize(screenSize.width, screenSize.height);

        g1 = new Grid();
        g2 = new Grid();

        g1.setPreferredSize(new Dimension(500, 500));
        g2.setPreferredSize(new Dimension(500, 500));
        panel.add(g1);
        panel2.add(g2);

        panel.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder(""),
                                BorderFactory.createEmptyBorder(5,5,5,5)),
                panel.getBorder()));
                
        panel2.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder(""),
                                BorderFactory.createEmptyBorder(5,5,5,5)),
                panel2.getBorder()));
        
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1.0;
        c.gridx = 0;
        c.gridy = 0;
        frame.add(panel, c);

        c.gridx = 1;
        c.gridy = 0;
        frame.add(panel2, c);

        frame.setVisible(true);
    }

}