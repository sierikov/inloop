import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class TimeTest {
    private Time time;

    @Before
    public void setUp() {
        time = new Time(18, 30);
    }

    @Test
    public void testConstructorIllegalArgument() {
        try {
            new Time(-1, 10);
            fail("Time.Time() should throw an IllegalArgumentException if the hour argument is invalid!");
        } catch (IllegalArgumentException e) {
        }

        try {
            new Time(24, 10);
            fail("Time.Time() should throw an IllegalArgumentException if the hour argument is invalid!");
        } catch (IllegalArgumentException e) {
        }

        try {
            new Time(20, -1);
            fail("Time.Time() should throw an IllegalArgumentException if the minute argument is invalid!");
        } catch (IllegalArgumentException e) {
        }

        try {
            new Time(20, 60);
            fail("Time.Time() should throw an IllegalArgumentException if the minute argument is invalid!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testGetHour() {
        assertEquals("Time.getHour() should return the correct value!", 18, time.getHour());
    }

    @Test
    public void testGetMinute() {
        assertEquals("Time.getMinute() should return the correct value!", 30, time.getMinute());
    }
}
