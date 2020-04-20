package ro.fasttrackit.curs20.country;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

import static java.util.stream.Collectors.*;

public class CountryReader {

    public List<Country> readCountries(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader(filename));
        List<Country> countries = new ArrayList<>();
        while (scanner.hasNextLine()) {
            countries.add(readCountry(scanner.nextLine()));
        }
        return countries;
    }

    public List<Country> readCountriesStream(String filename) throws FileNotFoundException {
        return new BufferedReader(new FileReader(filename))
                .lines()
                .map(this::readCountry)
                .collect(toList());
    }

    public Country readCountry(String line) {
        String[] elements = line.split("\\|");
        return new Country(
                elements[0],
                elements[1],
                Long.parseLong(elements[2]),
                Long.parseLong(elements[3]),
                elements[4],
                elements.length > 5 ? readNeighbours(elements[5]) : Collections.emptyList());
    }

    public List<String> readNeighbours(String neighbours) {
        String[] arr = neighbours.split("~");
        return new ArrayList<>(Arrays.asList(arr));
    }
}
