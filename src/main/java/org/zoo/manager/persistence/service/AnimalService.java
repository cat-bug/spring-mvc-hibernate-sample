package org.zoo.manager.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zoo.manager.persistence.dao.AnimalDao;
import org.zoo.manager.persistence.dao.DiseaseDao;
import org.zoo.manager.persistence.model.Animal;
import org.zoo.manager.persistence.model.Disease;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AnimalService {
    private AnimalDao animalDao;
    private DiseaseDao diseaseDao;

    @Autowired
    public AnimalService(AnimalDao animalDao, DiseaseDao diseaseDao) {
        this.animalDao = animalDao;
        this.diseaseDao = diseaseDao;
    }

    public List<Animal> getAllAnimals(){
        return animalDao.getAnimals();
    }
    public List<Disease> getAllDiseases(){
        return diseaseDao.getDiseases();
    }

    public Animal getAnimal(Integer id){
        return animalDao.getAnimal(id);
    }
    public void saveAnimal(Animal animal){
        animalDao.saveAnimal(animal);
    }
    public void deleteAnimal(Animal animal){
        animalDao.deleteAnimal(animal);
    }
}
