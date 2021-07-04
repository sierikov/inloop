import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Modifier;

import org.junit.Test;

public class AbstractEnterpriseUnitTest {
    private static class AbstractEnterpriseUnitImpl extends AbstractEnterpriseUnit {
        public AbstractEnterpriseUnitImpl(String name) {
            super(name);
        }
    }

    @Test
    public void testAbstract() {
        assertTrue("AbstractEnterpriseUnit should be abstract!",
                Modifier.isAbstract(AbstractEnterpriseUnit.class.getModifiers()));
    }

    @Test
    public void testConstructorNullArgument() {
        try {
            new AbstractEnterpriseUnitImpl(null);
            fail("AbstractEnterpriseUnit.AbstractEnterpriseUnit() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }

        try {
            new Holding(null);
            fail("Holding.Holding() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }

        try {
            new Company(null);
            fail("Company.Company() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }

        try {
            new Division(null);
            fail("Division.Division() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }

        try {
            new Team(null, new StaffMember("Mike", "Supervisor"));
            fail("Team.Team() should throw a NullPointerException if the name argument is null!");
        } catch (NullPointerException e) {
        }

        try {
            new Team("A-Team", null);
            fail("Team.Team() should throw a NullPointerException if the teamLeader argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testConstructorIllegalArgument() {
        try {
            new AbstractEnterpriseUnitImpl("");
            fail("AbstractEnterpriseUnit.AbstractEnterpriseUnit() should throw an IllegalArgumentException if the argument is empty!");
        } catch (IllegalArgumentException e) {
        }

        try {
            new Holding("");
            fail("Holding.Holding() should throw an IllegalArgumentException if the argument is empty!");
        } catch (IllegalArgumentException e) {
        }

        try {
            new Company("");
            fail("Company.Company() should throw an IllegalArgumentException if the argument is empty!");
        } catch (IllegalArgumentException e) {
        }

        try {
            new Division("");
            fail("Division.Division() should throw an IllegalArgumentException if the argument is empty!");
        } catch (IllegalArgumentException e) {
        }

        try {
            new Team("", new StaffMember("Mike", "Supervisor"));
            fail("Team.Team() should throw an IllegalArgumentException if the name argument is empty!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testGetName() {
        EnterpriseNode node = new AbstractEnterpriseUnitImpl("Abstract Enterprise Unit");
        assertTrue("AbstractEnterpriseUnit.getName() should return the correct value!",
                node.getName().equals("Abstract Enterprise Unit"));

        node = new Holding("AEU Holding");
        assertTrue("Holding.getName() should return the correct value!", node.getName().equals("AEU Holding"));

        node = new Company("AEU Company");
        assertTrue("Company.getName() should return the correct value!", node.getName().equals("AEU Company"));

        node = new Division("AEU Division");
        assertTrue("Division.getName() should return the correct value!", node.getName().equals("AEU Division"));

        node = new Team("AEU Team", new StaffMember("Member 1", "Executive 1"));
        assertTrue("Team.getName() should return the correct value!", node.getName().equals("AEU Team"));
    }
}
