import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

public class EventCatalogImplTest {
    private EventCatalog catalog;
    private List<Event> events;
    private List<List<Time>> times;
    private Map<EventCategory, List<Integer>> categoryToIndices;
    private Event newEvent;

    @Before
    public void setUp() {
        catalog = new EventCatalogImpl();
        events = new ArrayList<>();
        times = new ArrayList<>();
        categoryToIndices = new HashMap<>();

        events.add(new Event("e1", EventCategory.EXHIBITION));
        events.add(new Event("e2", EventCategory.EXHIBITION));
        categoryToIndices.put(EventCategory.EXHIBITION, Arrays.asList(0, 1));
        events.add(new Event("p1", EventCategory.PRESENTATION));
        events.add(new Event("p2", EventCategory.PRESENTATION));
        events.add(new Event("p3", EventCategory.PRESENTATION));
        categoryToIndices.put(EventCategory.PRESENTATION, Arrays.asList(2, 3, 4));
        events.add(new Event("s1", EventCategory.SHOW));
        events.add(new Event("s2", EventCategory.SHOW));
        events.add(new Event("s3", EventCategory.SHOW));
        categoryToIndices.put(EventCategory.SHOW, Arrays.asList(5, 6, 7));

        times.add(Arrays.asList(new Time(10, 30), new Time(13, 30), new Time(16, 30)));
        times.add(Arrays.asList(new Time(11, 00), new Time(15, 00)));
        times.add(Arrays.asList(new Time(14, 15), new Time(16, 45), new Time(19, 15)));
        times.add(Arrays.asList(new Time(10, 00), new Time(12, 40), new Time(14, 00)));
        times.add(Arrays.asList(new Time(11, 10), new Time(13, 30), new Time(16, 10)));
        times.add(Arrays.asList());
        times.add(Arrays.asList(new Time(11, 45), new Time(12, 45), new Time(13, 45)));
        times.add(Arrays.asList(new Time(17, 20), new Time(18, 50), new Time(20, 15)));

        for (int i = 0; i < events.size(); i++) {
            catalog.addCatalogEntry(events.get(i), new HashSet<>(times.get(i)));
        }

        newEvent = new Event("e3", EventCategory.EXHIBITION);
    }

    @Test
    public void testSuperClass() {
        assertEquals("The class EventCatalogImpl should extend the class TreeMap!",
                EventCatalogImpl.class.getSuperclass(), TreeMap.class);
    }

