import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class PayrollDispositionImpl implements PayrollDisposition {

    private Map<Employee, Double> payments;

    public PayrollDispositionImpl(){
        this.payments = new LinkedHashMap<>();
    }

    public double getTotal(){
        return this.payments
                .entrySet()
                .stream()
                .mapToDouble(Map.Entry::getValue)
                .sum();
    }

    public double getAverage(){
        if(this.payments.isEmpty()) return 0;
        return this.getTotal() / this.payments.size();
    }

    public Map<Employee, Double> getPayments() {
        return this.payments;
    }

    @Override
    public void sendPayment(Employee employee, double payment) {
        Validator.checkParam(payment);
        Objects.requireNonNull(employee);
        this.payments.put(employee, payment);
    }
}
