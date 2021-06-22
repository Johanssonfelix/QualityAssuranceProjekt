import java.time.LocalDate;

public class Book {
    public int ISBN;
    public String bookName;
    public int userID;
    public int numOfBooks;
    public LocalDate loanDate;
    public LocalDate returnDate;

    public Book() {
    }


    public Book(int isbn, int userID) {
        this.ISBN = isbn;
        this.userID = userID;
    }




    public Book(int isbn, String bookName, int numOfBooks) {
        this.ISBN = isbn;
        this.bookName = bookName;
        this.numOfBooks = numOfBooks;
    }

    public Book(int isbn, String bookName, int userID, int numOfBooks, LocalDate loanDate, LocalDate returnDate){
        this.ISBN = isbn;
        this.bookName = bookName;
        this.userID = userID;
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

    public LocalDate getLoanDate(){
        return loanDate;
    }

    public void setLoandate(){
       this.loanDate = LocalDate.now();

    }

    public LocalDate getReturnDate(){
        return returnDate;
    }

    public void setReturnDate() {
    returnDate = LocalDate.now().plusDays(14);



    }

}


