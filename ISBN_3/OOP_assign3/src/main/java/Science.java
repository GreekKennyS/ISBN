public class Science extends Book{

    private String scientificField;

    
    public Science() {
    }

    public Science(String title, String author, String ISBN, String publisher, int numberPages, int yearPublished, double price, String scientificField) {
        super(title, author, ISBN, publisher, numberPages, yearPublished, price);
        this.scientificField = scientificField;
    }

    public void setScientificField(String scientificField) {
        this.scientificField = scientificField;
    }
    
    public String getScientificField() {
        return scientificField;
    }

    @Override
    public String toString() {
        return "Science{" + "Τίτλος βιβλίου: " + getTitle() + ", Συγγραφέας: " + getAuthor() + ", ISBN: " + getISBN() + ", Εκδοτικός οίκος: " + getPublisher() + ", Αριθμός σελίδων: " + getNumberPages() + ", Έτος έκδοσης: " + getYearPublished() + ", Τιμή: " + getPrice() + ", scientificField = " + scientificField + '}';
    }
    
}
