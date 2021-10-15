import static java.lang.reflect.Modifier.isAbstract;
import static java.lang.reflect.Modifier.isPublic;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Method;

import org.junit.Test;

public class StatePatternTest {
    @Test
    public void hasInnerAbstractState() {
        Class<?> clazz = checkDoorState();
        assertTrue("Inner class DoorState should be non-static!", clazz.isMemberClass());
        assertTrue("Inner class DoorState should be abstract!", isAbstract(clazz.getModifiers()));
    }

    @Test
    public void innerAbstractStateContainsAllMethods() {
        try {
            Class<?> clazz = checkDoorState();
            checkThatMethodIsPublic(clazz.getDeclaredMethod("openDoor"));
            checkThatMethodIsPublic(clazz.getDeclaredMethod("closeDoor"));
            checkThatMethodIsPublic(clazz.getDeclaredMethod("stopper"));
        } catch (NoSuchMethodException e) {
            throw new AssertionError(
                    "Inner class DoorState should contain all methods from the class diagram!", e);
        }
    }

    @Test
    public void hasClosedState() {
        checkConcreteState("Closed");
    }

    @Test
    public void hasClosingState() {
        checkConcreteState("Closing");
    }

    @Test
    public void hasOpenState() {
        checkConcreteState("Open");
    }

    @Test
    public void hasOpeningState() {
        checkConcreteState("Opening");
    }

    private static Class<?> checkDoorState() {
        try {
            return Class.forName("GarageDoor$DoorState");
        } catch (ClassNotFoundException e) {
            throw new AssertionError("GarageDoor should have an inner class DoorState!");
        }
    }

    private static void checkConcreteState(String name) {
        try {
            Class<?> concreteClass = Class.forName("GarageDoor$" + name);
            Class<?> abstractClass = checkDoorState();
            assertTrue("Inner class " + name + " should extend DoorState!",
                    abstractClass.isAssignableFrom(concreteClass));
        } catch (ClassNotFoundException e) {
            throw new AssertionError("GarageDoor should have an inner class " + name + "!");
        }
    }

    private static void checkThatMethodIsPublic(Method method) {
        if (!isPublic(method.getModifiers())) {
            throw new AssertionError("Method " + method + " should be public!");
        }
    }
}
