package org.zoo.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.zoo.manager.persistence.model.Animal;
import org.zoo.manager.persistence.model.Disease;
import org.zoo.manager.persistence.service.AnimalService;

import javax.jws.WebParam;
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
        List<Disease> diseases = animalService.getAllDiseases();
        model.addAttribute("newAnimal", animal);
        model.addAttribute("diseases", diseases);
        return "add-form";
    }

    @PostMapping("/saveAnimal")
    public String saveAnimal(@ModelAttribute("newAnimal") Animal animal){
        animalService.saveAnimal(animal);
        return "redirect:/animals/list";
    }
    @GetMapping("/deleteAnimal")
    public String deleteAnimal(@RequestParam("animalId") Integer id){
        Animal animal = animalService.getAnimal(id);
        animalService.deleteAnimal(animal);
        return "redirect:/animals/list";
    }

    @GetMapping("/showFormForUpdate")
    public String updateAnimal(@RequestParam("animalId") Integer id, Model model){
        Animal animal = animalService.getAnimal(id);
        model.addAttribute("animal", animal);
        return "update-form";
    }

    @PostMapping("/updateAnimal")
    public String updateAnimal(@ModelAttribute("animal") Animal animal){
        animalService.saveAnimal(animal);
        return "redirect:/animals/list";
    }
}
