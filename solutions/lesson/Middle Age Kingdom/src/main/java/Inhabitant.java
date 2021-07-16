public class Inhabitant {

    @SuppressWarnings("WeakerAccess")
    protected int income ;
    protected float tax;

    public Inhabitant(){
        this.tax = 10.0f;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int taxableIncome() {
        return this.income;
    }

    public int tax() {
        int sum = getSum();
        return  sum > 0 ? sum : 1;

    }

    protected int getSum() {
        return (int) (taxableIncome() * (this.tax / 100.0f));
    }


}
