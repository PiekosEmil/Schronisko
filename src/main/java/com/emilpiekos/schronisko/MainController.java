package com.emilpiekos.schronisko;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private AnimalRepository animalRepository;

    public MainController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @GetMapping("/")
    public String index(@RequestParam(required = false) String category, Model model) {

        if (category != null) {
            model.addAttribute("animals", animalRepository.filterByCategory(category));
        } else {
            model.addAttribute("animals", animalRepository.findAll());
        }
        return "home";
    }

    @GetMapping("/animal")
    String animal(@RequestParam String name, Model model) {
        Animal animal = animalRepository.findByName(name);
        if (animal != null) {
            model.addAttribute("name", animal.getName());
            model.addAttribute("description", animal.getDescription());
            return "animal";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/add")
    String addForm(Animal animal, Model model) {
        model.addAttribute("animal", animal);
        model.addAttribute("cat", Category.CAT);
        model.addAttribute("dog", Category.DOG);
        model.addAttribute("other", Category.OTHER);
        return "add";
    }

    @PostMapping("/add_animal")
    String add(Animal animal) {
        animalRepository.add(animal);
        return "redirect:/animal?name=" + animal.getName();
    }

    @GetMapping("/edit")
    String editAnimal(@RequestParam String name, Model model) {
        Animal animal = animalRepository.findByName(name);
        animalRepository.remove(animal);
        model.addAttribute("animal", animal);
        model.addAttribute("name", animal.getName());
        model.addAttribute("description", animal.getDescription());
        model.addAttribute("category", animal.getCategory());
        model.addAttribute("image", animal.getImage());
        return "edit";
    }

    @PostMapping("/edit_animal")
    String edit(Animal animal) {
        animalRepository.add(animal);
        return "redirect:/animal?name=" + animal.getName();
    }

}

