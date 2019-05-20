import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class ResourceTypeTest {
    private ResourceType rt;
    private KeywordCollector coll;

    @Before
    public void setUp() {
        coll = new PlainTextCollector();
        rt = new ResourceType("Portable Network Graphics", coll);

    }

    @Test
    public void testConstructorNullArgument() {
        try {
            new ResourceType(null, coll);
            fail("ResourceType.ResourceType() should throw a NullPointerException if the desc argument is null!");
        } catch (NullPointerException e) {
        }

        try {
            new ResourceType("Portable Network Graphics", null);
            fail("ResourceType.ResourceType() should throw a NullPointerException if the keywordCollector argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testConstructorIllegalArgument() {
        try {
            new ResourceType("", coll);
            fail("ResourceType.ResourceType() should throw an IllegalArgumentException if the desc argument is empty!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testGetDescription() {
        assertEquals("ResourceType.getDescription() should return the correct value!", "Portable Network Graphics",
                rt.getDescription());
    }

    @Test
    public void testGetCollector() {
        assertEquals("ResourceType.getCollector() should return the correct object!", coll, rt.getCollector());
    }
}
