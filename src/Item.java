import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Item {

    //private fields, no need for setters, because once initialized the name and weight won't change
    private String pName;
    private int pWeight;


    //Constructor
    Item(String name, int weight){
        pName = name;
        pWeight = weight;

    }

    //Getters
    public String returnName(){
        return pName;
    }

    public int returnWeight(){
        return pWeight;
    }



}
