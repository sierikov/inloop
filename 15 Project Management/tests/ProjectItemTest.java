import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Modifier;

import org.junit.Before;
import org.junit.Test;

public class ProjectItemTest {
    private static class ProjectItemImpl extends ProjectItem {
        public ProjectItemImpl(String name, String details, Double rate) {
            super(name, details, rate);
        }

        @Override
        public double getTimeRequired() {
            return 2.5;
        }

        @Override
        public long getMaterialCost() {
            return 13;
        }
    }

    private ProjectItemImpl p;

    @Test
    public void testAbstract() {
        assertTrue("ProjectItem should be abstract!", Modifier.isAbstract(ProjectItem.class.getModifiers()));
        try {
            assertTrue("ProjectItem.getTimeRequired() should be abstract!",
                    Modifier.isAbstract(ProjectItem.class.getMethod("getTimeRequired").getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("ProjectItem should have a method named getTimeRequired without any parameters!");
        }
        try {
            assertTrue("ProjectItem.getMaterialCost() should be abstract!",
                    Modifier.isAbstract(ProjectItem.class.getMethod("getMaterialCost").getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("ProjectItem should have a method named getMaterialCost without any parameters!");
        }
    }

    @Before
    public void setUp() {
        p = new ProjectItemImpl("name", "details", 2.25);
    }

    @Test
    public void testConstructorNullArgument() {
        try {
            new ProjectItemImpl(null, "details", 1.0);
            fail("ProjectItem.ProjectItem() should throw a NullPointerException if the name argument is null!");
        } catch (NullPointerException e) {
        }
        try {
            new ProjectItemImpl("name", null, 1.0);
            fail("ProjectItem.ProjectItem() should throw a NullPointerException if the details argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testConstructorIllegalArgument() {
        try {
            new ProjectItemImpl("", "details", 1.0);
            fail("ProjectItem.ProjectItem() should throw an IllegalArgumentException if the name argument is empty!");
        } catch (IllegalArgumentException e) {
        }
        try {
            new ProjectItemImpl("name", "", 1.0);
            fail("ProjectItem.ProjectItem() should throw an IllegalArgumentException if the description argument is empty!");
        } catch (IllegalArgumentException e) {
        }
        try {
            new ProjectItemImpl("name", "details", -Double.MIN_VALUE);
            fail("ProjectItem.ProjectItem() should throw an IllegalArgumentException if the rate argument is negative!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testCostEstimate() {
        assertEquals("ProjectItem.getCostEsimate() should return the correct value!", 19, p.getCostEstimate());
    }
}
