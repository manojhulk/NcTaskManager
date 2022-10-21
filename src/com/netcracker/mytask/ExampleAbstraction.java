package com.netcracker.mytask;
import java.util.*;

public class ExampleAbstraction {
    private String name;
    ArrayList<String> ky=new ArrayList<>();

    public ExampleAbstraction(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
