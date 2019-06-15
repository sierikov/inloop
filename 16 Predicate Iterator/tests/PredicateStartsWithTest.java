import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class PredicateStartsWithTest {
    private PredicateStartsWith<String> psw;

    @Before
    public void setUp() {
        psw = new PredicateStartsWith<String>();
    }

    @Test
    public void testPredicate() {
        assertTrue(
                "PredicateStartsWith.predicate() should return true if the element satisfies the predicate concerning the argument!",
                psw.predicate("Test", "T"));
        assertTrue("PredicateStartsWith.predicate() should return true if the element satisfies the predicate!",
                psw.predicate("Test", "Tes"));
        assertTrue("PredicateStartsWith.predicate() should return true if the element satisfies the predicate!",
                psw.predicate("Test", "Test"));

        assertFalse(
                "PredicateStartsWith.predicate() should return false if the element does not satisfy the predicate concerning the argument!",
                psw.predicate("Test", "tes"));
        assertFalse(
                "PredicateStartsWith.predicate() should return false if the element does not satisfy the predicate concerning the argument!",
                psw.predicate("Test", "no"));
        assertFalse(
                "PredicateStartsWith.predicate() should return false if the element does not satisfy the predicate concerning the argument!",
                psw.predicate("Test", "Testen"));

        assertFalse(
                "PredicateStartsWith.predicate() should return false if at least one of the parameter values is null!",
                psw.predicate(null, null));
        assertFalse(
                "PredicateStartsWith.predicate() should return false if at least one of the parameter values is null!",
                psw.predicate("Test", null));
        assertFalse(
                "PredicateStartsWith.predicate() should return false if at least one of the parameter values is null!",
                psw.predicate(null, "Test"));

    }
}
