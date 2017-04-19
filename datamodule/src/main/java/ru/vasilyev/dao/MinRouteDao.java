package ru.vasilyev.dao;


import org.apache.ibatis.session.SqlSession;
import ru.vasilyev.mappers.MinRouteMapper;
import ru.vasilyev.model.MinRoute;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import java.util.Collection;
import java.util.List;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class MinRouteDao extends AbstractDao<MinRoute> {

    public void insertEntity(MinRoute minRoute) {

        try (SqlSession session = mybatisSessionFactory.getSqlSessionFactory().openSession()) {
            MinRouteMapper minRouteMapper = session.getMapper(MinRouteMapper.class);
            minRouteMapper.insertEntity(minRoute);
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
