import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class LoanManagerTest {

    @Test
    @DisplayName("Test that books can be fetched from DB without sql exception")
    void showBooks() {

        LoanManager lm = new LoanManager();
        assertDoesNotThrow(SQLException.class, () -> {
            lm.showBooks();
        });
    }

    @Test
    @DisplayName("Test that users can be fetched from DB without sql exception")
    void showUsers() {

        LoanManager lm = new LoanManager();
        assertDoesNotThrow(SQLException.class, () -> {
            lm.showUsers();
        });
    }


    @Test
    @DisplayName("Test that books can be added to DB")
    void addBook() {

        LoanManager lm = new LoanManager();
        assertDoesNotThrow(SQLException.class, () -> {
            lm.addBook(123, 'bookName', 1);
        });
    }

    @Test
    @DisplayName("Test that user can be added to DB")
    void addUser() {

        LoanManager lm = new LoanManager();
        assertDoesNotThrow(SQLException.class, () -> {
            lm.addUser('john', 'Doe', 2);
        });
    }

    @Test
    @DisplayName("Test that book isbn can be deleted")
    void deleteBookISBN() {

        LoanManager lm = new LoanManager();
        assertDoesNotThrow(SQLException.class, () -> {
            lm.deleteBookISBN(12);
        });
    }

    @Test
    @DisplayName("Test that book name can be deleted")
    void deleteBookName() {

        LoanManager lm = new LoanManager();
        assertDoesNotThrow(SQLException.class, () -> {
            lm.deleteBookName('bookName');
        });
    }

    @Test
    @DisplayName("Test user can be deleted")
    void deleteUser() {

        LoanManager lm = new LoanManager();
        assertDoesNotThrow(SQLException.class, () -> {
            lm.deleteUser(12, 'john', 'Doe', 2);
        });
    }

    @Test
    @DisplayName("Test that book name can be fetched from DB")
    void getBookName() {

        LoanManager lm = new LoanManager();
        assertDoesNotThrow(SQLException.class, () -> {
            lm.getBookName('bookName');
        });
    }

    @Test
    @DisplayName("Test that book ISBN can be fetched from DB")
    void getBookISBN() {

        LoanManager lm = new LoanManager();
        assertDoesNotThrow(SQLException.class, () -> {
            lm.getBookISBN(12);
        });
    }

    @Test
    @DisplayName("Test that user can be fetched from DB")
    void getUser() {

        LoanManager lm = new LoanManager();
        assertDoesNotThrow(SQLException.class, () -> {
            lm.getUser(2);
        });
    }

    @Test
    @DisplayName("Test loanBook")
    void loanBook() {

        LoanManager lm = new LoanManager();
        assertDoesNotThrow(SQLException.class, () -> {
            lm.loanBook(Book newbook, User user);
        });
    }

    @Test
    @DisplayName("Test that book can be returned")
    void returnBook() {

        LoanManager lm = new LoanManager();
        assertDoesNotThrow(SQLException.class, () -> {
            lm.returnBook();
        });
    }

    @Test
    @DisplayName("Check if books are available")
    void checkAvailableBooks() {

        LoanManager lm = new LoanManager();
        assertDoesNotThrow(SQLException.class, () -> {
            lm.checkAvailableBooks(12);
        });
    }

}
