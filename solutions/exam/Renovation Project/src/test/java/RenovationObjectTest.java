import org.junit.Test;

import java.lang.reflect.Modifier;
import java.util.Map;

import static org.junit.Assert.*;

public class RenovationObjectTest {
    @Test
    public void testAbstract() {
        assertTrue("RenovationObject should be an abstract class!",
                Modifier.isAbstract(RenovationObject.class.getModifiers()));
        assertFalse("RenovationObject should be an abstract class, not an interface!",
                RenovationObject.class.isInterface());
    }

    @Test
    public void testGetPriceAbstract() {
        try {
            assertTrue("RenovationObject.getPrice() should be abstract!",
                    Modifier.isAbstract(RenovationObject.class.getDeclaredMethod("getPrice").getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("RenovationObject should have a method named getPrice with no parameters!");
        }
    }

    @Test
    public void testAddMaterialRequirementsAbstract() {
        try {
            assertTrue("RenovationObject.addMaterialRequirements() should be abstract!",
                    Modifier.isAbstract(RenovationObject.class.getDeclaredMethod("addMaterialRequirements", Map.class)
                            .getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("RenovationObject should have a method named addMaterialRequirements with a parameter of type Map!");
        }
    }
}
