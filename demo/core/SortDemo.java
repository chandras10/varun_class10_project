package demo.core;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SortDemo implements ActionListener{
    
    private int arraySize;
    private int sortAlgoType;
    
    private JFrame mainframe;
    private JPanel controlPanel;
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
        mainframe.setLayout(new GridLayout(3,1));
        controlPanel = new JPanel();
        //controlPanel.setSize(100, 100);
        controlPanel.setLayout(new GridLayout(2,2));
        
        arraySizeLbl = new JLabel("Size of the Array: ");
        arraySizeTxtField = new JTextField(6);
        sortAlgoTypeLbl = new JLabel("Type of Sort: 1) Bubble Sort\n2)Selection Sort");
        final DefaultComboBoxModel sortAlgoListModel = new DefaultComboBoxModel();
        sortAlgoListModel.addElement("Bubble Sort");
        sortAlgoListModel.addElement("Selection Sort");
    
        sortAlgoList = new JComboBox(sortAlgoListModel);    
        sortAlgoList.setSelectedIndex(0);
        
        controlPanel.add(arraySizeLbl);
        controlPanel.add(arraySizeTxtField);
        controlPanel.add(sortAlgoTypeLbl);
        controlPanel.add(sortAlgoList);
        
        sortButton = new JButton("Sort");
        //sortButton.setBounds(100, 50, 100, 50);
        sortButton.addActionListener(this);
        
        resultPanel = new RedirectedFrame(false, false, null, 700, 600, JFrame.EXIT_ON_CLOSE);
        mainframe.add(controlPanel);
        mainframe.add(sortButton);
        mainframe.add(resultPanel);
        //resultPanel.setVisible(false);
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
        System.out.print("\n\nThe original array is: ");
        A.print();
        
        System.out.println("Algo used for sorting: " + algo.getName());
        algo.sort(A);
        System.out.println();
        algo.printCounters();
        System.out.print("The sorted array is: ");
        A.print();
    }
    
    public static void main() {
        
        SortDemo sorting = new SortDemo();
        
    }
}
