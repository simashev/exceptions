package sem3;
import sem3.Custom.PersonException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        String inputPersonData = getPersonData();
        Person person;
        try {
            person = Person.fromString(inputPersonData);
        } catch (PersonException e) {
            System.out.println(e.getMessage() + ": " + e.getContext());
            e.printStackTrace();
            return;
        }
        try (FileWriter fileWriter = new FileWriter(person.getLastname(), true)) {
            String output = person + "\n";
            fileWriter.write(output);
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println("Ошибка при записи данных в файл: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static Scanner scanner = new Scanner(System.in);

    public static String getPersonData() {
        System.out.println("Введите данные пользователя разделенные пробелом в следующем формате\n");
        System.out.println("фамилия, имя, отчество - строки");
        System.out.println("дата рождения - строка формата dd.mm.yyyy");
        System.out.println("номер телефона - целое беззнаковое число без форматирования");
        System.out.println("пол - символ латиницей f или m.");
        return scanner.nextLine();
    }
}