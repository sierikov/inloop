import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PredicateTest {
    @Test
    public void shouldBeAnInterface() {
        assertTrue("Predicate<T> should be an interface!", Predicate.class.isInterface());
    }
}