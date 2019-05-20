import java.util.*;

public class DefaultCollector implements KeywordCollector {
    @Override
    public Set<String> getKeywords(Resource res) {
        Objects.requireNonNull(res);
        return new HashSet<>(Collections.singletonList(res.getName()));
    }
}
