import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StatePatternTest extends JStateBaseTest {
    private String methodDiscuss = "discuss";
    private String methodEvaluate = "evaluate";
    private String methodHold = "hold";
    private String methodRelease = "release";
    private String methodDecline = "decline";

    private List<String> expectedStateClassNames = Arrays.asList(
            "DeclinedIdea",
            "ReleasedIdea",
            "ApprovedIdea",
            "OpenDraft",
            "Draft",
            "JState"
    );

    @Test
    public void testClassesAreSubClassesOfJState() {
        List<Class<?>> expectedSubclasses = new ArrayList<>();
        for (Class<?> actualClass : JIdea.class.getDeclaredClasses()) {
            if (!actualClass.getSimpleName().equals("JState") &&
                    expectedStateClassNames.contains(actualClass.getSimpleName())) {
                expectedSubclasses.add(actualClass);
            }
        }

        for (Class<?> expectedSubclass : expectedSubclasses) {
            assertEquals(
                    expectedSubclass.getSimpleName() + " must have the superclass JState",
                    "JState",
                    expectedSubclass.getSuperclass().getSimpleName()
            );
        }
    }

    @Test
    public void testStateClassesExist() {
        List<String> actualStateClassNames = new ArrayList<>();
        for (Class<?> actualClass : JIdea.class.getDeclaredClasses()) {
            actualStateClassNames.add(actualClass.getSimpleName());
        }

        for (String stateClassName : expectedStateClassNames) {
            assertTrue(
                    "JIdea should have an inner class named " + stateClassName + "!",
                    actualStateClassNames.contains(stateClassName)
            );
        }
    }

    @Test
    public void testJIdeaClasses() {
        assertTrue("JState should have a method named " + methodDiscuss + "!",
                searchForMethod("JState", methodDiscuss, String.class));
        assertTrue("JState should have a method named " + methodEvaluate + "!",
                searchForMethod("JState", methodEvaluate, JValuation.class));
        assertTrue("JState should have a method named " + methodHold + "!", searchForMethod("JState", methodHold));
        assertTrue("JState should have a method named " + methodRelease + "!",
                searchForMethod("JState", methodRelease));
        assertTrue("JState should have a method named " + methodDecline + "!",
                searchForMethod("JState", methodDecline));
    }

    private boolean searchForMethod(String innerClassName, String methodName, Class<?>... methodArguments) {
        for (Class<?> c : JIdea.class.getDeclaredClasses()) {
            if (c.getSimpleName().equals(innerClassName)) {
                try {
                    c.getMethod(methodName, methodArguments);
                    return true;
                } catch (NoSuchMethodException ex) {
                    return false;
                }
            }
        }
        return false;
    }
}
