

import java.util.Objects;

public class ResourceType {
    private String description;
    private KeywordCollector collector;

    public ResourceType(String desc, KeywordCollector collector){
        if(desc.isEmpty()) throw new IllegalArgumentException("Description cannot be emprty!");
        this.collector = Objects.requireNonNull(collector);
        this.description = Objects.requireNonNull(desc);
    }

    public String getDescription() {
        return this.description;
    }

    public KeywordCollector getCollector() {
        return this.collector;
    }
}
