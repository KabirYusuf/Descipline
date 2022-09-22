package creditCardNumberValidation.exceptions;

public class InvalidCardNumberException extends RuntimeException{
    public InvalidCardNumberException(String message){
        super(message);
    }
}
