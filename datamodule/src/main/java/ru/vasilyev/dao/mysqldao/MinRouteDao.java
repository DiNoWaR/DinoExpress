package ru.vasilyev.dao.mysqldao;


import java.util.Collection;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import ru.vasilyev.mappers.mysqlmappers.MinRouteMysqlMapper;
import ru.vasilyev.model.MinRoute;

import javax.ejb.Stateless;

@Stateless
public class MinRouteDao extends AbstractMySqlDao<MinRoute> {

    public void insertEntity(MinRoute entity) {

        try (SqlSession session = myBatisMysqlSessionFactory.getSqlSessionFactory().openSession()) {
            MinRouteMysqlMapper minRouteMapper = session.getMapper(MinRouteMysqlMapper.class);
            minRouteMapper.insertEntity(entity);

        }

    }

    public void insertCollectionOfEntity(Collection<MinRoute> entities) {

    }

    public List<MinRoute> getAllEntities() {
        return null;
    }

    public void deleteAllEntities() {

    }
}
