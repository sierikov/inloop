import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class SurfaceTest {
    private Surface testSurface;
    private Material testFlooring, testPaint;

    @Before
    public void setUp() {
        testSurface = new Surface(2.0, 10.0);
        testPaint = new Paint("Wall paint white", 50.0, 2, 10.0);
        testFlooring = new Flooring("PVC red", 10.0, 2.0);
    }

    @Test
    public void testConstructorNonpositiveArgument() {
        try {
            new Surface(-2.0, 10.0);
            fail("Surface.Surface() should throw an IllegalArgumentException if the length argument is negative!");
        } catch (IllegalArgumentException ignored) {
        }

        try {
            new Surface(0.0, 10.0);
            fail("Surface.Surface() should throw an IllegalArgumentException if the length argument is zero!");
        } catch (IllegalArgumentException ignored) {
        }

        try {
            new Surface(2.0, -10.0);
            fail("Surface.Surface() should throw an IllegalArgumentException if the width argument is negative!");
        } catch (IllegalArgumentException ignored) {
        }

        try {
            new Surface(2.0, 0.0);
            fail("Surface.Surface() should throw an IllegalArgumentException if the width argument is zero!");
        } catch (IllegalArgumentException ignored) {
        }
    }

    @Test
    public void testSetMaterialNullArgument() {
        try {
            testSurface.setMaterial(null);
            fail("Surface.setMaterial() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException ignored) {
        }
    }

    @Test
    public void testSetMaterial() {
        testSurface.setMaterial(testFlooring);
    }

    @Test
    public void testGetArea() {
        assertEquals("Surface.getArea() should return the correct value!", 20.0, testSurface.getArea(), 0.0);
    }

    @Test
    public void testGetPrice() {
        testSurface.setMaterial(testPaint);
        assertEquals("Surface.getPrice() should return the correct value!", 400.0, testSurface.getPrice(), 0.0);
        testSurface.setMaterial(testFlooring);
        assertEquals("Surface.getPrice() should return the correct value!", 100.0, testSurface.getPrice(), 0.0);
    }

    @Test
    public void testAddMaterialRequirementsNullArgument() {
        try {
            testSurface.addMaterialRequirements(null);
            fail("Surface.addMaterialRequirements() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException ignored) {
        }

        testSurface.setMaterial(testPaint);
        try{
            testSurface.addMaterialRequirements(Collections.singletonMap(null, 1));
            fail("Surface.addMaterialRequirements() should throw a NullPointerException if a key of the argument is null!");
        } catch (NullPointerException ignored) {
        }
        try{
            testSurface.addMaterialRequirements(Collections.singletonMap("key", null));
            fail("Surface.addMaterialRequirements() should throw a NullPointerException if a value of the argument is null!");
        } catch (NullPointerException ignored) {
        }
    }

    @Test
    public void testSelectedMaterialNull() {
        try {
            testSurface.addMaterialRequirements(new TreeMap<String, Integer>());
            fail("Surface.addMaterialRequirements() should throw a NullPointerException if Surface.selectedMaterial is null!");
        } catch (NullPointerException ignored) {
        }
    }

    @Test
    public void testAddMaterialRequirementsEmpty() {
        Map<String, Integer> expectedPaint = new TreeMap<String, Integer>();
        expectedPaint.put("Wall paint white", 8);
        Map<String, Integer> expectedFlooring = new TreeMap<String, Integer>();
        expectedFlooring.put("PVC red", 10);

        testSurface.setMaterial(testPaint);
        Map<String, Integer> actualMap = testSurface.addMaterialRequirements(new TreeMap<String, Integer>());
        assertEquals("Surface.addMaterialRequirements() should return a Map containing the correct entries!", expectedPaint,
                actualMap);
        testSurface.setMaterial(testFlooring);
        actualMap = testSurface.addMaterialRequirements(new TreeMap<String, Integer>());
        assertEquals("Surface.addMaterialRequirements() should return a Map containing the correct entries!", expectedFlooring,
                actualMap);
    }

    @Test
    public void testAddMaterialRequirementsFilled() {
        Map<String, Integer> expectedPaint = new TreeMap<String, Integer>();
        expectedPaint.put("Wall paint white", 11);
        Map<String, Integer> expectedFlooring = new TreeMap<String, Integer>();
        expectedFlooring.put("PVC red", 14);

        Map<String, Integer> materialRequirements1 = new TreeMap<String, Integer>();
        materialRequirements1.put("Wall paint white", 3);
        Map<String, Integer> materialRequirements2 = new TreeMap<String, Integer>();
        materialRequirements2.put("PVC red", 4);

        testSurface.setMaterial(testPaint);
        Map<String, Integer> actualMap = testSurface.addMaterialRequirements(materialRequirements1);
        assertEquals("Surface.addMaterialRequirements() should return a Map containing the correct entries!", expectedPaint,
                actualMap);
        testSurface.setMaterial(testFlooring);
        actualMap = testSurface.addMaterialRequirements(materialRequirements2);
        assertEquals("Surface.addMaterialRequirements() should return a Map containing the correct entries!", expectedFlooring,
                actualMap);
    }

    @Test
    public void testDontChangeArgumentAddMaterialRequirements() {
        testSurface.setMaterial(new Paint("Paint", 1, 1, 1));
        Map<String, Integer> materialRequirements = Collections.singletonMap("Wood", 4);
        try{
            testSurface.addMaterialRequirements(materialRequirements);
        } catch (UnsupportedOperationException e) {
            fail("Surface.addMaterialRequirements() shouldn't change the given Map. Instead, a new Map should be used!");
        }
    }
}
