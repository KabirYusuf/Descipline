package creditCardNumberValidation;

import creditCardNumberValidation.exceptions.InvalidCardLengthException;
import creditCardNumberValidation.exceptions.InvalidCardNumberException;

import java.util.Scanner;

public class Main {
    static CreditCardNumberValidation validation = new CreditCardNumberValidation();
    public static void main(String[] args) {
        cardNumberValidation();
    }


    public static void cardNumberValidation(){
        Scanner scanner = new Scanner(System.in);
        String number = "";
        System.out.println("Enter Credit Card Number: ");
        number = scanner.nextLine();

        try {
            validation.cardNumber(number);
            validation.isCardValid();
        }
        catch (InvalidCardLengthException | InvalidCardNumberException ex){
            System.out.println(ex.getMessage());
            cardNumberValidation();

        }

        scanner.close();

    }
}
