package OS;

 
import java.util.ArrayList;

public class BattleGame {

    public ArrayList<String> locationCells;
    public boolean state[] = new boolean[3];
    private String name;

    BattleGame() {
        for (int j = 0; j < 3;j++) {
            state[j] = false;
        }
    }

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
        int h = 0;
        int index = locationCells.indexOf(userInput); // finds out if the user input is there in the array or not.
        // It returns a -1 if it is not present

        if(index >= 0) {

            locationCells.remove(index);

            if(locationCells.isEmpty()) {
                result = "sunk";
            }else {
                result = "hit";
                state[h] = true;
                h++;
            }
        }

        return(result);
    } // end method

}