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
}
