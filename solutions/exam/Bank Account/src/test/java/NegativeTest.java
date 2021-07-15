import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.junit.Assert.*;

public class NegativeTest {

    private BankAccount account, account2;
    private static final double DELTA = 0.001;

    @Before
    public void setUp() {
        account = new BankAccount("123", 50);
        account.payOff(30);

        account2 = new BankAccount("1337", 10);
        account2.payOff(5);
    }

    @Test
    public void testNegativeInheritance() {
        var negativeClass = Arrays.stream(BankAccount.class.getDeclaredClasses())
                .filter(cls -> cls.getSimpleName().equals("Negative"))
                .findFirst();

        if (negativeClass.isPresent()) {
            assertEquals(
                    "Negative should be a subclass of AccountState!",
                    "AccountState",
                    negativeClass.get().getSuperclass().getSimpleName()
            );
        } else {
            fail("BankAccount should have inner class Negative!");
        }
    }

    @Test
    public void testToString() {
        assertEquals(
                "BankAccount.getState() should return \"Negative\", if the state is Negative!",
                "Negative",
                account.getState()
        );
    }

    @Test
    public void testPayInToNegative() {
        assertTrue("Negative.payIn() should return true!", account.payIn(10));
        assertEquals(
                "Negative.payIn() should add the amount to the balance of the account!",
                -20,
                account.getBalance(),
                DELTA
        );
        assertEquals("Negative.payIn() should not change the account's state if" +
                "the balance is still less than 0!", "Negative", account.getState());
    }

    @Test
    public void testPayInToPositive() {
        assertTrue("Negative.payIn() should return true!", account.payIn(30));
        assertEquals(
                "Negative.payIn() should add the amount to the balance of the account!",
                0,
                account.getBalance(),
                DELTA
        );
        assertEquals("Negative.payIn() should change the account's state to Positive " +
                "if the balance is 0!", "Positive", account.getState());

        account.payOff(30);
        assertTrue("Negative.payIn() should return true!", account.payIn(40));
        assertEquals(
                "Negative.payIn() should add the amount to the balance of the account!",
                10,
                account.getBalance(),
                DELTA
        );
        assertEquals("Negative.payIn() should change the account's state to Positive " +
                "if the balance is greater than 0!", "Positive", account.getState());
    }

    @Test
    public void testPayOffReturnFalse() {
        assertFalse(
                "Negative.payOff() should return false " +
                        "if the transaction exceeded the account's lineOfCredit!",
                account.payOff(60)
        );
        assertEquals(
                "Negative.payOff() should not change the balance " +
                        "if the transaction exceeded the account's lineOfCredit!",
                -30,
                account.getBalance(),
                DELTA
        );
        assertEquals(
                "Negative.payOff() should not change the account's state " +
                        "if the transaction exceeded the account's lineOfCredit!",
                "Negative",
                account.getState()
        );
    }

    @Test
    public void testPayOffToFrozen() {
        assertTrue(
                "Negative.payOff() should return true if the transaction can be processed!",
                account.payOff(20)
        );
        assertEquals(
                "Negative.payOff() should subtract the amount from the balance of the account!",
                -50,
                account.getBalance(),
                DELTA
        );
        assertEquals(
                "Negative.payOff() should change the state to Frozen if the balance equals lineOfCredit!",
                "Frozen",
                account.getState()
        );
    }

    @Test
    public void testPayOffToNegative() {
        assertTrue(
                "Negative.payOff() should return true if the transaction can be processed!",
                account.payOff(10)
        );
        assertEquals(
                "Negative.payOff() should subtract the amount from the balance of the account!",
                -40,
                account.getBalance(),
                DELTA
        );
        assertEquals(
                "Negative.payOff() should not change the state if the transaction can be processed!",
                "Negative",
                account.getState()
        );
    }

    @Test
    public void testPayInterestToNegative() {
        account.payInterest();
        assertEquals(
                "Negative.payInterest() should increase the debts by 3 percent!",
                -30.9,
                account.getBalance(),
                DELTA
        );
        assertEquals("Negative.payInterest() should not change the state " +
                "unless the balance falls below negative lineOfCredit!",
                "Negative",
                account.getState()
        );

        account2.payInterest();
        assertEquals(
                "Negative.payInterest() should increase the debts by 3 percent!",
                -5.15,
                account2.getBalance(),
                DELTA
        );
        assertEquals("Negative.payInterest() should not change the state " +
                        "unless the balance falls below negative lineOfCredit!",
                "Negative",
                account.getState()
        );

    }

    @Test
    public void testPayInterestToFrozen() {
        account.payOff(19);
        account.payInterest();
        //balance: -50.47
        assertEquals("Negative.payInterest() should change the state to " +
                "Frozen if the balance falls below negative lineOfCredit!",
                "Frozen",
                account.getState()
        );
    }

    @Test
    public void testPrintBalance() {
        var outStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outStream));
        account.printBalance();
        var outString = outStream.toString(StandardCharsets.UTF_8);
        assertEquals(
                "Negative.printBalance() should print the balance as specified in the task description!",
                "Balance is NEGATIVE: -30.0.",
                outString.trim()
        );
    }

}
