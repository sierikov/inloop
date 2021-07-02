import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

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
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testConstructorIllegalArgument() {
        try {
            new Paint("", 10.0, 1, 10.0);
            fail("Paint.Paint() should throw an IllegalArgumentException if the name argument is empty!");
        } catch (IllegalArgumentException e) {
        }
        
        try {
            new Paint("name", -10.0, 1, 10.0);
            fail("Paint.Paint() should throw an IllegalArgumentException if the price argument is negative!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testConstructorNonpositiveArgument() {
        try {
            new Paint("test", 50.0, 0, 10.0);
            fail("Paint.Paint() should throw an IllegalArgumentException if the noOfCoats argument is zero!");
        } catch (IllegalArgumentException e) {
        }

        try {
            new Paint("test", 50.0, -2, 10.0);
            fail("Paint.Paint() should throw an IllegalArgumentException if the noOfCoats argument is negative!");
        } catch (IllegalArgumentException e) {
        }

        try {
            new Paint("test", 50.0, 1, 0.0);
            fail("Paint.Paint() should throw an IllegalArgumentException if the noOfSqMPerLiter argument is zero!");
        } catch (IllegalArgumentException e) {
        }

        try {
            new Paint("test", 50.0, 1, -10.0);
            fail("Paint.Paint() should throw an IllegalArgumentException if the noOfSqMPerLiter argument is negative!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testGetNoOfCoats() {
        assertEquals("Paint.getNoOfCoats() should return the correct value!", 2, testPaint.getNoOfCoats());
    }

    @Test
    public void testGetNoOfSqMPerLiter() {
        assertEquals("Paint.getNoOfCoats() should return the correct value!", 10.0, testPaint.getNoOfSqMPerLiter(),
                0.0);
    }

    @Test
    public void testGetMaterialReqNullArgument() {
        try {
            testPaint.getMaterialReq(null);
            fail("Paint.getMaterialReq() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testGetMaterialReq() {
        assertEquals("Paint.getMaterialReq() should calculate the required materials using the given formula!",
                results[0], testPaint.getMaterialReq(surfaces[0]));
        assertEquals("Paint.getMaterialReq() should round down if the tolerance is less than 0.02!", results[1],
                testPaint.getMaterialReq(surfaces[1]));
        assertEquals("Paint.getMaterialReq() should round up if the tolerance is higher than or equal to 0.02!",
                results[2], testPaint.getMaterialReq(surfaces[2]));
        assertEquals("Paint.getMaterialReq() should round down if the tolerance is less than 0.02!", results[3],
                testPaint.getMaterialReq(surfaces[3]));
        assertEquals("Paint.getMaterialReq() should round down if the tolerance is less than 0.02!", results[4],
                testPaint.getMaterialReq(surfaces[4]));
        assertEquals("Paint.getMaterialReq() should round up if the tolerance is higher than or equal to 0.02!",
                results[5], testPaint.getMaterialReq(surfaces[5]));
    }
}
