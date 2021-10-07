public abstract class Wine extends Drink {
    private String region;

    public Wine(String region){
        this.setRegion(region);
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String brewery) {
        this.region = brewery;
    }

    @Override
    public String toString(){
        return this.getRegion();
    }
}
