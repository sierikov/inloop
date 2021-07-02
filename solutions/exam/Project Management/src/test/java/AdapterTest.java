import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AdapterTest {
    private Adapter adapter;
    private List<Deliverable> expDeliverables;

    @Before
    public void setUp() {
        Task t1, t2;
        Deliverable d1, d2, d3, d4;

        d1 = new Deliverable("checkTask", "Request task-list", 1.0, 10, 30.0, LocalDate.of(2008, 2, 10));
        d2 = new Deliverable("checkAvailability", "Check availability of goods", 1.0, 0, 100.0, LocalDate.of(
                2008, 2, 20));
        d3 = new Deliverable("checkAccount", "Check customers account", 1.0, 30, 30.0, LocalDate.of(2008, 3,
                2));
        d4 = new Deliverable("confirmOrder", "Deliver goods", 2.0, 1000, 100.0, LocalDate.of(2008, 3, 23));

        t2 = new Task("confirmTask", "Check order", 1.0);
        t2.addProjectItem(d2);
        t2.addProjectItem(d3);

        t1 = new Task("shipOrdering", "Ship goods", 1.0);
        t1.addProjectItem(d1);
        t1.addProjectItem(t2);
        t1.addProjectItem(d4);

        adapter = new Adapter("Test adapter", "This adapter is created to test the Adapter class.", 3.0);
        adapter.setTask(t1);

        expDeliverables = new ArrayList<Deliverable>();
        expDeliverables.add(d1);
        expDeliverables.add(d2);
        expDeliverables.add(d3);
        expDeliverables.add(d4);
    }

    @Test
    public void testImplementsIProject() {
        assertTrue("Adapter should implement the interface IProject!", IProject.class.isAssignableFrom(Adapter.class));
    }

    @Test
    public void testConstructorNullArgument() {
        try {
            new Adapter(null, "details", 5.0);
            fail("Adapter.Adapter() should throw a NullPointerException if the name argument is null!");
        } catch (NullPointerException ignored) {
        }

        try {
            new Adapter("name", null, 5.0);
            fail("Adapter.Adapter() should throw a NullPointerException if the details argument is null!");
        } catch (NullPointerException ignored) {
        }
    }

    @Test
    public void testConstructorIllegalArgument() {
        try {
            new Adapter("", "details", 5.0);
            fail("Adapter.Adapter() should throw an IllegalArgumentException if the name argument is empty!");
        } catch (IllegalArgumentException ignored) {
        }

        try {
            new Adapter("name", "", 5.0);
            fail("Adapter.Adapter() should throw an IllegalArgumentException if the details argument is empty!");
        } catch (IllegalArgumentException ignored) {
        }

        try {
            new Adapter("name", "details", -Double.MIN_VALUE);
            fail("Adapter.Adapter() should throw an IllegalArgumentException if the rate argument is negative!");
        } catch (IllegalArgumentException ignored) {
        }
    }

    @Test
    public void testSetTaskNullArgument() {
        try {
            adapter.setTask(null);
            fail("Adapter.setTask() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException ignored) {
        }
    }

    @Test
    public void testGetDuration() {
        assertEquals("Adapter.getDuration() should return the correct value!", 260.0, adapter.getDuration(), 0.0001);
    }

    @Test
    public void testGetTotalCost() {
        assertEquals("Adapter.getTotalCosts() should return the correct value!", 1300, adapter.getTotalCost());
    }

    @Test
    public void testAllDeliverables() {
        List<Deliverable> actual = adapter.getDeliverables();
        assertTrue("Adapter.allDeliverables() should return all Deliverables!", expDeliverables.containsAll(actual)
                && actual.containsAll(expDeliverables));
    }
}
