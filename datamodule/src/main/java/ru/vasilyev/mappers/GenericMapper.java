package ru.vasilyev.mappers;


import java.util.Collection;
import java.util.List;

public interface GenericMapper<T> {

    void insertEntity(T entity);

    void insertCollectionOfEntity(Collection<T> entities);

    List<T> getAllEntities();

    void deleteAllEntities();

}
