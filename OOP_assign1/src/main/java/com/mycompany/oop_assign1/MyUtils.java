package com.mycompany.oop_assign1;

class MyUtils {
    
    static Book seqSearch(String ISBN,Book[] arrayOfBooks){
        
        int index = -1;
        
        for(int i = 0; i<arrayOfBooks.length; i++){
            if(arrayOfBooks[i].getISBN().equals(ISBN)){
                index = i;
                break;
            }
        }
        
        return arrayOfBooks[index];
    }

    static Book[] seqSearch(int year,Book[] arrayOfBooks){
        
        int count = 0;
        
        for(int i = 0; i<arrayOfBooks.length; i++){
            if(arrayOfBooks[i].getYearPublished() == year){                
                count++;
            }
        }
        Book[] totalResult = new Book[count];
        
        for(int i =0; i<arrayOfBooks.length; i++){
            if(arrayOfBooks[i].getYearPublished() == year){
                totalResult[i] = arrayOfBooks[i];
            }
        }
        
        return totalResult;
    }

    
}
