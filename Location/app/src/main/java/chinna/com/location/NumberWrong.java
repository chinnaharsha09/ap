package chinna.com.location;

public class NumberWrong extends Exception {
    private String message = "";
    public NumberWrong(String _message){
        this.message = _message;
    }
}
