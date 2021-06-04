public class User {
    public int userId;
    public String userName;
    public int userType;
    private String password;

    public User() {
    }

    public User(int userId, String userName, int userType, String password) {
        this.userId = userId;
        this.userName = userName;
        this.userType = userType;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
