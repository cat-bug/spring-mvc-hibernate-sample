package org.zoo.manager.persistence.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.zoo.manager.persistence.model.Disease;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class DiseaseDaoImpl extends AbstractDao<Disease> implements DiseaseDao {
    public DiseaseDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<Disease> getDiseases() {
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery cr = cb.createQuery(Disease.class);
        Root<Disease> root = cr.from(Disease.class);
        cr.orderBy(cb.asc(root.get("name")));
        cr.select(root);

        Query<Disease> query = getSession().createQuery(cr);
        return query.getResultList();
    }

}
