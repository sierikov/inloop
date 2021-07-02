import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class PaintTest {
    private Paint testPaint;
    private Surface[] surfaces = new Surface[6];
    private int[] results = new int[6];

    @Before
    public void setUp() {
        testPaint = new Paint("Wall paint white", 50.0, 2, 10.0);
        surfaces[0] = new Surface(5.0, 2.0);
        surfaces[0].setMaterial(testPaint);
        surfaces[1] = new Surface(5.0, 2.01);
        surfaces[1].setMaterial(testPaint);
        surfaces[2] = new Surface(5.0, 2.02);
        surfaces[2].setMaterial(testPaint);
        surfaces[3] = new Surface(1.25, 2);
        surfaces[3].setMaterial(testPaint);
        surfaces[4] = new Surface(1.275, 2);
        surfaces[4].setMaterial(testPaint);
        surfaces[5] = new Surface(5.0, 1.52);
        surfaces[5].setMaterial(testPaint);

        results[0] = 4; // 2.00 l
        results[1] = 4; // 2.01 l
        results[2] = 5; // 2.02 l
        results[3] = 1; // 0.50 l
        results[4] = 1; // 0.51 l
        results[5] = 4; // 1.52 l
    }

    @Test
    public void testConstructorNullArgument() {
        try {
            new Paint(null, 10.0, 1, 10.0);
            fail("Paint.Paint() should throw a NullPointerException if the name argument is null!");
        } catch (NullPointerException ignored) {
        }
    }

    @Test
    public void testConstructorIllegalArgument() {
        try {
            new Paint("", 10.0, 1, 10.0);
            fail("Paint.Paint() should throw an IllegalArgumentException if the name argument is empty!");
        } catch (IllegalArgumentException ignored) {
        }
        
        try {
            new Paint("name", -10.0, 1, 10.0);
            fail("Paint.Paint() should throw an IllegalArgumentException if the price argument is negative!");
        } catch (IllegalArgumentException ignored) {
        }
    }

    @Test
    public void testConstructorNonpositiveArgument() {
        try {
            new Paint("test", 50.0, 0, 10.0);
            fail("Paint.Paint() should throw an IllegalArgumentException if the noOfCoats argument is zero!");
        } catch (IllegalArgumentException ignored) {
        }

        try {
            new Paint("test", 50.0, -2, 10.0);
            fail("Paint.Paint() should throw an IllegalArgumentException if the noOfCoats argument is negative!");
        } catch (IllegalArgumentException ignored) {
        }

        try {
            new Paint("test", 50.0, 1, 0.0);
            fail("Paint.Paint() should throw an IllegalArgumentException if the noOfSqMPerLiter argument is zero!");
        } catch (IllegalArgumentException ignored) {
        }

        try {
            new Paint("test", 50.0, 1, -10.0);
            fail("Paint.Paint() should throw an IllegalArgumentException if the noOfSqMPerLiter argument is negative!");
        } catch (IllegalArgumentException ignored) {
        }
    }

    @Test
    public void testGetNumberOfCoats() {
        assertEquals("Paint.getNumberOfCoats() should return the correct value!", 2, testPaint.getNumberOfCoats());
    }

    @Test
    public void testGetSquareMetersPerLiter() {
        assertEquals("Paint.getSquareMetersPerLiter() should return the correct value!", 10.0, testPaint.getSquareMetersPerLiter(),
                0.0);
    }

    @Test
    public void testGetMaterialRequirementsNullArgument() {
        try {
            testPaint.getMaterialRequirements(null);
            fail("Paint.getMaterialRequirements() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException ignored) {
        }
    }

    @Test
    public void testGetMaterialRequirements() {
        assertEquals("Paint.getMaterialRequirements() should calculate the required materials using the given formula!",
                results[0], testPaint.getMaterialRequirements(surfaces[0]));
        assertEquals("Paint.getMaterialRequirements() should round down if the tolerance is less than 0.02!", results[1],
                testPaint.getMaterialRequirements(surfaces[1]));
        assertEquals("Paint.getMaterialRequirements() should round up if the tolerance is higher than or equal to 0.02!",
                results[2], testPaint.getMaterialRequirements(surfaces[2]));
        assertEquals("Paint.getMaterialRequirements() should round down if the tolerance is less than 0.02!", results[3],
                testPaint.getMaterialRequirements(surfaces[3]));
        assertEquals("Paint.getMaterialRequirements() should round down if the tolerance is less than 0.02!", results[4],
                testPaint.getMaterialRequirements(surfaces[4]));
        assertEquals("Paint.getMaterialRequirements() should round up if the tolerance is higher than or equal to 0.02!",
                results[5], testPaint.getMaterialRequirements(surfaces[5]));
    }
}
