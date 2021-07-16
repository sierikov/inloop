public class Noble extends Inhabitant {
    @Override
    public int tax(){
        int sum = super.getSum();
        return sum > 20 ? sum : 20;
    }
}
