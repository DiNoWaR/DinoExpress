package ru.vasilyev.dao;

import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import ru.vasilyev.model.Wagon;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class WagonDao extends AbstractDao<Wagon> {


    public void insertEntity(Wagon entity) {

    }

    public void insertCollectionOfEntity(Collection<Wagon> entities) {

    }

    public List<Wagon> getAllEntities() {
        return null;
    }

    public void deleteAllEntities() {

    }
}
