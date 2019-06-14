import java.time.LocalDate;
import java.util.Map;

public abstract class ProjectItem {
    private double rate;
    private String name;
    private String details;


    public ProjectItem(String name, String details, Double rate) {
        this.name = Validator.checkParam(name);
        this.details = Validator.checkParam(details);
        this.rate = Validator.checkParam(rate);
    }


    public long getCostEstimate(){
        double timeCost = this.rate * this.getTimeRequired();
        double totalCost = timeCost + this.getMaterialCost();
        return Math.round(totalCost);
    }

    public abstract double getTimeRequired();
    public abstract long getMaterialCost();
}
