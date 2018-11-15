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
        mainframe.setSize(700, 600);
        mainframe.setLayout(new GridBagLayout());

        arraySizeLbl = new JLabel("Size of the Array: ", JLabel.RIGHT);
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(20, 5, 5, 5);
        mainframe.add(arraySizeLbl, c);

        arraySizeTxtField = new JTextField(3);
        c.weightx = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(20, 5, 5, 500);

        mainframe.add(arraySizeTxtField, c);

        sortAlgoTypeLbl = new JLabel("Type of Sort: ", JLabel.RIGHT);
        c.weightx = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(20, 5, 20, 5);

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
        c.insets = new Insets(20, 5, 20, 500);
        mainframe.add(sortAlgoList, c);

        sortButton = new JButton("Sort");
        sortButton.addActionListener(this);
        GridBagConstraints cb = new GridBagConstraints();
        sortButton.setPreferredSize(new Dimension(100, 30));
        cb.weightx = 0.0;
        cb.gridx = 0;
        cb.gridy = 2;
        cb.gridwidth = 2;
        cb.insets = new Insets(20, 5, 20, 5);
        mainframe.add(sortButton, cb);

        mainframe.setAlwaysOnTop (true);
    }

    public void actionPerformed(ActionEvent event) {
        boolean flag = true;
        int n = Integer.parseInt(arraySizeTxtField.getText());

        while (flag == true) {
            n = Integer.parseInt(arraySizeTxtField.getText());

            if(n > 500) {
                System.out.println("enter a value below 500...");
                arraySizeTxtField.setText(null);
                arraySizeTxtField.requestFocus();    
                sortButton.requestFocus();
                continue;
            }
            flag = false;
        } // end while
        sortButton.setText("Sorting...");        
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

        /*A.shuffle();
        System.out.print("The original array is: ");
        A.print();

        System.out.println("Algo used for sorting: " + algo.getName());
        algo.sort(A);
        System.out.println();
        algo.printCounters();
        System.out.print("The sorted array is: ");
        A.print();
        System.out.println("\n");
        sortButton.setText("Sort");*/
        SimpleGui sorter = new SimpleGui(n);
        mainframe.setVisible(false);
    }

    public static void main() {

        SortDemo sorting = new SortDemo();

    }
}