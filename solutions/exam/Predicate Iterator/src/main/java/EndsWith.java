public class EndsWith<T extends String> implements Predicate<T>{

    private final String suffix;

    public EndsWith(String suffix) {
        if (suffix == null) throw new IllegalArgumentException("Suffix can't be null");
        this.suffix = suffix;
    }

    @Override
    public boolean test(String value) {
        return Validator.checkParams(value, suffix) && value.endsWith(suffix);
    }
}
