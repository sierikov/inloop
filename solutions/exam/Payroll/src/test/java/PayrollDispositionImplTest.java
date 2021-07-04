import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import static org.junit.Assert.*;

public class PayrollDispositionImplTest {
    private PayrollDispositionImpl disposition;
    private Employee newEmployee;
    private Map<Employee, Double> payments;

    @Before
    public void setUp() {
        disposition = new PayrollDispositionImpl();
        newEmployee = new Appointee("a0", 21, 197, 37);
        payments = new HashMap<>();

        Employee e1 = new Appointee("a1", 21, 205, 13);
        Employee e2 = new Appointee("a2", 21, 120, 25);
        Employee e3 = new Appointee("a3", 21, 163, 11);
        Employee e4 = new Appointee("a4", 21, 87, 10);
        Employee e5 = new Appointee("a5", 21, 111, 31);

        payments.put(e1, 1599.0);
        payments.put(e2, 1800.0);
        payments.put(e3, 1075.8);
        payments.put(e4, 522.0);
        payments.put(e5, 2064.6);
    }

    private void depositPayments() {
        for (Entry<Employee, Double> e : payments.entrySet()) {
            disposition.sendPayment(e.getKey(), e.getValue());
        }
    }

    @Test
    public void testSendPaymentNullArgument() {
        try {
            disposition.sendPayment(null, 5);
            fail("PayrollDispositionImpl.sendPayment() should throw a NullPointerException if the empl argument is null!");
        } catch (NullPointerException exception) {
            // NullPointerException correctly thrown
        }
    }

    @Test
    public void testSendPaymentIllegalArgument() {
        try {
            disposition.sendPayment(newEmployee, -1);
            fail("PayrollDispositionImpl.sendPayment() should throw an IllegalArgumentException if the payment argument is negative!");
        } catch (IllegalArgumentException exception) {
            // IllegalArgumentException correctly thrown
        }

        try {
            disposition.sendPayment(newEmployee, 0);
            fail("PayrollDispositionImpl.sendPayment() should throw an IllegalArgumentException if the payment argument is zero!");
        } catch (IllegalArgumentException exception) {
            // IllegalArgumentException correctly thrown
        }
    }

    @Test
    public void testGetTotal() {
        assertEquals("PayrollDispositionImpl.getTotal() should return the correct value", 0, disposition.getTotal(),
                0);

        depositPayments();

        assertEquals("PayrollDispositionImpl.getTotal() should return the correct value", 7061.4,
                disposition.getTotal(), 0.0001);
        disposition.sendPayment(newEmployee, 4373.4);
        assertEquals("PayrollDispositionImpl.getTotal() should return the correct value", 11434.8,
                disposition.getTotal(), 0.0001);
    }

    @Test
    public void testGetAverage() {
        assertEquals("PayrollDispositionImpl.getAverage() should return the correct value", 0,
                disposition.getAverage(), 0);

        depositPayments();

        assertEquals("PayrollDispositionImpl.getAverage() should return the correct value", 1412.28,
                disposition.getAverage(), 0.0001);
        disposition.sendPayment(newEmployee, 4373.4);
        assertEquals("PayrollDispositionImpl.getAverage() should return the correct value", 1905.8,
                disposition.getAverage(), 0.0001);
    }

    @Test
    public void testGetPayments() {
        assertTrue("PayrollDispositionImpl.getPayments() should return an empty Map if not payments have been sent!",
                disposition.getPayments().isEmpty());

        depositPayments();

        for (Entry<Employee, Double> e : payments.entrySet()) {
            assertEquals("PayrollDispositionImpl.getPayments() should return all sent Employee-payment pairs!",
                    disposition.getPayments().get(e.getKey()), e.getValue(), 0);
        }
        assertEquals("PayrollDispositionImpl.getPayments() should only return sent Employee-payment pairs!",
                disposition.getPayments().size(), payments.size());
    }
}
