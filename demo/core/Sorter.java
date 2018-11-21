import javax.swing.*;
import javax.swing.text.*;

import java.awt.*;              //for layout managers and more
import java.awt.event.*;        //for action events

import java.net.URL;
import java.io.IOException;

public class Sorter extends JPanel
                             implements ActionListener {
    private String newline = "\n";
    protected static final String arraySizeFieldString = "Array Size";
    protected static final String algorithmFieldString = "Algorithm";
    protected static final String sortButtonString = "Sort";
    protected static final String shuffleButtonString = "Shuffle";
    protected static final String buttonString = "JButton";
    protected static SortArray sortArray;

    protected static final JTextField sortArraySizeField = new JTextField(10);

    protected static JScrollPane sortArrayScrollPane;
    protected static JComboBox algorithmComboBox;

    protected static JLabel compareCount;
    protected static JLabel swapCount;


    public Sorter() {
        setLayout(new BorderLayout());

        //Array Size field
        
        sortArraySizeField.setActionCommand(arraySizeFieldString);
        sortArraySizeField.addActionListener(this);


        //Sort Algorithm DropDown field
        final DefaultComboBoxModel algorithmComboBoxModel = new DefaultComboBoxModel();
        algorithmComboBoxModel.addElement("Bubble Sort");
        algorithmComboBoxModel.addElement("Selection Sort");

        algorithmComboBox = new JComboBox(algorithmComboBoxModel);    
        algorithmComboBox.setSelectedIndex(0);


        //Sort Button
        JButton sortButton = new JButton(" Sort ");
        sortButton.setActionCommand(sortButtonString);
        sortButton.addActionListener(this);

        //Shuffle Button
        JButton shuffleButton = new JButton(" Shuffle ");
        shuffleButton.setActionCommand(shuffleButtonString);
        shuffleButton.addActionListener(this);

        //Create some labels for the fields.
        JLabel sortArraySizeFieldLabel = new JLabel(arraySizeFieldString + ": ");
        sortArraySizeFieldLabel.setLabelFor(sortArraySizeField);
        JLabel algorithmFieldLabel = new JLabel(algorithmFieldString + ": ");
        algorithmFieldLabel.setLabelFor(algorithmComboBox);
        JLabel ftfLabel = new JLabel(sortButtonString);
        ftfLabel.setLabelFor(sortButton);

        //Lay out the text controls and the labels.
        JPanel sortParametersPane = new JPanel();
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();

        sortParametersPane.setLayout(gridbag);

        JLabel[] labels = {sortArraySizeFieldLabel, algorithmFieldLabel};
        JComponent[] fields = {sortArraySizeField, algorithmComboBox};
        addSortParameterRows(labels, fields, gridbag, sortParametersPane);

        c.gridwidth = GridBagConstraints.RELATIVE; //next-to-last
        c.fill = GridBagConstraints.HORIZONTAL;     
        c.weightx = 0.0; 
        sortParametersPane.add(shuffleButton, c);

        c.gridwidth = GridBagConstraints.REMAINDER;     //end row
        c.weightx = 1.0;
        sortParametersPane.add(sortButton, c);

        c.gridwidth = GridBagConstraints.RELATIVE; //next-to-last
        c.fill = GridBagConstraints.HORIZONTAL;     
        c.weightx = 0.0;
        sortParametersPane.add(new JLabel("Compares: "), c);

        c.gridwidth = GridBagConstraints.REMAINDER; //next-to-last
        c.fill = GridBagConstraints.HORIZONTAL;     
        c.weightx = 1.0;
        compareCount = new JLabel("");
        sortParametersPane.add(compareCount, c);

        c.gridwidth = GridBagConstraints.RELATIVE; //next-to-last
        c.fill = GridBagConstraints.HORIZONTAL;     
        c.weightx = 0.0;
        sortParametersPane.add(new JLabel("Swaps: "), c);

        c.gridwidth = GridBagConstraints.REMAINDER; //next-to-last
        c.fill = GridBagConstraints.HORIZONTAL;     
        c.weightx = 1.0;
        swapCount = new JLabel("");
        sortParametersPane.add(swapCount, c);

        sortParametersPane.setBorder(
                BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder("Parameters"),
                                BorderFactory.createEmptyBorder(5,5,5,5)));

        //Create Sort Array visualization pane
        SortArray s = new SortArray(1,1,1);
        s.setPreferredSize(new Dimension(500, 500));
        sortArrayScrollPane = new JScrollPane(s);

        
        sortArrayScrollPane.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder(""),
                                BorderFactory.createEmptyBorder(5,5,5,5)),
                sortArrayScrollPane.getBorder()));

        //Put everything together.
        JPanel leftPane = new JPanel(new BorderLayout());
        leftPane.add(sortParametersPane, 
                     BorderLayout.PAGE_START);
        leftPane.add(sortArrayScrollPane,
                     BorderLayout.CENTER);

        add(leftPane, BorderLayout.PAGE_START);
    }

    private void addSortParameterRows(JLabel[] labels,
                                  JComponent[] sortArraySizeFields,
                                  GridBagLayout gridbag,
                                  Container container) {
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.EAST;
        int numLabels = labels.length;

        for (int i = 0; i < numLabels; i++) {
            c.gridwidth = GridBagConstraints.RELATIVE; //next-to-last
            c.fill = GridBagConstraints.NONE;      //reset to default
            c.weightx = 0.0;                       //reset to default
            
            c.fill = GridBagConstraints.HORIZONTAL;
            container.add(labels[i], c);
            c.gridwidth = GridBagConstraints.REMAINDER;     //end row
            c.weightx = 1.0;
            container.add(sortArraySizeFields[i], c);
        }
    }

    private boolean validateParms() {

        System.out.println("Array Size: " + sortArraySizeField.getText());
        try {
            int n = Integer.parseInt(sortArraySizeField.getText());
            if ((n <= 0) || (n > 1000)) {
                JOptionPane.showMessageDialog(null, "Please enter a value between 1-1000.");
                return false;
            }

        } catch(NumberFormatException exception) {
            JOptionPane.showMessageDialog(null, "Please enter a number");
            return false;
        }

        return true;
    }


    public void actionPerformed(ActionEvent e) {
        System.out.println("I was called. ActionCmd: " + e.getActionCommand());
        
        if (!validateParms()) {
                return;
        }
        
        if (sortButtonString.equals(e.getActionCommand())) {
              try {

                int n = Integer.parseInt(sortArraySizeField.getText());
                sortDemo(n);
              } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, "Please enter a number");
              }
        } else if (shuffleButtonString.equals(e.getActionCommand())) {
            sortArray.shuffleWithAnimation();
            sortArray.print();
        }
    }

    private void sortDemo(int n) {
        class SortTask implements Runnable {
            Sorter o;
            int n;

            SortTask(Sorter obj, int size) { 
                o = obj; 
                n = size;
            }

            public void run() {
                System.out.println("SortDemo called");
                sortArray = new SortArray(n, o.sortArrayScrollPane.getWidth(), o.sortArrayScrollPane.getHeight());
                sortArray.shuffle();
                o.sortArrayScrollPane.setViewportView(sortArray);
                

                int choice = o.algorithmComboBox.getSelectedIndex();
                SortAlgorithm algo = null;
                switch (choice) {      
                    case 0:
                        algo = new BubbleSort();
                        break;
                    case 1:
                        algo = new SelectionSort();
                        break;
                } // end switch
                algo.sort(sortArray);

                o.compareCount.setText(new Integer(sortArray.getCompareCount()).toString());
                o.swapCount.setText(new Integer(sortArray.getSwapCount()).toString());
            }
        }
        Thread t = new Thread(new SortTask(this, n));
        t.start();
    }
 

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Sorting Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add content to the window.
        frame.add(new Sorter());

        //Display the window.
        frame.setPreferredSize(new Dimension( 800,600));
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event dispatching thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
		        UIManager.put("swing.boldMetal", Boolean.FALSE);
		        createAndShowGUI();
            }
        });
    }
}
