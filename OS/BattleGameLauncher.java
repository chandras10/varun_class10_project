package OS;

import java.util.*;
import java.awt.*;
import javax.swing.*;

public class BattleGameLauncher {

    // instance variables

    private GameHelper helper = new GameHelper();
    private ArrayList<BattleGame> enemyList = new ArrayList<BattleGame>();
    private ArrayList<BattleGame> userList = new ArrayList<BattleGame>();

    private int numOfGuesses = 0;
    private String userGuess = "";
    private String compGuess = "";

    private boolean shipSunk = false;

    private GridDrawer theGrid;

    public void setUpGame() {

        System.out.print("\u000C");
        BattleGame enemy1 = new BattleGame();
        BattleGame enemy2 = new BattleGame();   //make three Battle game objects , i.e the computer's battleships
        BattleGame enemy3 = new BattleGame();

        BattleGame user1 = new BattleGame();
        BattleGame user2 = new BattleGame();   //make three Battle game objects , i.e the user's battleships
        BattleGame user3 = new BattleGame();

        enemy1.setName("Enemy Ship 1");
        enemy2.setName("Enemy Ship 2");   //naming the three user objects
        enemy3.setName("Enemy Ship 3");

        user1.setName("Battle Ship 1");
        user2.setName("Battle Ship 2");   //naming the three computer objects
        user3.setName("Battle Ship 3");

        enemyList.add(enemy1);
        enemyList.add(enemy2);    //add the "enemies" to the enemyList ArrayList
        enemyList.add(enemy3);

        userList.add(user1);
        userList.add(user2);    //add the "battleShips" to the userList ArrayList
        userList.add(user3);

        theGrid = new GridDrawer(); // draw the grid
        theGrid.setUpGrid();

        //  Some instruction to the player...

        JOptionPane.showMessageDialog(null, "You need to sink three battle ships");

        for (BattleGame enemyToSet : enemyList) {

            ArrayList<String> newLocation = helper.placeEnemy(3);
            enemyToSet.setLocationCells(newLocation);

            System.out.println("The Enemy Location: ");
            System.out.print(enemyToSet.locationCells + "\t");;

        } // end for

        for (BattleGame userToSet : userList) {

            ArrayList<String> newLocation = helper.placeEnemy(3);//new ArrayList<String>();
            /*newLocation.add("a2");
            newLocation.add("b2");
            newLocation.add("c2");*/
            
            userToSet.setLocationCells(newLocation);

            System.out.println("\nThe User Location: ");
            System.out.print(userToSet.locationCells + "\t");
        } // end for

        startPlaying();
    } // end setUpGame method

    public void startPlaying() {

        while((!enemyList.isEmpty()) || ((!userList.isEmpty()))) {

            userGuess = helper.getUserInput("Enter a guess:");
            if(userGuess.equalsIgnoreCase("Quit")) {
                System.out.println("You gave up :(");
                theGrid.frame.setVisible(false);
                Thread.currentThread().interrupt();
                return;
            }

            compGuess = helper.compGuess();

            try {
                checkUserGuess(userGuess, enemyList);
                Thread.sleep(500);
                checkUserGuess(compGuess, userList);
                Thread.sleep(500);
            } catch (Exception e) {
            }

        }//end while

        finishGame();

    } // end startPlaying method

    public void checkUserGuess(String guess, ArrayList<BattleGame> list) {

        numOfGuesses++;
        String result = "miss";

        if (list == enemyList) {

            for (BattleGame enemyToSet: enemyList) {

                result = enemyToSet.checkYourself(guess);

                if(result.equals("hit")) {
                    theGrid.g1.setState(true, guess);
                    break;
                }else if(result.equals("sunk")){
                    list.remove(enemyToSet);
                    theGrid.g1.setState(true, guess);
                    shipSunk = true;
                    System.out.println("You sunk: "+ enemyToSet.getName() + "\n");
                    break;
                }
            } // end for

        } else if (list == userList) {

            for (BattleGame enemyToSet: userList) {
                result = enemyToSet.checkYourself(guess);
                
                if(result.equals("hit")) {
                    theGrid.g2.setState(true, guess);
                    break;
                }else if(result.equals("sunk")){
                    list.remove(enemyToSet);
                    theGrid.g2.setState(true, guess);
                    shipSunk = true;
                    theGrid.g2.repaint();
                    System.out.println("You sunk: "+ enemyToSet.getName() + "\n");
                    break;
                }
            } // end for

        }

        if (shipSunk == true) {
            shipSunk = false;
        } else {
            System.out.println(result+"\n");
        }

    } //end checkUserGuess method

    public void finishGame() {

        System.out.println("GAME OVER");
        System.out.println("\n\t\tYou took: " + numOfGuesses + " guesses :|");
        theGrid.frame.setVisible(false);
        Thread.currentThread().interrupt();

    }// end finish game method
}// end class
