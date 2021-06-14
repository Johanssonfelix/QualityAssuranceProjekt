import java.util.ArrayList;
import java.util.Random;

public class generateUserID {

    public generateUserID(){

    }

    public static int generateUserId(){
        Random randomID = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 4; i++){
            int randomNumber = randomID.nextInt(10);
            stringBuilder.append(randomNumber);
        }
        return Integer.parseInt(stringBuilder.toString());
    }

    public static int returnUserId(ArrayList<Integer> userArray){
        int newUserId = generateUserId();
        for (int i : userArray ){
            if (newUserId == i){
                returnUserId(userArray);
            }
        }
        System.out.println("Nytt användarID" + newUserId);
        return newUserId;
    }
}
