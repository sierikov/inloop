import java.util.Map;

public abstract class RenovationObject {
    public abstract double getPrice();

    public abstract Map<String, Integer> addMaterialReq(Map<String, Integer> materials);
}
