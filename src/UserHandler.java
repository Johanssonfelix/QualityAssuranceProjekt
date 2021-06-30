public class UserHandler {
    User user;
    LoanManager lm;

    public UserHandler(User user, LoanManager loanManager) {
        this.user = user;
        this.lm = loanManager;
    }

    public void addUser(String forname, String lastname, int usertype, String password) {
        lm.addUser(forname, lastname, usertype, password);
    }

    public void removeUser(int userid, String forname, String lastname, int usertype, String password) {
        lm.deleteUser(userid, forname, lastname, usertype, password);
    }

}
