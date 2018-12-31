package OS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class paint extends JComponent{
    static int width;
    static int height;
    
    public void setVar(int w, int h) {
        width = w;
        height = h;
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(0,0, width, height);

        g.setColor(Color.black);
        g.fillOval(20, 20, 30, 30);
    }

}