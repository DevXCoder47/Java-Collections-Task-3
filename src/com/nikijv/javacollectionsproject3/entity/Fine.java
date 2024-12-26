package com.nikijv.javacollectionsproject3.entity;
public class Fine {
    public String type;
    public double fine_amount;
    public Fine(String type, double fine_amount) {
        this.type = type;
        this.fine_amount = fine_amount;
    }
    public String toString() {
        return "Fine: " + type + " - " + fine_amount + "\n";
    }
}
