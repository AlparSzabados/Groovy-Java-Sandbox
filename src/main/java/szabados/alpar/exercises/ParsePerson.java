package szabados.alpar.exercises;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.*;

public class ParsePerson {
    private static final DateTimeFormatter INPUT_FORMATTER = DateTimeFormatter.ofPattern("ddMMyyyy");

    public static List<Person> parsePerson(String text) {
        if (text.isEmpty()) return new ArrayList<>();
        return parse(text.split("\\s"));
    }

    private static List<Person> parse(String[] split) {
        return Arrays.stream(split)
                     .map(person -> person.split("\\W"))
                     .map(personInfo -> new Person(personInfo[0], personInfo[1], parseDate(personInfo[2]), personInfo[3]))
                     .collect(toList());
    }

    private static LocalDate parseDate(String date) {
        return LocalDate.parse(date, INPUT_FORMATTER);
    }
}

class Person {
    private static final DateTimeFormatter OUTPUT_FORMATTER = DateTimeFormatter.ofPattern("dd MMM yyyy");

    private String firstName, lastName;
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
        return String.join(" ", firstName, lastName, dateOfBirth.format(OUTPUT_FORMATTER), location);
    }
}
