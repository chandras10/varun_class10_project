import java.util.Random;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JComponent;
import java.util.concurrent.TimeUnit;
import java.awt.Dimension;

public class SortArray extends JComponent{

    // instance variables

    protected int m_values[];
    protected boolean m_state[];
    private int m_swapCount = 0;
    private int m_compareCount = 0;
   
    private int barWidth = 0;
    private int barHeight = 0;

    // constructers

    public SortArray (int size, int width, int height) {

        if (size < 0) {
            throw new IllegalArgumentException();
        }

        m_values = new int[size];
        m_state = new boolean[size];
        for (int i = 0; i < m_values.length; i++) {
            m_values[i] = i + 1;
            m_state[i] = false;
        }

        
        int len = this.length();
       
        System.out.println("H: " + height + " W: " + width);
        barWidth = Math.max(width/len, 5);
        barHeight = 10;
        
        System.out.println("BH: " + barHeight + " BW: " + barWidth);

         
        Dimension windowSize = new Dimension(
                                        (barWidth + 5) * (size+1), //leave additional bar space to make the last bar label visible 
                                        (barHeight * (size + 5)));
        this.setPreferredSize(windowSize);
        
        
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
        internalSwap(i, j, true);
    }


    public void internalSwap(int i, int j, boolean showAnimation) {

        if (i < 0 || j < 0 || i >= m_values.length || j >= m_values.length) {
            throw new IndexOutOfBoundsException();
        }

        int temp = m_values[i];
        m_values[i] = m_values[j];
        m_values[j] = temp;
        m_swapCount++;

        if (!showAnimation) {
            return;  //No need to visually show the swapping if not needed, for example when called from shuffle()
        }

        m_state[j] = m_state[i] = true;
        try {
            Thread.sleep(Math.max(10, 500/length()));
        }catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }

        this.paintImmediately(0, 0, this.getWidth(), this.getHeight());
        m_state[j] = m_state[i] = false;
    }

    public void shuffle() {
        for (int i = m_values.length - 1; i > 0; i--) {
            internalSwap(i, random.nextInt(i+1), false);
        }
    }

    public void shuffleWithAnimation() {
        for (int i = m_values.length - 1; i > 0; i--) {
            internalSwap(i, random.nextInt(i+1), true);
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

        int len = this.length();
        int width = this.getWidth();
        int height = this.getHeight();

        g.fillRect(0, 0, width, height);

        int j, k = 0;
        int w = height - 10;
       
        for (int a = 0; a < len; a++) {

            if(m_state[a] == true)
                g.setColor(Color.red);
            else
                g.setColor(Color.orange);

            j = (m_values[a]+1) * barHeight; //Scaling the array value to make the bars visible
            g.fillRect(k, w - j, barWidth, j);
            g.setColor(Color.white);
            g.drawString(Integer.toString(m_values[a]), barWidth/2 + k, w - j - 5);
            k += barWidth + 5;

        }

    }    

    public void printCounters(SortArray array) {
        System.out.println("Compare#: " + this.getCompareCount() + "\t Swap#: " + this.getSwapCount());
    }

    public static final Random random = new Random();
}