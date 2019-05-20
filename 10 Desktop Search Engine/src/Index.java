import java.util.*;

public class Index {
    private Map<String, List<Resource>> index;

    public Index(){
        index = new HashMap<>();
    }
    public void add(Resource res){
        Objects.requireNonNull(res);
        Set<String> keywords = res.getType().getCollector().getKeywords(res);
        keywords.forEach(keyword -> {
            if (!index.containsKey(keyword)) {
                index.put(keyword, new ArrayList<>());
            }
            if (!index.get(keyword).contains(res)) {
                index.get(keyword).add(res);
            }
        });

    }
    public List getResources(String keyword){
        Objects.requireNonNull(keyword);
        return index.getOrDefault(keyword, new ArrayList<>());
    }
}
