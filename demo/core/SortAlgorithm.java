package demo.core;

import java.util.Objects;

public class SortAlgorithm
{

    private final String name;

    protected SortAlgorithm(String name) {
        Objects.requireNonNull(name);
        this.name = name;

    }

    public final String getName() {
        return (name);
    }

    public void sort(SortArray array) {
        System.out.println("Don't know how to sort");
    }

}