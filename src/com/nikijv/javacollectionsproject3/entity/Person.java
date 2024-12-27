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
        return "Person:\nId: " + id + "\nName: " + name + "\nTown: " + town + "\nFines:\n" + showFines();
    }
    private String showFines(){
        StringBuilder fine_string = new StringBuilder();
        if(!fines.isEmpty()) {
            for (Fine fine : fines)
                fine_string.append(fine);
        }
        else
            fine_string.append("No fines\n");
        return fine_string.toString();
    }
}
