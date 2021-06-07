import java.sql.*;


public class LoanManager extends Book {

    public LoanManager(){}

    public void addBook(Book book){

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Music?useSSL=false","root","Hanna0811" )){
            PreparedStatement thebook = conn.prepareStatement("Insert INTO books Values (?,?,?)");
            thebook.setInt(1,book.getBookISBN());
            thebook.setString(2,book.getBookName());
            thebook.executeUpdate();
        }
        catch (SQLException ex){
            System.out.println();
        }
    }
    public void addBook(int isbn, String namn, String author){

        int ISBN = isbn;
        String Namn = namn;
        String Author = author;

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Music?useSSL=false","root","Hanna0811" )){
            PreparedStatement book = conn.prepareStatement("Insert INTO books Values (?,?,?)");
            book.setInt(1,ISBN);
            book.setString(2,Namn);
            book.executeUpdate();
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

    public void showBooks(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver did not load");
        }

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Music?useSSL=false","root","Hanna0811" )){

            // Skapar statement
            Statement statement = conn.createStatement();
            System.out.println("Böcker\n========\n");
            ResultSet result = statement.executeQuery("SELECT * FROM books" );
            // Skapar ett set där statment utför MYSQL queryn
            // Utför settet tills allt har skrivits ut
            while (result.next()) {
                System.out.println((result.getInt(1) + ": " + result.getString(2) + ": " + result.getString(3) ));
            }

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
                newBook = new Book(result.getInt(1),result.getString(2));
                System.out.println(result.getInt(1)+ " " + result.getString(2));
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
                newBook = new Book(result.getInt(1),result.getString(2));
                System.out.println(result.getInt(1)+ ": " + result.getString(2));
            }

        }
        catch (SQLException ex){
            System.out.println("Something went wrong " + ex.getMessage());
        }

        return newBook;
    }
}