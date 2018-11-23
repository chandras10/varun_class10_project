package demo.core;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class BattleGameLauncher {
    
    // instance variables
    
    private GameHelper helper = new GameHelper();
    private ArrayList<BattleGame> enemyList = new ArrayList<BattleGame>();
    private int numOfGuesses = 0;
    
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
        
        GridDrawer theGrid = new GridDrawer(); // draw the grid
        theGrid.go();
        
        //  Some instruction to the player...
        
        JOptionPane.showMessageDialog(null, "You need to sink three battle ships");
        
        for (BattleGame BattleGameToSet : enemyList) {
            
            ArrayList<String> newLocation = helper.placeEnemy(3);
            BattleGameToSet.setLocationCells(newLocation);
            
        } // end for
        
    } // end setUpGame method
    
    public void startPlaying() {
        
        while(!enemyList.isEmpty()) {
            
            String userGuess = helper.getUserInput("Enter a guess: ");
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
                break;
            }else if(result.equals("sunk")){
                enemyList.remove(enemyToSet);
                System.out.println("You sunk: "+ enemyToSet.getName());
                break;
            }
            
        } // end for
        
        System.out.println(result);
        
    } //end checkUserGuess method
    
    public void finishGame() {
        
        System.out.println("GAME OVER");
       
        if (numOfGuesses <= 18)
            System.out.println("Time to play another game. Try your GF's fucking feelings this time.");
        else 
            System.out.println("You lost");
            
    }// end finish game method
    
    public static void main() {
        
        BattleGameLauncher game = new BattleGameLauncher();
        game.setUpGame();
        game.startPlaying();
        
    }// end main
    
}// end class
