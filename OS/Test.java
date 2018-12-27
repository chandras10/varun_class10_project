package OS;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Test{

    JFrame frame;

    public void initialize() {
        
        frame = new JFrame();
        
        ImageIcon image1 = new ImageIcon(getClass().getResource("sort.jpg"));
        ImageIcon image2 = new ImageIcon(getClass().getResource("calcul.png"));
        
        Image renderedImage = image1.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(renderedImage);
        
        JButton b1 = new JButton(image1);
        JButton b2 = new JButton(image2);
        
        b1.setPreferredSize(new Dimension(100, 100));
        b2.setPreferredSize(new Dimension(100, 100));
        
        
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill=GridBagConstraints.BOTH;
        c.anchor=GridBagConstraints.CENTER;
        c.weightx=0.0;
        buttonsPanel.add(b1, c);
        
        c.fill=GridBagConstraints.BOTH;
        c.anchor=GridBagConstraints.CENTER;
        c.weightx=0.0;
        buttonsPanel.add(b2, c);
        
        frame.add(buttonsPanel);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    public static void main() {
        Test t = new Test();
        t.initialize();
    }

}