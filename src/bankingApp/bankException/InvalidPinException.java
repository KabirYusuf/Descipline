package bankingApp.bankException;

public class InvalidPinException extends RuntimeException{
    public InvalidPinException(String message){
        super(message);
    }
}
