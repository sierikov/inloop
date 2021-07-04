import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class AbstractUnitTest {
    private static class AbstractUnitImpl extends AbstractUnit {
        public AbstractUnitImpl(String name) {
            super(name);
        }
    }

    private AbstractUnit unit;
    private Set<AbstractUnit> childNodes;
    private AbstractUnit subUnit;

    @Before
    public void setUp() {
        unit = new AbstractUnitImpl("Abstract Unit");
        subUnit = new AbstractUnitImpl("AU1");
        childNodes = new HashSet<>();
        childNodes.add(subUnit);
        childNodes.add(new AbstractUnitImpl("AU2"));
        childNodes.add(new AbstractUnitImpl("AU3"));
        childNodes.add(new AbstractUnitImpl("AU4"));
        childNodes.add(new AbstractUnitImpl("AU5"));
    }

    @Test
    public void testAbstract() {
        assertTrue("AbstractUnit should be abstract!", Modifier.isAbstract(AbstractUnit.class.getModifiers()));
    }

    @Test
    public void testConstructorNullArgument() {
        try {
            new AbstractUnitImpl(null);
            fail("AbstractUnit.AbstractUnit() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testConstructorIllegalArgument() {
        try {
            new AbstractUnitImpl("");
            fail("AbstractUnit.AbstractUnit() should throw an IllegalArgumentException if the argument is empty!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testGetName() {
        assertEquals("AbstractUnit.getName() should return the correct value!", "Abstract Unit", unit.getName());
    }

    @Test
    public void testAddNullArgument() {
        try {
            unit.add(null);
            fail("AbstractUnit.add() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testAdd() {
        for (AbstractUnit childNode : childNodes) {
            assertTrue("AbstractUnit.add() should return true if the unit was added!",
                    unit.add(childNode));
            assertTrue(
                    "AbstractUnit.add() should add the unit if it was not a direct child node previously!",
                    unit.getChildNodes().contains(childNode));

            int sizeBefore = unit.getChildNodes().size();
            assertFalse("AbstractUnit.add() should return false if the unit was not added!",
                    unit.add(childNode));
            assertEquals("AbstractUnit.add() should not add duplicates of the unit!",
                    sizeBefore, unit.getChildNodes().size());
        }
    }

    @Test
    public void testRemoveNullArgument() {
        try {
            unit.remove(null);
            fail("AbstractUnit.remove() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testRemove() {
        for (AbstractUnit childNode : childNodes) {
            unit.add(childNode);
        }

        for (AbstractUnit childNode : childNodes) {
            assertTrue("AbstractUnit.remove() should return true if the unit was a child node!",
                    unit.remove(childNode));
            assertFalse("AbstractUnit.remove() should remove the unit if it is a child node!",
                    unit.getChildNodes().contains(childNode));
            assertFalse("AbstractUnit.remove() should return false if the unit is not a child node!",
                    unit.remove(childNode));
        }
    }

    @Test
    public void testRemoveIndirectChildNode() {
        for (AbstractUnit childNode : childNodes) {
            unit.add(childNode);
        }

        AbstractUnit newUnit = new Holding("H1");
        subUnit.add(newUnit);

        assertFalse("AbstractUnit.remove() should return false if the unit is not a direct child node!",
                unit.remove(newUnit));
        assertTrue("AbstractUnit.remove() should not remove an indirect child node!",
                subUnit.getChildNodes().contains(newUnit));
    }

    @Test
    public void testGetChildNodesInitiallyEmpty() {
        List<AbstractEnterpriseUnit> childNodes = unit.getChildNodes();
        assertTrue("AbstractUnit.getChildNodes() should return an empty set if no child nodes have been added!",
                childNodes.isEmpty());
    }
}
