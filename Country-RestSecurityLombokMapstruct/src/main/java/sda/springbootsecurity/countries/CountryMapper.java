package sda.springbootsecurity.countries;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    CountryDto map(Country country);
    Country map(CountryDto countryDto);
}
