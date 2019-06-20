package enterprise_node;

import java.util.Arrays;
import java.util.Objects;

public abstract class AbstractEnterpriseUnit implements EnterpriseNode {

    public static void notNull(Object ...args) {
        if(Arrays.stream(args).anyMatch(Objects::isNull)){
            throw new NullPointerException();
        }
    }

    public static void notEmpty(String ...args){
        if(Arrays.stream(args).anyMatch(String::isEmpty)){
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String getName() {
        return name;
    }

    private String name;

    public AbstractEnterpriseUnit(String name) {
        AbstractEnterpriseUnit.notNull(name);
        AbstractEnterpriseUnit.notEmpty(name);
        if(name.isEmpty()){
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof EnterpriseNode) {
            return this.getName().equals(((EnterpriseNode) obj).getName());
        }
        return false;
    }
}
