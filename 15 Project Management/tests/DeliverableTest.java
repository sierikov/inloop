import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class DeliverableTest {
    private Deliverable deliverable;
    private LocalDate date;

    @Before
    public void setUp() {
        date = LocalDate.now();
        deliverable = new Deliverable("Deliverable1", "Details1", 2.2, 55, 2.5, date);
    }

    @Test
    public void testConstructorNullArgument() {
        try {
            new Deliverable(null, "details", 1.5, 1, 1.0, LocalDate.now());
            fail("Deliverable.Deliverable() should throw a NullPointerException if the name argument is null!");
        } catch (NullPointerException ignored) {
        }
        try {
            new Deliverable("name", null, 1.5, 1, 1.0, LocalDate.now());
            fail("Deliverable.Deliverable() should throw a NullPointerException if the details argument is null!");
        } catch (NullPointerException ignored) {
        }
        try {
            new Deliverable("name", "details", 1.5, 1, 1.0, null);
            fail("Deliverable.Deliverable() should throw a NullPointerException if the date argument is null!");
        } catch (NullPointerException ignored) {
        }
    }

    @Test
    public void testConstructorIllegalArgument() {
        try {
            new Deliverable("", "details", 1.5, 1, 1.0, LocalDate.now());
            fail("Deliverable.Deliverable() should throw an IllegalArgumentException if the name argument is empty!");
        } catch (IllegalArgumentException ignored) {
        }
        try {
            new Deliverable("name", "", 1.5, 1, 1.0, LocalDate.now());
            fail("Deliverable.Deliverable() should throw an IllegalArgumentException if the description argument is empty!");
        } catch (IllegalArgumentException ignored) {
        }
        try {
            new Deliverable("name", "details", -1.5, 1, 1.0, LocalDate.now());
            fail("Deliverable.Deliverable() should throw an IllegalArgumentException if the rate argument is negative!");
        } catch (IllegalArgumentException ignored) {
        }
        try {
            new Deliverable("name", "details", 1.5, -1, 1.0, LocalDate.now());
            fail("Deliverable.Deliverable() should throw an IllegalArgumentException if the materialCost argument is negative!");
        } catch (IllegalArgumentException ignored) {
        }
        try {
            new Deliverable("name", "details", 1.5, 1, -Double.MIN_VALUE, LocalDate.now());
            fail("Deliverable.Deliverable() should throw an IllegalArgumentException if the productionTime argument is negative!");
        } catch (IllegalArgumentException ignored) {
        }
        try {
            new Deliverable("name", "details", 1.5, 1, 0.0, LocalDate.now());
            fail("Deliverable.Deliverable() should throw an IllegalArgumentException if the productionTime argument is zero!");
        } catch (IllegalArgumentException ignored) {
        }
    }

    @Test
    public void testGetCostEstimate() {
        assertEquals("Deliverable.getCostEstimate() should return the correct value!", 61,
                deliverable.getCostEstimate(), 0.0001);
    }

    @Test
    public void testGetMaterialCost() {
        assertEquals("Deliverable.getMaterialCost() should return the correct value!", 55,
                deliverable.getMaterialCost());
    }

    @Test
    public void testGetTimeRequired() {
        assertEquals("Deliverable.getTimeRequired() should return the correct value!", 2.5,
                deliverable.getTimeRequired(), 0.0001);
    }

    @Test
    public void testGetDate() {
        assertEquals("Deliverable.getDate() should return the correct object!", date, deliverable.getDate());
    }
}
