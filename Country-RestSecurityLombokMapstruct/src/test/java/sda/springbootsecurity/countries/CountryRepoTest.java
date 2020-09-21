package sda.springbootsecurity.countries;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;

@Sql(scripts = "classpath:country-repository-test.sql")
@DataJpaTest
class CountryRepoTest {
    @Autowired
    CountryRepo countryRepo;


    @Test
    void shouldShowCountriesWithPopulationAboveGivenLimit(){
        //given
        var anyPopulationLimit = 15_000_000L;

        //when
        List<Country> result = countryRepo.findAllByPopulationGreaterThanOrPopulationIsNull(anyPopulationLimit);

        //then
        assertThat(result,notNullValue());
        assertThat(result, hasSize(2));
    }

}
