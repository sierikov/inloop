import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class DesktopSearch {
    private Map<String, ResourceType> types;
    private Index index;

    public DesktopSearch() {
        index = new Index();
        types = new HashMap<>();
    }

    public void registerType(String extension, ResourceType type){
        Objects.requireNonNull(extension);
        Objects.requireNonNull(type);
        types.put(extension, type);
    }

    public ResourceType getType(String extension){
        return types.get(extension);
    }

    public void unregisterType(String extension){
        Objects.requireNonNull(extension);
        types.remove(extension);
    }

    public void registerResource(Resource res){
        index.add(res);
    }

    public List processRequest(String request){
        return index.getResources(request);
    }
}
