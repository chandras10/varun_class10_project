package demo.core;

public class SimpleBattleGame {

    private int numberOfHits;
    private int location[];
    
    public void setLocationCells() {
        
        location = new int[3];
        int i = (int)(Math.random() * 7);
        
        location[0] = i;
        location[1] = i+1;
        location[2] = i+2;
    } // end constructor
    
    public void setnumberOfHits() {
        numberOfHits = 0;
    }
    
    public int getnumberOfHits() {
        return(numberOfHits);
    }
    public String check(int g) {
        
        boolean flag = false;
        if((g > 7) || (g < 0))
            return("You idiot...");
            
        for(int i = 0; i < location.length; i++) {
            
            if(g == location[i]) {
                numberOfHits++;
                flag = true;
            }
            
        } // end for
        
        if(flag) {
            return("hit");
        } else {
            return("miss");
        }
    } // end method
}
