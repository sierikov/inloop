import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MatrixIndexTest {
    MatrixIndex matrixIndex;

    @Before
    public void setUp() {
        matrixIndex = new MatrixIndex(3, 4);
    }

    @Test
    public void testThatNoSetters() {
        try {
            MatrixIndex.class.getMethod("setRow", int.class);
            fail("MatrixIndex.setRow() shouldn't exist!");
        } catch (NoSuchMethodException e) {
        }
        try {
            MatrixIndex.class.getMethod("setColumn", int.class);
            fail("MatrixIndex.setColumn() shouldn't exist!");
        } catch (NoSuchMethodException e) {
        }
    }

    @Test
    public void testOverrideMethods() {
        try {
            MatrixIndex.class.getMethod("equals", Object.class);
        } catch (NoSuchMethodException e) {
            fail("MatrixIndex.equals() should be overridden!");
        }
        try {
            MatrixIndex.class.getMethod("hashCode");
        } catch (NoSuchMethodException e) {
            fail("MatrixIndex.hashCode() should be overridden!");
        }
    }

    @Test
    public void testGetter() {
        assertEquals("Typle.getRow() should return the right number!", matrixIndex.getRow(), 3);
        assertEquals("Typle.getColumn() should return the right number!", matrixIndex.getColumn(), 4);
    }
}
