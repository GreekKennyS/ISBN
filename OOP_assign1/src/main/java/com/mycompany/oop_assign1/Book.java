package com.mycompany.oop_assign1;

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
        if(yearPublished >999 && yearPublished <1000){
        this.yearPublished = yearPublished;
        }else{
            System.out.println("Invalid year value must be 4 digits!!!");
        }
    }
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" + "title=" + title + ", author=" + author + ", ISBN=" + ISBN + ", publisher=" + publisher + ", numberPages=" + numberPages + ", yearPublished=" + yearPublished + ", price=" + price + '}';
    }
    
    
}
