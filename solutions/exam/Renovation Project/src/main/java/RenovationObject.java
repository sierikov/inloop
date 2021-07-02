import java.util.Map;

public abstract class RenovationObject {
    public abstract double getPrice();

    public abstract Map<String, Integer> addMaterialRequirements(Map<String, Integer> materials);
}
