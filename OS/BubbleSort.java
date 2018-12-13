package OS;

 

public class BubbleSort extends SortAlgorithm
{
    public BubbleSort() {
        super("Bubble Sort");
    }
    
    public void sort(SortArray array) {
        for(int i = array.length(); i >= 1; i--) {
            
            for(int j = 0; j < i-1; j++) {
                if (array.compare(j, j+1) > 0) {
                    array.swap(j, j+1);
                }
            }
        }
    }
}
