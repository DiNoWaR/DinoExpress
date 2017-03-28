package ru.vasilyev.dao;


import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import ru.vasilyev.model.Train;

@Stateless
public class TrainDao extends AbstractDao<Train> {


    public void insertEntity(Train entity) {

    }

    public void insertCollectionOfEntity(Collection<Train> entities) {

    }

    public Train findEntityById(long id, Class<Train> clazz) {
        return null;
    }

    public List<Train> getAllEntities() {
        return null;
    }

    public void deleteAllEntities() {

    }
}
