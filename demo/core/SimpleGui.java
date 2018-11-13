package demo.core;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SimpleGui extends JPanel implements ActionListener{
    
    JFrame m_frame;
    JButton m_button;
    int m_array[];
    
    public SimpleGui(int i) {
        m_frame = new JFrame();
        //this.add(m_frame);
        m_button = new JButton("Sort the array");
        m_array = new int[i];
        for(int n = 0; n < m_array.length; n++) {
            m_array[n] = n;
        }
        m_button.addActionListener(this);
       
        m_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.shuffle(m_array);
        m_frame.getContentPane().add(BorderLayout.CENTER,this);
        m_frame.getContentPane().add(BorderLayout.NORTH,m_button);
        m_frame.setSize(500, 500);
        m_frame.setVisible(true);
    }
    
    public static void main() {
        SimpleGui gui = new SimpleGui(8);
    }
    
    public void shuffle(int values[]) {
        
        for (int i = values.length - 1; i >= 0; i--) {
            int randomValue = random.nextInt(i+1);
            int temp = values[i];
            values[i] = values[randomValue];
            values[randomValue] = temp;
            
        }
    }

    public void paintComponent(Graphics g) {
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            g.setColor(Color.orange);
            int j, k = 0;
            int w = this.getHeight() - 10;
            
            for (int a = 0; a < m_array.length; a++) {
                j = m_array[a] * 10 + 10; //Scaling the array value to make the bars visible
                g.fillRect(k, w - j, 50, j);
                k += 55;
            }
            
    }    
        
    public void actionPerformed(ActionEvent event) {

        int temp;
        int j = 0;
        int length = m_array.length;
        for (int i = 0; i < length; i++) {
            int minIndex = i;
            for (j = i ; j < length; j++) {
                
                if (m_array[j] < m_array[minIndex])
                    minIndex = j;
            }

            temp = m_array[minIndex];
            m_array[minIndex] = m_array[i];
            m_array[i] = temp;
            
            System.out.println(i);
            try {
                Thread.sleep(1000);
            }catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }
            
            this.revalidate();
            this.repaint();
            m_frame.getContentPane().revalidate();
            m_frame.getContentPane().repaint();
        }
        
        
    }
    
    public static final Random random = new Random();
}