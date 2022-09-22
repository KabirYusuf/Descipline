package creditCardNumberValidation.exceptions;

public class InvalidCardLengthException extends RuntimeException{
    public InvalidCardLengthException(String message){
        super(message);
    }
}
