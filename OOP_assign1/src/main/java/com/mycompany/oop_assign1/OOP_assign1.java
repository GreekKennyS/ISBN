package com.mycompany.oop_assign1;

public class OOP_assign1 {


    static boolean correctISBN(String ISBN, int year) {
        int[] ISBN10 = new int[10];
        int[] ISBN13 = new int[13];

        int sum = 0;

        if (ISBN.length() == 10 || ISBN.length() == 13) {

            if (year > 2006) {
                for (int i = 0; i < 13; i++) {
                    ISBN13[i] = Character.getNumericValue(ISBN.charAt(i));
                }
                for (int i = 0; i < 13; i += 2) {
                    sum += ISBN13[i];
                }
                for (int i = 1; i < 13; i += 2) {
                    sum += ISBN13[i] * 3;
                }
                System.out.println("Sum Check is " + sum);
                if (sum % 10 == 0) {
                    return true;
                } else {
                    System.out.println("Λάθος τιμή ISBN προσπαθήστε ξανά");
                    return false;
                }
            } else {
                for (int i = 0; i < 10; i++) {
                    ISBN10[i] = Character.getNumericValue(ISBN.charAt(i));
                }
                for (int i = 0; i < 10; i++) {
                    sum += (10 - i) * ISBN10[i];
                }
                System.out.println("Sum Check is " + sum);
                if (sum % 11 == 0) {
                    return true;
                } else {
                    System.out.println("Λάθος τιμή ISBN προσπαθήστε ξανά");
                    return false;
                }
            }

        }
        return false;
    }
    static void InsertBook(Book[] arrayOfBooks, int index) {

        int[] ISBN10 = new int[10];
        int[] ISBN13 = new int[13];
        int sum = 0;
        boolean flag = true;
        String ISBNCheck;

        System.out.println("Εισάγετε τα δεδομένα: (Έτος έκδοσης) (ISBN) (Τίτλος βιβλίου) (Ονοματεπώνυμο συγγραφέα)"
                + " (Εκδοτικός οίκος) (Αριθμός σελίδων) (Τιμή) ");

        int year = UserInput.getInteger();

        for (;;) {
            if (year < 1000 || year > 9999) {
                System.out.println("Λάθος τιμή Έτος έκδοσης προσπαθήστε ξάνα");
                year = UserInput.getInteger();
            } else {
                break;
            }
        }

        for (;;) {
            ISBNCheck = UserInput.getString();
            if (correctISBN(ISBNCheck, year)) {
                break;
            }

            return;
        }
         arrayOfBooks[index] = new Book(UserInput.getString(), UserInput.getString(), ISBNCheck, UserInput.getString(),
                    UserInput.getInteger(), year,
                    UserInput.getDouble());

    }
    
