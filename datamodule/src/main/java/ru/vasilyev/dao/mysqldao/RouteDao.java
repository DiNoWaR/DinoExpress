package ru.vasilyev.dao.mysqldao;

import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import org.apache.ibatis.session.SqlSession;
import ru.vasilyev.mappers.mysqlmappers.RouteMysqlMapper;
import ru.vasilyev.model.Route;

@Stateless
public class RouteDao extends AbstractMySqlDao<Route> {


    public void insertEntity(Route entity) {

    }

    public void insertCollectionOfEntity(Collection<Route> entities) {

    }

    public int findRouteIDByRouteCode(String code) {

        int routeID;

        try (SqlSession session = myBatisMysqlSessionFactory.getSqlSessionFactory().openSession()) {
            RouteMysqlMapper routeMapper = session.getMapper(RouteMysqlMapper.class);

            routeID = routeMapper.findRouteIDByRouteCode(code);

        }
        return routeID;
    }

    public List<Route> getAllEntities() {
        return null;
    }

    public void deleteAllEntities() {

    }
}
