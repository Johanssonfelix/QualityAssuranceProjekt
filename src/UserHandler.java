public class UserHandler {
    User user = null;
    LoanManager loanManager;

    public UserHandler(User user, LoanManager loanManager){
        this.user = user;
        this.loanManager = loanManager;
    }

    /*public  boolean checkUserStatus(User user, LoanManager loanManager){
        return loanManager.getMemberStatus(user);//Skapa möjligheten i tabellerna att kontrollera användarstatusen, om de kan långa eller ej...
    }*/

    /*public boolean checkUserSuspension(User user){
        if (user.getStrikes() == 3){
            loanManager.addSuspension(user);//Kolla tabellerna, för att skapa möjligheterna att lägga till en bann
            user.suspended = true;
            return false;
        }
        return true;
    }*/

    /*public boolean checkUserBan(User user, LoanManager loanManager){
        if (user.getSuspendedUser() == 3){
            loanManager.bannedMember(user);
            loanManager.deleteUser(userid,forname,lastname,usertype,password);
        }
    }*/
}
