import java.util.Objects;

public class Factory {
    private ReceivingStock receivingStock;
    private Purchasing purchasing;

    public Factory(Purchasing purchasing, ReceivingStock receivingStock){
        this.purchasing = Objects.requireNonNull(purchasing);
        this.receivingStock = Objects.requireNonNull(receivingStock);
    }

    public ReceivingStock getReceivingStock() {
        return receivingStock;
    }

    public Purchasing getPurchasing() {
        return purchasing;
    }

    public static Part createPart(PartType partType, String id, String name){
        Validator.checkParam(id, name);
        switch (partType){
            case RESOURCE: return new Resource(id, name);
            case COMPONENTS: return new Components(id, name);
            case SINGLE_COMPONENT: return new SingleComponent(id, name);
            default: return null;
        }
    }
}

