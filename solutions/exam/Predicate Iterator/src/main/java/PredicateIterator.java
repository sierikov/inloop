import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;

public class PredicateIterator<T> implements Iterator<T> {

    private final Iterator<T> iterator;
    private final Predicate<T> predicate;
    private Optional<T> store;
    private boolean tested = false;

    public PredicateIterator(Iterator<T> iterator, Predicate<T> predicate) {
        this.iterator = iterator;
        this.predicate = predicate;
        this.store = Optional.empty();
    }

    private void findNext(){
        T tmp;
        while (iterator.hasNext()) {
            tmp = iterator.next();
            if (predicate.test(tmp)) {
                tested = true;
                this.store = Optional.of(tmp);
                return;
            }
        }
        this.store = Optional.empty();
    }

    @Override
    public boolean hasNext() {
        if (this.iterator == null) throw new NoSuchElementException();
        this.findNext();
        return this.store.isPresent();
    }

    @Override
    public T next() {
        if (!tested) {
            this.findNext();
        }
        if (this.store.isPresent()){
            tested = false;
            return this.store.get();
        }
        throw new NoSuchElementException();
    }


    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
