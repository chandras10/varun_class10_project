 

import java.util.Objects;

public class SortAlgorithm {

    private final String name;

    protected SortAlgorithm(String nameOfSort) {
        Objects.requireNonNull(nameOfSort);
        this.name = nameOfSort;

    }

    public final String getName() {
        return (name);
    }

    public void sort(SortArray array) {
        System.out.println("Don't know how to sort");
    }

}