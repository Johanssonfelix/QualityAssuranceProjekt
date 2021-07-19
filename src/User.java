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
    int suspendedUser;

    public boolean isSuspended(){
        return suspended;
    }

    boolean suspended;


    // Fixa efter låna bok fungerar.

    public User() {
    }

    public User(String forname, String lastname, int userType, String password) {
        this.userId = setUserId();
        this.forName = forname;
        this.lastName = lastname;
        this.userType = userType;
        this.password = password;

        this.UsertypeDescription();
        this.setMaxLoans(userType);
    }

    public User(String forname, String lastname, int userType, String password, int suspendedUser) {
        this.userId = setUserId();
        this.forName = forname;
        this.lastName = lastname;
        this.userType = userType;
        this.password = password;
        this.suspendedUser = suspendedUser;

        this.UsertypeDescription();
        this.setMaxLoans(userType);
    }

    public int getUserId() {
        return userId;

    }
    public int setUserId() {

        Random randomID = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int randomNumber = randomID.nextInt(10);
            stringBuilder.append(randomNumber);
        }

        return Integer.parseInt(stringBuilder.toString());

    }

    public String getForName() {
        return forName;
    }
    public void setForName(String forname) {
        this.forName = forname;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    public int getUserType() {
        return userType;
    }

    public void setStrikes(int strikes){
        this.strikes = strikes;
    }

    public int getStrikes(){
        return strikes;
    }

    public int getSuspendedUser() {
        return suspendedUser;
    }
    public void setSuspendedUser(int suspendedUser){
        this.suspendedUser = suspendedUser;
    }


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

    public void setUserType(int userType) {
        if (userType == 0 || userType == 1 || userType == 2 || userType == 3) {
            this.userType = userType;
        } else {
            System.out.println("Usertype must have an int from 0-3");
        }

    }

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

    public String getPassword(){return password;}
    public void setPassword(String password){
        if (password.length() <= 3){
            System.out.println("Lösenord är för kort, måste vara minst 4 bokstäver");
        } else {
            this.password = password;
        }
    }
}
