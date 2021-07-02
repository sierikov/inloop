import java.util.Objects;

public class StartsWith<Type extends String> implements Predicate<Type>{

    private final String prefix;

    StartsWith(String prefix){
        if(prefix == null) throw new IllegalArgumentException("Prefix can't be null");
        this.prefix = prefix;
    }

    @Override
    public boolean test(String value) {
        return Validator.checkParams(value, prefix)
                && value.startsWith(prefix);
    }
}
