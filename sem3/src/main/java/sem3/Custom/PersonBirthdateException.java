package sem3.Custom;
public class PersonBirthdateException extends PersonException{
    private final String birthdate;
    public PersonBirthdateException(String message, String birthdate) {
        super(message);
        this.birthdate = birthdate;
    }
    @Override
    public String getContext() {
        return birthdate;
    }
}