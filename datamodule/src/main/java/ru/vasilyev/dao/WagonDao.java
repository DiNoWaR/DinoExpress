package ru.vasilyev.dao;

import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import ru.vasilyev.model.Wagon;

@Stateless
public class WagonDao extends AbstractDao<Wagon> {

    public void insertEntity(Wagon entity) {

    }

    public void insertCollectionOfEntity(Collection<Wagon> entities) {

    }

    public Wagon findEntityById(long id, Class<Wagon> clazz) {
        return null;
    }

    public List<Wagon> getAllEntities() {
        return null;
    }

    public void deleteAllEntities() {

    }
}
