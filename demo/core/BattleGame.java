package demo.core;
import java.util.*;

public class BattleGame {

    public ArrayList<String> locationCells;
    private String name;
    
    public void setLocationCells(ArrayList<String> loc) {
        locationCells = loc;
    } // end constructor
    
    public void setName(String enemyName) {
        name = enemyName;
    }
    
    public String check(String stringGuess) {
        
        String result = "miss";
        int index = locationCells.indexOf(stringGuess);

        if(index >= 0) {
                
            locationCells.remove(index);
            
            if(locationCells.isEmpty()) {
                result = "kill";
                System.out.println("Thump! You Killed " + name);
            }else {
                result = "hit";
            }
        }
            
        return(result);
    } // end method
    
}