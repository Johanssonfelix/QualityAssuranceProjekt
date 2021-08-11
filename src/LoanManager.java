import java.sql.*;

public class LoanManager extends Book {
    int loanId = 0;

    public LoanManager(){}

    public void showBooks(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver did not load");
        }

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Music?useSSL=false","root","Hanna0811" )){

            Statement statement = conn.createStatement();
            System.out.println();
            System.out.println("Böcker");
            System.out.println(" ISBN " + "  Bokensnamn" + "\n ----   ---------- \n" );
            ResultSet result = statement.executeQuery("SELECT * FROM books" );

            while (result.next()) {
                System.out.println((result.getInt(1) + ": " + result.getString(2)));
            }
            System.out.println();
        }
        catch (SQLException ex){
            System.out.println("Something went wrong " + ex.getMessage());
        }
    }

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

    public void deleteBookISBN(int isbn){
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

    public void deleteBookName(String name){

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Music?useSSL=false","root","Hanna0811" )){
            PreparedStatement book = conn.prepareStatement("DELETE FROM books where bookname = ?");
            book.setString(1,name);
            book.executeUpdate();
        }
        catch (SQLException ex){
            System.out.println("Something went wrong " + ex.getMessage());
        }
    }

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

    public Book getBookName(String name){
        Book newBook = new Book();
        String Sql = "SELECT * FROM books WHERE bookname = ?";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Music?useSSL=false","root","Hanna0811" )){
            PreparedStatement ps = conn.prepareStatement(Sql);
            ps.setString(1,name);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                newBook = new Book(result.getInt(1),result.getString(2), result.getInt(3));
            }
        }
        catch (SQLException ex){
            System.out.println("Something went wrong " + ex.getMessage());
        }
        return newBook;
    }

    public Book getBookISBN(int isbn){
        Book newBook = new Book();
        String Sql = "SELECT * FROM books WHERE ISBN=" + isbn;

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Music?useSSL=false","root","Hanna0811" )){
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(Sql);

            while (result.next()) {
                newBook = new Book(result.getInt(1),result.getString(2), result.getInt(3));
            }

        }
        catch (SQLException ex){
            System.out.println("Something went wrong " + ex.getMessage());
        }

        return newBook;
    }

    public User getUser(int userId, String password){
        User newUser = new User();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Music?useSSL=false","root","Hanna0811" )){
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM users where userId= ?  AND password= ?");
            statement.setInt(1,userId);
            statement.setString(2,password);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                newUser = new User(result.getString(2),result.getString(3), result.getInt(4), result.getString(5));
                newUser.userId = result.getInt(1);
            }
        }
        catch (SQLException ex){
            System.out.println("Something went wrong " + ex.getMessage());
        }
        return newUser;
    }

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
          }

      }catch (SQLException exception){
          System.out.println("Något blev fel");
          System.out.println(exception.getMessage());
      }

      return newUser;
    }

    public void loanBook(Book book, User user) {

        if (user.currentnumberofloans > user.maxLoans || user.suspendedUser == 1){
            System.out.println("Du har för många lån eller är du avstängd");
        } else {

            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Music?useSSL=false", "root", "Hanna0811")) {
                String sql = "SELECT numberofbooks FROM books WHERE ISBN=" + book.getBookISBN();
                PreparedStatement statement = conn.prepareStatement(sql);
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
                System.out.println("Grattis till lånet");
                user.currentnumberofloans++;
            } else if (book.getNumOfBooks() == 0) {
                System.out.println("Ledsen, denna bok är inte tillgägnlig för att lån idag. Den");
                System.out.print(book.getReturnDate() + " ska boken vara lämnad åter.");
            }
        }
    }

    public void returnBook(Book book, User user){

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Music?useSSL=false","root","Hanna0811");
            PreparedStatement nps = conn.prepareStatement("UPDATE book SET numberofbooks = numberofbooks + 1 WHERE ISBN=?");//Inte säker på kommandot
            PreparedStatement nnps = conn.prepareStatement("DELETE from bookuser where isbn = ? AND userId = ? ");//Inte säker på kommandot, kan vara loanId också...
            nnps.setInt(1, book.getBookISBN());
            nnps.setInt(2, user.getUserId());
            nps.setInt(1, book.getBookISBN());

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Boken är återlämnad");

    }

/*
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