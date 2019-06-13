import java.util.Objects;

public class Flooring extends Material {
    private double limit = 0.02;
    private double widthOfFlooring;

    public Flooring(String name, double price, double width){
        super(name,price);
        Validator.checkParam(width);
        this.widthOfFlooring = width;
    }

    public double getWidth() {
        return widthOfFlooring;
    }

    @Override
    public int getMaterialReq(Surface surface) {
        int result = (int) (surface.getArea() / this.widthOfFlooring);
        double tolerance = round(surface.getArea() % this.widthOfFlooring);
        if (tolerance <= this.limit) return result;
        else return result + 1;
    }

    private double round(double d){
        return Math.round(d * 100f) / 100f;
    }

}
