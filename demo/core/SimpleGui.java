package demo.core;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.lang.Math.*;


public class SimpleGui extends JPanel implements ActionListener{
    
    JFrame m_frame;
    JButton m_button;
    int m_array[];
    JScrollPane scroller;
    boolean m_state[];
    
    public SimpleGui(int i) {
        m_frame = new JFrame();
        m_button = new JButton("Sort the array");
        m_array = new int[i];
        m_state = new boolean[i];
        
        for(int n = 0; n < m_array.length; n++) {
            m_array[n] = n;
            m_state[n] = false;
        }
        
        m_button.addActionListener(this);
       
        m_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.shuffle(m_array);
        m_frame.getContentPane().add(BorderLayout.CENTER,this);
        m_frame.getContentPane().add(BorderLayout.NORTH,m_button);
        m_frame.setSize(500, 500);
        m_frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        SimpleGui gui = new SimpleGui(Integer.parseInt(args[0]));
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
            
            int j, k = 0;
            int w = this.getHeight() - 10;
            int barWidth = Math.max((m_frame.getWidth()/m_array.length), 5);
            int barHeight = Math.min((m_frame.getHeight()/m_array.length), 10);
            
            for (int a = 0; a < m_array.length; a++) {
                
                if(m_state[a] == true)
                    g.setColor(Color.red);
                else
                    g.setColor(Color.orange);
                    
                j = (m_array[a]+1) * barHeight; //Scaling the array value to make the bars visible
                g.fillRect(k, w - j, barWidth, j);
                k += barWidth + 5;
                
            }
            scroller = new JScrollPane();
            scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
            scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
            m_frame.getContentPane().add(BorderLayout.SOUTH, scroller);
            
    }    
        
    public void actionPerformed(ActionEvent event) {

        int j = 0;
        int length = m_array.length;
        
        for (int i = 0; i < length; i++) {
            int minIndex = i;
            for (j = i ; j < length; j++) {
                
                if (m_array[j] < m_array[minIndex])
                    minIndex = j;
            }
            m_state[minIndex] = m_state[i] = true;
            int temp = m_array[minIndex];
            m_array[minIndex] = m_array[i];
            m_array[i] = temp;
            
            try {
                Thread.sleep(Math.max(10, 5000/m_array.length));
            }catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }
            
            this.paintImmediately(0, 0, m_frame.getWidth(), m_frame.getHeight());
            m_state[minIndex] = m_state[i] = false;
        }
        
    }
    
    public static final Random random = new Random();
}