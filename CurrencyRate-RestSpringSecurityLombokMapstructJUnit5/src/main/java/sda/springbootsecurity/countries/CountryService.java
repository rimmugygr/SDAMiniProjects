package sda.springbootsecurity.countries;

import org.springframework.stereotype.Service;
import sda.springbootsecurity.commons.ResourcesNotFound;

import java.util.Collection;

@Service
public class CountryService {
    private final CountryRepo countryRepo;

    public CountryService(CountryRepo countryRepo) {
        this.countryRepo = countryRepo;
        countryRepo.save(new Country(1L,"Poland","Warsaw","Polish","PLN", 38_000_000));
        countryRepo.save(new Country(2L,"Czech Republic","Prague",  "Czech","CZK",15_000_000));
        countryRepo.save(new Country(3L,"USA","Washington","English", "USD", 320_000_000));
    }

    Collection<Country> getCountries(long population) {
        return countryRepo.findAllByPopulationGreaterThanOrPopulationIsNull(population);
    }

    public Country addCountries(Country newCountry) {
        return countryRepo.save(newCountry);
    }

    public Country getCountry(long id) {
        return countryRepo.findById(id)
                .orElseThrow(()->new ResourcesNotFound("Not found country"));
    }

    public Country putCountry(long id, Country receiveCountry) {
        Country country = getCountry(id);
        putFromSourceToTarget(receiveCountry, country);
        return country;
    }

    public Country patchCountry(long id, Country receiveCountry) {
        Country country = getCountry(id);
        patchFromSourceToTarget(receiveCountry, country);
        return country;
    }

    public void deleteCountry(long id) {
        countryRepo.deleteById(id);
    }

    private void patchFromSourceToTarget(Country source, Country target) {
        if (source.getCapital()!=null) {
            target.setCapital(source.getCapital());
        }
        if (source.getCurrency()!=null) {
            target.setCurrency(source.getCurrency());
        }
        if (source.getLanguage()!=null) {
            target.setLanguage(source.getLanguage());
        }
        if (source.getName()!=null) {
            target.setName(source.getName());
        }
        if (source.getPopulation()!=0) {
            target.setPopulation(source.getPopulation());
        }
    }

    private void putFromSourceToTarget(Country source, Country target) {
        target.setCapital(source.getCapital());
        target.setCurrency(source.getCurrency());
        target.setLanguage(source.getLanguage());
        target.setName(source.getName());
        target.setPopulation(source.getPopulation());
    }

}

