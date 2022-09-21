package bankingApp;

import java.util.Objects;

public class Bank {

    Account [] accounts = new Account[5];
    private int count = 0;
    public void createAccount(String accountName,String pin) {
        Account account = new Account(accountName, (count + 1)+ "", pin);
        accounts[count] = account;
        count++;
    }

    public Account findAccount(String accountNumber) {
        for (Account account:accounts) {
            if(Objects.equals(accountNumber, account.getAccountNumber())){
                return account;
            }

        }
        throw new NullPointerException("Account not found");

    }

    public double checkBalance(String accountNumber, String pin) {
        Account account = findAccount(accountNumber);
        return account.getBalance(pin);
    }

    public void deposit(String accountNumber, double amount) {
        Account account = findAccount(accountNumber);
        account.deposit(amount);
    }



    public void withdraw(String accountNumber, String pin, double amount) {
        Account account = findAccount(accountNumber);
        account.withdraw(pin,amount);
    }
    public void transfer(String senderAccountNumber, String pin, double amount, String receiverAccountNumber ) {
        findAccount(senderAccountNumber);
        findAccount(receiverAccountNumber);
        withdraw(senderAccountNumber,pin,amount);
        deposit(receiverAccountNumber,amount);
    }



}
