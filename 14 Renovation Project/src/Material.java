import java.util.Objects;

public class Material {
    private String name;
    private double price;

    public Material (String name, double price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return this.name;
    }


    public double getPricePerUnit() {
        return this.price;
    }

    public double getPriceOfASurface(Surface s) {
        Objects.requireNonNull(s);
        return 0;
    }

    public int getMaterialReq(Surface s){

    }
}
