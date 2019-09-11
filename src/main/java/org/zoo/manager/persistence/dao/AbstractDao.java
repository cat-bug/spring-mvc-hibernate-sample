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
        sessionFactory.getCurrentSession().saveOrUpdate(t);
    }

    public void delete(T t){
        sessionFactory.getCurrentSession().delete(t);
    }

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }
}
