package ru.vasilyev.dao;

import org.apache.ibatis.session.SqlSession;
import ru.vasilyev.mappers.mysqlmappers.RouteMysqlMapper;
import ru.vasilyev.model.Route;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import java.util.Collection;
import java.util.List;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class RouteDao extends AbstractDao<Route> {


    public void insertEntity(Route entity) {

    }

    public void insertCollectionOfEntity(Collection<Route> entities) {

    }

    public List<Route> getAllEntities() {
        return null;
    }

    public void deleteAllEntities() {

    }

    public int findRouteIDByRouteCode(String code) {

        int routeID;

        try (SqlSession session = mybatisSessionFactory.getSqlSessionFactory().openSession()) {
            RouteMysqlMapper routeMapper = session.getMapper(RouteMysqlMapper.class);

            routeID = routeMapper.findRouteIDByRouteCode(code);

        }
        return routeID;
    }

}
