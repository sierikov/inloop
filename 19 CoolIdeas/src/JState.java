import java.util.Objects;

public abstract class JState {
    private JValuation valuation;
    private String currentDiscussion;

    public abstract void hold();
    public abstract void release();
    public abstract void decline();

    public void discuss(String currentDiscussion) {
        this.currentDiscussion = currentDiscussion;
    }

    public void evaluate(JValuation valuation) {
        this.valuation = valuation;
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
