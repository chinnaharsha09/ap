package chinna.com.location;

public class OwnerVO {
    public int getNumber() throws NumberWrong {
        String message = "Error";
        if (!message.isEmpty()) {
            return 1;
        } else {
            throw new NumberWrong("Number not valid");
        }
    }
}
