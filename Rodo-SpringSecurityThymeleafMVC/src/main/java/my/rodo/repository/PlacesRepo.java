package my.rodo.repository;

import my.rodo.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlacesRepo extends JpaRepository<Place,Long> {
}
