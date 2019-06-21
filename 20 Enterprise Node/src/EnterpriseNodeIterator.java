import java.util.Iterator;

public interface EnterpriseNodeIterator<T extends EnterpriseNode> extends Iterator<T> {
    @Override
    boolean hasNext();

    @Override
    T next();
}
