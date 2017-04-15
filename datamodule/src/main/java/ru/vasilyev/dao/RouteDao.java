package ru.vasilyev.dao;

import org.apache.ibatis.session.SqlSession;
import ru.vasilyev.mappers.mysqlmappers.RouteMysqlMapper;
import ru.vasilyev.model.Route;
import ru.vasilyev.views.RootStationsView;
import ru.vasilyev.views.RoutesByStationsAndDateView;
import ru.vasilyev.wrappers.RoutesByStationsAndDateWrapper;

import javax.ejb.*;
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

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<RoutesByStationsAndDateView> findTrainsByStationsAndDate(RoutesByStationsAndDateWrapper wrapper) {

        List<RoutesByStationsAndDateView> routes;

        try (SqlSession session = mybatisSessionFactory.getSqlSessionFactory().openSession()) {

            RouteMysqlMapper routeMysqlMapper = session.getMapper(RouteMysqlMapper.class);

            routes = routeMysqlMapper.findRoutesByStationsAndDate(wrapper);
        }
        return routes;
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<RootStationsView> findStationsWhichRoutePasses(String routeCode) {

        List<RootStationsView> rootStationsViewList;

        try (SqlSession session = mybatisSessionFactory.getSqlSessionFactory().openSession()) {

            RouteMysqlMapper routeMysqlMapper = session.getMapper(RouteMysqlMapper.class);

            rootStationsViewList = routeMysqlMapper.findStationsWhichRoutePasses(routeCode);
        }
        return rootStationsViewList;
    }
}
