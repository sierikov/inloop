import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class TextFileIterator implements Iterator {
    private Resource res;
    private String text = "We wish you good luck in this exam!\nWe hope you are well pre-\npared.";
    private Iterator<String> iterator;

    public TextFileIterator(Resource res) {
        Objects.requireNonNull(res);
        this.res = res;
        this.iterator = Arrays.asList(getCleanText().split(" ")).iterator();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Object next() {
        return iterator.next();
    }

    @Override
    public void remove(){
        throw new UnsupportedOperationException("Removing is not supporting");
    }

    private String getText() {
        return text;
    }

    private String getCleanText() {
        return this.getText()
                .replaceAll("-\n", "")
                .replaceAll("\n", " ")
                .replaceAll("[^A-Za-z0-9 ]", "");
    }
}
