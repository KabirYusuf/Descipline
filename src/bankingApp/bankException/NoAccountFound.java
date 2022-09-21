package bankingApp.bankException;

public class NoAccountFound extends RuntimeException{
    public NoAccountFound(String message){
        super(message);
    }
}
