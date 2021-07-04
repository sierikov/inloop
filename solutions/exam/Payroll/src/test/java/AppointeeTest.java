import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class AppointeeTest {
    private Appointee appointee1, appointee2;

    @Before
    public void setUp() {
        appointee1 = new Appointee("Martin", 5, 165, 21.5);
        appointee2 = new Appointee("Eric", 29, 83, 19.87);
    }

    @Test
    public void testConstructorInvalidPayday() {
        try {
            new Appointee("Martin", -1, 1, 1);
            fail("Appointee.Appointee() should throw an IllegalArgumentException if the payday argument is invalid!");
        } catch (IllegalArgumentException e) {
        }
        try {
            new Appointee("Martin", 0, 1, 1);
            fail("Appointee.Appointee() should throw an IllegalArgumentException if the payday argument is invalid!");
        } catch (IllegalArgumentException e) {
        }
        try {
            new Appointee("Martin", 32, 1, 1);
            fail("Appointee.Appointee() should throw an IllegalArgumentException if the payday argument is invalid!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testConstructorValidPayday() {
        try {
            for (int i = 1; i < 32; i++) {
                new Appointee("Martin", i, 1, 1);
            }
        } catch (IllegalArgumentException e) {
            fail("Appointee.Appointee() should not throw an IllegalArgumentException if the payday argument is valid!");
        }
    }

    @Test
    public void testConstructorHoursPerMonth() {
        try {
            new Appointee("Martin", 1, 0, 1);
            fail("Appointee.Appointee() should throw an IllegalArgumentException if the hoursPerMonth argument is invalid!");
        } catch (IllegalArgumentException e) {
        }

        try {
            new Appointee("Martin", 1, -1, 1);
            fail("Appointee.Appointee() should throw an IllegalArgumentException if the hoursPerMonth argument is invalid!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testConstructorPayPerHour() {
        try {
            new Appointee("Martin", 1, 1, 0);
            fail("Appointee.Appointee() should throw an IllegalArgumentException if the payPerHour argument is invalid!");
        } catch (IllegalArgumentException e) {
        }

        try {
            new Appointee("Martin", 1, 1, -1);
            fail("Appointee.Appointee() should throw an IllegalArgumentException if the payPerHour argument is invalid!");
        } catch (IllegalArgumentException e) {
        }

        try {
            new Appointee("Martin", 1, 1, Double.MIN_VALUE);
        } catch (IllegalArgumentException e) {
            fail("Appointee.Appointee() should not throw an IllegalArgumentException if the payPerHour argument is valid!");
        }
    }

    @Test
    public void testIsPayday() {
        for (int i = -10; i < 40; i++) {
            if (i == 5) {
                assertTrue("Appointee.isPayday() should return the correct value!", appointee1.isPayday(i));
            } else {
                assertFalse("Appointee.isPayday() should return the correct value!", appointee1.isPayday(i));
            }
            if (i == 29) {
                assertTrue("Appointee.isPayday() should return the correct value!", appointee2.isPayday(i));
            } else {
                assertFalse("Appointee.isPayday() should return the correct value!", appointee2.isPayday(i));
            }
        }
    }

    @Test
    public void testCalculatePay() {
        try {
            assertEquals("Appointee.calculatePay() should return the correct value!", 3547.5,
                    appointee1.calculatePay(), 0.0001);
            assertEquals("Appointee.calculatePay() should return the correct value!", 1649.21,
                    appointee2.calculatePay(), 0.0001);
        } catch (UnpayableEmployeeException e) {
            fail("Appointee.calculatePay() should never throw an UnpayableEmployeeException!");
        }
    }

    @Test
    public void testCalculateDeductions() {
        assertEquals("Appointee.calculateDeductions() should return the correct value!", 1419,
                appointee1.calculateDeductions(), 0.0001);
        assertEquals("Appointee.calculateDeductions() should return the correct value!", 659.684,
                appointee2.calculateDeductions(), 0.0001);
    }
}
