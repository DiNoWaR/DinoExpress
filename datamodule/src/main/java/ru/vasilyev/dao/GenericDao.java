package ru.vasilyev.dao;


import java.util.Collection;
import java.util.List;

/**
 * Common dao interface with standard C.R.U.D. methods
 */
public interface GenericDao<T> {

    void insertEntity(T entity);

    void insertCollectionOfEntity(Collection<T> entities);

    List<T> getAllEntities();

    void deleteAllEntities();

}
