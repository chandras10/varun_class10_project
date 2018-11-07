package demo.core;
import java.util.ArrayList;

public class ArrrayListProg {
    
    public static void main() {
        
        ArrayList<String> myList = new ArrayList<String>();
        
        String a = new String("first element");
        myList.add(a);
        String b = new String("second element");
        myList.add(b);
        String c = new String("third element");
        int theSize = myList.size();
        System.out.print("The size of the ArrayList is : " + theSize + " \n");
        boolean IsIn = myList.contains(a);
        boolean IsntIn = myList.contains(c);
        System.out.print("Is: \nfirst element in ArrayList -\t" + IsIn + "\nthird element in ArrayList -\t" + IsntIn);
        int index = myList.indexOf(b);
        boolean empty = myList.isEmpty();
        System.out.println("\nIs the ArrayList empty?");
        System.out.println(empty);
        myList.remove(b);
        myList.remove(a);
        empty = myList.isEmpty();
        System.out.println("\nIs the ArrayList empty now?");
        System.out.println(empty);
    }// end main
    
}// end class