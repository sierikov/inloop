import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Modifier;

import org.junit.Before;
import org.junit.Test;

public class FactoryTest {
    private Factory fac;
    private ReceivingStock rStock;
    private Purchasing purch;

    @Before
    public void setUp() {
        rStock = new ReceivingStock(3, 10);
        purch = new Purchasing(rStock);
        fac = new Factory(purch, rStock);
    }

    @Test
    public void testConstructorNullArgument() {
        try {
            new Factory(null, rStock);
            fail("Factory.Factory() should throw a NullPointerException if the purchasing argument is null!");
        } catch (NullPointerException e) {
        }
        try {
            new Factory(purch, null);
            fail("Factory.Factory() should throw a NullPointerException if the receivingStock argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testGetPurchasing() {
        assertEquals("Factory.getPurchasing() should return the correct object!", purch, fac.getPurchasing());
    }

    @Test
    public void testGetReceivingStock() {
        assertEquals("Factory.getReceivingStock() should return the correct object!", rStock, fac.getReceivingStock());
    }

    @Test
    public void testCreatePartStatic() throws NoSuchMethodException {
        assertTrue("Factory.createPart() should be static!", Modifier.isStatic(Factory.class.getMethod("createPart",
                PartType.class, String.class, String.class).getModifiers()));
    }

    @Test
    public void testCreatePartNullArgument() {
        try {
            Factory.createPart(null, "id", "name");
            fail("Factory.createPart() should throw an NullPointerException if the partType argument is null!");
        } catch (NullPointerException e) {
        }

        try {
            Factory.createPart(PartType.COMPONENTS, null, "name");
            fail("Factory.createPart() should throw a NullPointerException if the id argument is null!");
        } catch (NullPointerException e) {
        }

        try {
            Factory.createPart(PartType.COMPONENTS, "id", null);
            fail("Factory.createPart() should throw a NullPointerException if the name argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testCreatePartIllegalArgument() {
        try {
            Factory.createPart(PartType.COMPONENTS, "", "name");
            fail("Factory.createPart() should throw an IllegalArgumentException if the id argument is empty!");
        } catch (IllegalArgumentException e) {
        }

        try {
            Factory.createPart(PartType.COMPONENTS, "id", "");
            fail("Factory.createPart() should throw an IllegalArgumentException if the name argument is empty!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testCreatePart() {
        Part p = Factory.createPart(PartType.COMPONENTS, "0", "some components");
        assertSame("Factory.createPart() should return the kind of object specified by the partType argument!",
                Components.class, p.getClass());
        assertEquals("Factory.createPart() should return a Part with the specified id!", "0", p.getId());
        assertEquals("Factory.createPart() should return a Part with the specified name!", "some components", p.getName());

        p = Factory.createPart(PartType.SINGLE_COMPONENT, "1", "a single component");
        assertSame("Factory.createPart() should return the kind of object specified by the partType argument!",
                SingleComponent.class, p.getClass());
        assertEquals("Factory.createPart() should return a Part with the specified id!", "1", p.getId());
        assertEquals("Factory.createPart() should return a Part with the specified name!", "a single component",
                p.getName());

        p = Factory.createPart(PartType.RESOURCE, "2", "a resource");
        assertSame("Factory.createPart() should return the kind of object specified by the partType argument!",
                Resource.class, p.getClass());
        assertEquals("Factory.createPart() should return a Part with the specified id!", "2", p.getId());
        assertEquals("Factory.createPart() should return a Part with the specified name!", "a resource", p.getName());
    }
}