    @Test
    public void testAddCatalogEntryNullArgument() {
        Set<Time> nullSet = new HashSet<>(times.get(0));
        nullSet.add(null);

        try {
            catalog.addCatalogEntry(null, new HashSet<>(times.get(0)));
            fail("EventCatalogImpl.addCatalogEntry() should throw a NullPointerException if the e argument is null!");
        } catch (NullPointerException e) {
        }

        try {
            catalog.addCatalogEntry(events.get(0), null);
            fail("EventCatalogImpl.addCatalogEntry() should throw a NullPointerException if the tSet argument is null!");
        } catch (NullPointerException e) {
        }

        try {
            catalog.addCatalogEntry(events.get(0), nullSet);
            fail("EventCatalogImpl.addCatalogEntry() should throw a NullPointerException if one of the objects in the tSet argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testAddCatalogEntry() {
        assertFalse(
                "EventCatalogImpl.addCatalogEntry() should return false if the catalog already contains the Event!",
                catalog.addCatalogEntry(events.get(0), new HashSet<>(times.get(1))));
        assertEquals(
                "EventCatalogImpl.addCatalogEntry() should not change the Event's catalog entry if the catalog already contains the Event!",
                new HashSet<>(times.get(0)), catalog.getTimesOfEvent(events.get(0)));

        assertTrue("EventCatalogImpl.addCatalogEntry() should return true if the catalog did not contain the Event!",
                catalog.addCatalogEntry(newEvent, new HashSet<>(times.get(6))));
        assertEquals("EventCatalogImpl.addCatalogEntry() should add the Event-Set<Time> pair!",
                new HashSet<>(times.get(0)), catalog.getTimesOfEvent(events.get(0)));
    }

    @Test
    public void testAddTimeToEventNullArgument() {
        try {
            catalog.addTimeToEvent(null, times.get(0).get(0));
            fail("EventCatalogImpl.addTimeToEvent() should throw a NullPointerException if the e argument is null!");
        } catch (NullPointerException e) {
        }

        try {
            catalog.addTimeToEvent(events.get(0), null);
            fail("EventCatalogImpl.addTimeToEvent() should throw a NullPointerException if the t argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testAddTimeToEvent() {
        assertFalse(
                "EventCatalogImpl.addTimeToEvent() should return false if the Time is already registered for the Event!",
                catalog.addTimeToEvent(events.get(0), times.get(0).get(0)));

        assertFalse("EventCatalogImpl.addTimeToEvent() should return false if the catalog does not contain the Event!",
                catalog.addTimeToEvent(newEvent, times.get(1).get(0)));
        assertFalse("EventCatalogImpl.addTimeToEvent() should not add the Event if the catalog did not contain it!",
                catalog.getAllEvents().contains(newEvent));

        Set<Time> newTimes = new HashSet<>(times.get(0));
        newTimes.add(times.get(1).get(0));

        assertTrue(
                "EventCatalogImpl.addTimeToEvent() should return true if the Time was not registered for the Event!",
                catalog.addTimeToEvent(events.get(0), times.get(1).get(0)));
        assertEquals("EventCatalogImpl.addTimeToEvent() should actually add the Time!", newTimes,
                catalog.getTimesOfEvent(events.get(0)));
    }

    @Test
    public void testGetAllEvents() {
        assertEquals(
                "EventCatalogImpl.getAllEvents() should return a Set containing all the Events added to the catalog!",
                new HashSet<>(events), catalog.getAllEvents());
    }

    @Test
    public void testGetTimesOfEventNullArgument() {
        try {
            catalog.getTimesOfEvent(null);
            fail("EventCatalogImpl.getTimesOfEvent() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testGetTimesOfEvent() {
        assertNull("EventCatalogImpl.getTimesOfEvent() should return null if the catalog does not contain the event!",
                catalog.getTimesOfEvent(newEvent));

        for (int i = 0; i < events.size(); i++) {
            assertEquals("EventCatalogImpl.getTimesOfEvent() should return the correct Set<Time>!",
                    new HashSet<>(times.get(i)), catalog.getTimesOfEvent(events.get(i)));
        }
    }

    @Test
    public void testFilterByEventCategoryNullArgument() {
        try {
            catalog.filterByEventCategory(null);
            fail("EventCatalogImpl.filterByEventCategory() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testFilterByEventCategoryEmptyCategory() {
        for (Event e : new HashSet<>(catalog.getAllEvents())) {
            if (e.getCategory() == EventCategory.EXHIBITION) {
                catalog.deleteEvent(e);
            }
        }
        Map<Event, Set<Time>> actual = catalog.filterByEventCategory(EventCategory.EXHIBITION);

        assertEquals(
                "EventCatalogImpl.filterByEventCategory() should return an empty Map if there are no Events of the given category!",
                actual, Collections.EMPTY_MAP);
    }

    @Test
    public void testFilterByEventCategory() {
        Map<Event, Set<Time>> actual;

        for (Map.Entry<EventCategory, List<Integer>> entry : categoryToIndices.entrySet()) {
            actual = catalog.filterByEventCategory(entry.getKey());

            for (Integer index : entry.getValue()) {
                assertTrue(
                        "EventCatalogImpl.filterByEventCategory() should return a Map containing all matching Event-Set<Time> pairs!",
                        actual.containsKey(events.get(index)));
                assertEquals(
                        "EventCatalogImpl.filterByEventCategory() should return a Map containing all matching Event-Set<Time> pairs!",
                        new HashSet<>(times.get(index)), actual.get(events.get(index)));
            }
            assertEquals(
                    "EventCatalogImpl.filterByEventCategory() should return a Map containing only the matching Event-Set<Time> pairs!",
                    actual.size(),
                    entry.getValue().size()
            );
        }
    }

    @Test
    public void testDeleteEventNullArgument() {
        try {
            catalog.deleteEvent(null);
            fail("EventCatalogImpl.deleteEvent() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testDeleteEvent() {
        assertNull("EventCatalogImpl.deleteEvent() should return null if the catalog does not contain the Event!",
                catalog.deleteEvent(newEvent));

        for (int i = 0; i < events.size(); i++) {
            assertEquals("EventCatalogImpl.deleteEvent() should return the correct Set<Time>!",
                    new HashSet<>(times.get(i)), catalog.deleteEvent(events.get(i)));
            assertTrue("EventCatalogImpl.deleteEvent() should actually remove the Event from the catalog!",
                    !catalog.getAllEvents().contains(events.get(i)) && catalog.deleteEvent(events.get(i)) == null);
        }
    }

    @Test
    public void testDeleteTimeNullArgument() {
        try {
            catalog.deleteTime(null, times.get(0).get(0));
            fail("EventCatalogImpl.deleteTime() should throw a NullPointerException if the e argument is null!");
        } catch (NullPointerException e) {
        }

        try {
            catalog.deleteTime(events.get(0), null);
            fail("EventCatalogImpl.deleteTime() should throw a NullPointerException if the t argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testDeleteTime() {
        assertFalse(
                "EventCatalogImpl.deleteTime() should return false if the catalog does not contain the Event-Set<Time> pair!",
                catalog.deleteTime(newEvent, times.get(0).get(0)));
        assertFalse(
                "EventCatalogImpl.deleteTime() should return false if the catalog does not contain Event-Set<Time> pair!",
                catalog.deleteTime(events.get(0), times.get(1).get(0)));

        for (int i = 0; i < events.size(); i++) {
            for (int j = 0; j < times.get(i).size(); j++) {
                assertTrue(
                        "EventCatalogImpl.deleteTime() should return true if the catalog contained the Event-Set<Time> pair!",
                        catalog.deleteTime(events.get(i), times.get(i).get(j)));
                assertFalse("EventCatalogImpl.deleteTime() should actually remove the Time from the Event!",
                        catalog.getTimesOfEvent(events.get(i)).contains(times.get(i).get(j))
                                || catalog.deleteTime(events.get(i), times.get(i).get(j)));
            }
        }
    }
}
