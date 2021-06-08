public class Book {
    public int ISBN;
    public String bookName;
    public User loanUser;
    public int numOfBooks;

    public Book() {
    }

    public Book(int isbn, String bookName, int numOfBooks) {
        this.ISBN = isbn;
        this.bookName = bookName;
        this.numOfBooks = numOfBooks;
    }


    public int getBookISBN() {
        return ISBN;
    }

    public void setBookISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public User getLoanUser() {
        return loanUser;
    }

    public void setLoanUser(User user) {
        this.loanUser = user;
    }

    public int getNumOfBooks(){
        return numOfBooks;
    }
    public void setNumOfBooks(int numOfBooks){
        this.numOfBooks = numOfBooks;
    }

}


