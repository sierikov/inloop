import static org.junit.Assert.fail;

import java.lang.reflect.Field;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;

@Ignore
public class DoorStateBaseTest {
    protected GarageDoor gd;
    static Class<?> classClosed;
    static Class<?> classOpening;
    static Class<?> classOpen;
    static Class<?> classClosing;

    @BeforeClass
    public static void setUpStateClassVariables() {
        searchForInnerClass("DoorState");
        classClosed = searchForInnerClass("Closed");
        classOpening = searchForInnerClass("Opening");
        classOpen = searchForInnerClass("Open");
        classClosing = searchForInnerClass("Closing");
    }

    @Before
    public void setUp() {
        gd = new GarageDoor();
    }

    /* Return the content of the attribute "GarageDoor.currentState" */
    protected Object getState() {
        try {
            Field myField = GarageDoor.class.getDeclaredField("currentState");
            myField.setAccessible(true);
            return myField.get(gd);
        } catch (NoSuchFieldException e) {
            fail("GarageDoor should have an attribute named currentState!");
        } catch (IllegalArgumentException e) {
            fail("An unexpected error occurred!");
        } catch (IllegalAccessException e) {
            fail("An unexpected error occurred!");
        }
        throw new AssertionError("An unexpected error occurred!");
    }

    private static Class<?> searchForInnerClass(String name) {
        for (Class<?> clazz : GarageDoor.class.getDeclaredClasses()) {
            if (clazz.getSimpleName().equals(name)) {
                if ("DoorState".equals(clazz.getSimpleName()) ||
                        "DoorState".equals(clazz.getSuperclass().getSimpleName())) {
                    return clazz;
                } else {
                    throw new AssertionError(name + " should be a sub-class of DoorState!");
                }
            }
        }
        throw new AssertionError("GarageDoor should have an inner class named " + name + "!");
    }
}
