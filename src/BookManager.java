public class BookManager {

    LoanManager loanManager;
    Book[] books;
    User user;

    public BookManager(LoanManager loanManager, User user) {
        this.loanManager = loanManager;
        this.user = user;
        //books = hämta användarna, från den klassen...
    }
}
