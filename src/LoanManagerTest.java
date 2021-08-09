import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LoanManagerTest {

    public Book book = new Book(1234,1);

    @org.junit.jupiter.api.Test
    void loanBookAvailiable() {

        book.setNumOfBooks(1);

        User user = new User();
        LoanManager loanMock = mock(LoanManager.class);
        BookHandler bookHandler = new BookHandler(loanMock, user);
        when(loanMock.getBookISBN(1234)).thenReturn(book);

        Book testBook = bookHandler.loanBook(1234);

        assertEquals(1234,testBook.getBookISBN() );

    }
    @Test
    void loanBookNotAvailable() {

        book.setNumOfBooks(0);

        User user = new User();
        LoanManager loanMock = mock(LoanManager.class);
        BookHandler bookHandler = new BookHandler(loanMock, user);
        when(loanMock.getBookISBN(1234)).thenReturn(book);

        Exception exception = assertThrows(NullPointerException.class, () -> {
            Book testBook = bookHandler.loanBook(1234);
            testBook.getBookISBN();
            });

        String expectedMessage = "Inga tillgängliga böcker";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
        }
    @Test
    void loanBookISBNNull() {

            User user = new User();
            LoanManager loanMock = mock(LoanManager.class);
            BookHandler bookHandler = new BookHandler(loanMock, user);
            when(loanMock.getBookISBN(1234)).thenReturn(null);

            Exception exception = assertThrows(NoSuchElementException.class, () -> {
                Book testBook = bookHandler.loanBook(1234);
                testBook.getBookISBN();
            });

        String expectedMessage = "ISBN saknas";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
        }

    @Test
    void testAvailability_isAvailable(){

        book.setNumOfBooks(1);

        User user = new User();
        LoanManager loanMock = mock(LoanManager.class);
        BookHandler bookHandler = new BookHandler(loanMock, user);

        boolean availableBook = bookHandler.checkAvaibilty(book);

        assertEquals(true, availableBook);

    }

    @Test
    void testAvailability_NotAvailable(){

        book.setNumOfBooks(0);

        User user = new User();
        LoanManager loanMock = mock(LoanManager.class);
        BookHandler bookHandler = new BookHandler(loanMock, user);

        boolean availableBook = bookHandler.checkAvaibilty(book);

        assertEquals(false, availableBook);

    }
/*
    @Test
    void checkSuspension_notSuspended(){

        User user = new User();
        user.setStrikes(2);

        LoanManager loanMock = mock(LoanManager.class);
        UserHandler userHandler = new UserHandler(user, loanMock);

        boolean userStatus = userHandler.checkUserSuspension(user);

        assertEquals(true,userStatus);

    }
    @Test
    void checkSuspension_isSuspended(){

        User user = new User();
        user.setStrikes(3);

        LoanManager loanMock = mock(LoanManager.class);
        UserHandler userHandler = new UserHandler(user, loanMock);

        boolean userStatus = userHandler.checkUserSuspension(user);

        assertEquals(false,userStatus);

    }

 */

}