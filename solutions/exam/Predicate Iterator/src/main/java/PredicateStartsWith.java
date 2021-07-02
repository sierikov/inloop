public class PredicateStartsWith<Type extends String> implements Predicate<Type>{

    @Override
    public boolean predicate(String element, String argument) {
        return Validator.checkParams(element, argument) && element.startsWith(argument);
    }
}
