package ro.fasttrackit.curs20.country;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.*;

public class CountryService {
    private final List<Country> countries;

    public CountryService(List<Country> countries) {
        this.countries = Optional.ofNullable(countries)
                .map(ArrayList::new)
                .orElseGet(ArrayList::new);
    }

    public List<String> countryNames() {
        return countries.stream()
                .map(Country::getName)
                .collect(toList());
    }
}
