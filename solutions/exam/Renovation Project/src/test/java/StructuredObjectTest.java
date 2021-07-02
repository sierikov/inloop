import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class StructuredObjectTest {
    private StructuredObject structuredObject;

    @Before
    public void setUp() {
        structuredObject = new StructuredObject();
    }

    @Test
    public void testPartsType() {
        try {
            assertEquals("StructuredObject.parts should be a Set!", Set.class, structuredObject.getClass()
                    .getDeclaredField("parts").getType());
        } catch (NoSuchFieldException nsfe) {
            fail("The class StructuredObject should have an attribute named parts!");
        }
    }

    @Test
    public void testAddNullArgument() {
        try {
            structuredObject.add(null);
            fail("StructuredObject.add() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException ignored) {
        }
    }

    @Test
    public void testAddMaterialRequirementsNullArgument() {
        try {
            structuredObject.addMaterialRequirements(null);
            fail("StructuredObject.addMaterialRequirements() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException ignored) {
        }
        try {
            structuredObject.addMaterialRequirements(Collections.singletonMap(null, 1));
            fail("StructuredObject.addMaterialRequirements() should throw a NullPointerException if a key of the argument is null!");
        } catch (NullPointerException ignored) {
        }
        try {
            structuredObject.addMaterialRequirements(Collections.singletonMap("key", null));
            fail("StructuredObject.addMaterialRequirements() should throw a NullPointerException if a value of the argument is null!");
        } catch (NullPointerException ignored) {
        }
    }

    @Test
    public void testFloorSurface() {
        Surface surface = new Surface(2.0, 3.0);
        Material material = new Flooring("PVC red", 5.0, 2.0);
        surface.setMaterial(material);
        structuredObject.add(surface);

        Map<String, Integer> expectedMaterials = new TreeMap<String, Integer>();
        expectedMaterials.put("PVC red", 3);

        Map<String, Integer> actualMaterials = new TreeMap<String, Integer>();
        actualMaterials = structuredObject.addMaterialRequirements(actualMaterials);

        assertEquals("StructuredObject.addMaterialRequirements() should return a Map containing the correct entries!",
                expectedMaterials, actualMaterials);
        assertEquals("StructuredObject.getPrice() should return the correct value!", 15.0,
                structuredObject.getPrice(), 0.0);
    }

    @Test
    public void testSurface() {
        StructuredObject structuredObject = new StructuredObject();
        Surface surface1 = new Surface(2.0, 3.0);
        Surface surface2 = new Surface(3.0, 4.0);

        Material material1 = new Flooring("PVC red", 10.0, 2.0);
        Material material2 = new Paint("Wall paint green", 50.0, 2, 10.0);

        surface1.setMaterial(material1);
        surface2.setMaterial(material2);

        this.structuredObject.add(surface1);
        this.structuredObject.add(structuredObject);

        structuredObject.add(surface2);
        structuredObject.add(surface2);

        Map<String, Integer> expectedMaterials = new TreeMap<String, Integer>();
        expectedMaterials.put("PVC red", 3);
        expectedMaterials.put("Wall paint green", 5);

        Map<String, Integer> actualMaterials = new TreeMap<String, Integer>();
        actualMaterials = this.structuredObject.addMaterialRequirements(actualMaterials);

        assertEquals("RenovationObject.addMaterialRequirements() should return a Map containing the correct entries",
                expectedMaterials, actualMaterials);
        assertEquals("RenovationObject.getPrice() should return the correct value!", 280.0,
                this.structuredObject.getPrice(), 0.0);
    }

    @Test
    public void testDontChangeArgumentAddMaterialRequirements() {
        structuredObject.add(new StructuredObject());
        Map<String, Integer> mat = Collections.singletonMap("Wood", 4);
        try{
            structuredObject.addMaterialRequirements(mat);
        } catch (UnsupportedOperationException e) {
            fail("StructuredObject.addMaterialRequirements() shouldn't change the given Map. Instead, a new Map should be used!");
        }
    }
}
