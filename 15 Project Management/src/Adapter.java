import java.util.List;
import java.util.Objects;

public class Adapter extends Project implements IProject {

    private Task task;

    public Adapter(String name, String description, double rate) {
        super(name, description, rate);
    }

    @Override
    public void setTask(Task task) {
        Objects.requireNonNull(task);
        this.task = task;
    }

    @Override
    public double getDuration() {
        return this.task.getTimeRequired();
    }

    @Override
    public long getTotalCost() {
        return this.task.getCostEstimate();
    }

    @Override
    public List<Deliverable> getDeliverables() {
        return this.task.allDeliverables();
    }
}
