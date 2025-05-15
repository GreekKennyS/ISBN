public class DaySales {
    private Book[] books;
    private int[] sales;
    
    public DaySales(Book[] books){
        this.books = books;
        this.sales = new int[books.length];
    }
    
    public void sellBook(String ISBN, int quantity){
        if(quantity < 1){
            System.out.println("Η ποσότητα προς πώληση πρέπει να είναι τουλάχιστον 1");
            return;
        }
        for(int i = 0; i<books.length; i++){
            if(books[i] != null && books[i].getISBN().equals(ISBN)){
                sales[i] += quantity;
                return;
            }
        }
        System.out.println("Το βιβλίο με "+ISBN+" δεν βρέθηκε");
    }
    
    
}
