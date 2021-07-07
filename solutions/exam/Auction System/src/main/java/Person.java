public class Person {
    private String name;

    Person(String name){
        this.name = Validator.checkParam(name);
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
