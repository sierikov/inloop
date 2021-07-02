import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MaterialTest {
    private static class MaterialDummy extends Material {
        MaterialDummy(String name, double price) {
            super(name, price);
        }

        @Override
        public int getMaterialRequirements(Surface surface) {
            return 13;
        }
    }

    private Material material;

    @Before
    public void setUp() {
        material = new MaterialDummy("matName", 1234.56);
    }

    @Test
    public void testConstructorNullArgument() {
        try {
            new MaterialDummy(null, 0);
            fail("The constructor of Material should throw a NullPointerException if the name argument is null!");
        } catch (NullPointerException ignored) {
        }
    }

    @Test
    public void testConstructorEmptyString() {
        try {
            new MaterialDummy("", 0);
            fail("The constructor of Material should throw an IllegalArgumentException if the name argument is an empty String!");
        } catch (IllegalArgumentException ignored) {
        }
    }

    @Test
    public void testConstructorNegativeArgument() {
        try {
            new MaterialDummy("test", -10.0);
            fail("The constructor of Material should throw an IllegalArgumentException if the cost argument is negative!");
        } catch (IllegalArgumentException ignored) {
        }
    }

    @Test
    public void testGetName() {
        assertEquals("Material.getName() should return the correct value!", "matName", material.getName());
    }

    @Test
    public void testGetPricePerUnit() {
        assertEquals("Material.getPricePerUnit() should return the correct value!", 1234.56,
                material.getPricePerUnit(), 0.0001);
    }

    @Test
    public void testGetPriceOfASurfaceNullArgument() {
        try {
            material.getPriceOfASurface(null);
            fail("Material.getPriceOfASurface() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException ignored) {
        }
    }

    @Test
    public void testGetPriceOfASurface() {
        assertEquals("Material.getPriceOfASurface() should return the correct value!", 16049.28,
                material.getPriceOfASurface(new Surface(13, 3)), 0.0001);
    }
}
