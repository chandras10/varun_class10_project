package demo.core;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.lang.Math.*;

public class Test implements ActionListener{

    
    public void actionPerformed(ActionEvent event) {
        boolean flag = true;
  
        
    }
    
    
    public static void main() {
        
             JScrollPane scrollPane;
    JLabel arraySizeLbl;
     JLabel sortAlgoTypeLbl;
     JButton sortButton;
     JComboBox sortAlgoList;
     JTextField arraySizeTxtField;
        
        JFrame frame = new JFrame("test");
        frame.setSize(new Dimension(500, 500));

        
        SortArray array = new SortArray(10, frame.getWidth(), frame.getHeight());
        
        scrollPane = new JScrollPane(array);
        scrollPane.setViewportView(array);
        
        GridLayout layout = new GridLayout(0, 1);
        frame.setLayout(layout);
        
        arraySizeTxtField = new JTextField();
        frame.add(arraySizeTxtField);
        
        final DefaultComboBoxModel sortAlgoListModel = new DefaultComboBoxModel();
        sortAlgoListModel.addElement("Bubble Sort");
        sortAlgoListModel.addElement("Selection Sort");

 
        sortAlgoList = new JComboBox(sortAlgoListModel);    
        sortAlgoList.setSelectedIndex(0);
        frame.add(sortAlgoList);
        
        sortButton = new JButton("Sort");
        
        frame.add(scrollPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setVisible(true);
        
        SortAlgorithm algo = new SelectionSort();
        array.shuffle();
        algo.sort(array);
    }

}