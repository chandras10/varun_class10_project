package demo.core;

public class SelectionSort extends SortAlgorithm
{
    public SelectionSort() {
        super("Selection Sort");
    }
    
    public void sort(SortArray array) {

        for(int i = 0; i <= array.length(); i++) {
            
            int minIndex = i;
            for(int j = i + 1; j < array.length(); j++) {
                
                if (compare(array, j, minIndex) < 0) {
                    minIndex = j;
                }
                
                swap(array, i, minIndex);
            }
        }
    }
    
    
}