    public static void main(String[] args) {

        Book[] arrayOfBooks = new Book[10];
        
        int choice = 0;
        int index = 0;
        int tempYear;
        String tempISBN;
        
        do {
            System.out.println("\tΛίστα Επιλογών\n"
                    + "1. Εισαγωγή στοιχείων βιβλίου\n"
                    + "2. Αναζήτηση βιβλίου\n"
                    + "3. Εμφάνιση στοιχείων βιβλίων με τιμή μεταξύ κάποιων ορίων\n"
                    + "4. Εμφάνιση στοιχείων όλων των βιβλίων\n"
                    + "5. Τέλος\n"
                    + "\n  Δώστε Επιλογή (1-4):");
            choice = UserInput.getInteger();

            switch (choice) {
                case 1:
                    System.out.println("1 selected - Εισαγωγή στοιχείων βιβλίου");

                    if(index < 10){
                    InsertBook(arrayOfBooks,index);
                    index++;
                    }else{
                        System.out.println("Ο πίνακας είναι γεμάτος δεν θα γίνει η εισαγωγή");
                    }

                    break;
                case 2:
                    System.out.println("2 selected - Αναζήτηση βιβλίου");
                    do{
                        System.out.println("\tΕπιλογή Πεδίου Αναζήτησης\n"
                                        + "1. ISBN\n"
                                        + "2.Έτος κυκλοφορίας\n"
                                        + "3.Επιστροφή στην Αρχική Λίστα Επιλογών\n\n"
                                        + "  Δώστε Επιλογή(1-3):");
                        choice = UserInput.getInteger();
                        switch(choice){
                            case 1:
                                do{
                                    System.out.println("\tΕπιλογή Μεθόδου Αναζήτησης\n"
                                                    + "1. Σειριακή Αναζήτηση\n"
                                                    + "2. Δυαδική Αναζήτηση\n"
                                                    + "3. Επιστροφή στην Επιλογή Πεδίου Αναζήτησης\n"
                                                    + "\nΔώστε Επιλογή (1-3):");
                                    choice = UserInput.getInteger();
                                }while(choice !=3);
                                    switch(choice){
                                        case 1:
                                            System.out.println("1 επιλέχτηκε - Σειριακή Αναζήτηση\n"
                                                            + "Δώστε τιμή ISBN: ");
                                            tempISBN = UserInput.getString();
                                            Book tempISBNBook = MyUtils.seqSearch(tempISBN,arrayOfBooks);
                                            if(tempISBNBook == null){
                                                System.out.println("Δεν βρέθηκε βιβλίο");
                                            }else{
                                            System.out.println("Βρέθηκε βιβλίο: "+tempISBNBook);
                                            }
                                            break;
                                        case 2:
                                            System.out.println("2 επιλέχτηκε - Δυαδική Αναζήτηση"
                                                            + "Δώστε τιμή ISBN: ");
                                            tempISBN = UserInput.getString();
                                            Book tempISBNBook2 = MyUtils.seqSearch(tempISBN,arrayOfBooks);
                                            if(tempISBNBook2 == null){
                                                System.out.println("Δεν βρέθηκε βιβλίο");
                                            }else{
                                            System.out.println("Βρέθηκε βιβλίο: "+tempISBNBook2);
                                            }
                                            break;
                                        case 3:
                                            System.out.println("Επιστροφή πίσω");
                                            break;
                                        default:
                                            System.out.println("Κάτι πήγε λάθος!");
                                            break;
                                    }
                                break;
                            case 2:
                                do{
                                    System.out.println("\tΕπιλογή Μεθόδου Αναζήτησης\n"
                                                    + "1. Σειριακή Αναζήτηση\n"
                                                    + "2. Δυαδική Αναζήτηση\n"
                                                    + "3. Επιστροφή στην Επιλογή Πεδίου Αναζήτησης\n"
                                                    + "\nΔώστε Επιλογή (1-3):");
                                    choice = UserInput.getInteger();
                                }while(choice !=3);
                                    switch(choice){
                                        case 1:
                                            System.out.println("1 επιλέχτηκε - Σειριακή Αναζήτηση\n"
                                                            + "Δώστε χρονιά: ");
                                            tempYear = UserInput.getInteger();
                                            Book[] result = MyUtils.seqSearch(tempYear,arrayOfBooks);
                                            if(result == null || result.length == 0){
                                                System.out.println("Δεν βρέθηκαν βιβλία");
                                            }else{
                                             for(int i = 0; i<result.length; i++){
                                                    System.out.println(result[i]);
                                                }
                                            }
                                            break;
                                        case 2:
                                            System.out.println("2 επιλέχτηκε - Δυαδική Αναζήτηση"
                                                            + "Δώστε χρονιά: ");
                                            tempYear = UserInput.getInteger();
                                            Book[] result2 = MyUtils.seqSearch(tempYear,arrayOfBooks);
                                            if(result2 == null || result2.length == 0){
                                                System.out.println("Δεν βρέθηκαν βιβλία");
                                            }else{
                                             for(int i = 0; i<result2.length; i++){
                                                    System.out.println(result2[i]);
                                                }
                                            }
                                            break;
                                        case 3:
                                            System.out.println("Επιστροφή πίσω");
                                            break;
                                        default:
                                            System.out.println("Κάτι πήγε λάθος!");
                                            break;
                                    }
                                break;
                            case 3:
                                System.out.println("Επιστροφή πίσω");
                                break;
                            default:
                                System.out.println("Λάθος τιμή προσπαθήστε ξανά.");
                                break;
                        }
                    }while(choice != 3);
                    break;
                case 3:
                    System.out.println("3 selected - Φιλτράρισμα βιβλίων βάσει τιμής");
                    break;
                case 4:
                    System.out.println("4 selected - Προβολή όλων των βιβλίων");
                    for(int i = 0; i<10; i++){
                        if(arrayOfBooks[i] != null){
                            arrayOfBooks[i].toString();
                        }
                    }
                    break;
                case 5:
                    System.out.println("Έξοδος από το πρόγραμμα.");
                    break;
                default:
                    System.out.println("Λάθος επιλογή! Προσπαθήστε ξανά.");
                    break;
            }

        } while (choice != 5);
    }
}
