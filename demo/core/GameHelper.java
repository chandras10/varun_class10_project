package demo.core;
import java.util.*;

public class GameHelper {

    private static final String alphabet = "ABCDEFG";
    private int gridLength = 7;
    private int gridSize = 7;
    private int [] grid = new int[gridSize];
    private int enemyCount = 0;
    
    public String getUserInput(String prompt) {
        
        String inputLine = null;
        System.out.print(prompt + " ");
        
        Scanner sc = new Scanner(System.in);
        inputLine = sc.next();
        if (inputLine.length() == 0)
                return (null);
        
        return(inputLine.toLowerCase());
        
    }
    
    public ArrayList<String> placeEnemy(int enemyCount) {
        
        ArrayList<String> alpha
        
    } // end constructor
}