package demo.core;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GridDrawer extends JFrame {

    //  instance variables

    JFrame m_frame;

    //  constructors

    void GridDrawer() {
        m_frame = new JFrame();
        m_frame.setSize(500, 500);
        m_frame.add(this);
        m_frame.setVisible(true);
        //m_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main() {
        GridDrawer grid = new GridDrawer();
        //new GridDrawer();
    }

    public void paintComponent(Graphics g) {

        g.fillRect(0 , 0, this.getWidth(), this.getHeight());

        int h = 10;
        int w = 10;
        g.setColor(Color.orange);

        for (int row = 0; row < 10; row++) {

            for(int column = 0; column < 10; column++){
                g.fillRect(20, 20, 20 + w, 20 + h);
            }

        }

    }
} 