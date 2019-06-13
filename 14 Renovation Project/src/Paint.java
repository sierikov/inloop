import java.util.Objects;

public class Paint extends  Material{
    private double limit = 0.02;
    private int noOfCoast;
    private double noOfSqMPerLiter;
    private double volumeOfCan = 0.500000000;

    public Paint(String name, double price, int noOfCoast, double noOfSqMPerLiter){
        super(name, price);

        this.noOfCoast = Validator.checkParam(noOfCoast);
        this.noOfSqMPerLiter = Validator.checkParam(noOfSqMPerLiter);
    }

    public int getNoOfCoast() {
        return this.noOfCoast;
    }

    public double getNoOfSqMPerLiter() {
        return this.noOfSqMPerLiter;
    }


    public int getNoOfCoats() {
        return this.noOfCoast;
    }


    @Override
    public int getMaterialReq(Surface surface){
        Objects.requireNonNull(surface);
        double calcVal =  (surface.getArea() * this.getNoOfCoats()) / this.getNoOfSqMPerLiter();
        int result = (int) (calcVal / this.getVolumeOfCan());
        double tolerance = calcVal % this.getVolumeOfCan();
        return tolerance <= this.limit ? result : result + 1;
    }

    private double round(double d){
        return Math.round(d * 100f) / 100f;
    }


    public double getVolumeOfCan() {
        return volumeOfCan;
    }
}
