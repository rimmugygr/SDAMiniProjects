package sda.springbootsecurity.countries;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Collection;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/countries")
public class CountryController {
    CountryService countryService;
    CountryMapper mapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Collection<CountryDto>> getCountries(
            @PathParam("minPop") Long minPop){
        Collection<CountryDto> countries = countryService.getCountries(minPop).stream()
                .map(mapper::map)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(countries);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> postCountries(@RequestBody CountryDto countryDto){
        countryService.addCountries(mapper.map(countryDto));
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CountryDto getCountry(@PathVariable long id){
        return mapper.map(countryService.getCountry(id));
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void patchCountry(@RequestBody CountryDto countryDto,
                             @PathVariable long id){
        countryService.patchCountry(id, mapper.map(countryDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> putCountry(@RequestBody CountryDto countryDto,
                                           @PathVariable long id){
        countryService.putCountry(id, mapper.map(countryDto));
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCountry(@PathVariable long id){
        countryService.deleteCountry(id);
    }
}
