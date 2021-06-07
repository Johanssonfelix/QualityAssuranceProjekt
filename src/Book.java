public class Book {
    public int ISBN;
    public String bookName;
    public User loanUser;

    public Book() {
    }

    public Book(int isbn, String bookName) {
        this.ISBN = isbn;
        this.bookName = bookName;
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

}


