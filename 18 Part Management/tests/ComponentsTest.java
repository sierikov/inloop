import org.junit.Test;

import static org.junit.Assert.*;

public class ComponentsTest {
    @Test
    public void testConstructorNullArgument() {
        try {
            new Components(null, "name");
            fail("Components.Components() should throw a NullPointerException if the id argument is null!");
        } catch (NullPointerException e) {
        }

        try {
            new Components("id", null);
            fail("Components.Components() should throw a NullPointerException if the name argument is null!");
        } catch (NullPointerException e) {
        }

        try {
            new Components(null, null);
            fail("Components.Components() should throw a NullPointerException if the id and the name argument are null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testConstructorIllegalArgument() {
        try {
            new Components("", "name");
            fail("Components.Components() should throw an IllegalArgumentException if the id argument is empty!");
        } catch (IllegalArgumentException e) {
        }

        try {
            new Components("id", "");
            fail("Components.Components() should throw an IllegalArgumentException if the name argument is empty!");
        } catch (IllegalArgumentException e) {
        }

        try {
            new Components("", "");
            fail("Components.Components() should throw an IllegalArgumentException if the id and the name argument are empty!");
        } catch (IllegalArgumentException e) {
        }
    }
}