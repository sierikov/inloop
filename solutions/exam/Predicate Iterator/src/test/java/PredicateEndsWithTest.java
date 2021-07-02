import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class PredicateEndsWithTest {
    private PredicateEndsWith<String> psw;

    @Before
    public void setUp() {
        psw = new PredicateEndsWith<String>();
    }

    @Test
    public void testPredicate() {
        assertTrue("PredicateEndsWith.predicate() should return true if the element satisfies the predicate!",
                psw.predicate("Test", "t"));
        assertTrue("PredicateEndsWith.predicate() should return true if the element satisfies the predicate!",
                psw.predicate("Test", "est"));
        assertTrue("PredicateEndsWith.predicate() should return true if the element satisfies the predicate!",
                psw.predicate("Test", "Test"));

        assertFalse(
                "PredicateEndsWith.predicate() should return false if the element does not satisfy the predicate concerning the argument!",
                psw.predicate("Test", "esT"));
        assertFalse(
                "PredicateEndsWith.predicate() should return false if the element does not satisfy the predicate concerning the argument!",
                psw.predicate("Test", "no"));
        assertFalse(
                "PredicateEndsWith.predicate() should return false if the element does not satisfy the predicate concerning the argument!",
                psw.predicate("Test", "Testen"));

        assertFalse(
                "PredicateEndsWith.predicate() should return false if at least one of the parameter values is null!",
                psw.predicate(null, null));
        assertFalse(
                "PredicateEndsWith.predicate() should return false if at least one of the parameter values is null!",
                psw.predicate("Test", null));
        assertFalse(
                "PredicateEndsWith.predicate() should return false if at least one of the parameter values is null!",
                psw.predicate(null, "Test"));
    }
}
