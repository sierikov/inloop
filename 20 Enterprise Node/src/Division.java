import java.util.Objects;

public class Division extends AbstractUnit {
    public Division(String name) {
        super(name);
    }

    @Override
    public boolean add(AbstractEnterpriseUnit node){
        Objects.requireNonNull(node);
        if (node instanceof Team){
            return super.add(node);
        }
        else throw new IllegalArgumentException();
    }
}
