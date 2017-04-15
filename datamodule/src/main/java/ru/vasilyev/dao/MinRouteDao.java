package ru.vasilyev.dao;


import java.util.Collection;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import ru.vasilyev.mappers.mysqlmappers.MinRouteMysqlMapper;
import ru.vasilyev.model.MinRoute;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class MinRouteDao extends AbstractDao<MinRoute> {

    public void insertEntity(MinRoute entity) {

        try (SqlSession session = mybatisSessionFactory.getSqlSessionFactory().openSession()) {
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
