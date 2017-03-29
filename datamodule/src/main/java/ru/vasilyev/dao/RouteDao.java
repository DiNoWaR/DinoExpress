package ru.vasilyev.dao;

import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import org.apache.ibatis.session.SqlSession;
import ru.vasilyev.mappers.RouteMapper;
import ru.vasilyev.mappers.TrainMapper;
import ru.vasilyev.model.Route;

@Stateless
public class RouteDao extends AbstractDao<Route> {


    public void insertEntity(Route entity) {

    }

    public void insertCollectionOfEntity(Collection<Route> entities) {

    }

    public int findRouteByRouteCode(String code) {

        SqlSession session = null;

        int routeID;

        try {
            session = myBatisSessionFactory.getSqlSessionFactory().openSession();
            RouteMapper routeMapper = session.getMapper(RouteMapper.class);

            routeID = routeMapper.findRouteByRouteCode(code);

        } finally {
            session.close();
        }
        return routeID;
    }

    public Route findEntityById(long id, Class<Route> clazz) {
        return null;
    }

    public List<Route> getAllEntities() {
        return null;
    }

    public void deleteAllEntities() {

    }
}
