import java.util.Observable;

public abstract class JContent extends Observable {
    private String title;
    private String description;

    public JContent(String title, String description){
        this.title = Validator.checkParam(title);
        this.description = Validator.checkParam(description);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = Validator.checkParam(title);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = Validator.checkParam(description);
    }

    @Override
    public abstract String toString();
}
