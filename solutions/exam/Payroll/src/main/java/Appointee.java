public class Appointee extends Employee {
    private int payday;
    private int hoursPerMonth;
    private double payPerHour;
    private final static double LIFE = 0.4d;

    public Appointee(String id, int payday, int hoursPerMonth, double payPerHour) {
        super(id);
        this.payday = Validator.checkDayInMonth(payday);
        this.payPerHour = Validator.checkParam(payPerHour);
        this.hoursPerMonth = Validator.checkParam(hoursPerMonth);
    }

    @Override
    public boolean isPayday(int dayOfMonth) {
        return dayOfMonth == this.payday;
    }

    @Override
    public double calculatePay() throws UnpayableEmployeeException  {
        return this.hoursPerMonth * this.payPerHour;
    }

    @Override
    public double calculateDeductions() {
        try {
            return this.calculatePay() * LIFE;
        } catch (UnpayableEmployeeException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
