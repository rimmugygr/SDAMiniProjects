package sda.springbootsecurity.countries;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepo extends JpaRepository<Country,Long> {

    List<Country> findAllByPopulationGreaterThanOrPopulationIsNull(Long population);
}
