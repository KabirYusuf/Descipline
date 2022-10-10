package creditCard;

import creditCardNumberValidation.CreditCardNumberValidation;
import creditCardNumberValidation.exceptions.InvalidCardLengthException;
import creditCardNumberValidation.exceptions.InvalidCardNumberException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreditCardNumberValidationTest {
    private CreditCardNumberValidation creditCardNumberValidation;

    @BeforeEach
    void setUp() {
        creditCardNumberValidation = new CreditCardNumberValidation();
    }

    @Test
    void testThatCreditCardNumberStartsWithFour() {
        String cardNumber = "43522190887998";
        assertTrue(CreditCardNumberValidation.isValidNumber(cardNumber));
    }

    @Test
    void testThatExceptionIsThrownIfCardNumberDoesntStartWithFour() {
        String cardNumber = "93522190887998";
        assertThrows(InvalidCardNumberException.class, () -> CreditCardNumberValidation.isValidNumber(cardNumber));
    }

    @Test
    void testThatCardNumberDoesntNotContainLetters() {
        String cardNumber = "43522190887998";
        assertTrue(CreditCardNumberValidation.isContainLetter(cardNumber));
    }

    @Test
    void testThatExceptionIsThrownIfCardNumberContainsLetter() {
        String cardNumber = "9352r19088b998";
        assertThrows(InvalidCardNumberException.class, () -> CreditCardNumberValidation.isContainLetter(cardNumber));
    }

    @Test
    void cardNumberLengthIsGreaterOrEqualToThirteenAndLessThanOrEqualToSixteenTest() {
        String cardNumber = "9352219088799878";
        assertTrue(CreditCardNumberValidation.isValidLength(cardNumber));
    }

    @Test
    void testThatExceptionIsThrownIfCardNumberIsLessThanOrGreaterThanRequiredCardNumberLength() {
        String cardNumber = "93522190887998788976689";
        assertThrows(InvalidCardLengthException.class, () -> CreditCardNumberValidation.isValidLength(cardNumber));
    }


}
