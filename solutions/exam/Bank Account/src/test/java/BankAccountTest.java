import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import static org.junit.Assert.*;

public class BankAccountTest {

    private BankAccount account;
    private static final double DELTA = 0.01;

    @Before
    public void setUp() {
        account = new BankAccount("123", 50);
    }

    @Test
    public void testFieldBalance() {
        try {
            Field balanceField = BankAccount.class.getDeclaredField("balance");
            assertTrue("Field balance should be private!",
                    Modifier.isPrivate(balanceField.getModifiers()));
            assertEquals("Field balance should be of type double!",
                    double.class, balanceField.getType());
        } catch (NoSuchFieldException e) {
            fail("BankAccount should have a field 'balance'!");
        }
    }

    @Test
    public void testFieldLineOfCredit() {
        try {
            Field lineOfCreditField = BankAccount.class.getDeclaredField("lineOfCredit");
            assertTrue("Field lineOfCredit should be private!",
                    Modifier.isPrivate(lineOfCreditField.getModifiers()));
            assertEquals("Field lineOfCredit should be of type double!",
                    double.class, lineOfCreditField.getType());
        } catch (NoSuchFieldException e) {
            fail("BankAccount should have a field 'lineOfCredit'!");
        }
    }

    @Test
    public void testFieldAccountNumber() {
        try {
            Field accountNumberField = BankAccount.class.getDeclaredField("accountNumber");
            assertTrue("Field accountNumber should be private!",
                    Modifier.isPrivate(accountNumberField.getModifiers()));
            assertEquals("Field accountNumber should be of type String!",
                    String.class, accountNumberField.getType());
        } catch (NoSuchFieldException e) {
            fail("BankAccount should have a field 'accountNumber'!");
        }
    }

    @Test
    public void testFieldState() {
        try {
            Field stateField = BankAccount.class.getDeclaredField("state");
            assertTrue("Field 'state' should be private!",
                    Modifier.isPrivate(stateField.getModifiers()));
            var innerClasses = BankAccount.class.getDeclaredClasses();
            var stateClass = Arrays.stream(innerClasses)
                    .filter(cls -> cls.getSimpleName().equals("AccountState"))
                    .findFirst();
            assertTrue("BankAccount should have an inner class AccountState!", stateClass.isPresent());
            assertEquals(
                    "Field 'accountNumber' should be of type AccountState!",
                    stateField.getType(),
                    stateClass.get()
            );
        } catch (NoSuchFieldException e) {
            fail("BankAccount should have a field 'state'!");
        }
    }

    @Test
    public void testConstructorNullArgument() {
        try {
            new BankAccount(null, 50);
            fail("Constructor BankAccount() should throw a NullPointerException if" +
                    " the accountNumber is null!");
        } catch (NullPointerException ignored) {
        }
    }

    @Test
    public void testConstructorIllegalArgument() {
        try {
            new BankAccount("", 50);
            fail("Constructor BankAccount() should throw an IllegalArgumentException" +
                    " if the accountNumber is empty!");

            new BankAccount("", -1);
            fail("Constructor BankAccount() should throw an IllegalArgumentException" +
                    " if the lineOfCredit is negative!");
        } catch (IllegalArgumentException ignored) {
        }
    }

    @Test
    public void testConstructor() {
        assertEquals("Constructor BankAccount should initialize the balance" +
                "with 0!", 0, account.getBalance(), DELTA);
        assertEquals("Constructor BankAccount() should set initial state to Positive!",
                "Positive", account.getState());
        assertEquals("Constructor BankAccount() should set the field " +
                        "'accountNumber' to the String passed as argument!",
                "123", account.getAccountNumber());
        try {
            Field lineOfCreditField = BankAccount.class.getDeclaredField("lineOfCredit");
            lineOfCreditField.setAccessible(true);
            double lineOfCredit = (double) lineOfCreditField.get(account);
            assertEquals("Constructor BankAccount() should set the field " +
                            "'lineOfCredit' to the double passed as argument!",
                    50, lineOfCredit, DELTA);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("BankAccount should have a field 'lineOfCredit'!");
        }
    }

    @Test
    public void testPayInIllegalArgument() {
        try {
            account.payIn(-1);
            fail("BankAccount.payIn() should throw an IllegalArgumentException " +
                    "if called with a negative amount!");
        } catch (IllegalArgumentException ignored) {
        }

        try {
            account.payIn(0);
            fail("BankAccount.payIn() should throw an IllegalArgumentException " +
                    "if called with the an non positive amount!");
        } catch (IllegalArgumentException ignored) {
        }
    }

    @Test
    public void testPayOffIllegalArgument() {
        try {
            account.payOff(-1);
            fail("BankAccount.payOff() should throw an IllegalArgumentException " +
                    "if called with a negative amount!");
        } catch (IllegalArgumentException ignored) {
        }

        try {
            account.payOff(0);
            fail("BankAccount.payOff() should throw an IllegalArgumentException " +
                    "if called with the an non positive amount!");
        } catch (IllegalArgumentException ignored) {
        }
    }

    @Test
    public void testClose() {
        var state = account.getState();
        account.payIn(50);
        assertFalse("BankAccount.close() should return false if the balance is not 0!",
                account.close());
        assertEquals(
                "An unsuccessful BankAccount.close() call should not change the account state!",
                state,
                account.getState()
        );
        account.payOff(50);
        assertTrue("BankAccount.close() should return true if the balance is 0!",
                account.close());
        assertEquals(
                "A successful BankAccount.close() call should set the state to Closed!",
                "Closed",
                account.getState()
        );
    }

}
