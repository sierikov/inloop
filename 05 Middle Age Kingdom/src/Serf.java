public class Serf extends Peasant {
    @Override
    public int tax(){
        if(this.taxableIncome() < 12) return 0;
        else {
            int sum = getSum();
            return sum > 0 ? sum : 1;
        }
    }

    @Override
    public int taxableIncome() {
        return this.income - 12 >= 0 ? this.income - 12 : 0;
    }
}
