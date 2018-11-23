package demo.core;
import java.util.ArrayList;

public class BattleGame {

    public ArrayList<String> locationCells;
    private String name;

    public void setLocationCells(ArrayList<String> loc) {
        locationCells = loc;
    } // end constructor

    public void setName(String enemyName) {
        name = enemyName;
    }

    public String getName() {
        return name;
    }

    public String checkYourself(String userInput) {

        String result = "miss";
        int index = locationCells.indexOf(userInput); // finds out if the user input is there in the array or not.
                                                        // It returns a -1 if it is not present

        if(index >= 0) {

            locationCells.remove(index);

            if(locationCells.isEmpty()) {
                result = "sunk";
                System.out.println("You sunk " + getName());
            }else {
                result = "hit";
            }
        }

        return(result);
    } // end method

}