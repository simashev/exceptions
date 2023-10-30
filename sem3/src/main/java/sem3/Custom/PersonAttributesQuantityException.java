package sem3.Custom;

public class PersonAttributesQuantityException extends PersonException{

    private final int attributesQuantity;

    public PersonAttributesQuantityException(String message, int attributesQuantity) {
        super(message);
        this.attributesQuantity = attributesQuantity;
    }

    @Override
    public String getContext() {
        return String.format("%d", attributesQuantity);
    }
}
