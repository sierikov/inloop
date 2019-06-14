import java.time.LocalDate;
import java.util.Objects;

public class Deliverable extends ProjectItem {
    private long materialCost;
    private double productionTime;
    private LocalDate date;

    public Deliverable(String name,
                       String details,
                       double rate,
                       long materialCost,
                       double productionTime,
                       LocalDate date){

        super(name, details, rate);

        this.date = Objects.requireNonNull(date);
        this.materialCost = Validator.checkParam(materialCost);
        this.productionTime = Validator.checkParam(productionTime);

    }


    public LocalDate getDate() {
        return this.date;
    }

    @Override
    public double getTimeRequired() {
        return this.productionTime;
    }

    @Override
    public long getMaterialCost() {
        return this.materialCost;
    }
}
