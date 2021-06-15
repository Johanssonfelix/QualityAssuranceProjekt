import java.util.NoSuchElementException;

public class BookHandler {

    LoanManager loanManager;
    Book[] books;
    User user;

    public BookHandler(LoanManager loanManager, User user) {
        this.loanManager = loanManager;
        this.user = user;
        //books = getUserloans();
    }

    /*public Book loan(int isbn){
        Book tBook = loanManager.getBookISBN(isbn);

        if (tBook == null){
            throw new NoSuchElementException("ISBN Saknas");
        }
    }*/

    public boolean checkAvaibilty(Book book){
        if (book.getNumOfBooks() == 0){
            return false;
        }
        else
            return book.getNumOfBooks() > 0;
    }

    /*public Book[] getUserloans(){
        return loanManager.getLoanUser();

    }*/
}
