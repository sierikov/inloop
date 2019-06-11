public class Paint extends  Material{
    private double limit = 0.02;
    private int noOfCoast;
    private double noOfSqMPerLiter;

    public Paint(String name, double price, int noOfCoast, double noOfSqMPerLiter){
        super(name, price);
    }

    public int getNoOfCoast() {
        return noOfCoast;
    }

    public double getNoOfSqMPerLiter() {
        return noOfSqMPerLiter;
    }


}
