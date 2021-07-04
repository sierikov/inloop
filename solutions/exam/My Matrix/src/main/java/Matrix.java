import java.util.Iterator;

public interface Matrix <T>{
    int getRowCount();
    int getColumnCount();
    int getObjectCount();
    int getDistinctObjectCount();
    Iterator<T> iterator();
    T get(int row, int column);
    T put(int row, int column, T value);
    boolean contains(T value);
}
