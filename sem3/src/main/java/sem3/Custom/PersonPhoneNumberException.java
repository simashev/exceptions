package sem3.Custom;
public class PersonPhoneNumberException extends PersonException{

    private final String phoneNumber;

    public PersonPhoneNumberException(String message, String phoneNumber) {
        super(message);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String getContext() {
        return phoneNumber;
    }
}