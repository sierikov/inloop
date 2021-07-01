import org.junit.Test;

import static org.junit.Assert.*;

public class IProjectTest {
    @Test
    public void testInterface() {
        assertTrue(IProject.class.isInterface());
    }
}