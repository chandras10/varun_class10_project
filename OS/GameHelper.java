 
import java.util.*;

public class GameHelper {

    private static final String alphabet = "abcdefg";
    private int gridLength = 7;
    private int gridSize = 49;
    private int [] grid = new int[gridSize];
    private int enemyCount = 0;
    public String getUserInput() {
        
        String inputLine = "";
        System.out.print("Enter a guess: ");
        Scanner sc = new Scanner(System.in);                        
        inputLine = sc.next();
        if (inputLine.length() == 0) {
            return (null);
        }
        
        return(inputLine.toLowerCase());
        
    }
    
    public ArrayList<String> placeEnemy(int enemySize) {
        
        ArrayList<String> alphaCells = new ArrayList<String>();
        String[] alphacoords = new String [enemySize];
        String temp = "";
        int[] coords = new int[enemySize];
        int attempts = 0;
        boolean success = false;
        int location = 0;
        enemyCount++;
        int incr = 1;
        if((enemyCount % 2) == 1) {
            incr = gridLength;
        } // end if
        
        while( !success & attempts++ < 200) {
            
            location = (int)(Math.random() * gridSize);
            System.out.print(" try " + location);
            int x = 0;
            success = true;
            
            while (success && x < enemySize) {
                
                if (grid[location] == 0) {
                    
                    coords[x++] = location;
                    location += incr;
                    if(location >= gridSize) {
                        success = false;
                    }
                    if((x > 0) && (location % gridLength == 0)){
                        success = false;
                    }
                } else {
                    System.out.print("  used " + location);
                    success = false;
                }
            } // end inner while
            
        } // end outer while
        
        int x = 0;
        int row = 0;
        int column = 0;
        System.out.println(" \n");
        while (x < enemySize) {
            
            grid[coords[x]] = 1;
            row = (int) (coords[x] / gridLength);
            column = coords[x] % gridLength;
            temp = String.valueOf(alphabet.charAt(column));
            
            alphaCells.add(temp.concat(Integer.toString(row)));
            x++;
            System.out.print("   coord "+x+" = " + alphaCells.get(x-1));
        } // end while
        
        System.out.println( "\n");
        
        return (alphaCells);
    } // end constructor
}