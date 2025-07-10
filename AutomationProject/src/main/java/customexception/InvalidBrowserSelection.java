package customexception;

public class InvalidBrowserSelection extends RuntimeException{

    public InvalidBrowserSelection(String message){
        super(message);
    }
}
