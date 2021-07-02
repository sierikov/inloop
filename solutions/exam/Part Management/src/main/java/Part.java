public abstract class Part {
    private String id;
    private String name;

    public Part(String id, String name){
        this.id = Validator.checkParam(id);
        this.name = Validator.checkParam(name);
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
