import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;


public class LoanSystem extends LoanManager {
    private static Logger logger = LogManager.getLogger(LoanSystem.class);

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);


        int option = 0;
        boolean end = false;
        LoanManager lm = new LoanManager();
        while (!end) {

            System.out.println("Välkommen till Consol-Libary!");
            System.out.println("-----------------------------");
            System.out.println();

            System.out.println("För att kunna låna böcker, återlämna böcker måste du vara inloggad. Utan att vara " +
                    "inloggad kan du se vilka böcker som finns, söka och se vilka böcker som är lediga. ");

            System.out.println();
            System.out.println("För att logga in, tryck 1");
            System.out.println("För att vara oinloggad eller skapa inlogg tryck 2 ");
            option = input.nextInt();
            if (option == 1) {
                LoanManager manager = new LoanManager();
                User user = new User();

                System.out.println("Var vänlig att skriva in namn enligt följande ordning:");
                System.out.println("Förnamn:");
                String forname = input.next();
                System.out.println("Efternamn");
                String lastname = input.next();
                System.out.println("Lösenord");
                String password = input.next();
                user = manager.getUser(forname, lastname, password);
                System.out.println();
                System.out.println("Välkommen!");

                if (user.getUserType() == 1) {
                    System.out.println("Du är inloggad som " + user.usertypeDescription);
                    System.out.println("Vad vill du göra?");
                    System.out.println("1.- Administrera \n" +
                            "2.- Lån & Återlämning \n" +
                            "3.- Mitt Konto");
                    option = input.nextInt();

                    if (option == 1) {
                        System.out.println("Vill du lägga till böcker eller ta bort?");
                        System.out.println("1.- Lägga till\n" +
                                "2.- Ta bort");
                        option = input.nextInt();
                        if (option == 1) {
                            System.out.println("Skriv in: \n" +
                                    "Namn: ");
                            String boknamn = input.next();
                            System.out.println("ISBN:");
                            int isbn = input.nextInt();
                            System.out.println("Hur många antal böcker är inköpta");
                            int antal = input.nextInt();
                            lm.addBook(isbn, boknamn, antal);
                            logger.info(user.getUserId() + " har lagt till " + antal + " exemplar av " + boknamn + "[" + isbn + "]");
                        } else if (option == 2) {
                            System.out.println("Skriv in ISBN");
                            int isbn = input.nextInt();
                            Book newBook = lm.getBookISBN(isbn);
                            String bookname = newBook.getBookName();
                            lm.deleteBookISBN(isbn);
                            logger.info(user.getUserId() + " har raderat " + bookname + "[" + isbn + "]");
                        }

                    } else if (option == 2) {
                        System.out.println("1.- Vill du låna");
                        System.out.println("2.- Vill du återlämna?");
                        System.out.println("3.- Sök efter bok");
                        System.out.println("4.- Visa alla böcker");
                        option = input.nextInt();

                        if (option == 1) {
                            System.out.println("Vilken bok vill du låna?");
                            String boknamn = input.next();
                            lm.loanBook(manager.getBookName(boknamn),user);
                            logger.info(user.getUserId() + " har lånat " + manager.getBookName(boknamn) + " användaren har " + user.currentnumberofloans + " lån" );
                            System.out.println(" Grattis du har lånat boken");

                        } else if (option == 2) {
                            System.out.println("Vilken bok vill du lämna tillbaka?");
                            // Return book
                        } else if (option == 3) {
                            System.out.println("Vilken bok vill du söka efter?");
                            System.out.println("Vill du söka efter namn eller isbn?");
                            System.out.println("1.- Namn");
                            System.out.println("2.- ISBN");

                            option = input.nextInt();
                            if (option == 1) {
                                System.out.println("Skriv in bokens namn:");
                                String boknamn = input.next();
                                lm.getBookName(boknamn);

                            } else if (option == 2) {
                                System.out.println("Skriv in bokens isbn");
                                int isbn = input.nextInt();
                                lm.getBookISBN(isbn);
                            }
                        } else if (option == 4){
                            lm.showBooks();
                        }
                    } else if (option == 3) {
                        System.out.println("Vill du radera ditt konto?");
                        System.out.println("Förnamn");
                        String förnamn = input.next();
                        System.out.println("Efternamn");
                        String efternamn = input.next();
                        System.out.println("UserId");
                        int userid = input.nextInt();
                        System.out.println("Usertype");
                        int usertype = input.nextInt();
                        System.out.println("Lösenord");
                        password = input.next();

                        lm.deleteUser(userid, förnamn, efternamn, usertype, password);
                        logger.info(forname + " " + lastname + " har raderats");
                        end = true;
                    } else {
                        System.out.println("Felhanteringen är inte optimal, ber om ursäkt för det.");
                    }
                } else if (user.getUserType() == 2 || user.getUserType() == 3 || user.getUserType() == 4 || user.getUserType() == 5) {
                    System.out.println("Du är inloggad som " + user.usertypeDescription);
                    System.out.println("Vad vill du göra?");
                    System.out.println("1.- Lån & Återlämning \n" +
                            "2.- Mitt Konto");
                    option = input.nextInt();
                    if (option==1){
                        System.out.println("1.- Vill du låna");
                        System.out.println("2.- Vill du återlämna?");
                        System.out.println("3.- Sök efter bok");
                        System.out.println("4.- Visa alla böcker");
                        option = input.nextInt();

                        if (option == 1) {
                            System.out.println("Vilken bok vill du låna?");
                            String boknamn = input.next();
                            lm.loanBook(manager.getBookName(boknamn),user);
                            logger.info(user.getUserId() + " har lånat " + manager.getBookName(boknamn) + " användaren har " + user.currentnumberofloans + " lån" );
                            System.out.println(" Grattis du har lånat boken");

                        } else if (option == 2) {
                            System.out.println("Vilken bok vill du lämna tillbaka?");
                            // Return book
                        } else if (option == 3) {
                            System.out.println("Vilken bok vill du söka efter?");
                            System.out.println("Vill du söka efter namn eller isbn?");
                            System.out.println("1.- Namn");
                            System.out.println("2.- ISBN");

                            option = input.nextInt();
                            if (option == 1) {
                                System.out.println("Skriv in bokens namn:");
                                String boknamn = input.next();
                                lm.getBookName(boknamn);
                            } else if (option == 2) {
                                System.out.println("Skriv in bokens isbn");
                                int isbn = input.nextInt();
                                lm.getBookISBN(isbn);
                            } else if (option == 3){
                                lm.showBooks();
                            }

                        }
                    } else if (option == 2) {
                        System.out.println("Vill du radera ditt konto?");
                        System.out.println("Förnamn");
                        String förnamn = input.next();
                        System.out.println("Efternamn");
                        String efternamn = input.next();
                        System.out.println("UserId");
                        int userid = input.nextInt();
                        System.out.println("Usertype");
                        int usertype = input.nextInt();
                        System.out.println("Lösenord");
                        password = input.next();

                        lm.deleteUser(userid, förnamn, efternamn, usertype, password);
                        logger.info(forname + " " + lastname + " har raderats");
                        end = true;
                    }
                    else {
                        System.out.println("Felhanteringen är inte optimal, ber om ursäkt för det.");
                    }
                }

            }
            else if (option == 2){
                System.out.println(" Vill du?" +
                        "1. Se alla böckerna?" +
                        "2. Söka efter specifik bok?");
                option = input.nextInt();
                if (option == 1){
                    lm.showBooks();
                } else if (option == 2){
                    System.out.println("Skriv in bokens namn");
                    String boknamn = input.next();
                    lm.getBookName(boknamn);
                }
            }



        }


    }

}