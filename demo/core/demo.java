package demo.core;
import java.util.*;

public class demo
{
    public static void main() {
        
        SortArray A = new SortArray(10);
        Scanner sc = new Scanner(System.in);
        
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
        } // end switch
        
        System.out.println("Algo used for sorting: " + algo.getName());
        algo.sort(A);
        System.out.println();
        algo.printCounters();
        System.out.print("The sorted array is: ");
        A.print();
    }
}
