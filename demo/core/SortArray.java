package demo.core;
import java.util.Random;

public class SortArray {
    
    // instance variables
    
    protected int values[];
    
    // constructers
    
    public SortArray (int size) {
        
        if (size < 0) {
            throw new IllegalArgumentException();
        }
        
        values = new int[size];
        for (int i = 0; i < values.length; i++) {
            values[i] = i + 1;
        }
        
    }
    
    // methods
    
    public int length() {
        return values.length;
    }
    
    public int compare(int i, int j) {
        
        if (i < 0 || j < 0 || i >= values.length || j >= values.length) {
            throw new IndexOutOfBoundsException();
        }
        
        return Integer.compare(values[i], values[j]);
    }
    
    public void swap(int i, int j) {
        
        if (i < 0 || j < 0 || i >= values.length || j >= values.length) {
            throw new IndexOutOfBoundsException();
        }
        
        int temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }
    
    public void shuffle() {
        
        for (int i = values.length - 1; i > 0; i--) {
            swap(i, random.nextInt(i+1));
        }
    }
    
    public void print() {
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }
        
        System.out.println();
    }
    
    public static final Random random = new Random();
}