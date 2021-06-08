import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class LoanSystem extends LoanManager {
    private static Logger logger = LogManager.getLogger(LoanSystem.class.getName());

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
            System.out.println("4. Visa låntagare");
            System.out.println("5. Avsluta");
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
                System.out.println("Vilken bok vill du ta bort?");
                System.out.println("1.Söka med bokens namn?");
                System.out.println("2.Söka med bokens IBSN?");
                System.out.print("===>");
                int bokval = 0;
                bokval = input.nextInt();
                if (bokval == 1){ //Söka med hjälp av bokens namn
                    String boknamn;
                    System.out.println("Skriv in bokens namn");
                    System.out.print("===>");
                    boknamn = input.next();
                    lm.deleteBookName(boknamn);
                }
                if (bokval == 2) { //Söka på ISBN...
                    int isbn;
                    System.out.println("Skriv in bokens namn");
                    System.out.print("===>");
                    isbn = input.nextInt();
                    lm.deleteBookISBN(isbn);
                }
                // För Users Låna, Återlämna
                // För Libriarian Lägga till, Ta bort
            } else if (option == 4) {
            } else if (option == 5) {
                avsluta = true;
                System.out.println("Ha det bra");
            }
        }

    }
}