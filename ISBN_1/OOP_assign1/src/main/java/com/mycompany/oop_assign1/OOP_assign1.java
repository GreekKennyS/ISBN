package com.mycompany.oop_assign1;

public class OOP_assign1 {

    public static void main(String[] args) {

        Book[] arrayOfBooks = new Book[10];

        int choice = 0;
        int index = 0;
        int tempYear;
        String tempISBN;

        do {
            System.out.println("\t Λίστα Επιλογών\n"
                    + "1.\tΕισαγωγή στοιχείων βιβλίου\n"
                    + "2.\tΑναζήτηση βιβλίου\n"
                    + "3.\tΕμφάνιση στοιχείων βιβλίων με τιμή μεταξύ κάποιων ορίων\n"
                    + "4.\tΕμφάνιση στοιχείων όλων των βιβλίων\n"
                    + "5.\tΤέλος\n"
                    + "\n\tΔώστε Επιλογή (1-4):");
            choice = UserInput.getInteger();

            switch (choice) {
                case 1:
                    System.out.println("Επιλογή 1 - Εισαγωγή στοιχείων βιβλίου");

                    if (index < 10) {
                        String ISBNCheck;

                        System.out.println("Εισάγετε τα δεδομένα: (Έτος έκδοσης) (ISBN) (Τίτλος βιβλίου) (Ονοματεπώνυμο συγγραφέα)"
                                + " (Εκδοτικός οίκος) (Αριθμός σελίδων) (Τιμή) ");

                        int year = UserInput.getInteger();

                        for (;;) {
                            if (year < 1000 || year > 9999) {
                                System.out.println("Μη έγκυρος αριθμός Έτους Έκδοσης\nΠρέπει να είναι τετραψήφιος ακέραιος");
                                year = UserInput.getInteger();
                            } else {
                                break;
                            }
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
                    System.out.println("Επιλογή 4 - Προβολή όλων των βιβλίων");
                    for (int i = 0; i < 10; i++) {
                        if (arrayOfBooks[i] != null) {
                            System.out.println(arrayOfBooks[i]);
                        }
                    }
                    break;
                case 5:
                    System.out.println("Έξοδος από το πρόγραμμα");
                    break;
                default:
                    System.out.println("Λάθος επιλογή! Προσπαθήστε ξανά");
                    break;
            }

        } while (choice != 5);
    }
}
