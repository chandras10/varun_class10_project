package demo.simple;

/**
 * Write a description of class SimpleDemo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SimpleDemo
{
    public static void main(String[] args) {
     
        int size = Integer.parseInt(args[0]);
        SimpleSortArray a = new SimpleSortArray(size);
        
        a.print();
        System.out.println("# of Compares: " + a.comparisonCount + " # of Swaps: " + a.swapCount);
        a.shuffle();
        a.print();
        System.out.println("# of Compares: " + a.comparisonCount + " # of Swaps: " + a.swapCount);
    }
}
