import java.awt.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class MyMatrix<T> implements Matrix<T> {
    private HashMap<Point,T> matrix;
    private ArrayList<Integer> columnList;
    private ArrayList<Integer> rowList;



    MyMatrix(){
        matrix = new HashMap<>();
        rowList = new ArrayList<>();
        columnList = new ArrayList<>();
    }

    @Override
    public int getColumnCount() {
        return  this.checkList(columnList);
    }

    @Override
    public int getRowCount() {
        return this.checkList(rowList);
    }

    private int checkList(ArrayList<Integer> l) {
        return l.isEmpty() ? 0 : Collections.max(l) + 1;
    }

    @Override
    public int getObjectCount() {
        return matrix.size();
    }

    @Override
    public int getDistinctObjectCount() {
        ArrayList<Integer> uniq = rowList.stream()
                .filter(num -> !columnList.contains(num))
                .collect(Collectors.toCollection(ArrayList::new));

        return uniq.isEmpty() ? 0 : uniq.size() + 1;
    }

    @Override
    public Iterator<T> iterator() {
        return new DepthFirstIterator();
    }

    private class DepthFirstIterator implements Iterator<T>{
        int rowIndex = 0;
        int columnIndex = 0;


        @Override
        public boolean hasNext() { return columnIndex !=  Collections.max(columnList); }

        @Override
        public T next() {
            for (;columnIndex <= Collections.max(columnList); columnIndex++){
                for (;rowIndex <= Collections.max(rowList); rowIndex++){
                    Point point = new Point(columnIndex, rowIndex);
                    if(matrix.containsKey(point)){
                        T value = matrix.get(point);
                        System.out.println(columnIndex + " " + rowIndex + " " + value);
                        rowIndex++;
                        return value;
                    }
                }
                rowIndex = 0;
            }
            throw new NoSuchElementException();

        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

    @Override
    public T get(int row, int column) {
        if( row > Collections.max(rowList) ||
                column > Collections.max(columnList) ||
                row < 0 || column < 0)
            throw new IllegalArgumentException();

        return matrix.getOrDefault(new Point(column,row), null);

    }


    @Override   // row = y , column = x
    public T put(int row, int column, T value) {
        if  (row < 0 || column < 0) throw new IllegalArgumentException();
        columnList.add(column);
        rowList.add(row);
        return matrix.put(new Point(column,row),value);
    }

    @Override
    public boolean contains(T value) { return matrix.containsValue(value); }
}

