import java.util.Objects;

public abstract class Material {
    private String name;
    private double price;

    public Material (String name, double price){
        Validator.checkParam(name);
        Validator.checkParam(price);
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return this.name;
    }

    public double getPricePerUnit() {
        return this.price;
    }

    public double getPriceOfASurface(Surface surface) {
        Objects.requireNonNull(surface);
        return this.getPricePerUnit() * getMaterialReq(surface);
    }

    public abstract int getMaterialReq(Surface surface);
}
