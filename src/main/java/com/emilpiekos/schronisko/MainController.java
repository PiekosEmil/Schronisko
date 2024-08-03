package com.emilpiekos.schronisko;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private AnimalRepository animalRepository;

    public MainController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("animals", animalRepository.findAll());
        return "home";
    }

    @GetMapping("/animal")
    String zwierzak(@RequestParam String name, Model model) {
        Animal animal = animalRepository.findByName(name);

        if (animal != null) {
            model.addAttribute("name", animal.getName());
            model.addAttribute("description", animal.getDescription());
            return "animal";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/filter")
    String filter(@RequestParam String category, Model model) {
        model.addAttribute("animals", animalRepository.filterByCategory(category));
        model.addAttribute("category", category);
        return "filter";
    }
}

