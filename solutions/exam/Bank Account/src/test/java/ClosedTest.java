import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ClosedTest {

    private BankAccount account;
    private static final double DELTA = 0.001;

    @Before
    public void setUp() {
        account = new BankAccount("12345", 10);
        account.close();
    }

    @Test
    public void testClosedInheritance() {
        var frozenClass = Arrays.stream(BankAccount.class.getDeclaredClasses())
                .filter(cls -> cls.getSimpleName().equals("Closed"))
                .findFirst();

        if (frozenClass.isPresent()) {
            assertEquals(
                    "Closed should be a subclass of AccountState!",
                    "AccountState",
                    frozenClass.get().getSuperclass().getSimpleName()
            );
        } else {
            fail("BankAccount should have an inner class Closed!");
        }
    }

    @Test
    public void testToString() {
        assertEquals(
                "BankAccount.getState() should return \"Closed\" if the state is Closed!",
                "Closed",
                account.getState()
        );
    }

    @Test
    public void testPayIn() {
        assertFalse(
                "Closed.payIn() should return false!",
                account.payIn(10)
        );
        assertEquals(
                "Closed.payIn() should not change the account's balance!",
                0.0,
                account.getBalance(),
                DELTA
        );
        assertEquals(
                "Closed.payIn() should not change the account's state!",
                "Closed",
                account.getState()
        );
    }

    @Test
    public void testPayOff() {
        assertFalse(
                "Closed.payOff() should return false!",
                account.payOff(10)
        );
        assertEquals(
                "Closed.payOff() should not change the account's balance!",
                0.0,
                account.getBalance(),
                DELTA
        );
        assertEquals(
                "Closed.payOff() should not change the account's state!",
                "Closed",
                account.getState()
        );
    }

    @Test
    public void testPayInterest() {
        try {
            account.payInterest();
            fail("Closed.payInterest() should throw an IllegalStateException!");
        } catch (IllegalStateException ignored) {
        }
        assertEquals(
                "Closed.payInterest() should not change the account's balance!",
                0.0,
                account.getBalance(),
                DELTA
        );
        assertEquals(
                "Closed.payInterest() should not change the account's state!",
                "Closed",
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
                "Closed.printBalance() should print the balance as specified in the task description!",
                "This account is CLOSED. The balance is 0.",
                outString.trim()
        );
    }
}
