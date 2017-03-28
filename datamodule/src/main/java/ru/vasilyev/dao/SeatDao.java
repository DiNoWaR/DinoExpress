package ru.vasilyev.dao;


import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import ru.vasilyev.model.Seat;

@Stateless
public class SeatDao extends AbstractDao<Seat> {


    public void insertEntity(Seat entity) {

    }

    public void insertCollectionOfEntity(Collection<Seat> entities) {


    }

    public Seat findEntityById(long id, Class<Seat> clazz) {
        return null;
    }

    public List<Seat> getAllEntities() {
        return null;
    }

    public void deleteAllEntities() {

    }
}
