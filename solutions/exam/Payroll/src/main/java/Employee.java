public abstract class Employee {
    private String id;

    public Employee(String id){
        this.id = Validator.checkParam(id);
    }

    public String getId() {
        return this.id;
    }

    public abstract boolean isPayday(int dayOfMonth);
    public abstract double calculatePay() throws UnpayableEmployeeException;
    public abstract double calculateDeductions();

}
