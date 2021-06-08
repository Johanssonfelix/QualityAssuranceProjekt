import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class LoanSystem extends LoanManager {
    private static Logger logger = LogManager.getLogger(LoanSystem.class);

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);


        int option = 0;
        boolean avsluta = false;
        LoanManager lm = new LoanManager();
        while (!avsluta) {
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
                System.out.println("Visa alla låntagere");
                System.out.println("Visa låntagere på specik bok");
                System.out.println("Visa lånetagares alla böcker");
            } else if (option == 5) {
                avsluta = true;
                System.out.println("Ha det bra");
            }
        }

    }
}