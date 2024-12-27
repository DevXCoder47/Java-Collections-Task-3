package com.nikijv.javacollectionsproject3.database;
import com.nikijv.javacollectionsproject3.entity.Fine;
import com.nikijv.javacollectionsproject3.entity.Person;
import java.util.ArrayList;
import java.util.Scanner;
public class Database {
    public ArrayList<Person> data;
    public Scanner scanner;
    public Database() {
        scanner = new Scanner(System.in);
        data = new ArrayList<>();
        fillDatabase();
    }
    public void printDatabase(){
        for(Person p : data){
            System.out.println(p);
        }
    }
    public void printDataById(){
        System.out.print("Enter id: ");
        int id = scanner.nextInt();
        System.out.println();
        for(Person p : data){
            if(p.id == id) {
                System.out.println(p);
                return;
            }
        }
        System.out.println("Id not found");
    }
    public void printDataByFine(){
        System.out.print("Enter fine: ");
        String type = scanner.nextLine();
        int count = 0;
        for(Person p : data){
            for(Fine f : p.fines)
                if(f.type.equals(type)) {
                    System.out.println(p);
                    count++;
                    break;
                }
        }
        if(count == 0)
            System.out.println("Data not found");
    }
    public void printDataByTown(){
        System.out.print("Enter town: ");
        String town = scanner.nextLine();
        int count = 0;
        for(Person p : data){
            if(p.town.equals(town)){
                System.out.println(p);
                count++;
            }
        }
        if(count == 0)
            System.out.println("Data not found");
    }
    public void addPerson(){
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter town: ");
        String town = scanner.nextLine();
        data.add(new Person(name, town));
    }
    public void addFine(){
        System.out.print("Enter id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        for(Person p : data){
            if(p.id == id){
                System.out.print("Enter fine: ");
                String fine = scanner.nextLine();
                System.out.print("Enter fine amount: ");
                double fineAmount = scanner.nextDouble();
                p.fines.add(new Fine(fine, fineAmount));
                return;
            }
        }
        System.out.println("Id not found");
    }
    public void deleteFine(){
        System.out.print("Enter id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        for(Person p : data){
            if(p.id == id){
                if(!p.fines.isEmpty()) {
                    System.out.println("Choose fine: ");
                    for (int i = 0; i < p.fines.size(); i++)
                        System.out.print((i + 1) + ". " + p.fines.get(i));
                    System.out.println();
                    int choice = scanner.nextInt();
                    scanner.nextLine();
                    if (choice < 1 || choice > p.fines.size())
                        System.out.println("Wrong choice");
                    else
                        p.fines.remove(choice - 1);
                }
                else
                    System.out.println("Person has no fines");
                return;
            }
        }
        System.out.println("Id not found");
    }
    public void editPerson(){
        System.out.print("Enter id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        for(Person p : data){
            if(p.id == id){
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                System.out.print("Enter town: ");
                String town = scanner.nextLine();
                System.out.print("Enter fine count: ");
                int fineCount = scanner.nextInt();
                scanner.nextLine();
                ArrayList<Fine> fines = new ArrayList<>();
                if(fineCount > 0) {
                    for (int i = 0; i < fineCount; i++) {
                        System.out.print("Enter fine: ");
                        String fine = scanner.nextLine();
                        System.out.print("Enter fine amount: ");
                        double fineAmount = scanner.nextDouble();
                        scanner.nextLine();
                        fines.add(new Fine(fine, fineAmount));
                    }
                }
                p.name = name;
                p.town = town;
                p.fines = fines;
                return;
            }
        }
        System.out.print("Id nor found");
    }
    private void fillDatabase(){
        Person person1 = new Person("N1", "T1");
        person1.fines.add(new Fine("F1", 10));
        person1.fines.add(new Fine("F2", 20));
        person1.fines.add(new Fine("F3", 30));
        data.add(person1);
        Person person2 = new Person("N2", "T2");
        person2.fines.add(new Fine("F1", 10.20));
        person2.fines.add(new Fine("F2", 20.25));
        data.add(person2);
        Person person3 = new Person("N3", "T1");
        person3.fines.add(new Fine("F2", 10.10));
        person3.fines.add(new Fine("F2", 20.10));
        person3.fines.add(new Fine("F3", 30));
        person3.fines.add(new Fine("F4", 44.01));
        data.add(person3);
        Person person4 = new Person("N4", "T3");
        data.add(person4);
        Person person5 = new Person("N5", "T2");
        person5.fines.add(new Fine("F4", 22.44));
        data.add(person5);
    }
}
