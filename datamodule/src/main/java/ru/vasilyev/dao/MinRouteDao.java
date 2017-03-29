package ru.vasilyev.dao;


import java.util.Collection;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import ru.vasilyev.mappers.MinRouteMapper;
import ru.vasilyev.model.MinRoute;

public class MinRouteDao extends AbstractDao<MinRoute> {

    public void insertEntity(MinRoute entity) {

        SqlSession session = null;

        try {
            session = myBatisSessionFactory.getSqlSessionFactory().openSession();
            MinRouteMapper minRouteMapper = session.getMapper(MinRouteMapper.class);
            minRouteMapper.insertEntity(entity);

        } finally {
            session.close();
        }

    }

    public void insertCollectionOfEntity(Collection<MinRoute> entities) {

    }

    public MinRoute findEntityById(long id, Class<MinRoute> clazz) {
        return null;
    }

    public List<MinRoute> getAllEntities() {
        return null;
    }

    public void deleteAllEntities() {

    }
}
