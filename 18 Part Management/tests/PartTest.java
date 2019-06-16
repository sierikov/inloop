import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class PartTest {
    private static class PartDummy extends Part {
        public PartDummy(String id, String name) {
            super(id, name);
        }
    }

    private Part p1, p2, p3, p4;

    @Before
    public void setUp() {
        p1 = new PartDummy("id1", "name1");
        p2 = new Components("id2", "name2");
        p3 = new SingleComponent("id3", "name3");
        p4 = new Resource("id4", "name4");
    }

    @Test
    public void testConstructorNullArgument() {
        try {
            new PartDummy(null, "name");
            fail("Part.Part() should throw a NullPointerException if the id argument is null!");
        } catch (NullPointerException e) {
        }

        try {
            new PartDummy("id", null);
            fail("Part.Part() should throw a NullPointerException if the name argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testConstructorIllegalArgument() {
        try {
            new PartDummy("", "name");
            fail("Part.Part() should throw an IllegalArgumentException if the id argument is empty!");
        } catch (IllegalArgumentException e) {
        }

        try {
            new PartDummy("id", "");
            fail("Part.Part() should throw an IllegalArgumentException if the name argument is empty!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testGetId() {
        assertEquals("Part.getId() should return the correct value!", "id1", p1.getId());
        assertEquals("Components.getId() should return the correct value!", "id2", p2.getId());
        assertEquals("SingleComponent.getId() should return the correct value!", "id3", p3.getId());
        assertEquals("Resource.getId() should return the correct value!", "id4", p4.getId());
    }

    @Test
    public void testGetName() {
        assertEquals("Part.getName() should return the correct value!", "name1", p1.getName());
        assertEquals("Components.getName() should return the correct value!", "name2", p2.getName());
        assertEquals("SingleComponent.getName() should return the correct value!", "name3", p3.getName());
        assertEquals("Resource.getName() should return the correct value!", "name4", p4.getName());
    }
}
