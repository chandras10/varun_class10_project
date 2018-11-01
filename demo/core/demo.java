package demo.core;

public class demo
{
    public static void main() {
        
        SortArray A = new SortArray(10);
        
        A.shuffle();
        A.print();
        
        SortAlgorithm algo = new BubbleSort();
        System.out.println("Algo used for sorting: " + algo.getName());
        algo.sort(A);
        System.out.println();
        algo.printCounters();
        A.print();
    }
}
