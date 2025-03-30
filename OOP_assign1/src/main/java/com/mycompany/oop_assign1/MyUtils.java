package com.mycompany.oop_assign1;

class MyUtils {

    public static Book seqSearch(String ISBN, Book[] arrayOfBooks) {

        int index = -1;

        for (int i = 0; i < arrayOfBooks.length; i++) {
            if (arrayOfBooks[i].getISBN().equals(ISBN)) {
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

    public static Book[] seqSearch(int year, Book[] arrayOfBooks,int bounds) {

        int count = 0;
        

        for (int i = 0; i < 4; i++) {
            if ( arrayOfBooks[i] != null && arrayOfBooks[i].getYearPublished() == year) {
                count++;
            }
        }
        
        Book[] totalResult = new Book[count];

        for (int i = 0; i < count; i++) {
            if (arrayOfBooks[i].getYearPublished() == year && arrayOfBooks[i] != null) {
                totalResult[i] = arrayOfBooks[i];
            }
        }

        return totalResult;
    }

    public static Book binSearch(String ISBN, Book[] arrayOfBooks) {
        int left = 0;
        int right = arrayOfBooks.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arrayOfBooks[mid] != null && arrayOfBooks[mid].getISBN().equals(ISBN)) {
                return arrayOfBooks[mid];
            }

            if (arrayOfBooks[mid] != null && arrayOfBooks[mid].getISBN().compareTo(ISBN) > 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
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
            if (arrayOfBooks[mid] != null && arrayOfBooks[mid].getYearPublished() == year) {
                break;
            }

            if (arrayOfBooks[mid] != null && arrayOfBooks[mid].getYearPublished() > year) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (mid == -1 || arrayOfBooks[mid] == null || arrayOfBooks[mid].getYearPublished() != year) {
            return null;
        }

        Book[] result = new Book[10];
        result[0] = arrayOfBooks[mid];
        int seqLeftSide = mid;
        int seqRightSide = mid;
        int index = 0;

        while (seqLeftSide > 0) {
            if (arrayOfBooks[seqLeftSide - 1].getYearPublished() == year) {
                result[index + 1] = arrayOfBooks[seqLeftSide - 1];
                index++;
            }
            seqLeftSide--;
        }

        while (seqRightSide < arrayOfBooks.length - 1) {
            if (arrayOfBooks[seqRightSide + 1].getYearPublished() == year) {
                result[index + 1] = arrayOfBooks[seqRightSide + 1];
                index++;
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
;


}
