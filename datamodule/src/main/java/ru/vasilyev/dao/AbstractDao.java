package ru.vasilyev.dao;


import ru.vasilyev.mybatissessionfactory.MybatisSessionFactory;

import javax.inject.Inject;
import javax.inject.Named;


public abstract class AbstractDao<T> implements GenericDao<T> {

    @Inject
    @Named("myBatisMysqlSessionFactory")
    protected MybatisSessionFactory mybatisSessionFactory;

}
