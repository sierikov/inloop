import java.util.HashSet;
import java.util.Set;

public abstract class JContent {
    private String title;
    private String description;
    private Set<ContentObserver> observers;

    public JContent(String title, String description){
        this.title = Validator.checkParam(title);
        this.description = Validator.checkParam(description);
        this.observers = new HashSet<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = Validator.checkParam(title);
        this.notifyAll(this);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = Validator.checkParam(description);
        this.notifyAll(this);
    }

    public void addObservers(ContentObserver observer) {
        Validator.checkParam(observer);
        this.observers.add(observer);
    }

    public void removeObserver(ContentObserver observer){
        this.observers.remove(observer);
    }

    public int countObservers() {
        return this.observers.size();
    }

    private void notifyAll(JContent content){
        this.observers.forEach(observer -> observer.update((JTopic) content));
    }

    @Override
    public abstract String toString();
}
