package demo.core;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SortDemo implements ActionListener{
    private int arraySize;
    private int sortAlgoType;

    private JFrame mainframe;
    private JScrollPane scrollPane;
    private JLabel arraySizeLbl;
    private JLabel sortAlgoTypeLbl;
    private JButton sortButton;
    private JComboBox sortAlgoList;
    private JTextField arraySizeTxtField;
    JFrame sortFrame;
    
    public SortDemo() {
        mainframe = new JFrame("Sorting Demo");
        JPanel panel1;
        panel1 = new JPanel();
        
        GridLayout layout = new GridLayout(0,1);
        mainframe.setLayout(layout);
        mainframe.add(panel1);
        //mainframe.add(panel2);
        mainframe.setVisible(true);
        mainframe.setSize(700, 600);
        panel1.setLayout(new GridBagLayout());

        arraySizeLbl = new JLabel("Size of the Array: ", JLabel.RIGHT);
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(20, 5, 5, 5);

        panel1.add(arraySizeLbl, c);

        arraySizeTxtField = new JTextField(3);
        c.weightx = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(20, 5, 5, 500);

        panel1.add(arraySizeTxtField, c);

        sortAlgoTypeLbl = new JLabel("Type of Sort: ", JLabel.RIGHT);
        c.weightx = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(20, 5, 20, 5);

        panel1.add(sortAlgoTypeLbl, c);

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
        panel1.add(sortAlgoList, c);

        sortButton = new JButton("Sort");
        sortButton.addActionListener(this);
        GridBagConstraints cb = new GridBagConstraints();
        sortButton.setPreferredSize(new Dimension(100, 30));
        cb.weightx = 0.0;
        cb.gridx = 0;
        cb.gridy = 2;
        cb.gridwidth = 2;
        cb.insets = new Insets(20, 5, 20, 5);
        panel1.add(sortButton, cb);
    }

    public void actionPerformed(ActionEvent event) {
        boolean flag = true;
        int size = Integer.parseInt(arraySizeTxtField.getText());  
        int choice = sortAlgoList.getSelectedIndex();
        
        sortFrame = new JFrame();
        sortFrame.setVisible(true);
        sortFrame.setSize(700, 600);
        
        SortArray array = new SortArray(size, 
                                        sortFrame.getWidth(), 
                                        sortFrame.getHeight());
                                        
        
        sortFrame.getContentPane().add(new JScrollPane(array));
        
        SortAlgorithm algo = null;

        switch (choice) {

            case 0:
            algo = new BubbleSort();
            break;
            case 1:
            algo = new SelectionSort();
            break;
        } // end switch
        array.shuffle();
        array.print();
        algo.sort(array);
        algo.printCounters(array);
        //SimpleGui sorter = new SimpleGui(size);
        
    }

    public static void main() {
        Runnable runnable = new Runnable(){
            @Override
            public void run() {
                SortDemo sorting = new SortDemo();
            }
        };
        EventQueue.invokeLater(runnable);
        

    }
}