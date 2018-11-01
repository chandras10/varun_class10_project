package demo.core;
import java.util.Objects;

public class SortAlgorithm
{
    
    private final String name;
    protected int swapCount, compareCount;
    
    
    protected SortAlgorithm(String name) {
        
        Objects.requireNonNull(name);
        this.name = name;
        swapCount = compareCount = 0;
        
    }
    
    public final String getName() {
        return (name);
    }
    
    public void sort(SortArray array) {
        System.out.println("Don't know how to sort");
    }
    
    public void swap(SortArray array, int i, int j) {
        swapCount++;
        array.swap(i, j);
    }

    public int compare(SortArray array, int i, int j) {
        compareCount++;
        return array.compare(i, j);
    }
    public void printCounters() {
        System.out.println("Compare#: " + compareCount + "\t Swap#: " + swapCount);
    }
}
