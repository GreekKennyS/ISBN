package com.mycompany.oop_assign2;

public class OOP_assign2 {

    public static void main(String[] args) {

        boolean sortedFlag = false;

        Book[] arrayOfBooks = new Book[10];

        int sortMethod = 0;
        int sortByChoice;
        int choice = 0;
        int mainChoice;
        int searchChoice;
        int sortChoice;
        int index = 0;
        int tempYear;
        String tempISBN;

        do {
            System.out.println("\t Λίστα Επιλογών\n"
                    + "1.\tΕισαγωγή στοιχείων βιβλίου\n"
                    + "2.\tΑναζήτηση βιβλίου\n"
                    + "3.\tΕμφάνιση στοιχείων βιβλίων με τιμή μεταξύ κάποιων ορίων\n"
                    + "4.\tΤαξινόμηση βιβλίων\n"
                    + "5.\tΕμφάνιση στοιχείων όλων των βιβλίων\n"
                    + "6.\tΤέλος\n"
                    + "\n\tΔώστε Επιλογή (1-6):");
            choice = UserInput.getInteger();

            switch (choice) {
                case 1:
                    System.out.println("Επιλογή 1 - Εισαγωγή στοιχείων βιβλίου");

                    if (index < 10) {
                        String ISBNCheck;

                        System.out.println("Εισάγετε τα δεδομένα: (Έτος έκδοσης) (ISBN) (Τίτλος βιβλίου) (Ονοματεπώνυμο συγγραφέα)"
                                + " (Εκδοτικός οίκος) (Αριθμός σελίδων) (Τιμή) ");

                        int year = UserInput.getInteger();

                        if (year < 1000 || year > 9999) {
                            do {
                                System.out.println("Μη έγκυρος αριθμός Έτους Έκδοσης\nΠρέπει να είναι τετραψήφιος ακέραιος");
                                year = UserInput.getInteger();
                            } while (year < 1000 || year > 9999);
                        }

                        for (;;) {
                            ISBNCheck = UserInput.getString();
                            if (ISBNCheck.equals("0")) {
                                break;
                            }

                            if (Book.correctISBN(ISBNCheck, year)) {
                                arrayOfBooks[index] = new Book(UserInput.getString(), UserInput.getString(), ISBNCheck, UserInput.getString(),
                                        UserInput.getInteger(), year,
                                        UserInput.getDouble());
                                index++;
                                sortedFlag = false;
                                break;
                            } else {
                                System.out.println("Πατήστε 0 για ακύρωση καταχώρησης βιβλίου");
                            }

                        }

                    } else {
                        System.out.println("Ο πίνακας είναι γεμάτος\nΔεν μπορεί να πραγματοποιηθεί άλλη εισαγωγή βιβλίου");
                    }

                    break;
                case 2:
                    System.out.println("Επιλογή 2 - Αναζήτηση βιβλίου");
                    do {
                        System.out.println("\t Επιλογή Πεδίου Αναζήτησης\n"
                                + "1.\tISBN\n"
                                + "2.\tΈτος κυκλοφορίας\n"
                                + "3.\tΕπιστροφή στην Αρχική Λίστα Επιλογών\n"
                                + "\n\tΔώστε Επιλογή(1-3):");
                        choice = UserInput.getInteger();
                        switch (choice) {
                            case 1:
                                do {
                                    System.out.println("\t Επιλογή Μεθόδου Αναζήτησης\n"
                                            + "1.\tΣειριακή Αναζήτηση\n"
                                            + "2.\tΔυαδική Αναζήτηση (Προσοχή ο πίνακας πρέπει\n"
                                            + "\tνα είναι ταξινομημένος κατά το πεδίο αναζήτησης) \n"
                                            + "3.\tΕπιστροφή στην Επιλογή Πεδίου Αναζήτησης\n"
                                            + "\n\tΔώστε Επιλογή (1-3):");
                                    choice = UserInput.getInteger();

                                    switch (choice) {
                                        case 1:
                                            System.out.println("Επιλογή 1 - Σειριακή Αναζήτηση\n"
                                                    + "Δώστε τιμή ISBN: ");
                                            tempISBN = UserInput.getString();
                                            Book tempISBNBook = MyUtils.seqSearch(tempISBN, arrayOfBooks);
                                            if (tempISBNBook == null) {
                                                System.out.println("Δεν βρέθηκε κανένα βιβλίο με τιμή ISBN: " + tempISBN);
                                            } else {
                                                System.out.println("Βρέθηκε βιβλίο: " + tempISBNBook);
                                            }
                                            break;
                                        case 2:
                                            System.out.println("Επιλογή 2 - Δυαδική Αναζήτηση"
                                                    + "Δώστε τιμή ISBN: ");
                                            tempISBN = UserInput.getString();
                                            Book tempISBNBook2 = MyUtils.binSearch(tempISBN, arrayOfBooks);
                                            if (tempISBNBook2 == null) {
                                                System.out.println("Δεν βρέθηκε βιβλίο με τιμή ISBN: " + tempISBN);
                                            } else {
                                                System.out.println("Βρέθηκε βιβλίο: " + tempISBNBook2);
                                            }
                                            break;
                                        case 3:
                                            System.out.println("Επιστροφή\n");
                                            break;
                                        default:
                                            System.out.println("Λάθος τιμή προσπαθήστε ξανά");
                                            break;
                                    }
                                } while (choice != 3);
                                break;
                            case 2:
                                do {
                                    System.out.println("\t Επιλογή Μεθόδου Αναζήτησης\n"
                                            + "1.\tΣειριακή Αναζήτηση\n"
                                            + "2.\tΔυαδική Αναζήτηση (Προσοχή ο πίνακας πρέπει\n"
                                            + "\tνα είναι ταξινομημένος κατά το πεδίο αναζήτησης)\n"
                                            + "3.\tΕπιστροφή στην Επιλογή Πεδίου Αναζήτησης\n"
                                            + "\n\tΔώστε Επιλογή (1-3):");
                                    choice = UserInput.getInteger();

                                    switch (choice) {
                                        case 1:
                                            System.out.println("Επιλογή 1 - Σειριακή Αναζήτηση\n"
                                                    + "Δώστε έτος έκδοσης: ");
                                            tempYear = UserInput.getInteger();
                                            Book[] result = MyUtils.seqSearch(tempYear, arrayOfBooks);
                                            if (result == null || result.length == 0) {
                                                System.out.println("Δεν βρέθηκαν βιβλία με τιμή χρονιάς: " + tempYear);
                                            } else {
                                                for (int i = 0; i < result.length; i++) {
                                                    System.out.println(result[i]);
                                                }
                                            }
                                            break;
                                        case 2:
                                            System.out.println("2 επιλέχτηκε - Δυαδική Αναζήτηση"
                                                    + "Δώστε έτος έκδοσης: ");
                                            tempYear = UserInput.getInteger();
                                            Book[] result2 = MyUtils.binSearch(tempYear, arrayOfBooks);
                                            if (result2 == null || result2.length == 0) {
                                                System.out.println("Δεν βρέθηκαν βιβλία με τιμή έτους έκδοσης: " + tempYear);
                                            } else {
                                                for (int i = 0; i < result2.length; i++) {
                                                    if (result2[i] != null) {
                                                        System.out.println(result2[i]);
                                                    }
                                                }
                                            }
                                            break;
                                        case 3:
                                            System.out.println("Επιστροφή\n");
                                            break;
                                        default:
                                            System.out.println("Κάτι πήγε λάθος!");
                                            break;
                                    }
                                } while (choice != 3);
                                break;
                            case 3:
                                System.out.println("Επιστροφή\n");
                                break;
                            default:
                                System.out.println("Λάθος τιμή προσπαθήστε ξανά");
                                break;
                        }
                    } while (choice != 3);
                    break;
                case 3:
                    System.out.println("Επιλογή 3 - Φιλτράρισμα βιβλίων βάσει τιμής");

                    System.out.println("Δώστε την Ελάχιστη τιμή: ");
                    double minimumPrice = UserInput.getDouble();

                    System.out.println("Δώστε την Μέγιστη τιμή: ");
                    double maximumPrice = UserInput.getDouble();

                    MyUtils.valueSearch(arrayOfBooks, minimumPrice, maximumPrice);

                    break;
                case 4:
                    System.out.println("Επιλογή 4 - Ταξινόμηση Βιβλίων");
                    do {
                        System.out.println("\t Επιλογή Πεδίου Αναζήτησης\n"
                                + "1.\tΌνομα Συγγραφέα\n"
                                + "2.\tISBN\n"
                                + "3.\tΈτος κυκλοφορίας\n"
                                + "4.\tΤιμή Βιβλίων\n"
                                + "5.\tΕπιστροφη΄στην Αρχική Λίστα Επιλογών\n"
                                + "\n\tΔώστε Επιλογή(1-5):");
                        sortByChoice = UserInput.getInteger();

                        switch (sortByChoice) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                                do{
                                System.out.println("\tΕπιλογή Μεθόδου"
                                        + "\n1. Bubblesort"
                                        + "\n2. Ταξινόμηση με Εισαγωγή"
                                        + "\n3. Ταξινόμηση με Επιλογή"
                                        + "\n4. Γρήγορη Ταξινόμηση"
                                        + "\n5. Ταξινόμηση με Συγχώνευση"
                                        + "\n6. Επιστροφή στην Επιλογή Πεδίου Ταξινόμησης"
                                        + "\n\n\tΔώστε Επιλογή (1-6):");
                                sortMethod = UserInput.getInteger();

                                switch(sortMethod){
                                    case 1:
                                        MyUtils.bubbleSort(arrayOfBooks,sortByChoice);
                                        break;
                                    case 2:
                                        MyUtils.insertionSort(arrayOfBooks, sortByChoice);
                                        break;
                                    case 3:
                                        break;
                                    case 4:
                                        break;
                                    case 5:
                                        break;
                                    case 6:
                                        System.out.println("Επιστροφή");
                                        break;
                                    default:
                                        System.out.println("Λάθος επιλογή μεθόδου προσπαθήστε ξανά");
                                        break;
                                }
                                }while(sortMethod != 6);
                                break;
                            default:
                                System.out.println("Λάθος τιμή προσπαθήστε ξανά");
                                break;
                        }
                    } while (sortByChoice != 5);
                    break;
                case 5:
                    System.out.println("Επιλογή 5 - Προβολή όλων των βιβλίων");
                    for (int i = 0; i < 10; i++) {
                        if (arrayOfBooks[i] != null) {
                            System.out.println(arrayOfBooks[i]);
                        }
                    }
                    break;
                case 6:
                    System.out.println("Έξοδος από το πρόγραμμα");
                    break;
                default:
                    System.out.println("Λάθος επιλογή! Προσπαθήστε ξανά");
                    break;
            }

        } while (choice != 5);
    }
}
