package sda.people.phone;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/home")
public class HomeController {
    private DBService service;

    public HomeController(DBService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("peoples", service.getAllPeople());
        model.addAttribute("phones", service.getAllPhone());
        return "home";
    }

    @PostMapping("/addperson*")
    public String addperson(
            @RequestParam(name = "id") int id,
            @RequestParam(name = "first_name") String first_name,
            @RequestParam(name = "second_name") String second_name,
            @RequestParam(name = "age") String age,
            @RequestParam(name = "gender") String gender, Model model){
        String result = service.addPerson(id,first_name,second_name,age,gender);
        if(result==null) return "redirect:/home/";
        else {
            model.addAttribute("error", result);
            return "error_page";
        }
    }

    @PostMapping("/deleteperson*")
    public String deleteperson(
            @RequestParam(name = "id") int id, Model model){
        String result = service.deletePerson(id);
        if(result==null) return "redirect:/home/";
        else {
            model.addAttribute("error", result);
            return "error_page";
        }
    }

    @PostMapping("/addphone*")
    public String addnumber(
            @RequestParam(name = "id") int id,
            @RequestParam(name = "number") String number,
            @RequestParam(name = "person_id") int person_id, Model model){
        String result = service.addPhone(id,number,person_id);
        if(result==null) return "redirect:/home/";
        else {
            model.addAttribute("error", result);
            return "error_page";
        }
    }

    @PostMapping("/deletephone*")
    public String deletenumber(
            @RequestParam(name = "id") int id, Model model){
        String result = service.deletePhone(id);
        if(result==null) return "redirect:/home/";
        else {
            model.addAttribute("error", result);
            return "error_page";
        }
    }


    @PostMapping("/editperson*")
    public String editperson(
            @RequestParam(name = "id") int id, Model model){
        model.addAttribute("peoples", service.getAllPeople());
        model.addAttribute("phones", service.getAllPhone());
        model.addAttribute("person", service.getAllPeople().get(id));
        return "home";
    }

    @PostMapping("/updateperson*")
    public String updateperson(
            @RequestParam(name = "id") int id,
            @RequestParam(name = "first_name") String first_name,
            @RequestParam(name = "second_name") String second_name,
            @RequestParam(name = "age") String age,
            @RequestParam(name = "gender") String gender, Model model){
        String result = service.updatePerson(id,first_name,second_name,age,gender);
        if(result==null) return "redirect:/home/";
        else {
            model.addAttribute("error", result);
            return "error_page";
        }
    }

    @PostMapping("/editphone*")
    public String editphone(
            @RequestParam(name = "id") int id, Model model){
        model.addAttribute("peoples", service.getAllPeople());
        model.addAttribute("phones", service.getAllPhone());
        model.addAttribute("phone", service.getAllPhone().get(id));
        return "home";
    }

    @PostMapping("/updatephone*")
    public String updatephone(
            @RequestParam(name = "id") int id,
            @RequestParam(name = "number") String number,
            @RequestParam(name = "person_id") int person_id, Model model){
        String result = service.updatePhone(id,number,person_id);
        if(result==null) return "redirect:/home/";
        else {
            model.addAttribute("error", result);
            return "error_page";
        }
    }
}
