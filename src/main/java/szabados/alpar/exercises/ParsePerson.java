package szabados.alpar.exercises;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static szabados.alpar.exercises.ParsePerson.outputFormat;

public class ParsePerson {
    public static final DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("ddMMyyyy");
    public static final DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("dd MMM yyyy");

    public static List<Person> parsePerson(String text) {
        if (text.isEmpty()) return new ArrayList<>();
        String[] persons = text.split("\\s");
        return parse(persons);
    }

    private static List<Person> parse(String[] split) {
        return Arrays.stream(split)
                     .map(string -> string.split("\\W"))
                     .map(s -> new Person(s[0], s[1], parseDate(s[2]), s[3]))
                     .collect(Collectors.toList());
    }

    private static LocalDate parseDate(String date) {
        return LocalDate.parse(date, inputFormat);
    }
}

class Person {
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
        return String.join(" ", firstName, lastName, dateOfBirth.format(outputFormat), location);
    }
}
