import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class EndsWithTest {
    private Predicate<String> endsWithJava;
    private Predicate<String> endsWithUML;
    private Predicate<String> empty;

    @Before
    public void setUp() {
        endsWithJava = new EndsWith("Java");
        endsWithUML = new EndsWith("UML");
        empty = new EndsWith("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorRejectsNullSuffix() {
        new EndsWith(null);
    }

    @Test
    public void nullValuesNeverSatisfy() {
        String message = "null values should never satisfy the predicate!";
        assertFalse(message, empty.test(null));
        assertFalse(message, endsWithJava.test(null));
    }

    @Test
    public void endsWithEmptyStringShouldAlwaysMatch() {
        String message = "EndsWith(<empty string>) should be satisfied by any string!";
        assertTrue(message, empty.test(""));
        assertTrue(message, empty.test("x"));
        assertTrue(message, empty.test("some string"));
    }

    @Test
    public void emptyStringCannotEndWithNonEmptyString() {
        String message = "EndsWith(<non-empty string>) cannot be satisfied by an empty string!";
        assertFalse(message, endsWithUML.test(""));
        assertFalse(message, endsWithJava.test(""));
    }

    @Test
    public void sameStringShouldSatisfy() {
        String message = "EndsWith(<some string>) should always be satisfied by the same string!";
        assertTrue(message, endsWithJava.test("Java"));
        assertTrue(message, endsWithUML.test("UML"));
    }

    @Test
    public void comparisonShouldBeCaseSensitive() {
        String message = "EndsWith(<some string>) should compare strings in a case-sensitive manner!";
        assertFalse(message, endsWithJava.test("JAVA"));
        assertFalse(message, endsWithUML.test("uml"));
    }

    @Test
    public void charsBeforeSuffixShouldBeIgnored() {
        String message = "EndsWith(<some string>) should be satisfied by all strings that end with <some string>!";
        assertTrue(message, endsWithJava.test("UML and Java"));
        assertTrue(message, endsWithUML.test("Java and UML"));
    }

    @Test
    public void suffixShouldMatchAtLastPosition() {
        String message = "EndsWith(<some string>) should only be satisfied if <some string> appears at the strings's very end!";
        assertFalse(message, endsWithJava.test("Java "));
        assertFalse(message, endsWithUML.test("UML "));
    }
}
