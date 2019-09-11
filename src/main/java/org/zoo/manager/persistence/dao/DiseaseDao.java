package org.zoo.manager.persistence.dao;

import org.zoo.manager.persistence.model.Animal;
import org.zoo.manager.persistence.model.Disease;

import java.util.List;

public interface DiseaseDao {

    List<Disease> getDiseases();
}
