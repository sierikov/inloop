import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Surface extends RenovationObject {
    private double length;
    private double width;
    private Material selectedMaterial;

    public Surface (double length, double width){
        this.length = length;
        this.width = width;
    }

    public void setMaterial (Material newMaterial){
        this.selectedMaterial = newMaterial;
    }

    public double getArea(){
        return this.length * this.width;
    }

    public double getLength() {
        return this.length;
    }

    public double getWidth() {
        return this.width;
    }

    public double getPrice(){
        throw  new NotImplementedException();
    }



}
