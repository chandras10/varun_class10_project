package demo.core;
import java.util.ArrayList;

public class BattleGame {

    public ArrayList<String> locationCells;
    public boolean state[] = new boolean[3];
    private String name;
    //boolean TheCoordsState[][] = new boolean[7][7];

    BattleGame() {
        for (int j = 0; j < 3;j++) {
            state[j] = false; //ch2.concat(Integer.toString(j));
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

    /*    public void setState() {
    int j = 0;

    for (int i = 0; i < 7; i++) {

    j = 0;
    //int k = i + 97;
    //char ch = (char)k;
    //String ch2 = Character.toString(ch);
    //ch2.concat(Integer.toString(j));

    }
    }*/

    public String checkYourself(String userInput) {

        String result = "miss";
        int h = 0;
        int index = locationCells.indexOf(userInput); // finds out if the user input is there in the array or not.
        // It returns a -1 if it is not present

        if(index >= 0) {

            locationCells.remove(index);

            if(locationCells.isEmpty()) {
                result = "sunk";
                System.out.println("You sunk " + getName());
            }else {
                result = "hit";

                char YC = userInput.charAt(0);
                char XC = userInput.charAt(1);

                int XCoord = (int)(XC) - 48;
                int YCoord = (int)(YC) - 97;

                System.out.println("The x = " + XCoord + "\nThe y = " + YCoord);

                state[h] = true;
                h++;
            }
        }

        return(result);
    } // end method

}