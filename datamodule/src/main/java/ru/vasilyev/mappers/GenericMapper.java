package ru.vasilyev.mappers;


import java.util.List;

public interface GenericMapper<T> {

    void insertEntity(T entity);

    List<T> getAll();

    void deleteAll();

}
