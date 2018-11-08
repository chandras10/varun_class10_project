package demo.core;
import javax.swing.*;
import java.awt.*;
import java.awt.Event.*;

public class SortDemo {
    
    private int arraySize;
    private int sortAlgoType;
    
    private JFrame mainframe;
    private JPanel controlPanel;
    private JLabel arraySizeLbl;
    private JLabel sortAlgoTypeLbl;
    private JPanel resultPanel;
    
    public SortDemo() {
        
        mainframe = new JFrame("Sorting Demo");
        mainframe.setVisible(true);
        mainframe.setSize(400, 400);
        mainframe.setLayout(new GridLayout(3,1));
        controlPanel = new JPanel();
        //controlPanel.setSize(100, 100);
        controlPanel.setLayout(new GridLayout(2,2));
        
        arraySizeLbl = new JLabel("Size of the Array: ");
        JTextField arraySizeTxtField = new JTextField(6);
        sortAlgoTypeLbl = new JLabel("Type of Sort: ");
        JTextField sortAlgoTypeTxtField = new JTextField(6);
        controlPanel.add(arraySizeLbl);
        controlPanel.add(arraySizeTxtField);
        controlPanel.add(sortAlgoTypeLbl);
        controlPanel.add(sortAlgoTypeTxtField);
        
        JButton sortButton = new JButton("Sort");
        //sortButton.setSize(50, 10);
        
        resultPanel = new JPanel();
        mainframe.add(controlPanel);
        mainframe.add(sortButton);
        mainframe.add(resultPanel);
        resultPanel.setVisible(false);
    }
    
    public static void main() {
        
        SortDemo sorting = new SortDemo();
        
    }
}
