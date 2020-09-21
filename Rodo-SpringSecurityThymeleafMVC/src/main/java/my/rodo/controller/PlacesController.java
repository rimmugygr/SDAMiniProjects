package my.rodo.controller;

import my.rodo.model.Place;
import my.rodo.model.Zabezpieczenia;
import my.rodo.services.PlacesServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/place")
public class PlacesController {
    PlacesServices placesServices;

    public PlacesController(PlacesServices placesServices) {
        this.placesServices = placesServices;
    }

    @GetMapping
    public String getPlaces(Model model){
        System.out.println(Arrays.toString(Arrays.stream(Zabezpieczenia.values()).map(Enum::name).toArray()));
        model.addAttribute("places", placesServices.getPlacesList());
        model.addAttribute("zabezpieczenia", Arrays.toString(Arrays.stream(Zabezpieczenia.values()).map(Enum::name).toArray()));

        return "places";
    }

    @GetMapping("/add")
    public String addPlaces(Model model){

        model.addAttribute("zabezpieczenia", Zabezpieczenia.values());
        return "placesadd";
    }

    @PostMapping("/add")
    public RedirectView postPlaces(@ModelAttribute Place place){
        placesServices.addPlaces(place);
        return new RedirectView("/place");
    }

    @GetMapping("/{id}/edit")
    public String editPlaces(@PathVariable String id, Model model){

        model.addAttribute("place", placesServices.getPlaces(Long.parseLong(id)));
        model.addAttribute("zabez", Arrays.toString(Arrays.stream(Zabezpieczenia.values()).map(Enum::name).toArray()));
        System.out.println(Arrays.toString(Arrays.stream(Zabezpieczenia.values()).map(Enum::name).toArray()));
        System.out.println(model.getAttribute("zabez"));
        return "placesedit";
    }

    @PostMapping("/{id}/edit")
    public RedirectView postEditPlaces(@PathVariable String id, @ModelAttribute Place place){
        placesServices.editPlaces(place,Long.parseLong(id));
        return new RedirectView("/place");
    }

    @GetMapping("/{id}/delete")
    public RedirectView deletePlaces(@PathVariable String id){
        placesServices.deletePlaces(Long.parseLong(id));
        return new RedirectView("/place");
    }

}
