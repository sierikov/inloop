import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.*;

import org.junit.Test;

public class StaffMemberIteratorTest {
    @Test
    public void testConstructorRejectsNullArgument() {
        try {
            new StaffMemberIterator(null);
            fail("StaffMemberIterator.StaffMemberIterator() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testIteratorOverEmptySet() {
        Iterator<StaffMember> iter = new StaffMemberIterator(new HashSet<>());

        assertFalse("StaffMemberIterator.hasNext() should return false if there is no next element!", iter.hasNext());
        try {
            iter.next();
            fail("StaffMemberIterator.next() should throw a NoSuchElementException if there is no next element!");
        } catch (NoSuchElementException e) {
        }
    }

    @Test
    public void testIteratorReturnsElementsInProperOrder() {
        StaffMember teamLeader = new StaffMember("Mike", "Supervisor");
        SortedSet<StaffMember> expectedMembers = new TreeSet<>(TeamTest.createTeamHierarchy(teamLeader));
        expectedMembers.remove(teamLeader);

        Iterator<StaffMember> expectedIter = expectedMembers.iterator();
        Iterator<StaffMember> actualIter = new StaffMemberIterator(teamLeader.getDirectSubordinates());

        while (expectedIter.hasNext()) {
            assertTrue("StaffMemberIterator.hasNext() should return true if there is a next available element!",
                    actualIter.hasNext());
            assertEquals(
                    "StaffMemberIterator.next() should return the correct next element if there is one available!",
                    expectedIter.next(), actualIter.next());
        }

        assertFalse("StaffMemberIterator.hasNext() should return false if there is no next element!",
                actualIter.hasNext());
        try {
            actualIter.next();
            fail("StaffMemberIterator.next() should throw a NoSuchElementException if there is no next element!");
        } catch (NoSuchElementException e) {
        }
    }
}
