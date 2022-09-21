package bankingApp;

import bankingApp.bankException.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    private Account account;

    @BeforeEach
    void setUp(){
        account = new Account("kabir","1","1234");
    }
    @Test
    void testThatBalanceCanBeChecked(){
        assertEquals(0, account.getBalance("1234"));
    }

    @Test
    void testThatMoneyCanBeDeposited(){
        assertEquals(0,account.getBalance("1234"));
        account.deposit(200);
        assertEquals(200, account.getBalance("1234"));
    }
    @Test
    void testThatBalanceCantBeCheckedWithAWrongPin_AndWillThrowException(){
        assertThrows(InvalidPinException.class,()->account.getBalance("334"));
    }
    @Test
    void testThatInvalidPinCanThrowException(){
        account.deposit(200);
        assertEquals(200, account.getBalance("1234"));
        assertThrows(InvalidPinException.class, ()-> account.getBalance("1232"));
    }

    @Test
    void testThatNegativeAmountCantBeDeposited_AndWillThrowException(){
        assertThrows(InvalidAmountException.class,()->account.deposit(-300));
        assertEquals(0, account.getBalance("1234"));
    }
    @Test
    void testThatInvalidAmountCanThrowExceptionWhenMakingDeposit(){
        assertThrows(InvalidAmountException.class, ()-> account.deposit(-200));
    }
    @Test
    void testThatWithdrawalCanBeMade(){
        assertEquals(0,account.getBalance("1234"));
        account.deposit(3000);
        assertEquals(3000, account.getBalance("1234"));
        account.withdraw("1234",1000);
        assertEquals(2000, account.getBalance("1234"));
    }
    @Test
    void testThatWithdrawalCantBeDoneWithAWrongPin_AndExceptionIsThrown(){
        assertEquals(0,account.getBalance("1234"));
        account.deposit(3000);
        assertEquals(3000, account.getBalance("1234"));
        assertThrows(InvalidPinException.class,()->account.withdraw("2234",1000));
        assertEquals(3000, account.getBalance("1234"));
    }
    @Test
    void testThatWithdrawalWithAWrongPinThrowsException(){
        assertThrows(InvalidPinException.class,()->account.withdraw("2234",0));
    }
    @Test
    void testThatInvalidAmountCantBeWithdrawn_AndThrowsException(){
        assertEquals(0,account.getBalance("1234"));
        account.deposit(3000);
        assertEquals(3000, account.getBalance("1234"));
        assertThrows(InvalidAmountException.class,()-> account.withdraw("1234",5000));
        assertEquals(3000, account.getBalance("1234"));
    }
    @Test
    void testThatInvalidAmountThrowsException(){
        assertThrows(InvalidAmountException.class,()-> account.withdraw("1234",100));
        assertEquals(0, account.getBalance("1234"));
    }

}