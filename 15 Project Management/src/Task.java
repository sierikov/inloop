import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Task extends ProjectItem {
    private List<ProjectItem> projectItems;

    public Task(String name, String details, double rate) {
        super(name, details, rate);
        this.projectItems = new LinkedList<>();
    }

    public void addProjectItem(ProjectItem projectItem){
        Objects.requireNonNull(projectItem);
        projectItems.add(projectItem);
    }

    public void removeProjectItem(ProjectItem projectItem){
        Objects.requireNonNull(projectItem);
        projectItems.remove(projectItem);
    }

    public List<Deliverable> allDeliverables(){
        List<Deliverable> deliverables = new LinkedList<>();

        this.projectItems.forEach(item -> {
            if (item instanceof Deliverable)
                deliverables.add((Deliverable) item);
            if (item instanceof Task)
                deliverables.addAll(
                        ((Task) item).allDeliverables()
                );
        });

        return deliverables;
    }

    @Override
    public double getTimeRequired() {
        double time = projectItems
                .stream()
                .mapToDouble(ProjectItem::getTimeRequired)
                .sum();
        return time;
    }

    @Override
    public long getMaterialCost() {
        long totalCoost = projectItems
                .stream()
                .mapToLong(ProjectItem::getMaterialCost)
                .sum();
        return totalCoost;
    }
}
