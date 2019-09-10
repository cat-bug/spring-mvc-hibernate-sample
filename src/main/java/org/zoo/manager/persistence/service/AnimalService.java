package org.zoo.manager.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zoo.manager.persistence.dao.AnimalDao;
import org.zoo.manager.persistence.model.Animal;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AnimalService {
    private AnimalDao animalDao;

    @Autowired
    public AnimalService(AnimalDao dao) {
        this.animalDao = dao;
    }

    public List<Animal> getAllAnimals(){
        return animalDao.getAnimals();
    }
    public void saveAnimal(Animal animal){
        animalDao.saveAnimal(animal);
    }
}
