package bankingApp;

import bankingApp.bankException.InvalidAmountException;
import bankingApp.bankException.InvalidPinException;

import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    static Bank bank = new Bank();
    public static void main(String[] args) {
        startAtm();
    }


    public static void startAtm(){

        String mainMenu ="""
                1. Create Account
                2. Deposit
                3. Withdraw
                4. Transfer
                5. Check Balance
                6. Exit""";
        String userInput = input(mainMenu);
        switch (userInput) {
            case "1" -> createAccount();
            case "2" -> deposit();
            case "3" -> withdraw();
            case "4" -> transfer();
            case "5" -> checkBalance();
            case "6" -> exit(6);
            default -> {
            }
        }
    }

    private static void checkBalance() {

        String accountNumber = input("Enter your account Number: ");
        String pin = input("Enter your pin: ");
        try {
            bank.checkBalance(accountNumber,pin);
        }
        catch (NullPointerException ex){
            display("No Account found");
            checkBalance();
        }
        catch (InvalidPinException ex){
            display(ex.getMessage());
            checkBalance();
        }
        display(String.format("Your account balance is: %.2f",bank.checkBalance(accountNumber,pin)));
        startAtm();
    }

    private static void transfer() {
        String senderAccountNumber = input("Enter your account Number: ");
        String pin = input("Enter your pin: ");
        double amount = doubleInput("Enter your amount: ");
        String receiverAccountNumber = input("Enter Receiver accountNumber: ");
        try {
            bank.transfer(senderAccountNumber,pin,amount,receiverAccountNumber);
        }
        catch (NullPointerException ex){
            display("No Account found");
            transfer();
        }
        catch (InvalidPinException | InvalidAmountException ex){
            display(ex.getMessage());
            transfer();
        }
        display(String.format("Transfer of %.2f was successful%nBalance: %.2f",amount,bank.checkBalance(senderAccountNumber,pin)));
        startAtm();
    }

    private static void withdraw() {
        String accountNumber = input("Enter Account number");
        double amount = doubleInput("Enter amount to withdraw");
        String pin = input("Enter pin");
        try{
            bank.withdraw(accountNumber,pin,amount);
        }
        catch (NullPointerException ex){
            display("No Account found");
            withdraw();
        }
        catch (InvalidAmountException | InvalidPinException ex){
            display(ex.getMessage());
            withdraw();
        }
        display(String.format("Withdrawal of %.2f was successful%nBalance: %.2f",amount,bank.checkBalance(accountNumber,pin)));
        startAtm();

    }

    private static void deposit() {

            String accountNumber = input("Enter account number: ");
            double amount = doubleInput("Enter amount to deposit: ");
            try {
                bank.deposit(accountNumber,amount);
            }
            catch (NullPointerException ex){
                display("Account does not exist");
                deposit();
            }
            catch (InvalidAmountException e){
                display(e.getMessage());
                deposit();
            }
            display(String.format("Deposit of %.2f was successful",amount));
            startAtm();
    }

    private static void createAccount() {
        String accountName = input("Enter your Name");
        String pin = input("Enter your pin");
        bank.createAccount(accountName,pin);
        display(String.format("Account created for %s", accountName));
        startAtm();
    }

    private static double doubleInput(String prompt) {
        display(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

    public static void display(String prompt){
        System.out.println(prompt);
    }

    private static  String input(String prompt){
        display(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
