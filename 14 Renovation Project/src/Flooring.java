public class Flooring extends Material {
    private double limit = 0.02;
    private double widthOfFlooring;

    public Flooring(String name, double price, double width){
        super(name, price);
        this.widthOfFlooring = width;
    }

    public double getWidth() {
        return widthOfFlooring;
    }
    public int getMaterialReq(Surface s) {
        return (int) (s.getArea() / this.widthOfFlooring);
    }
}
