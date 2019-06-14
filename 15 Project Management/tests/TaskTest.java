import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class TaskTest {
    private Task mainTask, t1, t2, t3, emptyTask;
    private Deliverable d1, d2, d3;

    @Before
    public void setUp() {
        emptyTask = new Task("Empty", "Empty", 1);
        mainTask = new Task("MainTask", "MainDetails", 1.23456);

        t1 = new Task("Subtask1", "Subdetails1", 2.34567);
        t2 = new Task("Subtask2", "Subdetails2", 3.0);
        t3 = new Task("Subtask3", "Subdetails3", 1.0);

        d1 = new Deliverable("Deliverable1", "Deliverable1", 1.25, 1999, 2.33, LocalDate.now());
        d2 = new Deliverable("Deliverable2", "Deliverable2", 1.0, 401, 1.0, LocalDate.now());
        d3 = new Deliverable("Deliverable3", "Deliverable3", 1.0, 2, 5.5, LocalDate.now());

        t1.addProjectItem(d1);
        t1.addProjectItem(d2);

        t2.addProjectItem(d2);
        t2.addProjectItem(d3);

        t3.addProjectItem(d3);
        t3.addProjectItem(d1);
        t3.addProjectItem(t2);

        mainTask.addProjectItem(t1);
        mainTask.addProjectItem(t2);
        mainTask.addProjectItem(t3);
        mainTask.addProjectItem(d1);
    }

    @Test
    public void testConstructorNullArgument() {
        try {
            new Task(null, "details", 1.0);
            fail("Task.Task() should throw a NullPointerException if the name argument is null!");
        } catch (NullPointerException ignored) {
        }
        try {
            new Task("name", null, 1.0);
            fail("Task.Task() should throw a NullPointerException if the details argument is null!");
        } catch (NullPointerException ignored) {
        }
    }

    @Test
    public void testConstructorIllegalArgument() {
        try {
            new Task("", "details", 1.0);
            fail("Task.Task() should throw an IllegalArgumentException if the name argument is empty!");
        } catch (IllegalArgumentException ignored) {
        }
        try {
            new Task("name", "", 1.0);
            fail("Task.Task() should throw an IllegalArgumentException if the details argument is empty!");
        } catch (IllegalArgumentException ignored) {
        }
        try {
            new Task("name", "details", -Double.MIN_VALUE);
            fail("Task.Task() should throw an IllegalArgumentException if the rate argument is negative!");
        } catch (IllegalArgumentException ignored) {
        }
    }

    @Test
    public void testEmptyTask() {
        assertEquals("Task.getCostEstimate() should return 0 if no ProjectItem has been added!", 0,
                emptyTask.getCostEstimate());
        assertEquals("Task.getMaterialCost() should return 0 if no ProjectItem has been added!", 0,
                emptyTask.getMaterialCost());
        assertEquals("Task.getTimeRequired() should return 0 if no ProjectItem has been added!", 0,
                emptyTask.getTimeRequired(), 0.0001);
        assertTrue("Task.allDeliverables() should return an empty list if no ProjectItem has been added!", emptyTask
                .allDeliverables().isEmpty());
    }

    @Test
    public void testGetCostEstimate() {
        assertEquals("Task.getCostEstimate() should return the costs of all Deliverables!", 2408,
                t1.getCostEstimate(), 0.0001);
        assertEquals("Task.getCostEstimate() should return the costs of all Deliverables!", 423, t2.getCostEstimate(),
                0.0001);
        assertEquals("Task.getCostEstimate() should return the costs of all Deliverables and subtasks!", 2418,
                t3.getCostEstimate(), 0.0001);
        assertEquals("Task.getCostEstimate() should return the correct value!", 7239, mainTask.getCostEstimate(),
                0.0001);
    }

    @Test
    public void testGetMaterialCost() {
        assertEquals("Task.getMaterialCost() should return the costs of all Deliverables!", 2400, t1.getMaterialCost());
        assertEquals("Task.getMaterialCost() should return the costs of all Deliverables!", 403, t2.getMaterialCost());
        assertEquals("Task.getMaterialCost() should return the costs of all Deliverables and subtasks!", 2404,
                t3.getMaterialCost());
        assertEquals("Task.getMaterialCost() should return the correct value!", 7206, mainTask.getMaterialCost());
    }

    @Test
    public void testGetTimeRequired() {
        assertEquals("Task.getTimeRequired() should return the time of all Deliverables!", 3.33, t1.getTimeRequired(),
                0);
        assertEquals("Task.getTimeRequired() should return the time of all Deliverables!", 6.5, t2.getTimeRequired(),
                0.0001);
        assertEquals("Task.getTimeRequired() should return the time of all Deliverables and subtasks!", 14.33,
                t3.getTimeRequired(), 0.0001);
        assertEquals("Task.getTimeRequired() should return the correct value!", 26.49, mainTask.getTimeRequired(),
                0.0001);
    }

    @Test
    public void testAddProjectItemNullArgument() {
        try {
            mainTask.addProjectItem(null);
            fail("Task.addProjectItem() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException ignored) {
        }
    }

    @Test
    public void testAddProjectItem() {
        emptyTask.addProjectItem(d1);
        assertTrue("Task.addProjectItem() should actually add the ProjectItem!",
                emptyTask.allDeliverables().contains(d1) && emptyTask.allDeliverables().size() == 1);
        emptyTask.addProjectItem(t3);
        assertTrue("Task.addProjectItem() should actually add the ProjectItem!",
                emptyTask.allDeliverables().contains(d1) && emptyTask.allDeliverables().contains(d2)
                        && emptyTask.allDeliverables().contains(d3) && emptyTask.allDeliverables().size() == 5);
    }

    @Test
    public void testRemoveProjectItemNullArgument() {
        try {
            mainTask.removeProjectItem(null);
            fail("Task.removeProjectItem() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException ignored) {
        }
    }

    @Test
    public void testRemoveProjectItem() {
        t1.removeProjectItem(d1);
        assertFalse("Task.removeProjectItem() should actually remove the item!", t1.allDeliverables().contains(d1));
    }

    @Test
    public void testAllDeliverables() {
        List<ProjectItem> l1, l2, l3, lMain;

        l1 = new LinkedList<ProjectItem>();
        l1.add(d1);
        l1.add(d2);
        l2 = new LinkedList<ProjectItem>();
        l2.add(d2);
        l2.add(d3);
        l3 = new LinkedList<ProjectItem>();
        l3.add(d1);
        l3.add(d2);
        l3.add(d3);
        lMain = new LinkedList<ProjectItem>();
        lMain.add(d1);
        lMain.add(d1);
        lMain.add(d2);
        lMain.add(d2);
        lMain.add(d3);

        assertTrue("Task.allDeliverables() should return a List containing all Deliverables",
                l1.containsAll(t1.allDeliverables()) && t1.allDeliverables().containsAll(l1));
        assertTrue("Task.allDeliverables() should return a List containing all Deliverables",
                l2.containsAll(t2.allDeliverables()) && t2.allDeliverables().containsAll(l2));
        assertTrue("Task.allDeliverables() should return a List containing all Deliverables",
                l3.containsAll(t3.allDeliverables()) && t3.allDeliverables().containsAll(l3));
        assertTrue("Task.allDeliverables() should return a List containing all Deliverables",
                lMain.containsAll(mainTask.allDeliverables()) && mainTask.allDeliverables().containsAll(lMain));
    }
}
