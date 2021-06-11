public class User{
    public int userId;
    public String forName;
    public String lastName;
    public int userType;
    public int maxLoans;


    public User() {
    }

    public User(int userId, String forname, String lastname, int userType, int maxloans) {
        this.userId = userId;
        this.forName = forname;
        this.lastName = lastname;
        this.userType = userType;
        this.maxLoans = maxloans;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    /*public void setUserType(int userType) {
        if (userType == 0 || userType == 1 || userType == 2 || userType == 3 ){
            this.userType = userType;
        }else{
            System.out.println("Usertype must have an int from 0-3");
        }
        if (userType == 0){
            User student = new User();
        } else if (userType == 1){
            User phD = new User();
        } else if (userType == 2){
            User master = new User();
        } else {
            if (userType == 3){
                User teacher = new User();
            }
        }
    }*/

    public void maxBooks(int userType){
        switch (userType){
            case 1 -> this.setMaxLoans(3);
            case 2 -> this.setMaxLoans(5);
            case 3 -> this.setMaxLoans(7);
            case 4 -> this.setMaxLoans(10);
        }

    }
}
