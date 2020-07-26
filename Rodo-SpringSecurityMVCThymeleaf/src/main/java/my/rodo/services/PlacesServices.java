package my.rodo.services;

import my.rodo.model.Place;
import my.rodo.repository.PlacesRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlacesServices {

    PlacesRepo placesRepo;

    public PlacesServices(PlacesRepo placesRepo) {
        this.placesRepo = placesRepo;
    }

    public List<Place> getPlacesList() {
        return placesRepo.findAll();
    }

    public void addPlaces(Place place) {
        placesRepo.save(place);
    }

    public Place getPlaces(Long id) {
        return placesRepo.getOne(id);
    }

    public void editPlaces(Place place, Long id) {
        place.setId(id);
        placesRepo.save(place);
    }

    public void deletePlaces(Long id) {
        placesRepo.deleteById(id);
    }
}
