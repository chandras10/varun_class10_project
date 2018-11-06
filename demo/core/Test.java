package demo.core;
import java.util.*;

public class Test {
    
    public static void main() {
        
        Scanner sc = new Scanner(System.in);
        SortArray A = new SortArray(10);
        
        A.shuffle();
        System.out.print("The original array is: ");
        A.print();
        
        SortAlgorithm algo = null;
        
        boolean flag = true;
        
        while (flag) {
            
            System.out.println("Enter the sorting technique: ");
            System.out.print("1) Bubble Sort\n2)Selection Sort");
            int choice = sc.nextInt();
    
            switch (choice) {
                
                case 1:
                    algo = new BubbleSort();
                    flag = false;
                    break;
                case 2:
                    algo = new SelectionSort();
                    flag = false;
                    break;
                default:
                    System.out.println("Wrong choice");
                    System.out.println();
            } // end switch
            
        }// end while
        
        System.out.println("Algo used for sorting: " + algo.getName());
        algo.sort(A);
        System.out.println();
        algo.printCounters();
        System.out.print("The sorted array is: ");
        A.print();
        
    }
    
}