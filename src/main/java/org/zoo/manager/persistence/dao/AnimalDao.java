package org.zoo.manager.persistence.dao;

import org.zoo.manager.persistence.model.Animal;

import java.util.List;
public interface AnimalDao {

    List<Animal> getAnimals();
    void saveAnimal(Animal animal);
    Animal getAnimal(Integer id);
    void deleteAnimal(Animal animal);
}
