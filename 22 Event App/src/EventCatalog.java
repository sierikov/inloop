import java.util.*;

public interface EventCatalog {
    boolean deleteTime(Event e, Time t);
    boolean addTimeToEvent(Event e, Time t);
    boolean addCatalogEntry(Event e, Set<Time> tSet);

    Set<Time> deleteEvent(Event e);
    Set<Time> getTimesOfEvent(Event e);
    Set<Event> getAllEvents();
    Map<Event, Set<Time>> filterByEventCategory(EventCategory category);


}