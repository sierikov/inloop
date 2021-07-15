import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.junit.Assert.*;

public class PositiveTest {

    private BankAccount account;
    private static final double DELTA = 0.001;

    @Before
    public void setUp() {
        account = new BankAccount("123", 50);
    }

    @Test
    public void testPositiveInheritance() {
        var positiveClass = Arrays.stream(BankAccount.class.getDeclaredClasses())
                .filter(cls -> cls.getSimpleName().equals("Positive"))
                .findFirst();

        if (positiveClass.isPresent()) {
            assertEquals(
                    "Positive should be a subclass of AccountState!",
                    "AccountState",
                    positiveClass.get().getSuperclass().getSimpleName()
            );
        } else {
            fail("BankAccount should have inner class Positive!");
        }
    }

    @Test
    public void testToString() {
        assertEquals(
                "BankAccount.getState() should return \"Positive\" if the state is Positive!",
                "Positive",
                account.getState()
        );
    }

    @Test
    public void testPayIn() {
        assertTrue("Positive.payIn() should return true!", account.payIn(10));
        assertEquals(
                "Positive.payIn() should add the amount to the balance of the account!",
                10, account.getBalance(),
                DELTA
        );
        assertEquals("Positive.payIn() should not change the account's state!",
                "Positive", account.getState());
    }

    @Test
    public void testPayOffReturnFalse() {
        assertFalse(
                "Positive.payOff() should return false " +
                        "if the transaction exceeds the account's lineOfCredit!",
                account.payOff(60)
        );
        assertEquals(
                "Positive.payOff() should not change the balance " +
                        "if the transaction exceeds the account's lineOfCredit!",
                0, account.getBalance(),
                DELTA
        );
        assertEquals(
                "Positive.payOff() should not change the account's state " +
                        "if the transaction exceeds the account's lineOfCredit!",
                "Positive",
                account.getState()
        );
    }

    @Test
    public void testPayOffToFrozen() {
        assertTrue(
                "Positive.payOff() should return true if the transaction can be processed!",
                account.payOff(50)
        );
        assertEquals(
                "Positive.payOff() should subtract the sum passed as argument " +
                        "from the balance of the account!",
                -50,
                account.getBalance(),
                DELTA
        );
        assertEquals(
                "Positive.payOff() should change the state to Frozen if the balance equals lineOfCredit!",
                "Frozen",
                account.getState()
        );
    }

    @Test
    public void testPayOffToNegative() {
        assertTrue(
                "Positive.payOff() should return true if the transaction can be processed!",
                account.payOff(40)
        );
        assertEquals(
                "Positive.payOff() should subtract the amount from the balance of the account!",
                -40,
                account.getBalance(),
                DELTA
        );
        assertEquals(
                "Positive.payOff() should change the state to Negative " +
                        "if the amount is greater than the account's balance!",
                "Negative",
                account.getState()
        );
    }

    @Test
    public void testPayOffToPositive() {
        account.payIn(50);
        assertTrue(
                "Positive.payOff() should return true if the transaction can be processed!",
                account.payOff(40)
        );
        assertEquals(
                "Positive.payOff() should subtract the amount from the balance of the account!",
                10,
                account.getBalance(),
                DELTA
        );
        assertEquals(
                "Positive.payOff() should not change the state " +
                        "if the amount is less than the account's balance!",
                "Positive",
                account.getState()
        );
    }

    @Test
    public void testPayInterest() {
        account.payInterest();
        assertEquals(
                "Positive.payInterest() should not change the balance if the balance is 0!",
                0.0,
                account.getBalance(),
                DELTA
        );

        account = new BankAccount("1337", 10);
        account.payIn(20);
        account.payInterest();
        assertEquals(
                "Positive.payInterest() should increase the balance by 1 percent!",
                20.2,
                account.getBalance(),
                DELTA
        );

    }

    @Test
    public void testPrintBalance() {
        var outStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outStream));
        account.printBalance();
        var outString = outStream.toString(StandardCharsets.UTF_8);
        assertEquals(
                "Positive.printBalance() should print the balance as specified in the task description!",
                "Balance is POSITIVE: +0.0.",
                outString.trim()
        );
        account.payIn(20);
        outStream.reset();
        account.printBalance();
        outString = outStream.toString(StandardCharsets.UTF_8);
        assertEquals(
                "Positive.printBalance() should print the balance as specified in the task description!",
                "Balance is POSITIVE: +20.0.",
                outString.trim()
        );
    }

}
