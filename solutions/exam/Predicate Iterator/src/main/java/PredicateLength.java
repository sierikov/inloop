public class PredicateLength<Type extends String> implements Predicate<Type>{

    @Override
    public boolean predicate(String element, String argument) {
        return Validator.checkParams(element, argument) && element.length() == Integer.parseInt(argument);
    }
}
