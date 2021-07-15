import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.junit.Assert.*;

public class FrozenTest {

    private BankAccount account;
    private static final double DELTA = 0.001;

    @Before
    public void setUp() {
        account = new BankAccount("123", 50);
        account.payOff(50);
    }

    @Test
    public void testFrozenInheritance() {
        var frozenClass = Arrays.stream(BankAccount.class.getDeclaredClasses())
                .filter(cls -> cls.getSimpleName().equals("Frozen"))
                .findFirst();

        if (frozenClass.isPresent()) {
            assertEquals(
                    "Frozen should be a subclass of AccountState!",
                    "AccountState",
                    frozenClass.get().getSuperclass().getSimpleName()
            );
        } else {
            fail("BankAccount should have inner class Frozen!");
        }
    }

    @Test
    public void testGetState() {
        assertEquals(
                "BankAccount.getState() should return \"Frozen\", if the state is Frozen!",
                "Frozen",
                account.getState()
        );
    }

    @Test
    public void testPayInToNegative() {
        assertTrue("Frozen.payIn() should return true!", account.payIn(30));
        assertEquals("Frozen.payIn() should add the sum passed as argument " +
                "to the balance of the account!", -20, account.getBalance(), DELTA);
        assertEquals("Frozen.payIn() should change the state to Negative, " +
                        "if the sum passed as argument is lower than the account's lineOfCredit!",
                "Negative", account.getState());
    }

    @Test
    public void testPayInToPositive() {
        assertTrue("Frozen.payIn() should return true!", account.payIn(50));
        assertEquals("Frozen.payIn() should add the sum passed as argument " +
                "to the balance of the account!", 0, account.getBalance(), DELTA);
        assertEquals("Frozen.payIn() should change the state to Positive, " +
                        "if the sum passed as argument is equal to the account's lineOfCredit!",
                "Positive", account.getState());

        account.payOff(50);
        assertTrue("Frozen.payIn() should return true!", account.payIn(60));
        assertEquals("Frozen.payIn() should add the sum passed as argument " +
                "to the balance of the account!", 10, account.getBalance(), DELTA);
        assertEquals("Frozen.payIn() should change the state to Positive, " +
                        "if the sum passed as argument is greater than the account's lineOfCredit!",
                "Positive", account.getState());
    }

    @Test
    public void testPayOff() {
        assertFalse(
                "Frozen.payOff() should throw return false!",
                account.payOff(10)
        );
        assertEquals("Frozen.payOff() should not change the account's balance!",
                -50, account.getBalance(), DELTA);
        assertEquals("Frozen.payOff() should not change the account's state!",
                "Frozen", account.getState());
    }

    @Test
    public void testPayInterest() {
        account.payInterest();
        assertEquals(
                "Frozen.payInterest() should increase the debts by 5 percent!",
                -52.5,
                account.getBalance(),
                DELTA
        );

        account = new BankAccount("1337", 10);
        account.payOff(10);
        account.payInterest();
        assertEquals(
                "Frozen.payInterest() should increase the debts by 5 percent!",
                -10.5,
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
                "Frozen.printBalance() should print the balance as specified in the task description!",
                "Balance is NEGATIVE: -50.0. You need to pay in money.",
                outString.trim()
        );
    }
}
