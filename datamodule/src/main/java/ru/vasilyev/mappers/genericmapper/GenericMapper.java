package ru.vasilyev.mappers.genericmapper;


import java.util.Collection;
import java.util.List;

/**
 * Common mapper with standard C.R.U.D. methods
 */
public interface GenericMapper<T> {

    void insertEntity(T entity);

    void insertCollectionOfEntity(Collection<T> entities);

    List<T> getAllEntities();

    void deleteAllEntities();

}
