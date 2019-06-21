import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class EventCategoryTest {
    public enum ExpEventCategory {
        EXHIBITION, PRESENTATION, SHOW
    }

    @Test
    public void testValues() {
        assertEquals("The enumeration EventCategory should have the right number of values!",
                ExpEventCategory.values().length, EventCategory.values().length);
        for (ExpEventCategory e : ExpEventCategory.values()) {
            try {
                assertEquals(
                        "EventCategory." + e.name()
                                + " should be at the correct position within the enumeration EventCategory!",
                        e.ordinal(), EventCategory.valueOf(e.name()).ordinal());
            } catch (Exception ex) {
                fail("The enumeration EventCategory should possess the value " + e.name() + "!");
            }
        }
    }
}
