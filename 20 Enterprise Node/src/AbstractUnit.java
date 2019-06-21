import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractUnit extends AbstractEnterpriseUnit {
    private List<AbstractEnterpriseUnit> childNodes;

    AbstractUnit(String name) {
        super(name);
        childNodes = new ArrayList<>();
    }

    List<AbstractEnterpriseUnit> getChildNodes() {
        return childNodes;
    }

    public boolean add(AbstractEnterpriseUnit node) {
        Objects.requireNonNull(node);
        if(this.alreadyExist(node)) return false;
        else return this.childNodes.add(node);
    }

    boolean remove(AbstractEnterpriseUnit childNode) {
        Objects.requireNonNull(childNode);
        for (AbstractEnterpriseUnit node : childNodes) {
            if (childNode.getName().equals(node.getName())) {
                return childNodes.remove(node);
            }
        }
        return false;
    }

    private boolean alreadyExist(AbstractEnterpriseUnit node) {
        return this.childNodes
                .stream()
                .anyMatch(node::equals);
    }
}
