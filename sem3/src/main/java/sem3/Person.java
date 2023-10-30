package sem3;
import sem3.Custom.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
public class Person {
    private String name;
    private String lastname;
    private String parentName;
    private String birthdate;
    private String phoneNumber;
    private String gender;
    private static final int numberOfAttributes = 6;

    public Person() {

    }
    public Person(String name, String lastname, String parentName, String birthdate, String phoneNumber, String gender) {
        this.name = name;
        this.lastname = lastname;
        this.parentName = parentName;
        this.birthdate = birthdate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public static Person fromString(String data) throws PersonException {
        Person person = new Person();
        String[] parsedData = person.parseData(data);
        person.lastname = parsedData[0];
        person.name = parsedData[1];
        person.parentName = parsedData[2];
        person.birthdate = parsedData[3];
        person.phoneNumber = parsedData[4];
        person.gender = parsedData[5];
        return person;
    }

    private String[] parseData(String data) throws PersonException{
        String[] splitData = data.split(" ");
        validateAttributesQuantity(splitData);
        validateLastname(splitData[0].toLowerCase());
        validateName(splitData[1].toLowerCase());
        validateParentName(splitData[2].toLowerCase());
        validateBirthdate(splitData[3]);
        validatePhoneNumber(splitData[4]);
        validateGender(splitData[5]);
        return splitData;
    }

    private void validateAttributesQuantity(String[] attributes) throws PersonAttributesQuantityException {
        if (attributes.length != numberOfAttributes) {
            throw new PersonAttributesQuantityException("Введено неверное количество атрибутов", attributes.length);
        }
    }

    private void validateLastname(String name) throws PersonNameException {
        String regex = "[a-zа-яё]{1,50}";
        if (!name.matches(regex)) {
            throw new PersonNameException("Введена неверная фамилия", name);
        }
    }
    private void validateName(String name) throws PersonNameException {
        String regex = "[a-zа-яё]{1,50}";
        if (!name.matches(regex)) {
            throw new PersonNameException("Введено неверное имя", name);
        }
    }
    private void validateParentName(String name) throws PersonNameException {
        String regex = "[a-zа-яё]{1,50}";
        if (!name.matches(regex)) {
            throw new PersonNameException("Введено неверное отчество", name);
        }
    }

    private void validateBirthdate(String birthdate) throws PersonBirthdateException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.uuuu");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(birthdate);
        } catch (ParseException e) {
            throw new PersonBirthdateException("Дата введена в неверном формате", birthdate);
        }
    }
    private void validatePhoneNumber(String phoneNumber) throws PersonPhoneNumberException {
        String regex = "\\d{11}";
        if (!phoneNumber.matches(regex)) {
            throw new PersonPhoneNumberException("Введен неверный номер телефона", phoneNumber);
        }
    }
    private void validateGender(String gender) throws PersonGenderException {
        String regex = "f|m";
        if (!gender.matches(regex)) {
            throw new PersonGenderException("Введен неверный пол", gender);
        }
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getParentName() {
        return parentName;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s %s",
                getLastname(),
                getName(),
                getParentName(),
                getBirthdate(),
                getPhoneNumber(),
                getGender());
    }
}
