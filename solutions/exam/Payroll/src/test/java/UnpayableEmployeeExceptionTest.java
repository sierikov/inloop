import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UnpayableEmployeeExceptionTest {
    @Test
    public void testSuperclass() {
        assertEquals("UnpayableEmployeeException should be a subclass of java.lang.Exception!", Exception.class,
                UnpayableEmployeeException.class.getSuperclass());
    }

    @Test
    public void testConstructor() {
        try {
            throw new UnpayableEmployeeException("Test message");
        } catch (UnpayableEmployeeException e) {
            assertEquals(
                    "A thrown UnpayableEmployeeException should contain the message specified in the constructor!",
                    "Test message", e.getMessage());
        }
    }
}
