
public class OOP_assign4 {

    public static void main(String[] args) {

        Book[] arrayOfBooks = new Book[10];
        DaySales daySales = new DaySales(arrayOfBooks);

        boolean flagSort = false, flagSortMenu = false;
        int sortMethod = 0;
        int sortByChoice = 0;
        int choice = 0;
        int mainChoice = 0;
        int searchChoice = 0;
        int booktypeChoice = 0;
        int secondChoice = 0;
        int salesChoice = 0;
        int index = 0;
        int tempYear;
        boolean isSorted = false;
        String tempISBN;

        do {
            flagSort = false;
            /*
            System.out.println("\t Λίστα Επιλογών\n"
                    + "1.\tΕισαγωγή στοιχείων νέου βιβλίου\n"
                    + "2.\tΕπεξεργασία καταχωρημένων βιβλίων\n"
                    + "3.\tΠώληση βιβλίου\n"
                    + "4.\tΈξοδος από την εφαρμογή\n"
                    + "\n\tΔώστε Επιλογή (1-4):");
            
            System.out.println("\t Επιλογές Επεξεργασίας Βιβλίων\n"
                    +"1. Αναζήτηση βιβλίου\n"
                    +"2. Ταξινόμηση βιβλίων\n"
                    +"3. Εμφάνιση στοιχείων βιβλίων με τιμή μεταξύ κάποιων ορίων\n"
                    +"4. Εμφάνιση στοιχείων όλων των βιβλίων\n"
                    +"5. Επιστροφή στην Αρχική Λίστα Επιλογών\n"
                    +"\n\tΔώστε Επιλογή (1-5):");
            
            System.out.println("\t Επιλογές Διαχείρισης Πωλήσεων\n"
                    +"1. Καταχώριση Νέας Πώλησης Βιβλίου\n"
                    +"2. Υπολογισμός και εμφάνιση αξίας πωλήσεων\n"
                    +"3. Ημερήσιο best-seller\n"
                    +"4. Εμφάνιση στοιχείων όλων των πωλήσεων.\n"
                    +"5. Επιστροφήσ στην Αρχική Λίστα Επιλογών\n"
                    +"\n\tΔώστε Επιλογή (1-5):");
             */
//            System.out.println("\t Λίστα Επιλογών\n"
//                    + "1.\tΕισαγωγή στοιχείων βιβλίου\n"
//                    + "2.\tΑναζήτηση βιβλίου\n"
//                    + "3.\tΕμφάνιση στοιχείων βιβλίων με τιμή μεταξύ κάποιων ορίων\n"
//                    + "4.\tΤαξινόμηση βιβλίων\n"
//                    + "5.\tΕμφάνιση στοιχείων όλων των βιβλίων\n"
//                    + "6.\tΤέλος\n"
//                    + "\n\tΔώστε Επιλογή (1-6):");

            System.out.println("\t Λίστα Επιλογών\n"
                    + "1.\tΕισαγωγή στοιχείων νέου βιβλίου\n"
                    + "2.\tΕπεξεργασία καταχωρημένων βιβλίων\n"
                    + "3.\tΠώληση βιβλίου\n"
                    + "4.\tΈξοδος από την εφαρμογή\n"
                    + "\n\tΔώστε Επιλογή (1-4):");

            mainChoice = UserInput.getInteger();

            switch (mainChoice) {
                case 1:
                    do {
                        System.out.println("Τι είδος βιβλίου εισάγετε: \n"
                                + "1. Επιστημονικό βιβλίο\n"
                                + "2. Λεξικό");
                        booktypeChoice = UserInput.getInteger();
                    } while (booktypeChoice != 1 && booktypeChoice != 2);

                    if (index < 10) {
                        String ISBNCheck;

                        System.out.println("Εισάγετε τα δεδομένα: (Έτος έκδοσης) (ISBN) (Τίτλος βιβλίου) (Ονοματεπώνυμο συγγραφέα)"
                                + " (Εκδοτικός οίκος) (Αριθμός σελίδων) (Τιμή) ");
//                        String extraField = UserInput.getString();
//                        int extraFieldDictionary = 0;
//                        try {
//                            extraFieldDictionary = Integer.parseInt(extraField);
//                            booktypeChoice = 0;
//                        } catch (Exception e) {
//                            booktypeChoice = 1;
//                        }
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
                                String title = UserInput.getString();
                                String author = UserInput.getString();
                                String publisher = UserInput.getString();
                                int numberOfPages = UserInput.getInteger();
                                double price = UserInput.getDouble();
                                if (booktypeChoice == 1) {
                                    System.out.println("Εισάγετε επιστημονική περιοχή: ");
                                    String scientificField = UserInput.getString();
                                    arrayOfBooks[index] = new Science(title, author, ISBNCheck, publisher, numberOfPages, year, price, scientificField);

                                } else if (booktypeChoice == 2) {
                                    System.out.println("Εισάγετε αριθμό λημμάτων: ");
                                    int numEntries;
                                    do {
                                        numEntries = UserInput.getInteger();
                                        if (numEntries <= 0) {
                                            System.out.println("Μη έγκυρος αριθμός λημμάτων\nΠρέπει να είναι θετικός ακέραιος");
                                        }
                                    } while (numEntries <= 0);
                                    arrayOfBooks[index] = new Dictionary(title, author, ISBNCheck, publisher, numberOfPages, year, price, numEntries);
                                }
                                index++;
                                isSorted = false;
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
                    if (index == 0) {
                        System.out.println("Δεν έχει εισαχθεί κανένα βιβλίο");
                        break;
                    }
                    do {
                        System.out.println("\t Επιλογές Επεξεργασίας Βιβλίων\n"
                                + "1. Αναζήτηση βιβλίου\n"
                                + "2. Ταξινόμηση βιβλίων\n"
                                + "3. Εμφάνιση στοιχείων βιβλίων με τιμή μεταξύ κάποιων ορίων\n"
                                + "4. Εμφάνιση στοιχείων όλων των βιβλίων\n"
                                + "5. Επιστροφή στην Αρχική Λίστα Επιλογών\n"
                                + "\n\tΔώστε Επιλογή (1-5):");
                        secondChoice = UserInput.getInteger();
                    } while (secondChoice != 1 && secondChoice != 2 && secondChoice != 3 && secondChoice != 4 && secondChoice != 5);
                    switch (secondChoice) {
                        case 1:
                            System.out.println("Επιλογή 1 - Αναζήτηση βιβλίου");
                            if (index != 0) {
                                do {

                                    System.out.println("\t Επιλογή Πεδίου Αναζήτησης\n"
                                            + "1.\tISBN\n"
                                            + "2.\tΈτος κυκλοφορίας\n"
                                            + "3.\tΕπιστροφή στην Αρχική Λίστα Επιλογών\n"
                                            + "\n\tΔώστε Επιλογή(1-3):");
                                    searchChoice = UserInput.getInteger();

                                    if (isSorted) {
                                        switch (searchChoice) {
                                            case 1:
                                                System.out.println("Δώστε τιμή ISBN: ");
                                                tempISBN = UserInput.getString();
                                                Book tempISBNBook2 = MyUtils.binSearch(tempISBN, arrayOfBooks);
                                                if (tempISBNBook2 == null) {
                                                    System.out.println("Δεν βρέθηκε βιβλίο με τιμή ISBN: " + tempISBN);
                                                } else {
                                                    System.out.println("Βρέθηκε βιβλίο: " + tempISBNBook2);
                                                }
                                                break;
                                            case 2:
                                                System.out.println("Δώστε έτος έκδοσης: ");
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
                                        }
                                    } else {
                                        switch (searchChoice) {
                                            case 1:
                                                System.out.println("Δώστε τιμή ISBN: ");
                                                tempISBN = UserInput.getString();
                                                Book tempISBNBook = MyUtils.seqSearch(tempISBN, arrayOfBooks);
                                                if (tempISBNBook == null) {
                                                    System.out.println("Δεν βρέθηκε κανένα βιβλίο με τιμή ISBN: " + tempISBN);
                                                } else {
                                                    System.out.println("Βρέθηκε βιβλίο: " + tempISBNBook);
                                                }
                                                break;
                                            case 2:
                                                System.out.println("Δώστε έτος έκδοσης: ");
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
                                            case 3:
                                                System.out.println("Επιστροφή\n");
                                                break;
                                            default:
                                                System.out.println("Λάθος τιμή προσπαθήστε ξανά");
                                                break;
                                        }
                                    }

                                } while (searchChoice != 3 && searchChoice != 2 && searchChoice != 1);
                            }
                            break;
                        case 2:
                            System.out.println("Επιλογή 2 - Ταξινόμηση Βιβλίων");
                            do {
                                if (index == 0) {
                                    System.out.println("Δεν υπάρχουν βιβλία καταχωρημένα!");
                                }
                                System.out.println("\t Επιλογή Πεδίου Αναζήτησης\n"
                                        + "1.\tΌνομα Συγγραφέα\n"
                                        + "2.\tISBN\n"
                                        + "3.\tΈτος κυκλοφορίας\n"
                                        + "4.\tΤιμή Βιβλίων\n"
                                        + "5.\tΕπιστροφή στις Επιλογές Επεξεργασίας Βιβλίων\n"
                                        + "\n\tΔώστε Επιλογή(1-5):");
                                sortByChoice = UserInput.getInteger();

                                switch (sortByChoice) {
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                        do {
                                            System.out.println("\tΕπιλογή Μεθόδου"
                                                    + "\n1. Bubblesort"
                                                    + "\n2. Ταξινόμηση με Εισαγωγή"
                                                    + "\n3. Ταξινόμηση με Επιλογή"
                                                    + "\n4. Γρήγορη Ταξινόμηση"
                                                    + "\n5. Ταξινόμηση με Συγχώνευση"
                                                    + "\n6. Επιστροφή στην Επιλογή Πεδίου Ταξινόμησης"
                                                    + "\n\n\tΔώστε Επιλογή (1-6):");
                                            sortMethod = UserInput.getInteger();
                                            if (index != 0) {
                                                switch (sortMethod) {
                                                    case 1:
                                                        MyUtils.bubbleSort(arrayOfBooks, sortByChoice);
                                                        isSorted = true;
                                                        flagSort = true;
                                                        flagSortMenu = true;
                                                        break;
                                                    case 2:
                                                        MyUtils.insertionSort(arrayOfBooks, sortByChoice);
                                                        isSorted = true;
                                                        flagSort = true;
                                                        flagSortMenu = true;
                                                        break;
                                                    case 3:
                                                        MyUtils.selectionSort(arrayOfBooks, sortByChoice);
                                                        isSorted = true;
                                                        flagSort = true;
                                                        flagSortMenu = true;

                                                        break;
                                                    case 4:
                                                        MyUtils.quickSort(arrayOfBooks, sortByChoice);
                                                        isSorted = true;
                                                        flagSort = true;
                                                        flagSortMenu = true;

                                                        break;
                                                    case 5:
                                                        MyUtils.mergeSort(arrayOfBooks, sortByChoice);
                                                        isSorted = true;
                                                        flagSort = true;
                                                        flagSortMenu = true;

                                                        break;
                                                    case 6:
                                                        System.out.println("Επιστροφή");
                                                        flagSort = true;
                                                        flagSortMenu = true;
                                                        break;
                                                    default:
                                                        System.out.println("Λάθος επιλογή μεθόδου προσπαθήστε ξανά");
                                                        break;
                                                }
                                            }
                                        } while (!flagSort);
                                        break;
                                    case 5:
                                        flagSortMenu = true;
                                        break;
                                    default:
                                        System.out.println("Λάθος τιμή προσπαθήστε ξανά");
                                        break;
                                }
                            } while (!flagSortMenu);

                            break;

                        case 3:
                            System.out.println("Επιλογή 3 - Φιλτράρισμα βιβλίων βάσει τιμής");
                            if (index != 0) {
                                System.out.println("Δώστε την Ελάχιστη τιμή: ");

                                double minimumPrice = UserInput.getDouble();

                                System.out.println("Δώστε την Μέγιστη τιμή: ");
                                double maximumPrice = UserInput.getDouble();

                                MyUtils.valueSearch(arrayOfBooks, minimumPrice, maximumPrice);
                            } else {
                                System.out.println("Δεν υπάρχουν βιβλία καταχωρημένα!");
                            }
                            break;
                        case 4:
                            System.out.println("Επιλογή 4 - Προβολή όλων των βιβλίων");
                            for (int i = 0; i < 10; i++) {
                                if (arrayOfBooks[i] != null) {
                                    System.out.println(arrayOfBooks[i]);
                                }
                            }
                            break;
                    }
                    break;
                case 3:
                    if (index == 0) {
                        System.out.println("Δεν έχει εισαχθεί κανένα βιβλίο");
                        break;
                    }
                    do {
                        System.out.println("\t Επιλογές Διαχείρισης Πωλήσεων"
                                + "\n1. Καταχώριση Νέας Πώλησης Βιβλίου"
                                + "\n2. Υπολογισμός και εμφάνιση αξίας πωλήσεων"
                                + "\n3. Ημερήσιο best-seller"
                                + "\n4. Εμφάνιση στοιχείων όλων των πωλήσεων."
                                + "\n5. Επιστροφή στην Αρχική Λίστα Επιλογών\n"
                                + "\n\tΔώστε Επιλογή(1-5):");
                        salesChoice = UserInput.getInteger();
                        switch (salesChoice) {
                            case 1:
                                System.out.println("Εισάγετε ISBN: ");
                                String sellISBN = UserInput.getString();
                                System.out.println("Εισάγετε ποσότητα: ");
                                int quantity = UserInput.getInteger();
                                daySales.sellBook(sellISBN, quantity);
                                break;
                            case 2:
                                daySales.calculateTotalSales();
                                break;
                            case 3:
                                if (daySales.getBestSeller() == null) {
                                    System.out.println("Δεν έχει καταχωρηθεί καμία Πώληση Βιβλίου");
                                } else {
                                    System.out.println("Best-Seller: " + daySales.getBestSeller());
                                }
                                break;
                            case 4:
                                daySales.displaySales();
                                break;
                            case 5:
                                break;
                        }
                    } while (salesChoice != 5 && salesChoice != 4 && salesChoice != 3 && salesChoice != 2 && salesChoice != 1);

                    break;
                case 4:
                    System.out.println("Έξοδος από το πρόγραμμα");
                    break;
                default:
                    System.out.println("Λάθος επιλογή! Προσπαθήστε ξανά");
                    break;
            }
        } while (mainChoice != 4);
    }
}
