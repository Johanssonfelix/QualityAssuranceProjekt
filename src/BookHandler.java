public class BookHandler {

    LoanManager loanManager;
    Book[] books;
    User user;

    public BookHandler(LoanManager loanManager, User user) {
        this.loanManager = loanManager;
        this.user = user;
        //books = getUserloans();
    }

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
