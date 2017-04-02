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

        SqlSession session = null;

        int routeID;

        try {
            session = myBatisMysqlSessionFactory.getSqlSessionFactory().openSession();
            RouteMysqlMapper routeMapper = session.getMapper(RouteMysqlMapper.class);

            routeID = routeMapper.findRouteIDByRouteCode(code);

        } finally {
            session.close();
        }
        return routeID;
    }

    public List<Route> getAllEntities() {
        return null;
    }

    public void deleteAllEntities() {

    }
}
