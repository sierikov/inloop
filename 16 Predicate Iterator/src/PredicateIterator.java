import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class PredicateIterator<Type> implements Iterator {

    private ListIterator<Type> iterator;
    private Predicate<Type> predicate;
    private Type argument;

    public PredicateIterator(Iterator<Type> iterator, Predicate<Type> predicate, Type argument) {
        this.iterator = (ListIterator<Type>) iterator;
        this.predicate = predicate;
        this.argument = argument;
    }

    @Override
    public boolean hasNext() {
        while(iterator.hasNext()){
            if (predicate.predicate(iterator.next(), argument)) {
                iterator.previous();
                return true;
            }
        }
        return false;

    }

    @Override
    public Type next(){
        Type temp;

        while (iterator.hasNext()){
            temp = iterator.next();
            if(predicate.predicate(temp,argument)) return temp;
        }

        throw new NoSuchElementException();

    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
