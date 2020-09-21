package sda.springbootsecurity.countries;

import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@Import({CountryService.class})
@ExtendWith(SpringExtension.class)
class CountryServiceTest {
    @MockBean
    CountryRepo countryRepo;

    @Autowired
    CountryService service;

    @Test
    void shouldGetCountryFromRepositoryById() {
        //given
        var anyCountryId = 1L;
        var expectedCountry = Country.builder()
                .id(1L)
                .build();

        Mockito.when(countryRepo.findById(anyCountryId))
                .thenReturn(Optional.of(expectedCountry));

        //when
        var resultCountry = service.getCountry(anyCountryId);

        //then
        MatcherAssert.assertThat(resultCountry, Matchers.notNullValue());
        MatcherAssert.assertThat(resultCountry.getId(), Matchers.is(anyCountryId));
    }


}
