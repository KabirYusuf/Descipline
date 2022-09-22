package creditCardNumberValidation;

import creditCardNumberValidation.exceptions.InvalidCardLengthException;
import creditCardNumberValidation.exceptions.InvalidCardNumberException;

public class CreditCardNumberValidation {
    private String cardNumber;
    private String secondDigits;


    public void cardNumber(String cardNumber){
        isValidNumber(cardNumber);
        isValidLength(cardNumber);
        isContainLetter(cardNumber);
        this.cardNumber = cardNumber;

    }

    public static boolean isValidNumber(String cardNumber) {
        int cardNumberLength = cardNumber.length();
        for (int i = 0; i < cardNumberLength; i++) {
            if (cardNumber.charAt(0) == '4' ||cardNumber.charAt(0) == '5' ) return true;
        }
        throw new InvalidCardNumberException("Card Number is Invalid");
    }

    public static boolean isContainLetter(String cardNumber) {
        int cardNumberLength = cardNumber.length();
        for (int i = 0; i < cardNumberLength; i++) {
            if (Character.isLetter(cardNumber.charAt(i)))
                throw new InvalidCardNumberException("Card number must not contain letter!! ");
        }
        return true;
    }

    public static boolean isValidLength(String cardNumber) {
        int cardNumberLength = cardNumber.length();
        boolean isValidLength = (cardNumberLength >= 13 && cardNumberLength <= 16);
        if (isValidLength) {
            return true;
        } else {
            throw new InvalidCardLengthException("Card digits must be >=13 and <= 16");
        }
    }

    public void SecondDigits() {

        int cardNumberLength = cardNumber.length();
        secondDigits = "";
        for (int i = cardNumberLength - 2; i >= 0; i -= 2) {
            secondDigits += cardNumber.charAt(i);
        }

    }

    public String getSecondDigits() {
        return secondDigits;
    }

    public long getSecondDigitsDoubled() {
        long totalValue = 0;
        int cardNumberLength = cardNumber.length();
        String secondDigits = "";
        for (int i = cardNumberLength - 2; i >= 0; i -= 2) {
            secondDigits += cardNumber.charAt(i);
            long value = longValue(secondDigits) * 2;
            if (value > 9) totalValue += addProductValue(value);
            else totalValue += value;
            secondDigits = "";
        }
        return totalValue;
    }

    private long addProductValue(long value) {
        long decimalValue = value / 10;
        long modulusValue = value % 10;
        return decimalValue + modulusValue;
    }

    private long longValue(String secondDigits) {
        return Long.parseLong(secondDigits);
    }

    public long getSumOffOddPlace(){
        long totalOfOddPlace = 0;
        int cardNumberLength = cardNumber.length();
        String oddPlaceDigits = "";
        for (int i = cardNumberLength - 1; i >= 0 ; i -= 2) {
            oddPlaceDigits += cardNumber.charAt(i);
            totalOfOddPlace += longValue(oddPlaceDigits);
            oddPlaceDigits = "";
        }
        return totalOfOddPlace;

    }


    public long getSumOfOddAndSecond() {
        return  getSumOffOddPlace() + getSecondDigitsDoubled();
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void isCardValid() {

        if(getSumOfOddAndSecond() % 10 == 0){
            System.out.println("Card is Valid");

        }
        else {
            System.out.println("Card is invalid");
        }

    }
}
