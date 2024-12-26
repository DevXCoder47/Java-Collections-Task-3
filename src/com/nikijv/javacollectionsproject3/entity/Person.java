package com.nikijv.javacollectionsproject3.entity;
import java.util.ArrayList;
public class Person {
    public final int id;
    public static int count = 0;
    public String name;
    public String town;
    public ArrayList<Fine> fines;
    public Person(String name, String town) {
        count++;
        this.id = count;
        this.name = name;
        this.town = town;
        fines = new ArrayList<>();
    }
    public String toString() {
        return "Person:\n Id: " + id + "\n Name: " + name + "\n Town: " + town + "\n Fines:\n" + showFines();
    }
    private String showFines(){
        StringBuilder fine_string = new StringBuilder();
        for(Fine fine : fines)
            fine_string.append(fine);
        return fine_string.toString();
    }
}
