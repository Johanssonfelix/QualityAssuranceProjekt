public class Book {
    public int ISBN;
    public String bookName;
    public String author;
    public User loanUser;

    public Book() {
    }

    public Book(int isbn, String bookName, String author) {
        this.ISBN = isbn;
        this.bookName = bookName;
        this.author = author;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public User getLoanUser() {
        return loanUser;
    }

    public void setLoanUser(User user) {
        this.loanUser = user;
    }
}


