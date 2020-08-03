package sda.springbootsecurity.countries;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(controllers = {CountryController.class})
class CountryControllerTest {
    @Autowired
    MockMvc mvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    CountryService mockService;

//    @MockBean
//    CountryService mockService;
    @Test
    void shouldEditCountryWhenChangeProvided() throws Exception {
        //given
        var countryId = "3";

        var editCountry = Country.builder()
                .name("USA")
                .capital("NY")
                .currency("USD")
                .language("English")
                .population(1000).build();

        String editRequestCountryJson = mapper.writeValueAsString(editCountry);

        //when
        ResultActions result = mvc.perform(
                MockMvcRequestBuilders.put("/countries/{id}", countryId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(editRequestCountryJson));

        //then
        result.andExpect(MockMvcResultMatchers.status().isNoContent());
        Mockito.verify(mockService).putCountry(3,editCountry);
    }

}
