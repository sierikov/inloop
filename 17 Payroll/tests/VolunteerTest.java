import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class VolunteerTest {
    Volunteer volunteer;

    @Before
    public void setUp() {
        volunteer = new Volunteer("Martin");
    }

    @Test
    public void testIsPayday() {
        for (int i = -10; i < 40; i++) {
            assertFalse("Volunteer.isPayday() should return the correct value!", volunteer.isPayday(i));
        }
    }

    @Test
    public void testCalculatePay() {
        try {
            volunteer.calculatePay();
            fail("Volunteer.calculatePay() should throw an UnpayableEmployeeException!");
        } catch (UnpayableEmployeeException e) {
        }
    }

    @Test
    public void testCalculateDeductions() {
        assertEquals("Volunteer.calculateDeductions() should return the correct value!", 0,
                volunteer.calculateDeductions(), Double.MIN_VALUE);
    }
}
