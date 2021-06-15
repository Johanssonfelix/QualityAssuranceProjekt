import java.util.NoSuchElementException;

public class BookHandler {

    LoanManager loanManager;
    Book[] books;
    User user;

    public BookHandler(LoanManager loanManager, User user) {
        this.loanManager = loanManager;
        this.user = user;
    }

    public boolean addBook(int isbn, String bookName, int numOfBooks){
        return loanManager.addBook(isbn, bookName, numOfBooks);

    }

    public Book loanBook(int isbn){
        Book tBook = loanManager.getBookISBN(isbn);

        if (tBook == null){
            throw new NoSuchElementException("ISBN Saknas");
        }else if (!checkAvaibilty(tBook)){
            throw new  NullPointerException("Inga tillgängliga böcker");
        }else{
            loanManager.loanBook(tBook,user);
        }
        return tBook;
    }

    /*public Book returnBook(int isbn){
        Book tBook = loanManager.getBookISBN(isbn);
    }*///Kommer behöva kolla lite på kopplingstabellen

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
