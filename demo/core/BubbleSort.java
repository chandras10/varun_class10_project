package demo.core;

public class BubbleSort extends SortAlgorithm
{
    public BubbleSort() {
        super("Bubble Sort");
    }
    
    public void sort(SortArray array) {

        for(int i = array.length() -1; i > 0; i--) {
            
            for(int j = 0; j < i-1; j++) {
                if (compare(array, i, j) < 0) {
                    swap(array, i, j);
                }
            }
        }
    }
}
