import java.util.Random;

public class MatrixIndex {
    private int row;
    private int column;

    MatrixIndex (int row, int column){
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    @Override
    public boolean equals(Object o){
        return false;
    }

    @Override
    public int hashCode(){
        return new Random().nextInt(100);
    }
}
