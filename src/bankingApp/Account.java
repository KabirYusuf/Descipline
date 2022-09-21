package bankingApp;

import bankingApp.bankException.*;

import java.util.Objects;

public class Account {

    private String accountName;
    private String accountNumber;
    private String pin;
    private double balance;

    public Account(String accountName, String accountNumber, String pin){
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.pin = pin;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public double getBalance(String pin) {
        if(!Objects.equals(pin, this.pin))throw new InvalidPinException("Wrong Pin Entered");
        if(isCorrectPin(pin))return balance;
        return 0;
    }

    public void deposit(double amount) {
        if(amount <= 0)throw new InvalidAmountException("Invalid Amount");
        balance = getBalance(pin) + amount;
    }

    public void withdraw(String pin, double amount) {
        boolean isValidAmount = amount <= getBalance(pin);
        if(amount > getBalance(pin))throw new InvalidAmountException("Insufficient Account Balance");
        if(!Objects.equals(pin, this.pin))throw new InvalidPinException("Wrong Pin Entered");
        if(isCorrectPin(pin) && isValidAmount)balance = getBalance(pin) - amount;
    }

    private boolean isCorrectPin(String pin){
        return Objects.equals(pin, this.pin);
    }
}
