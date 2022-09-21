package bankingApp.bankException;

public class InvalidAmountException extends  RuntimeException {
    public InvalidAmountException(String message){
        super(message);
    }
}
