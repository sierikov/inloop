import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class JValuationTest extends JContentTest {
    private JValuation jValuation;

    @Override
    @Before
    public void setUp() {
        jValuation = new JValuation("title", "description");
        jContent = jValuation;
    }

    @Test
    public void testConstructorNullArgument() {
        try {
            new JValuation(null, "description");
            fail("JValuation.JValuation() should throw a NullPointerException if the title argument is null!");
        } catch (NullPointerException e) {
        }

        try {
            new JValuation("title", null);
            fail("JValuation.JValuation() should throw a NullPointerException if the description argument is null!");
        } catch (NullPointerException e) {
        }

        try {
            new JValuation(null, null);
            fail("JValuation.JValuation() should throw a NullPointerException if the title and the description argument are null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testConstructorInvalidArgument() {
        try {
            new JValuation("", "description");
            fail("JValuation.JValuation() should throw an IllegalArgumentException if the title argument is empty!");
        } catch (IllegalArgumentException e) {
        }

        try {
            new JValuation("title", "");
            fail("JValuation.JValuation() should throw an IllegalArgumentException if the description argument is empty!");
        } catch (IllegalArgumentException e) {
        }

        try {
            new JValuation("", "");
            fail("JValuation.JValuation() should throw an IllegalArgumentException if the title and the description argument are empty!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testToString() {
        assertEquals("JValuation.toString() should return the correct String!", "Valuation: title\ndescription",
                jValuation.toString());
    }
}
