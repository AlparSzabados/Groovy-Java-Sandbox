package szabados.alpar.exercises;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ParsePerson {
    public static List<Person> parsePerson(String text) throws Exception {
        if (text.isEmpty()) return null;
        List<Person> people = new ArrayList<>();
        String[] split = text.split("\\s");

        for (String s : split) {
            String[] person = s.split("\\W");
            if (person.length != 4) throw new Exception("Wrong format");
            people.add(parse(person));
        }
        return people;
    }

    private static Person parse(String[] person) {
        String firstName = person[0];
        String lastName = person[1];
        LocalDate dateOfBirth = parseDate(person[2]);
        String location = person[3];
        return new Person(firstName, lastName, dateOfBirth, location);
    }

    private static LocalDate parseDate(String person) {
        LocalDate dateOfBirth = null;
        try {
            String pattern = "ddMMyyyy";
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            dateOfBirth = LocalDate.parse(person, formatter);
        } catch (Exception e) {
            System.err.println("Can't parse Date " + e.getMessage());
        }
        return dateOfBirth;
    }
}

class Person {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String location;

    Person(String firstName, String lastName, LocalDate dateOfBirth, String location) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.location = location;
    }

    @Override
    public String toString() {
        String pattern = "dd MMM yyyy";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return firstName + " " + lastName + " " + dateOfBirth.format(formatter) + " " + location;
    }
}
