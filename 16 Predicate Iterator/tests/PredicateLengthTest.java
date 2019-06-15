import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class PredicateLengthTest {
    private PredicateLength<String> psw;

    @Before
    public void setUp() {
        psw = new PredicateLength<String>();
    }

    @Test
    public void testPredicate() {
        assertTrue(
                "PredicateLength.predicate() should return true if the element satisfies the predicate concerning the argument!",
                psw.predicate("", "0"));
        assertTrue(
                "PredicateLength.predicate() should return true if the element satisfies the predicate concerning the argument!",
                psw.predicate("", "0"));
        assertTrue(
                "PredicateLength.predicate() should return true if the element satisfies the predicate concerning the argument!",
                psw.predicate("", "0"));
        assertTrue(
                "PredicateLength.predicate() should return true if the element satisfies the predicate concerning the argument!",
                psw.predicate("Test", "4"));

        assertFalse(
                "PredicateLength.predicate() should return false if the element does not satisfy the predicate concerning the argument!",
                psw.predicate("Test", "6"));
        assertFalse(
                "PredicateLength.predicate() should return false if the element does not satisfy the predicate concerning the argument!",
                psw.predicate("", "1"));
        assertFalse(
                "PredicateLength.predicate() should return false if the element does not satisfy the predicate concerning the argument!",
                psw.predicate("", "1"));
        assertFalse(
                "PredicateLength.predicate() should return false if the element does not satisfy the predicate concerning the argument!",
                psw.predicate("", "1"));

        assertFalse(
                "PredicateLength.predicate() should return false if at least one of the parameter values is null!",
                psw.predicate(null, null));
        assertFalse(
                "PredicateLength.predicate() should return false if at least one of the parameter values is null!",
                psw.predicate("Test", null));
        assertFalse(
                "PredicateLength.predicate() should return false if at least one of the parameter values is null!",
                psw.predicate(null, "0"));
    }

}
