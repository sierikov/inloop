public class JValuation extends JContent {

    public JValuation(String title, String description) {
        super(title, description);
    }

    @Override
    public String toString() {
        return "Valuation: " + super.getTitle() + '\n'
                + super.getDescription();
    }
}
