import org.junit.Test;

import static org.junit.Assert.*;

public class PredicateTest {
    @Test
    public void testInterface() {
        assertTrue(Predicate.class.isInterface());
    }
}