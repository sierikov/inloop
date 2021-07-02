import org.junit.Test;

import static org.junit.Assert.*;

public class ResourceTest {
    @Test
    public void testConstructorNullArgument() {
        try {
            new Resource(null, "name");
            fail("Resource.Resource() should throw a NullPointerException if the id argument is null!");
        } catch (NullPointerException e) {
        }

        try {
            new Resource("id", null);
            fail("Resource.Resource() should throw a NullPointerException if the name argument is null!");
        } catch (NullPointerException e) {
        }

        try {
            new Resource(null, null);
            fail("Resource.Resource() should throw a NullPointerException if the id and the name argument are null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testConstructorIllegalArgument() {
        try {
            new Resource("", "name");
            fail("Resource.Resource() should throw an IllegalArgumentException if the id argument is empty!");
        } catch (IllegalArgumentException e) {
        }

        try {
            new Resource("id", "");
            fail("Resource.Resource() should throw an IllegalArgumentException if the name argument is empty!");
        } catch (IllegalArgumentException e) {
        }

        try {
            new Resource("", "");
            fail("Resource.Resource() should throw an IllegalArgumentException if the id and the name argument are empty!");
        } catch (IllegalArgumentException e) {
        }
    }
}