import java.util.*;

public class EventCatalogImpl extends TreeMap implements EventCatalog {
    private Map<Event,Set<Time>> catalog;

    public EventCatalogImpl(){
        catalog = new TreeMap<>();
    }

    @Override
    public boolean addCatalogEntry(Event event, Set<Time> timeSet) {
        if (timeSet == null || timeSet.contains(null))throw new NullPointerException();
        if (catalog.containsKey(event)) return false;

        catalog.put(event,timeSet);
        return true;
    }

    @Override
    public boolean addTimeToEvent(Event event, Time time) {
        Objects.requireNonNull(time);
        if(!catalog.containsKey(event))return false;
        Set<Time> events = catalog.get(event);
        if (events.contains(time))return false;

        events.add(time);
        catalog.put(event,events);
        return true;
    }

    @Override
    public Set<Event> getAllEvents() {
        return catalog.keySet();
    }

    @Override
    public Set<Time> getTimesOfEvent(Event e) {
        return catalog.get(e);
    }

    @Override
    public Map<Event, Set<Time>> filterByEventCategory(EventCategory category) {
        Objects.requireNonNull(category);
        Map<Event,Set<Time>> filteredMap = new TreeMap<>();

        for(Map.Entry<Event, Set<Time>> entry : catalog.entrySet()){
            Event e = entry.getKey();
            Set<Time> tSet = entry.getValue();
            if (e.getCategory() == category) {
                filteredMap.put(e,tSet);
            }

        }
        return filteredMap;
    }

    @Override
    public Set<Time> deleteEvent(Event event) {
        return catalog.remove(event);
    }

    @Override
    public boolean deleteTime(Event event,Time time) {
        Objects.requireNonNull(event);
        Objects.requireNonNull(time);
        if(catalog.containsKey(event)){
            Set<Time> times = catalog.get(event);
            if (times.contains(time)){
                times.remove(time);
                catalog.put(event,times);
                return true;
            }
        }
        return false;
    }

}