package demo.core;
import java.util.*;

public class SimpleBattleGameTest {
    
    public static void main() {
        
        Scanner sc = new Scanner(System.in);
        
        SimpleBattleGame enemy = new SimpleBattleGame();
        enemy.setnumberOfHits();
        enemy.setLocationCells();
        
        System.out.println("You are in a dungeon...");
        System.out.println("There are 7 rooms in front of you\nthere are three rooms with an ogre in them.");
        System.out.println("You are to destroy with your magic...");
        int hits = 0;
        int guesses = 0;
        while (hits < 2) {
            hits = enemy.getnumberOfHits();
            System.out.print("Pick a room: \t");
            int guess = sc.nextInt();
            
            System.out.println(enemy.check(guess));
            guesses++;
        }// end while
        
        if (guesses <= 3)
            System.out.println("GOD LEVEL");
        else if((guesses > 3 && guesses <= 6))
            System.out.println("GREAT JOB");
        else 
            System.out.println("Nice...");
    } // end main
    
}// end class
