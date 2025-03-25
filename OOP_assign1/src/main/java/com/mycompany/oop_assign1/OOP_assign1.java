package com.mycompany.oop_assign1;

public class OOP_assign1 {

    static void display(Book[] arrayOfBooks) {

        int choice = 0;
        int index = 0;
        
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
                    break;
                case 3:
                    System.out.println("3 selected - Φιλτράρισμα βιβλίων βάσει τιμής");
                    break;
                case 4:
                    System.out.println("4 selected - Προβολή όλων των βιβλίων");
                    System.out.println(arrayOfBooks[0]);
                    break;
                case 5:
                    System.out.println("Έξοδος από το πρόγραμμα.");
                    break;
                default:
                    System.out.println("Λάθος επιλογή! Προσπαθήστε ξανά.");
            }

        } while (choice != 5);

    }

    static boolean correctISBN(){
        
        
        return true;
    }
    
    static void InsertBook(Book[] arrayOfBooks,int index){
        
        int[] ISBN10 = new int[10];
        int[] ISBN13 = new int[13];
        int sum = 0;
        boolean flag = true;
        String ISBNCheck;

        System.out.println("Εισάγετε τα δεδομένα: (Έτος έκδοσης) (ISBN) (Τίτλος βιβλίου) (Ονοματεπώνυμο συγγραφέα)"
                            + " (Εκδοτικός οίκος) (Αριθμός σελίδων) (Τιμή) ");
        
        int year = UserInput.getInteger();
        
     
        
        for(;;){
        if (year <1000 || year > 9999){
                System.out.println("Λάθος τιμή Έτος έκδοσης προσπαθήστε ξάνα");
                year = UserInput.getInteger();
            }
        else{
            break;
            }
        }    
        
        do{
            ISBNCheck = UserInput.getString();
           
            if(ISBNCheck.length() == 10 || ISBNCheck.length() == 13){
           
               if(year > 2006){
                for(int i = 0; i<13; i++){
                    ISBN13[i] = Character.getNumericValue(ISBNCheck.charAt(i));
                }
                for(int i = 0; i<13; i+=2){
                    sum += ISBN13[i];
                }
                for(int i = 1; i<13; i+=2){
                    sum += ISBN13[i] * 3;
                }
                if(sum%10 == 0){
                    flag = false;
                }else{
                    System.out.println("Λάθος τιμή ISBN προσπαθήστε ξανά");
                }
            }
            else{
                 for(int i = 0; i<10; i++){
                    ISBN10[i] = Character.getNumericValue(ISBNCheck.charAt(i));
                }
                //NOT FINISHED!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!NOT FINISHED
                 for(int i = 0; i<10; i++){
                    sum += (10 - i) * ISBN10[i];
                }
                if(sum%11 == 0){
                    flag = false;
                }else{
                    System.out.println("Λάθος τιμή ISBN προσπαθήστε ξανά");
                }
            }
            
         }
           else{
               System.out.println("Λάθος τιμή ISBN προσπαθήστε ξανά");
           }
           
        }while(flag);
        
        
        arrayOfBooks[index] = new Book (UserInput.getString(),UserInput.getString(),ISBNCheck,UserInput.getString(),
                                        UserInput.getInteger(),year,
                                        UserInput.getDouble());
        return;
    }
    
    public static void main(String[] args) {

        Book[] arrayOfBooks = new Book[10];
        
        display(arrayOfBooks);
       
    
    
    }
}
