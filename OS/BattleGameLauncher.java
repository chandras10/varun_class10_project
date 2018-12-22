package OS;

import java.util.*;
import java.awt.*;
import javax.swing.*;

public class BattleGameLauncher {

    // instance variables

    GameHelper helper = new GameHelper();
    private ArrayList<BattleGame> enemyList = new ArrayList<BattleGame>();
    private int numOfGuesses = 0;
    String userGuess = "";

    boolean shipSunk = false;

    GridDrawer theGrid;

    public void setUpGame() {

        BattleGame enemy1 = new BattleGame();
        BattleGame enemy2 = new BattleGame();   //make three Battle game objects , i.e the battleships
        BattleGame enemy3 = new BattleGame();

        enemy1.setName("Battle Ship 1");
        enemy2.setName("Battle Ship 2");   //naming the three objects
        enemy3.setName("Battle Ship 3");

        enemyList.add(enemy1);
        enemyList.add(enemy2);    //add the "enemies" to the enemyList ArrayList
        enemyList.add(enemy3);

        theGrid = new GridDrawer(); // draw the grid
        theGrid.setUpGrid();

        //  Some instruction to the player...

        JOptionPane.showMessageDialog(null, "You need to sink three battle ships");

        for (BattleGame BattleGameToSet : enemyList) {

            ArrayList<String> newLocation = helper.placeEnemy(3);
            BattleGameToSet.setLocationCells(newLocation);

        } // end for

        
        startPlaying();
    } // end setUpGame method

    public void startPlaying() {

        while(!enemyList.isEmpty()) {

            userGuess = helper.getUserInput();
            if(userGuess.equalsIgnoreCase("Quit")) {
                System.out.println("You gave up :(");
                System.exit(0);
            }
            checkUserGuess(userGuess);

        }//end while

        finishGame();

    } // end startPlaying method

    public void checkUserGuess(String userGuess) {

        numOfGuesses++;
        String result = "miss";

        for (BattleGame enemyToSet: enemyList) {

            result = enemyToSet.checkYourself(userGuess);

            if(result.equals("hit")) {
                theGrid.setState(true, userGuess);
                break;
            }else if(result.equals("sunk")){
                enemyList.remove(enemyToSet);
                theGrid.setState(true, userGuess);
                shipSunk = true;
                System.out.println("You sunk: "+ enemyToSet.getName() + "\n");
                break;
            }
            
        } // end for

        if (shipSunk == true) {
                shipSunk = false;
            } else {
                System.out.println(result+"\n");
            }
        
    } //end checkUserGuess method

    public void finishGame() {

        System.out.println("GAME OVER");
        System.out.println("\n\t\tYou took: " + numOfGuesses + " guesses :|");

    }// end finish game method
}// end class
