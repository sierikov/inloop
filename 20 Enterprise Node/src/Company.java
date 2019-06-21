import java.util.Objects;

public class Company extends AbstractUnit {
    public Company(String name) {
        super(name);
    }

    @Override
    public boolean add(AbstractEnterpriseUnit node){
        Objects.requireNonNull(node);
        if (node instanceof Division){
            return super.add(node);
        }
        else throw new IllegalArgumentException();
    }
}
