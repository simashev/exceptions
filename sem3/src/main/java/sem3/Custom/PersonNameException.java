package sem3.Custom;

public class PersonNameException extends PersonException {
    private final String name;

    public PersonNameException(String message, String name) {
        super(message);
        this.name = name;
    }

    @Override
    public String getContext() {
        return name;
    }
}