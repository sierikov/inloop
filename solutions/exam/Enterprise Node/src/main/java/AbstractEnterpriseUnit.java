public abstract class AbstractEnterpriseUnit implements EnterpriseNode {
    private String name;

    AbstractEnterpriseUnit(String name) {
        this.name = Validator.checkParam(name);
    }

    @Override
    public String getName() {
        return this.name;
    }
}
