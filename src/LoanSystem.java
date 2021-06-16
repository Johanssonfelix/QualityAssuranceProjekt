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
            /*
            System.out.println("Biblioteksmeny\n=======");
            System.out.println("1.Visa inlagda böcker");
            System.out.println("2.Söka efter bok");
            System.out.println("3.Hantera lån");
            System.out.println("4.Visa låntagare");
            System.out.println("5.Avsluta");
            System.out.print("===>");
            option = input.nextInt();
            if (option == 1) {
                lm.showBooks();
            } else if (option == 2) {

                int bokval = 0;
                System.out.println("Vilken bok vill du söka efter?");
                System.out.println("1.Bokens namn?");
                System.out.println("2.Bokens IBSN?");
                System.out.print("");
                bokval = input.nextInt();
                if(bokval == 1){ // Söker på namnet på boken!
                    System.out.println("Skriv in Bokens namn!");
                    System.out.print("===>");
                    String boknamn = input.next();
                    lm.getBookName(boknamn);
                }else if(bokval == 2){ //Med detta val ska man kunna söka efter ISBN
                    int isbn;
                    System.out.println("Skriv in ISBN!");
                    isbn = input.nextInt();
                    lm.getBookISBN(isbn);
                }
            } else if (option == 3) {
                System.out.println("1. Vill du ta bort bok?");
                System.out.println("2. Vill du lägga till bok?");
                System.out.println("3. Vill du registera boklån?");
                System.out.println("Vilken bok vill du ta bort?");
                System.out.print("===>");
                int bokval = 0;
                bokval = input.nextInt();

                if (bokval == 1) {
                    System.out.println("1.Ta bort med bokens namn?");
                    System.out.println("2.Ta bort med bokens IBSN?");
                    int val = 0;
                    val = input.nextInt();

                    if (val == 1) { //Söka med hjälp av bokens namn
                        String boknamn;
                        System.out.println("Skriv in bokens namn");
                        System.out.print("===>");
                        boknamn = input.next();
                        lm.deleteBookName(boknamn);
                        logger.info("Boken: " + boknamn + " har tagits bort" );

                    }
                    if (val == 2) { //Söka på ISBN...
                        int isbn;
                        System.out.println("Skriv in bokens ISBN");
                        System.out.print("===>");
                        isbn = input.nextInt();
                        lm.deleteBookISBN(isbn);
                        logger.info("Boken med ISBN: " + isbn + " har tagits bort" );
                    }
                }
                if (bokval == 2){
                    System.out.println("Lägg till bok:");
                    System.out.println("Bokens namn:");
                    String boknamn = input.next();
                    System.out.println("Bokens isbn");
                    int isbn = input.nextInt();
                    System.out.println("Antal Böcker");
                    int numberofbooks = input.nextInt();

                    lm.addBook(isbn,boknamn,numberofbooks);
                    System.out.println("Boken är inlaggd");
                    logger.info(isbn + " " + boknamn + " " + numberofbooks);
                }
                if (bokval == 3){
                    System.out.println("1.Vill du registera ett lån");
                    System.out.println("2.Vill du registrera en återlämning");
                    int val1 = 0;
                    val1 = input.nextInt();

                    if (val1 == 1){
                        System.out.println("Registrera användare och boklån");

                        logger.info("Användaren har lånat boken");
                    }
                    if (val1 == 2){
                        System.out.println("Registrera återlämnning");

                        logger.info("Användaren har återlämnat boken");
                    }
                }
                // För Users Låna, Återlämna
                // För Libriarian Lägga till, Ta bort
            } else if (option == 4) {
                System.out.println("1. Visa alla låntagere");
                System.out.println("2. Visa låntagere på specik bok");
                System.out.println("3. Visa lånetagares alla böcker");

                int val = 0;
                val = input.nextInt();

                if (val==1){
                    lm.showUsers();
                }
                if (val==2){

                }
                if (val==3){

                }
            } else if (option == 5) {
                end = true;
                System.out.println("Ha det bra");
            }

             */

            System.out.println("Välkommen till Consol-Libary!");
            System.out.println("-----------------------------");
            System.out.println();

            System.out.println("För att kunna låna böcker, återlämna böcker måste du vara inloggad. Utan att vara " +
                    "inloggad kan du se vilka böcker som finns, söka och se vilka böcker som är lediga. ");

            System.out.println();
            System.out.println("För att logga in, tryck 1");
            System.out.println("För att vara oinloggad eller skapa inlogg tryck 2 ");
            option = input.nextInt();
            if (option == 1){
                LoanManager manager = new LoanManager();
                User user = new User();

                System.out.println("Var vänlig att skriva in namn enligt följande ordning:");
                System.out.println("Förnamn:");
                String forname = input.next();
                System.out.println("Efternamn");
                String lastname = input.next();
                System.out.println("Lösenord");
                String password = input.next();
                user = manager.getUser(forname,lastname,password);
                System.out.println();
                System.out.println("Välkommen!");

                if (user.getUserType() == 1){
                    System.out.println("Du är inloggad som " + user.usertypeDescription);
                    System.out.println("Vad vill du göra?");
                    System.out.println("1.- Administrera \n" +
                            "2.- Lån & Återlämning \n" +
                            "3.- Mitt Konto");
                    option = input.nextInt();

                    if (option==1){
                        System.out.println("Vill du lägga till böcker eller ta bort?");
                        System.out.println("1.- Lägga till\n" +
                        "2.- Ta bort");
                        option = input.nextInt();
                        if (option==1){
                            System.out.println("Skriv in: \n" +
                                    "Namn: ");
                            String boknamn = input.next();
                            System.out.println("ISBN:");
                            int isbn = input.nextInt();
                            System.out.println("Hur många antal böcker är inköpta");
                            int antal = input.nextInt();
                            lm.addBook(isbn,boknamn,antal);
                            logger.info(user.getUserId() + " har lagt till " + antal + " exemplar av " + boknamn + "[" +isbn+"]");
                        } else if (option==2){
                            System.out.println("Skriv in ISBN");
                            int isbn = input.nextInt();
                            Book newBook = lm.getBookISBN(isbn);
                            String bookname = newBook.getBookName();
                            lm.deleteBookISBN(isbn);
                            logger.info(user.getUserId() + " har raderat " + bookname + "[" + isbn + "]");
                        }

                    }
                    else if (option==2){
                        System.out.println("1.- Vill du låna");
                        System.out.println("2.- Vill du återlämna?");
                        System.out.println("3.- Sök efter bok");
                        System.out.println("4.- Visa alla böcker");
                        option = input.nextInt();

                        if (option==1){
                            System.out.println("Vilken bok vill du låna?");
                            String boknamn = input.next();

                        }
                        else if (option==2){
                            System.out.println("Vilken bok vill du lämna tillbaka?");
                            // Return book
                        }
                        else if (option==3){
                            System.out.println("Vilken bok vill du söka efter?");
                            System.out.println("Vill du söka efter namn eller isbn?");
                            System.out.println("1.- Namn");
                            System.out.println("2.- ISBN");

                            option = input.nextInt();
                            if (option==1){
                                System.out.println("Skriv in bokens namn:");
                                String boknamn = input.next();
                                lm.getBookName(boknamn);
                            }
                            else if (option==2){
                                System.out.println("Skriv in bokens isbn");
                                int isbn = input.nextInt();
                                lm.getBookISBN(isbn);
                            }
                        }
                    }
                    else if (option==3){
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

                        lm.deleteUser(userid,förnamn,efternamn,usertype,password);
                        logger.info( forname + " " + lastname + " har raderats");
                        end=true;
                    }
                    else {
                        System.out.println("Felhanteringen är inte optimal, ber om ursäkt för det.");
                    }
                }
                else if (user.getUserType() == 2){
                    System.out.println("Du är inloggad som " + user.usertypeDescription);
                    System.out.println("Vad vill du göra?");
                    System.out.println("1.- Lån & Återlämning \n" +
                            "2.- Mitt Konto");

                }else if (user.getUserType() == 3){
                    System.out.println("Du är inloggad som " + user.usertypeDescription);
                    System.out.println("Vad vill du göra?");
                    System.out.println(
                            "1.- Lån & Återlämning \n" +
                            "2.- Mitt Konto");

                }else if (user.getUserType() == 4){
                    System.out.println("Du är inloggad som " + user.usertypeDescription);
                    System.out.println("Vad vill du göra?");
                    System.out.println(
                            "1.- Lån & Återlämning \n" +
                            "2.- Mitt Konto");

                }else if (user.getUserType() == 5){
                System.out.println("Du är inloggad som " + user.usertypeDescription);
                System.out.println("Vad vill du göra?");
                System.out.println(
                            "1.- Lån & Återlämning \n" +
                            "2.- Mitt Konto");

                }
            }
            else if (option == 2){
                lm.showUsers();
            }


        }


    }

}