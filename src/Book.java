import java.util.Date;

public class Book {
    public int ISBN;
    public String bookName;
    public int userID;
    public int numOfBooks;
    public Date loanDate;
    public Date returnDate;

    public Book() {
    }

    public Book(int isbn, String bookName, int numOfBooks) {
        this.ISBN = isbn;
        this.bookName = bookName;
        this.numOfBooks = numOfBooks;
    }

    public Book(int isbn, String bookName, int userID, int numOfBooks, Date loanDate, Date returnDate){
        this.ISBN = isbn;
        this.bookName = bookName;
        this.userID = userID;
        this.numOfBooks = numOfBooks;
        this.loanDate = loanDate;
        this.returnDate = returnDate;

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

    public int getLoanUser() {
        return userID;
    }

    public void setLoanUser(int userID) {
        this.userID = userID;
    }

    public int getNumOfBooks(){
        return numOfBooks;
    }
    public void setNumOfBooks(int numOfBooks){
        this.numOfBooks = numOfBooks;
    }

    public Date getLoanDate(){
        return loanDate;
    }

    public void setLoandate(Date loanDate){
        this.loanDate = loanDate;
    }

    public Date getReturnDate(){
        return returnDate;
    }

    public void setReturnDate(Date returnDate){
        this.returnDate = returnDate;
    }

}


