package ru.vasilyev.dao.mysqldao;


import ru.vasilyev.dao.genericdao.GenericDao;
import ru.vasilyev.mybatissessionfactory.genericmybatissessionfactory.GenericMybatisSessionFactory;

import javax.inject.Inject;
import javax.inject.Named;


public abstract class AbstractMySqlDao<T> implements GenericDao<T> {

    @Inject
    @Named("myBatisMysqlSessionFactory")
    protected GenericMybatisSessionFactory myBatisMysqlSessionFactory;

}
