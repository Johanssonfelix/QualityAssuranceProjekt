public class User{
    public int userId;
    public String forname;
    public String lastname;
    public int userType;

    public User() {
    }

    public User(int userId, String forname, String lastname, int userType) {
        this.userId = userId;
        this.forname = forname;
        this.lastname = lastname;
        this.userType = userType;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getForName() {
        return forname;
    }

    public void setForName(String forname) {
        this.forname = forname;
    }
    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
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
    }
}
