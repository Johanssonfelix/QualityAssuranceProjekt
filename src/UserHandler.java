public class UserHandler {
    User user = null;
    LoanManager loanManager;

    public UserHandler(User user, LoanManager loanManager){
        this.user = user;
        this.loanManager = loanManager;
    }

    public void addUser(String forname, String lastname, int usertype, String password){
        loanManager.addUser(forname, lastname,usertype, password);
    }

    public void removerUser(int userid, String forname, String lastname, int usertype, String password){
        loanManager.deleteUser(userid,forname, lastname,usertype,password);
    }
/*
    public void addStrike(){
        loanManager.addStrike(user);
    }
/*
    public boolean checkUserSuspension(User user){
        if (user.getStrikes() == 3){
            loanManager.addSuspension(user.userId);//Skapa en sql-metod som gör detta möjligt, samt uppdatera tabellerna
            user.suspended = true;
            return false;
        }
        return true;
    }

    /*public boolean checkUserBan(User user, LoanManager loanManager){
        //if (user.getSuspendedUser())
    }*/


}
