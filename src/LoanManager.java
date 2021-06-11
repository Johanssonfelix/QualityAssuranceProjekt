import java.sql.*;


public class LoanManager extends Book {

    public LoanManager(){}

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
    public void addUser(int userid, String forname, String lastname, int usertype){


        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Music?useSSL=false","root","Hanna0811" )){
            PreparedStatement user = conn.prepareStatement("Insert INTO user Values (?,?,?,?)");
            user.setInt(1,userid);
            user.setString(2,forname);
            user.setString(3,lastname);
            user.setInt(4,usertype);
            user.executeUpdate();
        }
        catch (SQLException ex){
            System.out.println("Something went wrong " + ex.getMessage());
        }


    }

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
    public void deleteUser(int userid, String forname, String lastname, int usertype){
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Music?useSSL=false","root","Hanna0811" )){
            PreparedStatement user = conn.prepareStatement("DELETE FROM users where userId = ? and forname = ? and lastname = ? and usertype = ? ");
            user.setInt(1,userid);
            user.setString(2, forname);
            user.setString(3,lastname);
            user.setInt(4,usertype);

            user.executeUpdate();
        }
        catch (SQLException ex){
            System.out.println("Something went wrong " + ex.getMessage());
        }
    }

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
                System.out.println("ISBN: " + result.getInt(1)+ ", Boknamn: " + result.getString(2)+ ", Antal lediga böcker: " + result.getInt(3));
            }

        }
        catch (SQLException ex){
            System.out.println("Something went wrong " + ex.getMessage());
        }

        return newBook;
    }
    public Book getBookISBN(int isbn){//Bytte namn på denna....
        Book newBook = new Book();

        String Sql = "SELECT * FROM books WHERE ISBN=" + isbn;

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Music?useSSL=false","root","Hanna0811" )){
            // Skapar statement
            Statement statement = conn.createStatement();
            System.out.println("Boken\n========\n");
            ResultSet result = statement.executeQuery(Sql);


            // Skapar ett set där statment utför MYSQL queryn
            // Utför settet tills allt har skrivits ut
            while (result.next()) {
                newBook = new Book(result.getInt(1),result.getString(2), result.getInt(3));
                System.out.println("ISBN: " + result.getInt(1)+ ", Boknamn: " + result.getString(2)+ ", Antal lediga böcker: " + result.getInt(3));
            }

        }
        catch (SQLException ex){
            System.out.println("Something went wrong " + ex.getMessage());
        }

        return newBook;
    }


}