package demo.core;
import java.util.Random;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JComponent;
import java.util.concurrent.TimeUnit;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class SortArray extends JComponent{

    // instance variables

    protected int m_values[];
    protected boolean m_state[];
    private int m_swapCount = 0;
    private int m_compareCount = 0;

    // constructers

    public SortArray (int size) {

        if (size < 0) {
            throw new IllegalArgumentException();
        }

        m_values = new int[size];
        m_state = new boolean[size];
        for (int i = 0; i < m_values.length; i++) {
            m_values[i] = i + 1;
            m_state[i] = false;
        }

    }

    // methods

    public int length() {
        return m_values.length;
    }

    public int getSwapCount() {
        return(m_swapCount);
    }

    public int getCompareCount() {
        return(m_compareCount);
    }

    public int compare(int i, int j) {

        if (i < 0 || j < 0 || i >= m_values.length || j >= m_values.length) {
            throw new IndexOutOfBoundsException();
        }
        m_compareCount++;
        return Integer.compare(m_values[i], m_values[j]);
    }

    public void swap(int i, int j) {

        if (i < 0 || j < 0 || i >= m_values.length || j >= m_values.length) {
            throw new IndexOutOfBoundsException();
        }

        int temp = m_values[i];
        m_values[i] = m_values[j];
        m_values[j] = temp;
        m_swapCount++;
        
        try {
                Thread.sleep(Math.max(10, 5000/length()));
            }catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }
            
        this.paintImmediately(0, 0, this.getWidth(), this.getHeight());
        m_state[j] = m_state[i] = false;
    }

    public void shuffle() {

        for (int i = m_values.length - 1; i > 0; i--) {
            swap(i, random.nextInt(i+1));
        }
    }

    public void print() {
        for (int i = 0; i < m_values.length; i++) {
            System.out.print(m_values[i] + " ");
        }

        System.out.println();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        int len = this.length();
        int width = this.getWidth();
        int height = this.getHeight();
        
        g.fillRect(0, 0, width, height);
 
        int j, k = 0;
        int w = height - 10;
        int barWidth = Math.max((width/len), 5);
        int barHeight = Math.min((height/len), 10);

        for (int a = 0; a < len; a++) {

            if(m_state[a] == true)
                g.setColor(Color.red);
            else
                g.setColor(Color.orange);

            j = (m_values[a]+1) * barHeight; //Scaling the array value to make the bars visible
            g.fillRect(k, w - j, barWidth, j);
            g2.setColor(Color.white);
            g2.drawString(Integer.toString(m_values[a]), barWidth/2 + k, w - j - 5);
            k += barWidth + 5;

        }
        
        
    }    

    public static final Random random = new Random();
}