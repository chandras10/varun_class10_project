package demo.core;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Button2 implements ActionListener{
    
    JButton button2;
    public static void main() {
        Button2 gui = new Button2();
        gui.go();
    }
    
    public void go() { 
        JFrame frame = new JFrame();
        button2 = new JButton("Open Sorter");
        button2.addActionListener(this);
        
        frame.getContentPane().add(button2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent event) {
        
        Scanner sc = new Scanner(System.in);
        SortArray A = new SortArray(10);
        
        A.shuffle();
        System.out.print("The original array is: ");
        A.print();
        
        SortAlgorithm algo = null;
        
        System.out.println("Enter the sorting technique: ");
        System.out.print("1) Bubble Sort\n2)Selection Sort");
        int choice = sc.nextInt();

        switch (choice) {
            
            case 1:
                algo = new BubbleSort();
                break;
            case 2:
                algo = new SelectionSort();
                break;
            default:
                System.out.println("Wrong choice");
                return;
        } // end switch
        
        System.out.println("Algo used for sorting: " + algo.getName());
        algo.sort(A);
        System.out.println();
        algo.printCounters();
        System.out.print("The sorted array is: ");
        A.print();
    
    }
    
    
}