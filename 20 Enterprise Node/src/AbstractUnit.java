package enterprise_node;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractUnit extends AbstractEnterpriseUnit {

    private List<AbstractEnterpriseUnit> childNodes;

    public List<AbstractEnterpriseUnit> getChildNodes() {
        return childNodes;
    }

    public AbstractUnit(String name) {
        super(name);
        childNodes = new ArrayList<>();
    }

    private boolean isChild(AbstractEnterpriseUnit node) {
        return this.childNodes
                .stream()
                .anyMatch(node::equals);
    }

    private boolean isLegalChild(AbstractEnterpriseUnit child) {
        if (this instanceof Holding)
            return child instanceof Company;
        if (this instanceof Company)
            return child instanceof Division;
        if (this instanceof Division)
            return child instanceof Team;
        return true;
    }

    private void verifyChild(AbstractEnterpriseUnit node) {
        if (!this.isLegalChild(node)) {
            throw new IllegalArgumentException();
        }
    }

    public boolean add(AbstractEnterpriseUnit node) {
        AbstractEnterpriseUnit.notNull(node);
        this.verifyChild(node);
        if(this.isChild(node)){
            return false;
        }
        this.childNodes.add(node);
        return true;
    }

    public boolean remove(AbstractEnterpriseUnit childNode) {
        AbstractEnterpriseUnit.notNull(childNode);
        for (int i = 0; i < this.childNodes.size(); i++) {
            if (childNode.getName().equals(this.childNodes.get(i).getName())) {
                childNodes.remove(i);
                return true;
            }
        }
        return false;
    }
}
