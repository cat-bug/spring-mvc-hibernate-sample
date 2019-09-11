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
        cr.orderBy(cb.asc(root.get("name")));
        cr.select(root);

        Query<Animal> query = getSession().createQuery(cr);
        return query.getResultList();
    }

    public void saveAnimal(Animal animal) {
        persist(animal);
    }

    public Animal getAnimal(Integer id) {
//        CriteriaBuilder cb = getSession().getCriteriaBuilder();
//        CriteriaQuery cr = cb.createQuery(Animal.class);
//        Root<Animal> root = cr.from(Animal.class);
//        cr.where(cb.equal(root.get("id"), id));
//        cr.select(root);
//
//        Query<Animal> query = getSession().createQuery(cr);
//        return query.getSingleResult();

        return getSession().get(Animal.class, id);
    }

    public void updateAnimal(Animal animal) {
        persist(animal);
    }

    public void deleteAnimal(Animal animal) {
        delete(animal);
    }
}
