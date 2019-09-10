package org.zoo.manager.persistence.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao<T> {

    private SessionFactory sessionFactory;

    @Autowired
    public AbstractDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public void persist(T t){
        sessionFactory.getCurrentSession().persist(t);
    }

    public void delete(T t){
        sessionFactory.getCurrentSession().delete(t);
    }

    public void merge(T t){
        sessionFactory.getCurrentSession().merge(t);
    }

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }
}
