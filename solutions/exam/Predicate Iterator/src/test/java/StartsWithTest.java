import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class StartsWithTest {
    private Predicate<String> startsWithJava;
    private Predicate<String> startsWithUML;
    private Predicate<String> empty;

    @Before
    public void setUp() {
        startsWithJava = new StartsWith("Java");
        startsWithUML = new StartsWith("UML");
        empty = new StartsWith("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorRejectsNullPrefix() {
        new StartsWith(null);
    }

    @Test
    public void nullValuesNeverSatisfy() {
        String message = "null values should never satisfy the predicate!";
        assertFalse(message, empty.test(null));
        assertFalse(message, startsWithJava.test(null));
    }

    @Test
    public void startsWithEmptyStringShouldAlwaysMatch() {
        String message = "StartsWith(<empty string>) should be satisfied by any string!";
        assertTrue(message, empty.test(""));
        assertTrue(message, empty.test("x"));
        assertTrue(message, empty.test("some string"));
    }

    @Test
    public void emptyStringCannotStartWithNonEmptyString() {
        String message = "StartsWith(<non-empty string>) cannot be satisfied by an empty string!";
        assertFalse(message, startsWithUML.test(""));
        assertFalse(message, startsWithJava.test(""));
    }

    @Test
    public void sameStringShouldSatisfy() {
        String message = "StartsWith(<some string>) should always be satisfied by the same string!";
        assertTrue(message, startsWithJava.test("Java"));
        assertTrue(message, startsWithUML.test("UML"));
    }

    @Test
    public void comparisonShouldBeCaseSensitive() {
        String message = "StartsWith(<some string>) should compare strings in a case-sensitive manner!";
        assertFalse(message, startsWithJava.test("JAVA"));
        assertFalse(message, startsWithUML.test("uml"));
    }

    @Test
    public void charsAfterPrefixShouldBeIgnored() {
        String message = "StartsWith(<some string>) should be satisfied by all strings that begin with <some string>!";
        assertTrue(message, startsWithJava.test("Java and UML"));
        assertTrue(message, startsWithUML.test("UML and Java"));
    }

    @Test
    public void prefixShouldMatchAtPositionZero() {
        String message = "StartsWith(<some string>) should only be satisfied if <some string> appears at the strings's very beginning!";
        assertFalse(message, startsWithJava.test(" Java"));
        assertFalse(message, startsWithUML.test(" UML"));
    }
}
