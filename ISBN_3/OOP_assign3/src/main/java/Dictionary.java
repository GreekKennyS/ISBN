public class Dictionary extends Book {

    private int numEntries;

    public Dictionary() {
    }

    public Dictionary(String title, String author, String ISBN, String publisher, int numberPages, int yearPublished, double price, int numEntries) {
        super(title, author, ISBN, publisher, numberPages, yearPublished, price);
        this.numEntries = numEntries;
    }

    public void setNumEntries(int numEntries) {
        if (numEntries > 0) {
            this.numEntries = numEntries;
        } else {
            System.out.println("Ο αριθμός λημμάτων πρέπει να είναι θετικός ακέραιος");
        }
    }

    public int getNumEntries() {
        return numEntries;
    }

    @Override
    public String toString() {
        return "Dictionary{" + "numEntries=" + numEntries + '}';
    }

}
