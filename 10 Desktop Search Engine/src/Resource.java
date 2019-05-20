

import java.util.Objects;

public class Resource {
    private String name;
    private String path;
    private ResourceType type;

    public Resource(String name, String path, ResourceType rt){
        if (name.isEmpty() || path.isEmpty())
            throw new IllegalArgumentException("Arguments cannot be empty!");
        this.name = Objects.requireNonNull(name);
        this.path = Objects.requireNonNull(path);
        this.type = Objects.requireNonNull(rt);
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public ResourceType getType() {
        return type;
    }
}
