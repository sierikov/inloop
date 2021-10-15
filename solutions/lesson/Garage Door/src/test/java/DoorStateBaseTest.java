import java.lang.reflect.Field;

import org.junit.Before;
import org.junit.Ignore;

@Ignore
public class DoorStateBaseTest {
    protected GarageDoor garageDoor;

    @Before
    public void setUp() {
        garageDoor = new GarageDoor();
    }

    protected String getCurrentStateName() {
        try {
            Field myField = GarageDoor.class.getDeclaredField("currentState");
            myField.setAccessible(true);
            Object currentState = myField.get(garageDoor);
            return currentState.getClass().getSimpleName();
        } catch (NoSuchFieldException e) {
            throw new AssertionError("GarageDoor should have an attribute named currentState!");
        } catch (IllegalAccessException e) {
            throw new AssertionError("An unexpected error occurred!");
        }
    }
}
