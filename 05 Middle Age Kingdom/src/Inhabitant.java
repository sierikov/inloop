public class Inhabitant {

    @SuppressWarnings("WeakerAccess")
    protected int income;
    protected int tax = 10;


    public Inhabitant(){}

    public int getIncome() {
        return this.income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int taxableIncome(){
        return 0;
    }

    public int tax(){
        return (int)(getIncome()*(tax/100.0f));
    }


}
