package ro.fasttrackit.curs20.country;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CountryServiceTest {

    @Test
    @DisplayName("the country names are displayed correctly")
    void countryNames() {
        final CountryService service = new CountryService(List.of(
                new Country("Romania", "Bucharest", 19_000_000,
                        696969, "Europe", List.of("BGR", "HUN", "MDA", "SRB", "UKR")),
                new Country("Moldova", "Chisinau", 6_000_000,
                        80085, "Europe", List.of())
        ));

        List<String> result = service.countryNames();

        assertThat(result).containsExactly("Romania", "Moldova");

        assertThat(result)
                .extracting("length")
                .containsExactlyInAnyOrder(7, 7);
    }

}