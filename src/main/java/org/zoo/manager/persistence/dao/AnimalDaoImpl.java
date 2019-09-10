package org.zoo.manager.persistence.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.zoo.manager.persistence.model.Animal;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class AnimalDaoImpl extends AbstractDao<Animal> implements AnimalDao {
    public AnimalDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<Animal> getAnimals() {
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery cr = cb.createQuery(Animal.class);
        Root<Animal> root = cr.from(Animal.class);
        cr.select(root);

        Query<Animal> query = getSession().createQuery(cr);
        return query.getResultList();
    }

    public void saveAnimal(Animal animal) {
        persist(animal);
    }
}
