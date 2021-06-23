import java.util.Random;

public class User {
    public int userId;
    public String forName;
    public String lastName;
    public int userType;
    public String usertypeDescription;
    public int maxLoans;
    public int currentnumberofloans;
    public String password;
    public int strikes;


    public User() {
    }

    public User(String forname, String lastname, int userType, String password) {

        this.forName = forname;
        this.lastName = lastname;
        this.userType = userType;
        this.password = password;
        this.currentnumberofloans = 0;
        this.strikes = 0;
        this.UsertypeDescription();
        this.setMaxLoans(userType);
    }

    // Fungerar men setUserId måste göras efter en ny user skapats
    public int getUserId() {
        return userId;

    }
    public int setUserId() {
        Random randomID = new Random();
        userId = randomID.nextInt(10000);
        return userId;
    }

    // Bör fungera
    public String getForName() {
        return forName;
    }
    public void setForName(String forname) {
        this.forName = forname;
    }

    // Bör fungera
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    // Fungerar
    public int getUserType() {
        return userType;
    }

    // Inte utvecklat vidare(Inte påbörjad av Felix)
    public void setStrikes(int strikes){
        this.strikes = strikes;
    }
    public int getStrikes(){
        return strikes;
    }

    // Fungerar
    public void setMaxLoans(int userType) {
        if (userType == 0) {
            this.maxLoans = 3;
        } else if (userType == 1) {
            this.maxLoans = 5;
        } else if (userType == 2) {
            this.maxLoans = 7;
        } else if (userType == 3) {
            this.maxLoans = 10;
        }
    }
    public int getMaxLoans() {
        return maxLoans;
    }

    // Fungerar
    public void setUserType(int userType) {
        if (userType == 0 || userType == 1 || userType == 2 || userType == 3) {
            this.userType = userType;
        } else {
            System.out.println("Usertype must have an int from 0-3");
        }

    }

    // Fungerar
    public void UsertypeDescription() {
        if (userType == 0) {
            this.usertypeDescription = "Student";

        } else if (userType == 1) {
            this.usertypeDescription = "Master";

        } else if (userType == 2) {
            this.usertypeDescription = "PhD";

        } else if (userType == 3) {
            this.usertypeDescription = "Lärare";

        }
    }

    // Fungerar
    public String getPassword(){return password;}
    public void setPassword(String password){
        if (password.length() <= 3){
            System.out.println("Lösenord är för kort, måste vara minst 4 bokstäver");
        } else {
            this.password = password;
        }
    }
}
