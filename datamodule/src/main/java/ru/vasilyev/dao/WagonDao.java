package ru.vasilyev.dao;

import ru.vasilyev.model.Wagon;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import java.util.Collection;
import java.util.List;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class WagonDao extends AbstractDao<Wagon> {


    public void insertEntity(Wagon wagon) {

    }

    public void insertCollectionOfEntity(Collection<Wagon> wagons) {

    }

    public List<Wagon> getAllEntities() {
        return null;
    }

    public void deleteAllEntities() {

    }
}
