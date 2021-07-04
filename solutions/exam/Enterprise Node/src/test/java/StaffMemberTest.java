import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Set;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

public class StaffMemberTest {
    private StaffMember mike;
    private StaffMember bob;
    private Set<StaffMember> staffMembers;

    @Before
    public void setUp() {
        mike = new StaffMember("Mike", "Supervisor");
        bob = new StaffMember("Bob", "Executive 1");
        staffMembers = new TreeSet<>();
        staffMembers.add(bob);
        staffMembers.add(new StaffMember("Member 2", "Executive 2"));
        staffMembers.add(new StaffMember("Member 3", "Executive 3"));
        staffMembers.add(new StaffMember("Member 4", "Executive 4"));
    }

    @Test
    public void testConstructorNullArgument() {
        try {
            new StaffMember(null, "Supervisor");
            fail("StaffMember.StaffMember() should throw a NullPointerException if the name argument is null!");
        } catch (NullPointerException e) {
        }

        try {
            new StaffMember("Mike", null);
            fail("StaffMember.StaffMember() should throw a NullPointerException if the job argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testConstructorIllegalArgument() {
        try {
            new StaffMember("", "Supervisor");
            fail("StaffMember.StaffMember() should throw an IllegalArgumentException if the name argument is empty!");
        } catch (IllegalArgumentException e) {
        }

        try {
            new StaffMember("Mike", "");
            fail("StaffMember.StaffMember() should throw an IllegalArgumentException if the job argument is empty!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testGetName() {
        assertEquals("StaffMember.getName() should return the correct value!", "Mike", mike.getName());
    }

    @Test
    public void testGetJob() {
        assertEquals("StaffMember.getJob() should return the correct value!", "Supervisor", mike.getJob());
    }

    @Test
    public void testCompareTo() {
        assertTrue("StaffMember.compareTo() should return a positive integer if the given value is smaller!",
                mike.compareTo(new StaffMember("Marc", "CEO")) > 0);
        assertEquals("StaffMember.compareTo() should return the integer zero if the given value is equal!",
                0, mike.compareTo(new StaffMember("Mike", "Chief Supervisor")));
        assertTrue("StaffMember.compareTo() should return a negative integer if the given value is greater!",
                mike.compareTo(new StaffMember("Monique", "CFO")) < 0);
    }

    @Test
    public void testAddDirectSubordinateNullArgument() {
        try {
            mike.addDirectSubordinate(null);
            fail("StaffMember.addDirectSubordinate() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testAddDirectSubordinate() {
        for (StaffMember subordinate : staffMembers) {
            assertTrue("StaffMember.addDirectSubordinate() should return true if the member is to be added!",
                    mike.addDirectSubordinate(subordinate));
            assertTrue(
                    "StaffMember.addDirectSubordinate() should add the member if it was not a direct subordinate previously!",
                    mike.getDirectSubordinates().contains(subordinate));

            int sizeBefore = mike.getDirectSubordinates().size();
            assertFalse("StaffMember.addDirectSubordinate() should return false if the member is not to be added!",
                    mike.addDirectSubordinate(subordinate));
            assertEquals("StaffMember.addDirectSubordinate() should not add the member if it is a direct subordinate!",
                    sizeBefore, mike.getDirectSubordinates().size());
        }
    }

    @Test
    public void testRemoveDirectSubordinateNullArgument() {
        try {
            mike.removeDirectSubordinate(null);
            fail("StaffMember.removeDirectSubordinate() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testRemoveDirectSubordinate() {
        for (StaffMember subordinate : staffMembers) {
            mike.addDirectSubordinate(subordinate);
        }

        for (StaffMember subordinate : staffMembers) {
            assertTrue(
                    "StaffMember.removeDirectSubordinate() should return true if the member was a direct subordinate!",
                    mike.removeDirectSubordinate(subordinate));
            assertFalse(
                    "StaffMember.removeDirectSubordinate() should remove the member if it is a direct subordinate!",
                    mike.getDirectSubordinates().contains(subordinate));
            assertFalse(
                    "StaffMember.removeDirectSubordinate() should return false if the member is not a direct subordinate!",
                    mike.removeDirectSubordinate(subordinate));
        }
    }

    @Test
    public void testRemoveIndirectSubordinate() {
        for (StaffMember subordinate : staffMembers) {
            mike.addDirectSubordinate(subordinate);
        }

        StaffMember newMember = new StaffMember("New Guy", "New Stuff");
        bob.addDirectSubordinate(newMember);

        assertFalse(
                "StaffMember.removeDirectSubordinate() should return false if the member is not a direct subordinate!",
                mike.removeDirectSubordinate(newMember));
        assertTrue("StaffMember.removeDirectSubordinate() should not remove an indirect subordinate!",
                bob.getDirectSubordinates().contains(newMember));
    }

    @Test
    public void testGetDirectSubordinatesInitiallyEmpty() {
        Set<StaffMember> subordinates = mike.getDirectSubordinates();
        assertTrue(
                "StaffMember.getDirectSubordinates() should return an empty set if no direct subordinates have been added!",
                subordinates.isEmpty());
    }

    @Test
    public void testToString() {
        assertEquals("StaffMember.toString() should return the correct value!", "Mike", mike.toString());
    }
}
