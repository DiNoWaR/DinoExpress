package ru.vasilyev.dao;


import ru.vasilyev.sessionfactory.MyBatisSessionFactory;

import javax.ejb.EJB;

public abstract class AbstractDao<T> implements GenericDao<T> {

    @EJB
    protected MyBatisSessionFactory myBatisSessionFactory;


}
