package demo.core;
import java.util.*;

public class BattleGameLauncher {
    
    // instance variables
    
    private GameHelper helper = new GameHelper();
    private ArrayList<BattleGame> enemyList = new ArrayList<BattleGame>();
    private int numOfGuesses = 0;
    
    public void setUpGame() {
        
        BattleGame enemy1 = new BattleGame();
        BattleGame enemy2 = new BattleGame();   //make three Battle game objects
        BattleGame enemy3 = new BattleGame();
    
        enemy1.setName("Ogre");
        enemy2.setName("Goblin");   //naming the three objects
        enemy3.setName("Reptile");
        
        enemyList.add(enemy1);
        enemyList.add(enemy2);    //add the "enemies" to the enemyList ArrayList
        enemyList.add(enemy3);
        
        //  Some instruction to the player...
        
        System.out.println("You are in a dungeon...");
        System.out.println("3 enemies, an ogre, a goblin and a reptile");
        System.out.println("You are to destroy them with your magic...");
        
        for (BattleGame BattleGameToSet : enemyList) {
            
            ArrayList<String> newLocation = helper.placeEnemy(3);
            BattleGameToSet.setLocationCells(newLocation);
            
        } // end for
        
    } // end setUpGame method
    
    public void startPlaying() {
        
        while(!enemyList.isEmpty()) {
            
            String userGuess = helper.getUserInput("enter a guess");
            checkUserGuess(userGuess);
            
        }//end while
        
        finishGame();
        
    } // end startPlaying method
    
    public void checkUserGuess(String userGuess) {
        
        numOfGuesses++;
        String result = "miss";
        
        for (BattleGame enemyToSet: enemyList) {
            
            result = enemyToSet.check(userGuess);
            
            if(result.equals("hit")) {
                break;
            }else if(result.equals("kill")){
                enemyList.remove(enemyToSet);
                break;
            }
            
        } // end for
        
        System.out.println(result);
        
    } //end checkUserGuess method
    
    public void finishGame() {
        
        System.out.println("GAME OVER");
       
        if (numOfGuesses <= 18)
            System.out.println("GOD LEVEL");
        else 
            System.out.println("Nice...");
            
    }// end finish game method
    
    public static void main() {
        
        BattleGameLauncher game = new BattleGameLauncher();
        game.setUpGame();
        game.startPlaying();
        
    }// end main
    
}// end class
