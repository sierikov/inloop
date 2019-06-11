import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Modifier;
import java.util.Map;

import org.junit.Test;

public class RenovationObjectTest {
    @Test
    public void testAbstract() {
        assertTrue("RenovationObject should be an abstract class!",
                Modifier.isAbstract(RenovationObject.class.getModifiers()));
        assertTrue("RenovationObject should be an abstract class, not an interface!",
                !RenovationObject.class.isInterface());
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
    public void testAddMaterialReqAbstract() {
        try {
            assertTrue("RenovationObject.addMaterialReq() should be abstract!",
                    Modifier.isAbstract(RenovationObject.class.getDeclaredMethod("addMaterialReq", Map.class)
                            .getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("RenovationObject should have a method named addMaterialReq with a parameter of type Map!");
        }
    }
}
