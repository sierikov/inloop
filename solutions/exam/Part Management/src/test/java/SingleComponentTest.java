import org.junit.Test;

import static org.junit.Assert.*;

public class SingleComponentTest {
    @Test
    public void testConstructorNullArgument() {
        try {
            new SingleComponent(null, "name");
            fail("SingleComponent.SingleComponent() should throw a NullPointerException if the id argument is null!");
        } catch (NullPointerException e) {
        }

        try {
            new SingleComponent("id", null);
            fail("SingleComponent.SingleComponent() should throw a NullPointerException if the name argument is null!");
        } catch (NullPointerException e) {
        }

        try {
            new SingleComponent(null, null);
            fail("SingleComponent.SingleComponent() should throw a NullPointerException if the id and the name argument are null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testConstructorIllegalArgument() {
        try {
            new SingleComponent("", "name");
            fail("SingleComponent.SingleComponent() should throw an IllegalArgumentException if the id argument is empty!");
        } catch (IllegalArgumentException e) {
        }

        try {
            new SingleComponent("id", "");
            fail("SingleComponent.SingleComponent() should throw an IllegalArgumentException if the name argument is empty!");
        } catch (IllegalArgumentException e) {
        }

        try {
            new SingleComponent("", "");
            fail("SingleComponent.SingleComponent() should throw an IllegalArgumentException if the id and the name argument are empty!");
        } catch (IllegalArgumentException e) {
        }
    }
}