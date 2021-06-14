public class User{
    public int userId;
    public String forName;
    public String lastName;
    private int userType;
    public String usertypeDescription;
    public int maxLoans;



    public User( String forname, String lastname, int userType) {
        this.userId = getUserId();
        this.forName = forname;
        this.lastName = lastname;
        this.userType = userType;

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        if (userId == 4){
            this.userId = userId;
        } else {
            System.out.println("The userId must be 4 digits long.");
        }
        
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

    public void setMaxLoans(){
        if (userType == 0){
           this.maxLoans = 3;
        } else if (userType == 1){
            this.maxLoans = 5;
        } else if (userType == 2){
            this.maxLoans = 7;
        } else if (userType == 3){
            this.maxLoans = 10;
        }
    }

    public int getMaxLoans(){
        return maxLoans;
    }

    public void setUserType(int userType) {
        if (userType == 0){
            usertypeDescription = "Student";
            this.userType = userType;
        } else if (userType == 1){
            usertypeDescription = "Master";
            this.userType = userType;
        } else if (userType == 2){
            usertypeDescription = "PhD";
            this.userType = userType;
        } else if (userType == 3){
            usertypeDescription = "Lärare";
            this.userType = userType;
        }
        else{
            System.out.println("Usertype must have an int from 0-3, the number should have the right description depending on wheter he is a student, or a teacher");
        }
        
    }
/*
    public void maxBooks(int userType){
        switch (userType){
            case 1 -> this.setMaxLoans(3);
            case 2 -> this.setMaxLoans(5);
            case 3 -> this.setMaxLoans(7);
            case 4 -> this.setMaxLoans(10);
        }

    }

 */

}
