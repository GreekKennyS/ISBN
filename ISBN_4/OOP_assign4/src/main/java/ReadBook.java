
public class ReadBook extends Book {

    public ReadBook() {
    }

    public ReadBook(String title, String author, String ISBN, String publisher, int numberPages, int yearPublished, double price) {
        super(title, author, ISBN, publisher, numberPages, yearPublished, price);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
