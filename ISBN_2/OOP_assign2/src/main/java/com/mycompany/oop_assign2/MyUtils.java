package com.mycompany.oop_assign2;

class MyUtils {

    public static Book seqSearch(String ISBN, Book[] arrayOfBooks) {

        int index = -1;

        for (int i = 0; i < arrayOfBooks.length; i++) {
            if (arrayOfBooks[i] != null && arrayOfBooks[i].getISBN().equals(ISBN)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return null;
        } else {
            return arrayOfBooks[index];
        }
    }

    public static Book[] seqSearch(int year, Book[] arrayOfBooks) {

        int count = 0;

        for (int i = 0; i < arrayOfBooks.length; i++) {
            if (arrayOfBooks[i] != null && arrayOfBooks[i].getYearPublished() == year) {
                count++;
            }
        }

        Book[] totalResult = new Book[count];
        int index = 0;
        for (int i = 0; i < arrayOfBooks.length; i++) {
            if (arrayOfBooks[i] != null) {
                if (arrayOfBooks[i].getYearPublished() == year) {
                    totalResult[index] = arrayOfBooks[i];
                    index++;
                }
            }

        }

        return totalResult;
    }

    public static Book binSearch(String ISBN, Book[] arrayOfBooks) {
        int left = 0;
        int right = arrayOfBooks.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arrayOfBooks[mid] != null) {
                if (arrayOfBooks[mid].getISBN().equals(ISBN)) {
                    return arrayOfBooks[mid];
                }

                if (arrayOfBooks[mid].getISBN().compareTo(ISBN) > 0) {
                    right = mid - 1;
                } else if (arrayOfBooks[mid].getISBN().compareTo(ISBN) < 0) {
                    left = mid + 1;
                }
            } else {
                right--;
            }

        }
        return null;
    }

    public static Book[] binSearch(int year, Book[] arrayOfBooks) {
        int left = 0;
        int right = arrayOfBooks.length - 1;
        int mid = -1;

        while (left <= right) {
            mid = (left + right) / 2;
            if (arrayOfBooks[mid] != null) {
                if (arrayOfBooks[mid].getYearPublished() == year) {
                    break;
                }

                if (arrayOfBooks[mid].getYearPublished() > year) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                right--;
            }
        }
        if (mid == -1 || arrayOfBooks[mid] == null || arrayOfBooks[mid].getYearPublished() != year) {
            return null;
        }

        Book[] result = new Book[10];
        result[0] = arrayOfBooks[mid];
        int seqLeftSide = mid;
        int seqRightSide = mid;
        int index = 1;

        while (seqLeftSide > 0) {
            if (arrayOfBooks[seqLeftSide - 1] != null) {
                if (arrayOfBooks[seqLeftSide - 1].getYearPublished() == year) {
                    result[index] = arrayOfBooks[seqLeftSide - 1];
                    index++;
                }
            }
            seqLeftSide--;
        }

        while (seqRightSide < arrayOfBooks.length - 1) {
            if (arrayOfBooks[seqRightSide + 1] != null) {
                if (arrayOfBooks[seqRightSide + 1].getYearPublished() == year) {
                    result[index] = arrayOfBooks[seqRightSide + 1];
                    index++;
                }
            }
            seqRightSide++;
        }

        return result;

    }

    public static void valueSearch(Book[] arrayOfBooks, double lowerPrice, double upperPrice) {
        int count = 0;
        for (int i = 0; i < arrayOfBooks.length; i++) {
            if (arrayOfBooks[i] != null && arrayOfBooks[i].getPrice() >= lowerPrice && arrayOfBooks[i].getPrice() <= upperPrice) {
                System.out.println(arrayOfBooks[i]);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Δεν βρέθηκαν βιβλία με αυτά τα όρια\nΕλάχιστη τιμή: " + lowerPrice + "\nΜέγιστη τιμή: " + upperPrice);
        }
    }

    public static void bubbleSort(Book[] arrayOfBooks,int sortBy){
        
        int n = arrayOfBooks.length;
        boolean swapFlag = false;
        
        for(int i = 0; i< n - 1; i++){
            for(int j = 0; j < i - n - 1; j++){
                
                switch(sortBy){
                    case 1:
                        if(arrayOfBooks[j].getAuthor().compareTo(arrayOfBooks[j + 1].getAuthor()) > 0){
                            swapFlag = true;
                        }
                        break;
                    case 2:
                         if(arrayOfBooks[j].getISBN().compareTo(arrayOfBooks[j + 1].getISBN()) > 0){
                            swapFlag = true;
                         }
                        break;
                    case 3:
                        if(arrayOfBooks[j].getYearPublished() > arrayOfBooks[j + 1].getYearPublished()){
                            swapFlag = true;
                        }
                        break;
                    case 4:
                        if(arrayOfBooks[j].getPrice() > arrayOfBooks[j + 1].getPrice()){
                            swapFlag = true;
                        }
                        break;
                    default:
                        break;
                }
                if(swapFlag){
                    Book temp = arrayOfBooks[j];
                    arrayOfBooks[j] = arrayOfBooks[j + 1];
                    arrayOfBooks[j + 1] = temp;
                    swapFlag = false;
                }
            }
        }
    }

}
