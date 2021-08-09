import java.sql.*;
import java.util.ArrayList;

// Fixa suspension och strikes i mån av tid, returnbook halvklar.
// Testning ska göras klart.

public class LoanManager extends Book {

    int loanId = 0;

    public LoanManager(){}

    // Fungerar
    public void showBooks(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver did not load");
        }

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Music?useSSL=false","root","Hanna0811" )){

            // Skapar statement
            Statement statement = conn.createStatement();
            System.out.println();
            System.out.println("Böcker");
            System.out.println(" ISBN " + "  Bokensnamn" + "\n ----   ---------- \n" );
            ResultSet result = statement.executeQuery("SELECT * FROM books" );
            // Skapar ett set där statment utför MYSQL queryn
            // Utför settet tills allt har skrivits ut
            while (result.next()) {
                System.out.println((result.getInt(1) + ": " + result.getString(2)));
            }
            System.out.println();
        }
        catch (SQLException ex){
            System.out.println("Something went wrong " + ex.getMessage());
        }

    }

    // Fungerar
    public void showUsers(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver did not load");
        }

        try (Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/Music?useSSL=false","root","Hanna0811" )) {
            Statement statement = connect.createStatement();
            System.out.println();
            System.out.println("Användare");
            System.out.println(" UserId Förnamn Efternamn Användartyp");
            System.out.println();
            ResultSet result = statement.executeQuery("SELECT * FROM users");

            while (result.next()) {
                System.out.println((result.getInt(1) + ": " + result.getString(2) + " " + result.getString(3) +": " + result.getString(4)));
            }
            System.out.println();
        }
        catch (SQLException ex){
            System.out.println("Something went wrong " + ex.getMessage());
        }

        }

    // Fungerar, ändrade tillbaka tilll void, men vi kör boolean som Jakob fixade
    // Vi förändrar även de andra add/delete metoder till booleans
    public void addBook(int isbn, String namn, int numberofbooks){

        int ISBN = isbn;
        String Namn = namn;
        int NumberOfBooks = numberofbooks;


        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Music?useSSL=false","root","Hanna0811" )){
            PreparedStatement book = conn.prepareStatement("Insert INTO books Values (?,?,?)");
            book.setInt(1,ISBN);
            book.setString(2,Namn);
            book.setInt(3,NumberOfBooks);
            book.executeUpdate();

        }
        catch (SQLException ex){
            System.out.println("Something went wrong " + ex.getMessage());
        }


    }

    // Har fungerat innan
    public void addUser( String forname, String lastname, int usertype, String password){
        User newUser = new User(forname,lastname,usertype,password);

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Music?useSSL=false","root","Hanna0811" )){
            PreparedStatement user = conn.prepareStatement("Insert INTO user Values (?,?,?,?,?)");
            user.setInt(1,newUser.setUserId());
            user.setString(2,forname);
            user.setString(3,lastname);
            user.setInt(4,usertype);
            user.setString(5,password);
            user.executeUpdate();
        }
        catch (SQLException ex){
            System.out.println("Something went wrong " + ex.getMessage());
        }


    }
    

    // Fungerar
    public void deleteBookISBN(int isbn){//Ändrade även namnet på denna...
        int ISBN = isbn;


        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Music?useSSL=false","root","Hanna0811" )){
            PreparedStatement book = conn.prepareStatement("DELETE FROM books where ISBN = ?");
            book.setInt(1,ISBN);

            book.executeUpdate();
        }
        catch (SQLException ex){
            System.out.println("Something went wrong " + ex.getMessage());
        }


    }

    // Fungerar
    public void deleteBookName(String name){//La till denna metoden för att kunna ta bort boken på namn, men kunde inte testa den...


        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Music?useSSL=false","root","Hanna0811" )){
            PreparedStatement book = conn.prepareStatement("DELETE FROM books where bookname = ?");
            book.setString(1,name);

            book.executeUpdate();
        }
        catch (SQLException ex){
            System.out.println("Something went wrong " + ex.getMessage());
        }
    }

    // Fungerar
    public void deleteUser(int userid, String forname, String lastname, int usertype, String password){
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Music?useSSL=false","root","Hanna0811" )){
            PreparedStatement user = conn.prepareStatement("DELETE FROM users where userId = ? and forname = ? and lastname = ? and usertype = ? and password = ?");
            user.setInt(1,userid);
            user.setString(2, forname);
            user.setString(3,lastname);
            user.setInt(4,usertype);
            user.setString(5,password);

            user.executeUpdate();
        }
        catch (SQLException ex){
            System.out.println("Something went wrong " + ex.getMessage());
        }
    }

   // Fungerar
    public Book getBookName(String name){//La till detta då man tydligen skulle kunna söka efter bokens namn också... Men kunde inte testa den.
        Book newBook = new Book();



        String Sql = "SELECT * FROM books WHERE bookname = ?";


        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Music?useSSL=false","root","Hanna0811" )){
            // Skapar statement
            PreparedStatement ps = conn.prepareStatement(Sql);
            ps.setString(1,name);
            ResultSet result = ps.executeQuery();

            // Skapar ett set där statment utför MYSQL queryn
            // Utför settet tills allt har skrivits ut
            while (result.next()) {
                newBook = new Book(result.getInt(1),result.getString(2), result.getInt(3));
            //    System.out.println("ISBN: " + result.getInt(1)+ ", Boknamn: " + result.getString(2)+ ", Antal lediga böcker: " + result.getInt(3));
            }

        }
        catch (SQLException ex){
            System.out.println("Something went wrong " + ex.getMessage());
        }

        return newBook;
    }

    // Fungerar
    public Book getBookISBN(int isbn){//Bytte namn på denna....
        Book newBook = new Book();

        String Sql = "SELECT * FROM books WHERE ISBN=" + isbn;

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Music?useSSL=false","root","Hanna0811" )){
            // Skapar statement
            Statement statement = conn.createStatement();
         //   System.out.println("Boken\n========\n");
            ResultSet result = statement.executeQuery(Sql);


            // Skapar ett set där statment utför MYSQL queryn
            // Utför settet tills allt har skrivits ut
            while (result.next()) {
                newBook = new Book(result.getInt(1),result.getString(2), result.getInt(3));
              //  System.out.println("ISBN: " + result.getInt(1)+ ", Boknamn: " + result.getString(2)+ ", Antal lediga böcker: " + result.getInt(3));
            }

        }
        catch (SQLException ex){
            System.out.println("Something went wrong " + ex.getMessage());
        }

        return newBook;
    }

    // Fungerar
    public User getUser(int userId, String password){
        User newUser = new User();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Music?useSSL=false","root","Hanna0811" )){
            // Skapar statement
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM users where userId= ?  AND password= ?");
        //    System.out.println("Användare\n========\n");
            statement.setInt(1,userId);
            statement.setString(2,password);
            ResultSet result = statement.executeQuery();


            // Skapar ett set där statment utför MYSQL queryn
            // Utför settet tills allt har skrivits ut
            while (result.next()) {
                newUser = new User(result.getString(2),result.getString(3), result.getInt(4), result.getString(5));
                newUser.userId = result.getInt(1);
                //    System.out.println("Förnamn: " + result.getString(2)+ ", Efternamn: " + result.getString(3)+ ", Användartyp: " + result.getInt(4));
            }

        }
        catch (SQLException ex){
            System.out.println("Something went wrong " + ex.getMessage());
        }

        return newUser;
    }

    // Fungerar
    public User getUser(String fname, String lname, String pword){
      User newUser = new User();

      try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Music?useSSL=false","root","Hanna0811" )){
          PreparedStatement statement = conn.prepareStatement("SELECT * FROM users where forname= ? AND lastname= ?  AND password= ?");
          statement.setString(1,fname);
          statement.setString(2,lname);
          statement.setString(3, pword);
          ResultSet result = statement.executeQuery();

          while (result.next()){
              newUser = new User(result.getString(2),result.getString(3),result.getInt(4),result.getString(5));
              newUser.userId=result.getInt(1);

         //     System.out.println(result.getString(2) + " " + result.getString(3));
          }

      }catch (SQLException exception){
          System.out.println("Något blev fel");
          System.out.println(exception.getMessage());
      }

      return newUser;
    }

    // Fungerar, men inte klar
    public void loanBook(Book book, User user) {

        /*
        int availableBooks = 0;

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Music?useSSL=false","root","Hanna0811" )){
            String sql = "SELECT numberofbooks FROM books WHERE ISBN=";//Kom inte ihåg om vi la antalet i book eller i en kopplingstabell
            PreparedStatement newloan = conn.prepareStatement(sql);
            newloan.setInt(3, book.getNumOfBooks() - 1);
            ResultSet resultSet = newloan.executeQuery();

            while (resultSet.next()){
                availableBooks = resultSet.getInt(3);
            }
        } catch (SQLException ex) {
            System.out.println("Something went wrong " + ex.getMessage());
        }


        if (availableBooks > 0){
            try {Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Music?useSSL=false","root","Hanna0811");

                PreparedStatement nps = conn.prepareStatement("UPDATE book set numberofbooks = numberofbooks - 1 WHERE isbn= + isbn");//Kom inte ihåg strukturen
                nps.executeUpdate();

                PreparedStatement newNPS = conn.prepareStatement("INSERT INTO bookuser VALUES (?,?,?)");//Kom inte ihåg strukturen
                newNPS.setInt(1, newbook.getBookISBN());
                newNPS.setString(2, book.bookName);
                newNPS.setInt(3,user.getUserId());

                newNPS.executeUpdate();

                book.setLoanUser(user.getUserId());
                System.out.println(book.getBookName() + " har nu lånats");
                System.out.println("Tillgängligt antal kvar: " + (availableBooks - 1) );
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                System.out.println("Något gick fel");
            }
        }else{
            System.out.println("Inga tillgängliga böcker");
        }

         */

        if (user.currentnumberofloans > user.maxLoans || user.suspendedUser == 1){
            System.out.println("Du har för många lån eller är du avstängd");
        } else {
            int availableBooks = 0;

            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Music?useSSL=false", "root", "Hanna0811")) {
                String sql = "SELECT numberofbooks FROM books WHERE ISBN=" + book.getBookISBN();
                //Kom inte ihåg om vi la antalet i book eller i en kopplingstabell
                // Tar detta från books istället för kopplingstabellen

                PreparedStatement statement = conn.prepareStatement(sql);
                //    statement.setInt(1, book.getNumOfBooks() - 1);
                statement.executeQuery();


            } catch (SQLException ex) {
                System.out.println("Something went wrong " + ex.getMessage());
            }

            if (book.getNumOfBooks() >= 1) {
                book.setLoandate();
                book.setReturnDate();

                try {
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Music?useSSL=false", "root", "Hanna0811");

                    String sql = "Insert Into bookuser VALUES (?,?,?,?,?,?)";
                    PreparedStatement loan = conn.prepareStatement(sql);
                    loan.setInt(1, book.getBookISBN());
                    loan.setString(2, book.getBookName());
                    loan.setInt(3, user.getUserId());
                    loan.setDate(4, Date.valueOf(book.getLoanDate()));
                    loan.setDate(5, Date.valueOf(book.getReturnDate()));
                    loan.setInt(6,loanId++);
                    loan.executeUpdate();

                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                    System.out.println("Något gick fel");
                }

                try {
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Music?useSSL=false", "root", "Hanna0811");
                    String sql2 = "UPDATE books SET numberofbooks = ? Where isbn= ?";
                    PreparedStatement numberupdate = conn.prepareStatement(sql2);
                    numberupdate.setInt(1, book.numOfBooks - 1);
                    numberupdate.setInt(2, book.getBookISBN());
                    numberupdate.executeUpdate();

                } catch (SQLException exception) {
                    System.out.println(exception.getMessage());
                    System.out.println("Något gick fel");
                }
                user.currentnumberofloans++;
            } else if (book.getNumOfBooks() == 0) {
                System.out.println("Ledsen, denna bok är inte tillgägnlig för att lån idag. Den");
                System.out.print(book.getReturnDate() + " ska boken vara lämnad åter.");
            }
        }
    }

    // Jag, Felix har inte rört denna ännu
  /*  public void returnBook(Book book, User user){
/*
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Music?useSSL=false","root","Hanna0811");
            PreparedStatement nps = conn.prepareStatement("UPDATE book SET antal = antal + 1 WHERE isbn=?");//Inte säker på kommandot
            PreparedStatement nnps = conn.prepareStatement("DELETE from (LÅnadav, Kopplingstabellen?) where isbn = ? and (lånad av person? = ?)");//Inte säker på kommandot

            try {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Music?useSSL=false", "root", "Hanna0811");

           //     String sql = "DELETE FROM Row where loanId =?";
                PreparedStatement loan = conn.prepareStatement(sql);
                loan.setInt(1, book.getBookISBN());
                loan.setString(2, book.getBookName());
                loan.setInt(3, user.getUserId());
                loan.setDate(4, Date.valueOf(book.getLoanDate()));
                loan.setDate(5, Date.valueOf(book.getReturnDate()));
                loan.setInt(6,loanId++);
                loan.executeUpdate();

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                System.out.println("Något gick fel");
            }
      /*
            nnps.setInt(1, newbook.getBookISBN());
            nnps.setInt(2, user.getUserId());
            nps.setInt(1, newbook.getBookISBN());



        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }



    }
    /*

   */


    // Jag, Felix har inte rört denna ännu
    public Book[] checkAvailableBooks(int isbn){
        ArrayList<Book> tList = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Music?useSSL=false","root","Hanna0811");
            String sql = "Select isbn, (lånadav?) from (kopplingstabell) Where isbn = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setInt(1, isbn);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                tList.add(new Book(rs.getInt(1), rs.getInt(2)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        Book[] books = new Book[tList.size()];
        return tList.toArray(books);
    }

    public void addStrike(User user){//Lite som jag har tänkt mig att det ska fungera men vi får se...
        LoanManager lm = new LoanManager();
        if (user.getStrikes() < 3){
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Music?useSSL=false","root","Hanna0811");
            String sql = "UPDATE users SET strikes = ? Where userid = ?";//Vi får kolla tabellerna angående detta
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, user.strikes + 1 );
            preparedStatement.setInt(2, user.getUserId());
            preparedStatement.executeUpdate();
            System.out.println("Bok inlämand för sent, Strike tilldelad användare");


        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }
        }
        else {
          //  lm.addSuspension(user.getUserId());
        }


    }

    // Suspension
/*
    public void addSuspension(User user){//Vi får testa lite...
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Music?useSSL=false","root","Hanna0811");
            String sql = ("UPDATE user SET strikes=0, suspensions = suspensions+1, suspended=true, suspensiondate = DATE_ADD(CURRENT_DATE, INTERVAL 15 DAY) WHERE userid = ?");//Lite så här jag tänker att det ska fungera.
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, user.getUserId());
            preparedStatement.executeUpdate();
            System.out.println("Avstängning tillagd");

        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }
    }

    public void removeSuspension(int userid){//En grund att stå på
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Music?useSSL=false","root","Hanna0811");
            String sql = ("UPDATE user SET suspended=false, (suspensiondate=null?), strikes=0 WHERE userid = ?");
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, userid);
            preparedStatement.executeUpdate();

            System.out.println("Avstängning borttagen");

        }
        catch (SQLException e){
            System.out.println(e.getErrorCode());
        }

    }



 */

}