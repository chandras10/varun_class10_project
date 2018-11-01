package demo.simple;
import demo.core.AbstractSortArray;

/**
 * Write a description of class SimpleSortArray here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
class SimpleSortArray extends AbstractSortArray
{
    public long comparisonCount;
    public long swapCount;
    
    public SimpleSortArray(int size) {
        super(size);
        comparisonCount = swapCount = 0;
        shuffle();
    }
    
    public int compare(int i, int j) {
        
        comparisonCount++;
        return super.compare(i, j);
        
    }
    
    public void swap(int i, int j) {
        
        swapCount++;
        super.swap(i, j);
        
    }
    
    public void print(){
    
        System.out.println();
        for (int i=0; i<values.length; i++) {
            System.out.print(values[i] + " ");  
        }
        System.out.println();
    }
}