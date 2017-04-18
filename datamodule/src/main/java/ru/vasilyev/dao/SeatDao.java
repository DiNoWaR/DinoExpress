package ru.vasilyev.dao;


import ru.vasilyev.model.Seat;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import java.util.Collection;
import java.util.List;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class SeatDao extends AbstractDao<Seat> {


    public void insertEntity(Seat seat) {

    }

    public void insertCollectionOfEntity(Collection<Seat> seats) {


    }

    public List<Seat> getAllEntities() {
        return null;
    }

    public void deleteAllEntities() {

    }
}
