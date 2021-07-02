public class HasLength<T extends String> implements Predicate<T>{

    private final int length;

    HasLength(int length){
        if (length < 0) throw new IllegalArgumentException("Length can't be negative");
        this.length = length;
    }

    @Override
    public boolean test(String value) {
        return Validator.checkParams(value, Integer.toString(length))
                && value.length() == length;
    }
}
