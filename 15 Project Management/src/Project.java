import java.time.LocalDate;
import java.util.*;

public class Project {
    private Task task;
    private String name;
    private String description;

    public Project(String name, String description, double rate) {
        Validator.checkParam(rate);
        this.name = Validator.checkParam(name);
        this.description = Validator.checkParam(description);
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setTask(Task task) {
        Objects.requireNonNull(task);
        this.task = task;
    }

    public double getDuration(){
        return this.task.getTimeRequired();
    }

    public long getTotalCost(){
        return this.task.getCostEstimate();
    }

    public Map<LocalDate, List<Deliverable>> allDeliverables(){
        List<Deliverable> deliverables = this.task.allDeliverables();
        Map<LocalDate, List<Deliverable>> deliverableMap = new HashMap<>();

        for (Deliverable deliverable : deliverables) {

            List<Deliverable> valueList = new LinkedList<>();
            LocalDate dateKey = deliverable.getDate();
            boolean isKeyInMap = deliverableMap.containsKey(deliverable.getDate());

            if (isKeyInMap) {
                // Get valueList values from by by Key
                valueList = deliverableMap.get(dateKey);
                // Update Value
                valueList.add(deliverable);
                // Update Value by Key in Map
                deliverableMap.replace(dateKey, valueList);

            } else {
                // Clean up list
                valueList.clear();
                // Add new deliverable to temp ValueList
                valueList.add(deliverable);
                // Put list and Date to the map
                deliverableMap.put(dateKey, valueList);
            }
        }

        return deliverableMap;
    }


}

