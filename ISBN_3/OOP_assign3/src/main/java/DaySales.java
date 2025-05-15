public class DaySales {
    private Book[] books;
    private int[] sales;
    
    public DaySales(Book[] books){
        this.books = books;
        this.sales = new int[books.length];
        for(int i = 0; i < sales.length; i++){
            sales[i] = 0;
        }
    }
    
    public void sellBook(String ISBN, int quantity){
        if(quantity < 1){
            System.out.println("Η ποσότητα προς πώληση πρέπει να είναι τουλάχιστον 1");
            return;
        }
        for(int i = 0; i <books.length; i++){
            if(books[i] != null && books[i].getISBN().equals(ISBN)){
                sales[i] += quantity;
                return;
            }
        }
        System.out.println("Το βιβλίο με "+ISBN+" δεν βρέθηκε");
    }
    
    public void calculateTotalSales(){
        double scienceTotal = 0,dictionaryTotal = 0;
        for(int i = 0; i < books.length; i++){
            if(books[i] != null){
                if(books[i] instanceof Science){
                    scienceTotal += books[i].getPrice() * sales[i];
                }else if (books[i] instanceof Dictionary){
                    dictionaryTotal += books[i].getPrice() * sales[i];
                }
            }
        }
        System.out.println("Επιστημονικά βιβλία συνολική αξία: "+scienceTotal+" Euro");
        System.out.println("Λεξικά βιβλία συνολική αξία: "+dictionaryTotal+" Euro");
        System.out.println("Συνολικά Βιβλία συνολική αξία: "+scienceTotal+dictionaryTotal+" Euro");
        
        
    }
    
    public Book getBestSeller(){
        int maxSales = 0;
        Book bestSeller = null;
        for(int i = 0; i< books.length; i++){
            if(books[i] != null && sales[i] > maxSales){
                maxSales = sales[i];
                bestSeller = books[i];
            }
        }
        return bestSeller;
    }
    
    public void displaySales(){

        System.out.println("ISBN\tΕίδος Βιβλίου\tΠλήθος Αντιτύπων\n"
                + "------------------------------------------------------------------------------\n");
        
        for(int i = 0; i < books.length; i++){
            if(books[i] != null && sales[i] > 0){
                String bookType;
                if(books[i] instanceof Science){
                    bookType = "Επιστημονικά";
                }else if(books[i] instanceof Dictionary){
                    bookType = "Λεξικά";
                }else{
                    bookType = "Άγνωστο";
                }
                System.out.println(books[i].getISBN()+"\t"+bookType+"\t"+sales[i]+"\n");
            }
        }
    }
    
}
