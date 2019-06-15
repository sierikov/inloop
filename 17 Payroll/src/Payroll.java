import java.util.Objects;

public class Payroll {
    private int payday;
    private PayrollDisposition disposition;


    public Payroll(PayrollDisposition disposition, int payday) {
        this.disposition = Objects.requireNonNull(disposition);
        this.payday = Validator.checkDayInMonth(payday);
    }

    public void doPayroll(PayrollDB payrollDB) {
        Objects.requireNonNull(payrollDB);
        payrollDB
                .getEmployeeList()
                .stream()
                .filter(employee -> employee instanceof Appointee && employee.isPayday(payday))
                .forEach(e -> {
                    try {
                        disposition.sendPayment(e, e.calculatePay() - e.calculateDeductions());
                    } catch (UnpayableEmployeeException ex) {
                        ex.printStackTrace();
                    }
                });

    }
}
