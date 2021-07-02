import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class PartTypeTest {
    public enum ExpPartType {
        COMPONENTS, SINGLE_COMPONENT, RESOURCE;
    }

    @Test
    public void testValues() {
        assertEquals("The enumeration PartType should have the right number of values!", ExpPartType.values().length,
                PartType.values().length);
        for (ExpPartType e : ExpPartType.values()) {
            try {
                assertEquals("PartType." + e.name()
                        + " should be at the correct position within the enumeration PartType!", e.ordinal(), PartType
                        .valueOf(e.name()).ordinal());
            } catch (Exception ex) {
                fail("The enumeration PartType should possess the value " + e.name() + "!");
            }
        }
    }
}