public class Science extends Book implements ProsPolisi{

    private String scientificField;
    private int numberOfCopies;
    
    public Science() {
    }

    public Science(String title, String author, String ISBN, String publisher, int numberPages, int yearPublished, double price, String scientificField) {
        super(title, author, ISBN, publisher, numberPages, yearPublished, price);
        this.scientificField = scientificField;
    }
    
    public int getNumberOfCopies(){
        return numberOfCopies;
    }
    
    public void setNumberOfCopies(int copies){
        if(copies >= 0){
        this.numberOfCopies = copies;
        }else{
            throw new IllegalArgumentException("Το νούμερο δεν μπορεί να είναι αρνητικό");
        }
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
