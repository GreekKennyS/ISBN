
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

    public static void bubbleSort(Book[] arrayOfBooks, int sortBy) {

        int n = arrayOfBooks.length;
        boolean swapFlag = false;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arrayOfBooks[j] == null || arrayOfBooks[j + 1] == null) {
                    continue;
                }
                switch (sortBy) {
                    case 1:
                        if (arrayOfBooks[j].getAuthor().compareTo(arrayOfBooks[j + 1].getAuthor()) > 0) {
                            swapFlag = true;
                        }
                        break;
                    case 2:
                        if (arrayOfBooks[j].getISBN().compareTo(arrayOfBooks[j + 1].getISBN()) > 0) {
                            swapFlag = true;
                        }
                        break;
                    case 3:
                        if (arrayOfBooks[j].getYearPublished() > arrayOfBooks[j + 1].getYearPublished()) {
                            swapFlag = true;
                        }
                        break;
                    case 4:
                        if (arrayOfBooks[j].getPrice() > arrayOfBooks[j + 1].getPrice()) {
                            swapFlag = true;
                        }
                        break;
                    default:
                        break;
                }
                if (swapFlag) {
                    Book temp = arrayOfBooks[j];
                    arrayOfBooks[j] = arrayOfBooks[j + 1];
                    arrayOfBooks[j + 1] = temp;
                    swapFlag = false;
                }
            }
        }
    }

    public static void insertionSort(Book[] arrayOfBooks, int sortBy) {
        for (int i = 1; i < arrayOfBooks.length; i++) {
            if (arrayOfBooks[i] == null) {
                continue;
            }

            Book currentBook = new Book();
            int position = i;

            switch (sortBy) {
                case 1:
                    currentBook = arrayOfBooks[i];
                    while (position > 0 && arrayOfBooks[position - 1].getISBN().compareTo(currentBook.getISBN()) > 0) {
                        arrayOfBooks[position] = arrayOfBooks[position - 1];
                        position--;
                    }
                    arrayOfBooks[position] = currentBook;
                    break;
                case 2:
                    String currentISBN = arrayOfBooks[i].getISBN();
                    while (position > 0 && arrayOfBooks[position - 1].getISBN().compareTo(currentISBN) > 0) {
                        arrayOfBooks[position] = arrayOfBooks[position - 1];
                        position--;
                    }
                    arrayOfBooks[position].setISBN(currentISBN);
                    break;
                case 3:
                    currentBook = arrayOfBooks[i];
                    while (position > 0 && arrayOfBooks[position - 1].getYearPublished() > currentBook.getYearPublished()) {
                        arrayOfBooks[position] = arrayOfBooks[position - 1];
                        position--;
                    }
                    arrayOfBooks[position] = currentBook;
                    break;
                case 4:
                    currentBook = arrayOfBooks[i];
                    while (position > 0 && arrayOfBooks[position - 1].getPrice() > currentBook.getPrice()) {
                        arrayOfBooks[position] = arrayOfBooks[position - 1];
                        position--;
                    }
                    arrayOfBooks[position] = currentBook;
                    break;
                default:
                    break;
            }

        }

    }

    public static void selectionSort(Book[] arrayOfBooks, int sortBy) {
        int min;
        Book tempBook = new Book();
        switch (sortBy) {
            case 1:
                for (int i = 0; i < arrayOfBooks.length - 1; i++) {
                    min = i;
                    for (int j = i + 1; j < arrayOfBooks.length; j++) {
                        if (arrayOfBooks[j] != null && arrayOfBooks[min] != null && arrayOfBooks[j].getAuthor().compareTo(arrayOfBooks[min].getAuthor()) < 0) {
                            min = j;
                        }
                    }
                    if (arrayOfBooks[min] != null && arrayOfBooks[i] != null) {
                        tempBook = arrayOfBooks[min];
                        arrayOfBooks[min] = arrayOfBooks[i];
                        arrayOfBooks[i] = tempBook;
                    }
                }
                break;
            case 2:
                for (int i = 0; i < arrayOfBooks.length - 1; i++) {
                    min = i;
                    for (int j = i + 1; j < arrayOfBooks.length; j++) {
                        if (arrayOfBooks[j] != null && arrayOfBooks[min] != null && arrayOfBooks[j].getISBN().compareTo(arrayOfBooks[min].getISBN()) < 0) {
                            min = j;
                        }
                    }
                    if (arrayOfBooks[min] != null && arrayOfBooks[i] != null) {
                        tempBook = arrayOfBooks[min];
                        arrayOfBooks[min] = arrayOfBooks[i];
                        arrayOfBooks[i] = tempBook;
                    }
                }
                break;
            case 3:
                for (int i = 0; i < arrayOfBooks.length - 1; i++) {
                    min = i;
                    for (int j = i + 1; j < arrayOfBooks.length; j++) {
                        if (arrayOfBooks[j] != null && arrayOfBooks[min] != null && arrayOfBooks[j].getYearPublished() < arrayOfBooks[min].getYearPublished()) {
                            min = j;
                        }
                    }
                    if (arrayOfBooks[min] != null && arrayOfBooks[i] != null) {
                        tempBook = arrayOfBooks[min];
                        arrayOfBooks[min] = arrayOfBooks[i];
                        arrayOfBooks[i] = tempBook;
                    }
                }
                break;
            case 4:
                for (int i = 0; i < arrayOfBooks.length - 1; i++) {
                    min = i;
                    for (int j = i + 1; j < arrayOfBooks.length; j++) {
                        if (arrayOfBooks[j] != null && arrayOfBooks[min] != null && arrayOfBooks[j].getPrice() < arrayOfBooks[min].getPrice()) {
                            min = j;
                        }
                    }
                    if (arrayOfBooks[min] != null && arrayOfBooks[i] != null) {
                        tempBook = arrayOfBooks[min];
                        arrayOfBooks[min] = arrayOfBooks[i];
                        arrayOfBooks[i] = tempBook;
                    }
                }
                break;
            default:
                break;
        }
    }

    public static void quickSort(Book[] arrayOfBooks, int sortBy) {
        qSort(arrayOfBooks, 0, arrayOfBooks.length - 1, sortBy);
    }

    public static void qSort(Book[] arrayOfBooks, int f, int l, int sortBy) {
        if (l - f > 0) {
            int pivot_index = partition(arrayOfBooks, f, l, sortBy);
            qSort(arrayOfBooks, f, pivot_index - 1, sortBy);
            qSort(arrayOfBooks, pivot_index + 1, l, sortBy);

        }
    }

    public static int partition(Book[] arrayOfBooks, int f, int l, int sortBy) {
        int retValue = 0;
        int lowerLimit = f;
        int mid = (f + l) / 2;

        if (arrayOfBooks[mid] == null) {
            while (mid < l && arrayOfBooks[mid] == null) {
                mid++;
            }
            if (mid >= l) {
                return f;
            }
        }
        swap(arrayOfBooks, f, mid);

        Book pivot = arrayOfBooks[f];
        f++;

        if (pivot == null) {
            return f;
        }
        while (f < l) {
            if (arrayOfBooks[f] == null) {
                f++;
                continue;
            }
            if (arrayOfBooks[l] == null) {
                l--;
                continue;
            }
            switch (sortBy) {
                case 1:
                    while (arrayOfBooks[f].getAuthor().compareTo(pivot.getAuthor()) <= 0 && f < l) {
                        f++;
                    }
                    break;
                case 2:
                    while (arrayOfBooks[f].getISBN().compareTo(pivot.getISBN()) <= 0 && f < l) {
                        f++;
                    }
                    break;
                case 3:
                    while (arrayOfBooks[f].getYearPublished() <= pivot.getYearPublished() && f < l) {
                        f++;
                    }
                    break;
                case 4:
                    while (arrayOfBooks[f].getPrice() <= pivot.getPrice() && f < l) {
                        f++;
                    }
                    break;
            }

            switch (sortBy) {
                case 1:
                    while (arrayOfBooks[f].getAuthor().compareTo(pivot.getAuthor()) > 0 && l > lowerLimit) {
                        l--;
                    }
                    break;
                case 2:
                    while (arrayOfBooks[f].getISBN().compareTo(pivot.getISBN()) > 0 && l > lowerLimit) {
                        l--;
                    }
                    break;
                case 3:
                    while (arrayOfBooks[f].getYearPublished() > pivot.getYearPublished() && l > lowerLimit) {
                        l--;
                    }
                    break;
                case 4:
                    while (arrayOfBooks[f].getPrice() > pivot.getPrice() && l > lowerLimit) {
                        l--;
                    }
                    break;
            }

            if (f < l) {
                swap(arrayOfBooks, f, l);
            }
        }

        swap(arrayOfBooks, f, l);

        return f;
    }

    public static void swap(Book[] arrayOfBooks, int x, int y) {
        Book temp = arrayOfBooks[x];
        arrayOfBooks[x] = arrayOfBooks[y];
        arrayOfBooks[y] = temp;
    }

    public static void mergeSort(Book[] arrayOfBooks, int sortBy) {
        mSort(arrayOfBooks, 0, arrayOfBooks.length - 1, sortBy);
    }

    public static void mSort(Book[] arrayOfBooks, int f, int l, int sortBy) {
        if (f >= l) {
            return;
        }
        int mid = (f + l) / 2;
        mSort(arrayOfBooks, f, mid, sortBy);
        mSort(arrayOfBooks, mid + 1, l, sortBy);
        merge(arrayOfBooks, f, l, mid, sortBy);
    }

    public static void merge(Book[] arrayOfBooks, int f, int l, int mid, int sortBy) {

        int n = l - f + 1;

        Book[] b = new Book[n];

        int i1 = f, i2 = mid + 1;
        int j = 0;

        while (i1 <= mid && i2 <= l) {
            if (arrayOfBooks[i1] == null) {
                i1++;
                continue;
            }
            if (arrayOfBooks[i2] == null) {
                i2++;
                continue;
            }
            switch (sortBy) {
                case 1:
                    if (arrayOfBooks[i1].getAuthor().compareTo(arrayOfBooks[i2].getAuthor()) <= 0) {
                        b[j] = arrayOfBooks[i1];
                        i1++;
                    } else {
                        b[j] = arrayOfBooks[i2];
                        i2++;
                    }
                    break;
                case 2:
                    if (arrayOfBooks[i1].getISBN().compareTo(arrayOfBooks[i2].getISBN()) <= 0) {
                        b[j] = arrayOfBooks[i1];
                        i1++;
                    } else {
                        b[j] = arrayOfBooks[i2];
                        i2++;
                    }
                    break;
                case 3:
                    if (arrayOfBooks[i1].getYearPublished() <= arrayOfBooks[i2].getYearPublished()) {
                        b[j] = arrayOfBooks[i1];
                        i1++;
                    } else {
                        b[j] = arrayOfBooks[i2];
                        i2++;
                    }
                    break;
                case 4:
                    if (arrayOfBooks[i1].getPrice() <= arrayOfBooks[i2].getPrice()) {
                        b[j] = arrayOfBooks[i1];
                        i1++;
                    } else {
                        b[j] = arrayOfBooks[i2];
                        i2++;
                    }
                    break;
            }
            j++;
        }

        while (i1 <= mid) {
            b[j] = arrayOfBooks[i1];
            i1++;
            j++;
        }

        while (i2 <= l) {
            b[j] = arrayOfBooks[i2];
            i2++;
            j++;
        }

        for (j = 0; j < n; j++) {
            arrayOfBooks[f + j] = b[j];
        }
    }
}
