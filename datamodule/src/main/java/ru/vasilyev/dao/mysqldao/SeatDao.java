package ru.vasilyev.dao.mysqldao;


import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import ru.vasilyev.model.Seat;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class SeatDao extends AbstractMySqlDao<Seat> {


    public void insertEntity(Seat entity) {

    }

    public void insertCollectionOfEntity(Collection<Seat> entities) {


    }

    public List<Seat> getAllEntities() {
        return null;
    }

    public void deleteAllEntities() {

    }
}
