package com.mycompany.oop_assign2;

public class Book {

    private String title;
    private String author;
    private String ISBN;
    private String publisher;
    private int numberPages;
    private int yearPublished;
    private double price;

    public Book() {
    }

    public Book(String title, String author, String ISBN, String publisher, int numberPages, int yearPublished, double price) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.numberPages = numberPages;
        this.yearPublished = yearPublished;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getNumberPages() {
        return numberPages;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public double getPrice() {
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setNumberPages(int numberPages) {
        this.numberPages = numberPages;
    }

    public void setYearPublished(int yearPublished) {
        if (yearPublished > 999 && yearPublished < 1000) {
            this.yearPublished = yearPublished;
        } else {
            System.out.println("Μη έγκυρος αριθμός Έτους Έκδοσης\nΠρέπει να είναι τετραψήφιος ακέραιος");
        }
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Βιβλίο{" + "Τίτλος βιβλίου: " + title + ", Συγγραφέας: " + author + ", ISBN: " + ISBN + ", Εκδοτικός οίκος: " + publisher + ", Αριθμός σελίδων: " + numberPages + ", Έτος έκδοσης: " + yearPublished + ", Τιμή: " + price + '}';
    }

    public static boolean correctISBN(String ISBN, int year) {

        int sum = 0;

        if (ISBN.length() == 10 && year < 2007) {

            for (int i = 0; i < 10; i++) {
                sum += (10 - i) * (ISBN.charAt(i) - '0');
            }

            if (sum % 11 == 0) {
                return true;
            } else {
                System.out.println("Λάθος τιμή ISBN προσπαθήστε ξανά");
                return false;
            }

        } else if (ISBN.length() == 13 && year > 2006) {
            
            for (int i = 0; i < 13; i += 2) {
                sum += ISBN.charAt(i);
            }
            for (int i = 1; i < 13; i += 2) {
                sum += ISBN.charAt(i) * 3;
            }

            if (sum % 10 == 0) {
                return true;
            } else {
                System.out.println("Λάθος τιμή ISBN προσπαθήστε ξανά");
                return false;
            }
        } else {
            System.out.println("Μη έγκυρο μέγεθος ISBN\nΠρέπει να είναι είτε 10 είτε 13 ψηφία ανάλογα με το έτος έκδοσης");
        }
        return false;
    }

}
