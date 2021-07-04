import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VolunteerTest {
    private Volunteer volunteer;

    @Before
    public void setUp() {
        volunteer = new Volunteer("Martin");
    }

    @Test
    public void testIsPaydayIllegalArgument() {
        try {
            volunteer.isPayday(-1);
            fail("Volunteer.isPayday() should throw an IllegalArgumentException for values lower than 1!");
        } catch (IllegalArgumentException exception) {
            // IllegalArgumentException correctly thrown
        }

        try {
            volunteer.isPayday(0);
            fail("Volunteer.isPayday() should throw an IllegalArgumentException for values lower than 1!");
        } catch (IllegalArgumentException exception) {
            // IllegalArgumentException correctly thrown
        }

        try {
            volunteer.isPayday(31);
            fail("Volunteer.isPayday() should throw an IllegalArgumentException for values greater than 30!");
        } catch (IllegalArgumentException exception) {
            // IllegalArgumentException correctly thrown
        }
    }

    @Test
    public void testIsPayday() {
        for (int i = 1; i <= 30; i++) {
            assertFalse("Volunteer.isPayday() should return the correct value!", volunteer.isPayday(i));
        }
    }

    @Test
    public void testCalculatePay() {
        try {
            volunteer.calculatePay();
            fail("Volunteer.calculatePay() should throw an UnpayableEmployeeException!");
        } catch (UnpayableEmployeeException exception) {
            //UnpayableEmployeeException correctly thrown
        }
    }

    @Test
    public void testCalculateDeductions() {
        assertEquals("Volunteer.calculateDeductions() should return the correct value!", 0,
                volunteer.calculateDeductions(), Double.MIN_VALUE);
    }
}
