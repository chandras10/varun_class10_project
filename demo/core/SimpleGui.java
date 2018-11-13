package demo.core;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SimpleGui implements ActionListener{
    
    JFrame frame;
    SimpleGui2 gui2;
    JButton button;
    int array[] = new int[5];
    SimpleGui shuffler;
    
    public static void main() {
        SimpleGui gui = new SimpleGui();
        gui.go();
    }
    
    public void shuffle(int values[]) {
        
        for (int i = values.length - 1; i > 0; i--) {
            int temp = values[i];
            values[i] = values[random.nextInt(i+1)];
            values[random.nextInt(i+1)] = temp;
            
        }
    }
    
    public void go() {
        
        frame = new JFrame();
        button = new JButton("Sort the array");
        button.addActionListener(this);
        
        for(int i = 1; i < array.length; i++) {
            array[i] = i * 10;
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui2 = new SimpleGui2();
        shuffler = new SimpleGui();
        shuffler.shuffle(array);
        frame.getContentPane().add(BorderLayout.CENTER,gui2);
        frame.getContentPane().add(BorderLayout.NORTH,button);
        frame.setSize(500, 500);
        frame.setVisible(true);
        
    }
    public void actionPerformed(ActionEvent event) {

        int temp;
        int j = 0;
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int minIndex = i;
            for (j = i ; j < length; j++) {
                
                if (array[j] < array[minIndex])
                    minIndex = j;
            }

            temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
            
            try {
                Thread.sleep(100);
            }catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }
            
            SimpleGui2 gui3 = new SimpleGui2();
            
        }
        
        
    }
    
    public class SimpleGui2 extends JPanel {
        
        public void paintComponent(Graphics g) {
            
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            g.setColor(Color.orange);
            int k = 0;
            int w = this.getHeight() - 10;
            
            for (int a = 0; a < array.length; a++) {
                g.fillRect(k, w - array[a], 50, array[a]);
                k += 55;
            }
            
            frame.repaint();
        }    
    }    
    
    public static final Random random = new Random();
}