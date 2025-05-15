public class Dictionary extends Book{

    private int sizeof;
    
    public Dictionary() {
    }

    public Dictionary(String title, String author, String ISBN, String publisher, int numberPages, int yearPublished, double price) {
        super(title, author, ISBN, publisher, numberPages, yearPublished, price);
    }
    
}
