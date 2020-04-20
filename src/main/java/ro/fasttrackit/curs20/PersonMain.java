package ro.fasttrackit.curs20;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class PersonMain {
    public static void main(String[] args) {
        final List<String> cities = List.of("Oradea", "Bucuresti", "Craiova", "Cluj");
        final Random random = new Random();

        var persons = IntStream.range(1, 11)
                .mapToObj(index -> new Person("Name " + index,
                        random.nextInt(80),
                        cities.get(random.nextInt(cities.size()))))
                .collect(toList());

        OptionalDouble averageAge = persons.stream()
                .mapToInt(Person::getAge)
                .average();

        System.out.println();
        System.out.println(averageAge + "\n");

        System.out.println(persons.stream()
                .collect(toMap(Person::getName, Person::getAge)) + "\n");

        System.out.println(persons.stream()
                .collect(toMap(Person::getCity, person -> List.of(person.getName()), PersonMain::union)) + "\n");

        System.out.println(persons.stream()
                .collect(toMap(
                        Person::getCity,
                        person -> List.of(person.getName()),
                        (l1, l2) -> Stream.concat(l1.stream(), l2.stream())
                                .collect(toList()))) + "\n");

        System.out.println(persons.stream()
                .collect(toMap(
                        Person::getCity,
                        person -> (double) person.getAge(),
                        (age1, age2) -> (age1 + age2) / 2)));


    }

    private static List<String> union(final List<String> l1, final List<String> l2) {
        List<String> result = new ArrayList<>(l1);
        result.addAll(l2);
        return result;
    }
}
