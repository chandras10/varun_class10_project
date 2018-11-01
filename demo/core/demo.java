package demo.core;
import java.util.Random;

/**
 * Write a description of class demo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class demo
{
    public static void main() {
        
        SortArray s = new SortArray(10);
        
        s.print();
        Random r = new Random();
        for (int j = 0; j < 5; j++) {
            for(int i = 0; i < 10; i++) {
                System.out.print(r.nextInt(i+1) + " ");  
            }
        System.out.println();
        
    }
        System.out.println(s.compare(0 , s.length() - 1));
        s.print();
    }
}
