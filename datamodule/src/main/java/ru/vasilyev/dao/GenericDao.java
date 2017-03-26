package ru.vasilyev.dao;


import java.util.Collection;
import java.util.List;

public interface GenericDao<T> {

    void insertEntity(T entity);

    void insertCollectionOfEntity(Collection<T> entities);

    T findEntityById(long id, Class<T> clazz);

    List<T> getAllEntities();

    void deleteAllEntities();

}
