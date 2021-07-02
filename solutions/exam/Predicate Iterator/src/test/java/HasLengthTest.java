import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class HasLengthTest {
    @Test(expected = IllegalArgumentException.class)
    public void constructorRejectsNegativeLength() {
        new HasLength(-1);
    }

    @Test
    public void nullValuesNeverSatisfy() {
        String message = "null values should never satisfy the predicate!";
        assertFalse(message, new HasLength(0).test(null));
        assertFalse(message, new HasLength(9).test(null));
    }

    @Test
    public void matchEmptyStrings() {
        Predicate<String> lengthOfZero = new HasLength(0);
        String message = "HasLength.test(…) should only match strings of the given length (0)!";
        assertTrue(message, lengthOfZero.test(""));
        assertTrue(message, lengthOfZero.test(new String("")));
        assertFalse(message, lengthOfZero.test("x"));
    }

    @Test
    public void matchNonEmptyStrings() {
        Predicate<String> lengthOfFive = new HasLength(5);
        String message = "HasLength.test(…) should only match strings of the given length (5)!";
        assertTrue(message, lengthOfFive.test("12345"));
        assertFalse(message, lengthOfFive.test("1234"));
        assertFalse(message, lengthOfFive.test("123456"));
    }
}
