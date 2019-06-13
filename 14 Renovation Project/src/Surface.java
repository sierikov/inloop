import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Surface extends RenovationObject {
    private double length;
    private double width;
    private Material selectedMaterial;

    public Surface (double length, double width){
        this.length = Validator.checkParam(length);
        this.width = Validator.checkParam(width);
    }

    public void setMaterial (Material newMaterial){
        Objects.requireNonNull(newMaterial);
        this.selectedMaterial = newMaterial;
    }

    public double getArea(){
        return this.getLength() * this.getWidth();
    }

    public double getLength() {
        return this.length;
    }

    public double getWidth() {
        return this.width;
    }

    public double getPrice(){
        return this.selectedMaterial.getPriceOfASurface(this);
    }

    @Override
    public Map<String, Integer> addMaterialReq(Map<String, Integer> materialsOld) {
        Validator.checkParam(materialsOld);
        Objects.requireNonNull(this.selectedMaterial);


        Map<String, Integer> materials = new TreeMap<>(materialsOld);


        int materialAmountCurr  = this.selectedMaterial.getMaterialReq(this);
        String materialName     = this.selectedMaterial.getName();

        if (materials.containsKey(materialName)){
            int materialAmountOld  = materials.get(materialName);
            materials.replace(materialName, materialAmountCurr + materialAmountOld);
        }
        else {
            materials.put(materialName, materialAmountCurr);
        }

        return materials;
    }


}
