package sem3.Custom;

public class PersonGenderException extends PersonException{
    private final String gender;
    public PersonGenderException(String message, String gender) {
        super(message);
        this.gender = gender;
    }
    @Override
    public String getContext() {
        return gender;
    }
}