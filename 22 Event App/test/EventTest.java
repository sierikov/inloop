import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class EventTest {
    private Event event;

    @Before
    public void setUp() {
        event = new Event("Science Slam", EventCategory.PRESENTATION);
    }

    @Test
    public void testConstructorNullArgument() {
        try {
            new Event(null, EventCategory.EXHIBITION);
            fail("Event.Event() should throw a NullPointerException if the title argument is null!");
        } catch (NullPointerException e) {
        }

        try {
            new Event("Technical Collections", null);
            fail("Event.Event() should throw a NullPointerException if the category argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testConstructorIllegalArgument() {
        try {
            new Event("", EventCategory.EXHIBITION);
            fail("Event.Event() should throw an IllegalArgumentException if the title argument is empty!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testGetTitle() {
        assertEquals("Event.getTitle() should return the correct value!", "Science Slam", event.getTitle());
    }

    @Test
    public void testGetCategory() {
        assertEquals("Event.getCategory() should return the correct value!", EventCategory.PRESENTATION,
                event.getCategory());
    }

    @Test
    public void testCompareToNullArgument() {
        try {
            event.compareTo(null);
            fail("Event.compareTo() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testCompareTo() {
        assertTrue("Event.compareTo() should return a positive integer if the given value is smaller!",
                event.compareTo(new Event("Science", EventCategory.EXHIBITION)) > 0);
        assertTrue("Event.compareTo() should return a positive integer if the given value is smaller!",
                event.compareTo(new Event("Science", EventCategory.PRESENTATION)) > 0);
        assertTrue("Event.compareTo() should return a positive integer if the given value is smaller!",
                event.compareTo(new Event("Science", EventCategory.SHOW)) > 0);

        assertTrue("Event.compareTo() should return a positive integer if the given value is smaller!",
                event.compareTo(new Event("Science Slam", EventCategory.EXHIBITION)) > 0);
        assertTrue("Event.compareTo() should return the integer zero if the given value is equal!",
                event.compareTo(new Event("Science Slam", EventCategory.PRESENTATION)) == 0);
        assertTrue("Event.compareTo() should return a negative integer if the given value is greater!",
                event.compareTo(new Event("Science Slams", EventCategory.EXHIBITION)) < 0);

        assertTrue("Event.compareTo() should return a negative integer if the given value is greater!",
                event.compareTo(new Event("Science Slams", EventCategory.EXHIBITION)) < 0);
        assertTrue("Event.compareTo() should return a negative integer if the given value is greater!",
                event.compareTo(new Event("Science Slams", EventCategory.PRESENTATION)) < 0);
        assertTrue("Event.compareTo() should return a negative integer if the given value is greater!",
                event.compareTo(new Event("Science Slams", EventCategory.SHOW)) < 0);
    }
}
