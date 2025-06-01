
public class Dictionary extends Book implements ProsPolisi {

    private int numEntries;
    private int copies;

    public Dictionary() {
    }

    public Dictionary(String title, String author, String ISBN, String publisher, int numberPages, int yearPublished, double price, int numEntries) {
        super(title, author, ISBN, publisher, numberPages, yearPublished, price);
        this.numEntries = numEntries;
    }

    public int getNumberOfCopies() {
        return copies;
    }

    public void setNumberOfCopies(int copies) {
        this.copies = copies;
    }

    public void setNumEntries(int numEntries) {
        try {
            if (numEntries < 1000 || numEntries > 100000) {
                throw new IllegalArgumentException("Μη έγκυρος αριθμός λημμάτων\nΠρέπει να είναι από 1000 εώς 100000");
            }
            this.numEntries = numEntries;

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public int getNumEntries() {
        return numEntries;
    }

    @Override
    public String toString() {
        return "Dictionary{" + "Τίτλος βιβλίου: " + getTitle() + ", Συγγραφέας: " + getAuthor() + ", ISBN: " + getISBN() + ", Εκδοτικός οίκος: " + getPublisher() + ", Αριθμός σελίδων: " + getNumberPages() + ", Έτος έκδοσης: " + getYearPublished() + ", Τιμή: " + getPrice() + ", numEntries = " + numEntries + '}';
    }

}
