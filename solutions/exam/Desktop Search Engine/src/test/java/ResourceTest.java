import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class ResourceTest {
    private Resource r;
    private ResourceType rt;

    @Before
    public void setUp() {
        rt = new ResourceType("Plain Text File", new PlainTextCollector());
        r = new Resource("text.txt", "/home/user/textfiles/", rt);
    }

    @Test
    public void testConstructorNullArgument() {
        try {
            new Resource(null, "/home/user/textfiles/", rt);
            fail("Resource.Resource() should throw a NullPointerException if the name argument is null!");
        } catch (NullPointerException e) {
        }

        try {
            new Resource("text.txt", null, rt);
            fail("Resource.Resource() should throw a NullPointerException if the path argument is null!");
        } catch (NullPointerException e) {
        }

        try {
            new Resource("text.txt", "/home/user/textfiles/", null);
            fail("Resource.Resource() should throw a NullPointerException if the rt argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testConstructorIllegalArgument() {
        try {
            new Resource("", "/home/user/textfiles/", rt);
            fail("Resource.Resource() should throw an IllegalArgumentException if the name argument is empty!");
        } catch (IllegalArgumentException e) {
        }

        try {
            new Resource("text.txt", "", rt);
            fail("Resource.Resource() should throw an IllegalArgumentException if the path argument is empty!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testGetName() {
        assertEquals("Resource.getName() should return the correct value!", "text.txt", r.getName());
    }

    @Test
    public void testGetPath() {
        assertEquals("Resource.getPath() should return the correct value!", "/home/user/textfiles/", r.getPath());
    }

    @Test
    public void testGetType() {
        assertEquals("Resource.getType() should return the correct object!", rt, r.getType());
    }
}
