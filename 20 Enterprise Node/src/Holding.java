import java.util.Objects;

public class Holding extends AbstractUnit {

    public Holding(String name) {
        super(name);
    }

    @Override
    public boolean add(AbstractEnterpriseUnit node){
        Objects.requireNonNull(node);
        if (node instanceof Company){
            return super.add(node);
        }
        else throw new IllegalArgumentException();
    }



}
