import java.util.Objects;

public class Event implements Comparable<Event>{
    private String title;
    private EventCategory category;

    public Event(String title, EventCategory category){
        this.title = Validator.checkParam(title);
        this.category = Objects.requireNonNull(category);
    }

    public String getTitle() {
        return this.title;
    }

    public EventCategory getCategory() {
        return this.category;
    }

    @Override
    public int compareTo(Event event) {
        int ratioTitle = this.title.compareTo(event.getTitle());
        int ratioCateg = this.category.compareTo(event.getCategory());
        if (ratioTitle != 0) return ratioTitle;
        else return ratioCateg;
    }
}