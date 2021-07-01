import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.*;

import static org.junit.Assert.*;

public class ProjectTest {
    private Project project;
    private Task t1;
    private Map<LocalDate, List<Deliverable>> expDeliv_Task1;
    private Map<LocalDate, List<Deliverable>> expDeliv_Task2;

    @Before
    public void setUp() {
        Task t2;
        Deliverable d1, d2, d3, d4;
        LocalDate cal;

        expDeliv_Task1 = new HashMap<java.time.LocalDate, List<Deliverable>>();
        expDeliv_Task2 = new HashMap<java.time.LocalDate, List<Deliverable>>();

        cal = LocalDate.of(2008, 2, 10);
        d1 = new Deliverable("checkTask", "Request instruction list", 1.0, 10, 30.0, cal);
        d2 = new Deliverable("checkAvailability", "Check availability of the goods", 1.0, 100, 5.0, cal);
        expDeliv_Task2.put(cal, new ArrayList<Deliverable>());
        expDeliv_Task2.get(cal).add(d1);
        expDeliv_Task2.get(cal).add(d2);
        expDeliv_Task1.put(cal, new ArrayList<Deliverable>());
        expDeliv_Task1.get(cal).add(d2);

        cal = LocalDate.of(2008, 3, 2);
        d3 = new Deliverable("checkAccount", "Check customers account", 1.0, 30, 30.0, cal);
        expDeliv_Task1.put(cal, new ArrayList<Deliverable>());
        expDeliv_Task1.get(cal).add(d3);
        expDeliv_Task2.put(cal, new ArrayList<Deliverable>());
        expDeliv_Task2.get(cal).add(d3);

        cal = LocalDate.of(2008, 3, 23);
        d4 = new Deliverable("confirmOrder", "Deliver items", 2.0, 100, 1000.0, cal);
        expDeliv_Task2.put(cal, new ArrayList<Deliverable>());
        expDeliv_Task2.get(cal).add(d4);

        t1 = new Task("confirmTask", "Check order", 1);
        t1.addProjectItem(d2);
        t1.addProjectItem(d3);

        t2 = new Task("shipOrdering", "Ship items", 1);
        t2.addProjectItem(d1);
        t2.addProjectItem(t1);
        t2.addProjectItem(d4);

        project = new Project("shipOrdering", "Ship items", 1);
        project.setTask(t2);
    }

    @Test
    public void testConstructorNullArgument() {
        try {
            new Project(null, "description", 1.0);
            fail("Project.Project() should throw a NullPointerException if the name argument is null!");
        } catch (NullPointerException ignored) {
        }

        try {
            new Project("name", null, 1.0);
            fail("Project.Project() should throw a NullPointerException if the description argument is null!");
        } catch (NullPointerException ignored) {
        }
    }

    @Test
    public void testConstructorIllegalArgument() {
        try {
            new Project("", "description", 1.0);
            fail("Project.Project() should throw an IllegalArgumentException if the name argument is null!");
        } catch (IllegalArgumentException ignored) {
        }

        try {
            new Project("name", "", 1.0);
            fail("Project.Project() should throw an IllegalArgumentException if the description argument is null!");
        } catch (IllegalArgumentException ignored) {
        }

        try {
            new Project("name", "description", -Double.MIN_VALUE);
            fail("Project.Project() should throw an IllegalArgumentException if the rate argument is negative!");
        } catch (IllegalArgumentException ignored) {
        }
    }

    @Test
    public void testGetName() {
        assertEquals("Project.getName() should return the correct value!", "shipOrdering", project.getName());
    }

    @Test
    public void testGetDescription() {
        assertEquals("Project.getDescription() should return the correct value!", "Ship items",
                project.getDescription());
    }

    @Test
    public void testSetTaskNullArgument() {
        try {
            project.setTask(null);
            fail("Project.setTask() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException ignored) {
        }
    }

    @Test
    public void testSetTask() {
        project.setTask(t1);
        assertEquals("Project.setTask() should set the main task correctly!", 35.0, project.getDuration(), 0.0001);
        assertEquals("Project.setTask() should set the main task correctly!", 165, project.getTotalCost());
        assertEquals("Project.setTask() should set the main task correctly!", expDeliv_Task1, project.allDeliverables());
    }

    @Test
    public void testGetDuration() {
        assertEquals("Project.getDuration() should return the correct value!", 1065.0, project.getDuration(), 0.0001);
    }

    @Test
    public void testGetTotalCost() {
        assertEquals("Project.getTotalCosts() should return the correct value!", 1305, project.getTotalCost());
    }

    @Test
    public void testAllDeliverables() {
        /*
         * Sort the lists in both Maps to avoid nondeterministically different orders of the Deliverables within the
         * lists.
         */
        Comparator<Deliverable> comp = Comparator.comparingInt(Object::hashCode);
        Map<LocalDate, List<Deliverable>> actDeliv = project.allDeliverables();
        for (List<Deliverable> l : expDeliv_Task2.values()) {
            l.sort(comp);
        }
        for (List<Deliverable> l : actDeliv.values()) {
            l.sort(comp);
        }
        /*
         * This assertion is not performed with assertEquals because the message you get automatically in case of a
         * fail is bloated by the output String for the Calendar objects. That way, the message might not be too
         * helpful. If you still want to see it, change this to 'assertEquals(solution, project.allDeliverables());'
         * (of course without the quotes).
         */
        assertEquals(
                "Project.allDeliverables() should return a Map in which all Deliverables are associated to their date correctly!",
                expDeliv_Task2, actDeliv);
    }
}
