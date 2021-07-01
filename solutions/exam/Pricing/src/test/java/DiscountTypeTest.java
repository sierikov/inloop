import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class DiscountTypeTest {
    public enum ExpDiscountType {
        PERCENTAGEDISCOUNT, ABSOLUTEDISCOUNT;
    }

    @Test
    public void testValues() {
        assertEquals("The enumeration DiscountType should have the right number of values!",
                ExpDiscountType.values().length, DiscountType.values().length);
        for (ExpDiscountType e : ExpDiscountType.values()) {
            try {
                assertEquals("DiscountType." + e.name()
                        + " should be at the correct position within the enumeration DiscountType!", e.ordinal(),
                        DiscountType.valueOf(e.name()).ordinal());
            } catch (Exception ex) {
                fail("The enumeration DiscountType should possess the value " + e.name() + "!");
            }
        }
    }
}