import org.junit.Test;

import java.lang.reflect.Modifier;
import java.util.Arrays;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class AccountStateTest {

    @Test
    public void testAccountStateAbstract() {
        var stateClass = Arrays.stream(BankAccount.class.getDeclaredClasses())
                .filter(cls -> cls.getSimpleName().equals("AccountState"))
                .findFirst();

        if (stateClass.isPresent()) {
            assertTrue("Inner class AccountState should be abstract!",
                    Modifier.isAbstract(stateClass.get().getModifiers()));
        } else {
            fail("BankAccount should have inner class AccountState!");
        }
    }
}
