import java.util.*;

abstract class AbstractUnit extends AbstractEnterpriseUnit {
    /// https://github.com/Jonny80/SWT/blob/9d93357de2/stable/EnterpriseNode/src/AbstractUnit.java
    private List<AbstractEnterpriseUnit> childNodes;

    public AbstractUnit(String name) {

        super(name);
        if (name.isEmpty()){
            throw new IllegalArgumentException();
        }
        childNodes = new LinkedList<>();
    }

    public boolean add(AbstractEnterpriseUnit childnode){
        if (childnode == null){
            throw new NullPointerException();
        }
        if (childNodes.contains(childnode)){
            return false;
        }
        childNodes.add(childnode);
        return true;
    }
    public boolean remove(AbstractEnterpriseUnit childnode){
        if (childnode == null){
            throw new NullPointerException();
        }
        if (!childNodes.contains(childnode)){
            return false;
        }
        childNodes.remove(childnode);
        return true;
    }

    public List<AbstractEnterpriseUnit> getChildNodes() {
        return childNodes;
    }
}
