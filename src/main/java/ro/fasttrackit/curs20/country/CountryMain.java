package ro.fasttrackit.curs20.country;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

public class CountryMain {
    public static void main(String[] args) throws FileNotFoundException {
        CountryReader countryReader = new CountryReader();
        List<Country> countries = countryReader.readCountriesStream("C:\\fasttrack\\curs20\\course-code\\src\\main\\resources\\countries2.txt");

        for (Country country : countries) {
            System.out.println(country);
        }

        System.out.println();

        CountryService service = new CountryService(countries);
        System.out.println(service.countryNames());
    }
}
