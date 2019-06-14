import java.util.List;

interface IProject {
    void setTask(Task newTask);
    double getDuration();
    long getTotalCost();
    List<Deliverable> getDeliverables();
}