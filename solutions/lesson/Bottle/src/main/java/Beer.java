public class Beer extends Drink {
    private String brewery;

    public Beer(String brewery){
        this.setBrewery(brewery);
    }

    public String getBrewery() {
        return brewery;
    }

    public void setBrewery(String brewery) {
        this.brewery = brewery;
    }

    @Override
    public String toString(){
        return this.getBrewery();
    }
}
