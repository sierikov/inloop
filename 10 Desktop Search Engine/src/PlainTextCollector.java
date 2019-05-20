import java.util.*;

public class PlainTextCollector implements KeywordCollector {

    @Override
    public Set<String> getKeywords(Resource res) {
        Objects.requireNonNull(res);
        TextFileIterator iterator = new TextFileIterator(res);
        Set<String> keywords = new HashSet<>();
        iterator.forEachRemaining(keyword -> keywords.add(keyword.toString()));
        return keywords;
    }
}
