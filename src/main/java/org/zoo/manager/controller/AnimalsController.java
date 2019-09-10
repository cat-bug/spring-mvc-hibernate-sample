package org.zoo.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zoo.manager.persistence.model.Animal;
import org.zoo.manager.persistence.service.AnimalService;

import java.util.List;

@Controller
@RequestMapping("/animals")
public class AnimalsController {

    private AnimalService animalService;

    @Autowired
    public AnimalsController(AnimalService service) {
        this.animalService = service;
    }

    @GetMapping("/list")
    public String getAnimalList(Model model) {
        List<Animal> animals = animalService.getAllAnimals();

        model.addAttribute("animals", animals);

        return "animals-list";
    }

    @GetMapping("/showFormForAdd")
    public String addAnimalForm(Model model){
        Animal animal = new Animal();
        model.addAttribute("newAnimal", animal);
        return "add-form";
    }

    @PostMapping("/saveAnimal")
    public String saveAnimal(@ModelAttribute("newAnimal") Animal animal){
        animalService.saveAnimal(animal);
        return "redirect:/animals/list";
    }
}
