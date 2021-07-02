import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

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
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testAddMaterialReqNullArgument() {
        try {
            structuredObject.addMaterialReq(null);
            fail("StructuredObject.addMaterialReq() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }
        try {
            structuredObject.addMaterialReq(Collections.singletonMap(null, 1));
            fail("StructuredObject.addMaterialReq() should throw a NullPointerException if a key of the argument is null!");
        } catch (NullPointerException e) {
        }
        try {
            structuredObject.addMaterialReq(Collections.singletonMap("key", null));
            fail("StructuredObject.addMaterialReq() should throw a NullPointerException if a value of the argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testFloorSurface() {
        Surface s1 = new Surface(2.0, 3.0);
        Material m1 = new Flooring("PVC red", 5.0, 2.0);
        s1.setMaterial(m1);
        structuredObject.add(s1);

        Map<String, Integer> expectedMaterials = new TreeMap<String, Integer>();
        expectedMaterials.put("PVC red", 3);

        Map<String, Integer> actualMaterials = new TreeMap<String, Integer>();
        actualMaterials = structuredObject.addMaterialReq(actualMaterials);

        assertEquals("StructuredObject.addMaterialReq() should return a Map containing the correct entries!",
                expectedMaterials, actualMaterials);
        assertEquals("StructuredObject.getPrice() should return the correct value!", 15.0,
                structuredObject.getPrice(), 0.0);
    }

    @Test
    public void testSurface() {
        StructuredObject so1 = new StructuredObject();
        Surface s1 = new Surface(2.0, 3.0);
        Surface s2 = new Surface(3.0, 4.0);

        Material m1 = new Flooring("PVC red", 10.0, 2.0);
        Material m2 = new Paint("Wall paint green", 50.0, 2, 10.0);

        s1.setMaterial(m1);
        s2.setMaterial(m2);

        structuredObject.add(s1);
        structuredObject.add(so1);

        so1.add(s2);
        so1.add(s2);

        Map<String, Integer> expectedMaterials = new TreeMap<String, Integer>();
        expectedMaterials.put("PVC red", 3);
        expectedMaterials.put("Wall paint green", 5);

        Map<String, Integer> actualMaterials = new TreeMap<String, Integer>();
        actualMaterials = structuredObject.addMaterialReq(actualMaterials);

        assertEquals("RenovationObject.addMaterialReq() should return a Map containing the correct entries",
                expectedMaterials, actualMaterials);
        assertEquals("RenovationObject.getPrice() should return the correct value!", 280.0,
                structuredObject.getPrice(), 0.0);
    }

    @Test
    public void testDontChangeArgumentAddMaterialReq() {
        structuredObject.add(new StructuredObject());
        Map<String, Integer> mat = Collections.singletonMap("Wood", 4);
        try{
            structuredObject.addMaterialReq(mat);
        } catch (UnsupportedOperationException e) {
            fail("StructuredObject.addaddMaterialReq() shouldn't change the given Map. Instead, a new Map should be used!");
        }
    }
}
