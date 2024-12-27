package com.nikijv.javacollectionsproject3;
import com.nikijv.javacollectionsproject3.database.Database;
public class Main {
    public static void main(String[] args) {
        Database db = new Database();
        while(true) {
            System.out.print("""
                    Choose an option: \
                    
                    1. Print database \
                    
                    2. Print person by id \
                    
                    3. Print data by fine type \
                    
                    4. Print data by town \
                    
                    5. Add person \
                    
                    6. Add fine \
                    
                    7. Delete fine \
                    
                    8. Edit person \
                    
                    9. Exit""");
            System.out.println();
            int choice = db.scanner.nextInt();
            db.scanner.nextLine();
            System.out.println();
            switch (choice) {
                case 1: db.printDatabase(); break;
                case 2: db.printDataById(); break;
                case 3: db.printDataByFine(); break;
                case 4: db.printDataByTown(); break;
                case 5: db.addPerson(); break;
                case 6: db.addFine(); break;
                case 7: db.deleteFine(); break;
                case 8: db.editPerson(); break;
                case 9: break;
                default: System.out.println("Wrong option"); break;
            }
            if (choice == 9)
                break;
        }
        db.scanner.close();
    }
}
