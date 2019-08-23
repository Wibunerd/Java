public class Library {
    // Add the missing implementation to this class
    String libraryAddress;
    static String openningHours = "Libraries are open daily from 9am to 5pm.";
    Book bookList[] = new Book[10];
    int numBook = 0;

    Library(String libraryAddress){
        this.libraryAddress = libraryAddress;
    }
    void printAddress(){
        System.out.println(this.libraryAddress);;
    }

    static void printOpeningHours(){
        System.out.println(openningHours);
    }
    void addBook(Book b){
        bookList[numBook] = b;
        numBook++;
    }
    int borrowBook(String bookName){
        if(numBook==0){
            System.out.println("Sorry, this book is not in our catalog");
            return 0;
        }
        for(int book = 0; book<numBook; book++){
            if (bookName == bookList[book].getTitle()){
                if (!(bookList[book].isBorrowed())){
                    bookList[book].borrowed();
                    System.out.println("You successfully borrowed "+ bookName);
                    return 0;
                }else if(bookList[book].isBorrowed()){
                    System.out.println("Sorry, this book is already borrowed.");
                    return 0;
                }
            }
        }
        System.out.println("Sorry, this book is not in our catalog");
        return 0;
    }
    void printAvailableBooks(){
        if(numBook==0){
            System.out.println("No book in catalog");
        }
        for(int book = 0; book<numBook; book++){
            if(bookList[book].isBorrowed()){
                continue;
            }
            System.out.println(bookList[book].getTitle());
            
        }
    }

    void returnBook(String bookName){
        for(int book=0; book<numBook; book++){
            if(bookName==bookList[book].getTitle()){
                if(bookList[book].isBorrowed()){
                    bookList[book].returned();
                    System.out.println("You successfully returned "+ bookName);
                }
            }
        }
    }


    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
} 