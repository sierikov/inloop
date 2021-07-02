import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class StructuredObject extends RenovationObject {
    private Set<RenovationObject> parts;

    public StructuredObject() {
        this.parts = new HashSet<>();
    }

    public void add(RenovationObject renovationObject) {
        Objects.requireNonNull(renovationObject);
        this.parts.add(renovationObject);
    }

    public double getPrice() {
        AtomicReference<Double> price = new AtomicReference<>(0d);
        parts.forEach(
                renovationObject -> price.updateAndGet(
                        value -> (double) (value + renovationObject.getPrice())
                )
        );

        return price.get();
    }

    public Map<String, Integer> addMaterialReq(Map<String, Integer> materialMap) {
        Validator.checkParam(materialMap);

        for (RenovationObject obj : parts) materialMap = obj.addMaterialReq(materialMap);

        return materialMap;
    }
}
