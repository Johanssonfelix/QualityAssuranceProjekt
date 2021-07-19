public class UserHandler {
    User user = null;
    LoanManager loanManager;

    public UserHandler(User user, LoanManager loanManager){
        this.user = user;
        this.loanManager = loanManager;
    }

    public boolean checkUserSuspension(User user){
        if (user.getStrikes() == 3){
            //loanManager.addUserSuspension(user);Skapa en sql-metod som gör detta möjligt, samt uppdatera tabellerna
            user.suspended = true;
            return false;
        }
        return true;
    }

}
