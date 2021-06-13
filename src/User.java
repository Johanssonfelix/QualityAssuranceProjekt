public class User{
    public int userId;
    public String forName;
    public String lastName;
    public int userType;
    public int maxLoans;
    public int personalNumber;


    public User(int userId, String forname, String lastname, int userType, int maxloans, int personalNumber) {
        this.userId = userId;
        this.forName = forname;
        this.lastName = lastname;
        this.userType = userType;
        this.maxLoans = maxloans;
        this.personalNumber = personalNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        if (userId.length() == 4){
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

    public void setMaxLoans(int maxLoans){
        this.maxLoans = maxLoans;
    }

    public int getMaxLoans(){
        return maxLoans;
    }

    public void setUserType(int userType) {
        if (userType == 0 || userType == 1 || userType == 2 || userType == 3 ){
            this.userType = userType;
        }else{
            System.out.println("Usertype must have an int from 0-3");
        }
        
    }

    public void maxBooks(int userType){
        switch (userType){
            case 1 -> this.setMaxLoans(3);
            case 2 -> this.setMaxLoans(5);
            case 3 -> this.setMaxLoans(7);
            case 4 -> this.setMaxLoans(10);
        }

    }
    
    public void setPersonalNumber(int personalNumber) {
        this.personalNumber = personalNumber;
    }
    
    public int getPersonalNumber() {
        return personalNumber;
    }
}
