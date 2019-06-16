public class JTopic extends JContent {
    private int id;

    public JTopic(String title, String description, int id){
        super(title, description);
        this.id = Validator.checkParam(id);
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Topic: " + super.getTitle() + '\n' +
                super.getDescription();
    }

    public void setTitle(String title) {
        super.setTitle(title);
        this.not();
    }

    public void setDescription(String description) {
        super.setDescription(description);
        this.not();
    }

    private void not() {
        setChanged();
        notifyObservers(this);
    }
}
