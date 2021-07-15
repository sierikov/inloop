import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class JIdea extends JContent{

    private JState state;
    private List<JAttachment> attachments;

    public JIdea(String title, String description) {
        super(title, description);
        this.state = new Draft();
        this.attachments = new LinkedList<>();
    }

    public void discuss(String text){
        this.state.discuss(text);
    }

    public void evaluate(JValuation valuation){
        this.state.evaluate(valuation);
    }

    public void hold(){
        this.state.hold();
    }

    public void release(){
        this.state.release();
    }

    public void decline(){
        this.state.decline();
    }

    public boolean isDeclined(){
        return Utils.isInstance(this.state, DeclinedIdea.class);
    }

    public boolean isReleased(){
        return Utils.isInstance(this.state, ReleasedIdea.class);
    }

    public String getCurrentDiscussion(){
        return this.state.getCurrentDiscussion();
    }

    public JValuation getValuation(){
        return this.state.getValuation();
    }

    public void addAttachment(JAttachment attachment){
        Validator.checkParam(attachment);
        this.attachments.add(attachment);
    }

    public List<JAttachment> getAttachments() {
        return this.attachments;
    }

    public boolean removeAttachment(JAttachment attachment){
        Validator.checkParam(attachment);
        return attachments.remove(attachment);
    }

    @Override
    public String toString() {
        return "Idea: " + super.getTitle() + '\n' + super.getDescription();
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        JIdea idea = (JIdea) object;
        return  Objects.equals(idea.getTitle(),       this.getTitle()) &&
                Objects.equals(idea.getDescription(), this.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getTitle(), this.getDescription());
    }

    public abstract class JState {
        private JValuation valuation;
        private String currentDiscussion = "";

        public void hold() {};
        public void release(){};
        public void decline(){};

        public void discuss(String currentDiscussion) {
            Validator.checkParam(currentDiscussion);
            this.currentDiscussion += currentDiscussion + '\n';
        }

        public void evaluate(JValuation valuation) {
            this.valuation = Objects.requireNonNull(valuation);
        }

        public String getCurrentDiscussion() {
            return currentDiscussion;
        }

        public JValuation getValuation() {
            return valuation;
        }

        public void setCurrentDiscussion(String currentDiscussion) {
            this.currentDiscussion = Validator.checkParam(currentDiscussion);
        }
        public void setValuation(JValuation valuation) {
            this.valuation = Objects.requireNonNull(valuation);
        }
    }
    public class Draft extends JState {

        @Override
        public void hold() {
            state = new OpenDraft();
        }

        @Override
        public void decline() {
            state = new DeclinedIdea();
        }

        @Override
        public void discuss(String text){
            throw new IllegalStateException("Can be discussed: This is only Draft");
        }

        @Override
        public void evaluate(JValuation valuation) {
            throw new IllegalStateException("Can be evaluated: This is only Draft");
        }

        @Override
        public void release() {
            throw new IllegalStateException("Can be released: This is only Draft");
        }
    }
    public class OpenDraft extends JState{
        @Override
        public void decline() {
            state = new DeclinedIdea();
        }

        @Override
        public void hold() {
            state = new ApprovedIdea();
        }

        @Override
        public void release() {
            throw new IllegalStateException("Cannot be released yet: OpenDraft only");
        }
    }
    public class DeclinedIdea extends JState{
        @Override
        public void hold() {
            throw new IllegalStateException("Idea is declined. You can't hold it");
        }

        @Override
        public void decline() {
            throw new IllegalStateException("Idea is declined. You can't decline it");
        }

        @Override
        public void discuss(String currentDiscussion) {
            throw new IllegalStateException("Idea is declined. You can't discuss it");
        }

        @Override
        public void evaluate(JValuation valuation) {
            throw new IllegalStateException("Idea is declined. You can't evaluate it");
        }

        @Override
        public void release() {
            throw new IllegalStateException("Idea is declined. You can't release it");
        }
    }
    public class ApprovedIdea extends JState {
        @Override
        public void hold() {
            throw new IllegalStateException("Idea is Approved. You can't hold it");
        }

        @Override
        public void decline() {
            throw new IllegalStateException("Idea is Approved. You can't decline it");
        }

        @Override
        public void discuss(String currentDiscussion) {
            throw new IllegalStateException("Idea is Approved. You can't discuss it");
        }

        @Override
        public void evaluate(JValuation valuation) {
            throw new IllegalStateException("Idea is Approved. You can't evaluate it");
        }

        @Override
        public void release() {
            state = new ReleasedIdea();
        }
    }
    public class ReleasedIdea extends JState {
        @Override
        public void hold() {
            throw new IllegalStateException("Cannot be holed: ReleasedIdea");
        }

        @Override
        public void release() {
            throw new IllegalStateException("Cannot be released: ReleasedIdea");
        }

        @Override
        public void decline() {
            throw new IllegalStateException("Idea is already released!");
        }

        @Override
        public void discuss(String currentDiscussion) {
            throw new IllegalStateException("Idea is Released. You can't discuss it");
        }

        @Override
        public void evaluate(JValuation valuation) {
            throw new IllegalStateException("Idea is Released. You can't evaluate it");
        }
    }

}
