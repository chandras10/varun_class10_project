package demo.core;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SortDemo implements ActionListener{
    
    private int arraySize;
    private int sortAlgoType;
    
    private JFrame mainframe;
    private JLabel arraySizeLbl;
    private JLabel sortAlgoTypeLbl;
    private JFrame resultPanel;
    private JButton sortButton;
    private JComboBox sortAlgoList;
    private JTextField arraySizeTxtField;
    
    public SortDemo() {
        
        mainframe = new JFrame("Sorting Demo");
        mainframe.setVisible(true);
        mainframe.setSize(400, 400);
        mainframe.setLayout(new GridBagLayout());
        
        arraySizeLbl = new JLabel("Size of the Array: ");
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        mainframe.add(arraySizeLbl, c);
        
        arraySizeTxtField = new JTextField(6);
        c.weightx = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        mainframe.add(arraySizeTxtField, c);
        
        sortAlgoTypeLbl = new JLabel("Type of Sort: 1) Bubble Sort\n2)Selection Sort");
        c.weightx = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        mainframe.add(sortAlgoTypeLbl, c);
        
        final DefaultComboBoxModel sortAlgoListModel = new DefaultComboBoxModel();
        sortAlgoListModel.addElement("Bubble Sort");
        sortAlgoListModel.addElement("Selection Sort");
    
        sortAlgoList = new JComboBox(sortAlgoListModel);    
        sortAlgoList.setSelectedIndex(0);
        c.weightx = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        mainframe.add(sortAlgoList, c);
        
        sortButton = new JButton("Sort");
        sortButton.addActionListener(this);
        c.weightx = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        mainframe.add(sortButton, c);
        
        resultPanel = new RedirectedFrame(false, false, null, 700, 600, JFrame.EXIT_ON_CLOSE);
        c.weightx = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        c.ipady = 100;
        c.gridwidth = 2;
        
        mainframe.add(resultPanel.getContentPane(), c);
        mainframe.setAlwaysOnTop (true);
        resultPanel.setVisible(false);
    }
    
    public void actionPerformed(ActionEvent event) {
        sortButton.setText("Sorting...");
        int n = Integer.parseInt(arraySizeTxtField.getText());
        int choice = sortAlgoList.getSelectedIndex();
        SortArray A = new SortArray(n);
        SortAlgorithm algo = null;
        
        switch (choice) {
                
                case 0:
                    algo = new BubbleSort();
                    break;
                case 1:
                    algo = new SelectionSort();
                    break;
                default:
                    System.out.println("Wrong choice");
                    System.out.println();
            } // end switch
        
        A.shuffle();
        System.out.print("The original array is: ");
        A.print();
        
        System.out.println("Algo used for sorting: " + algo.getName());
        algo.sort(A);
        System.out.println();
        algo.printCounters();
        System.out.print("The sorted array is: ");
        A.print();
        System.out.println("\n");
    }
    
    public static void main() {
        
        SortDemo sorting = new SortDemo();

    }
}