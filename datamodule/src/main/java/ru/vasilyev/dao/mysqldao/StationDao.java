package ru.vasilyev.dao.mysqldao;


import org.apache.ibatis.session.SqlSession;
import ru.vasilyev.model.Station;
import ru.vasilyev.mappers.mysqlmappers.StationMysqlMapper;

import javax.ejb.Stateless;
import java.util.Collection;
import java.util.List;

@Stateless
public class StationDao extends AbstractMySqlDao<Station> {


    public void insertEntity(Station entity) {

    }

    public void insertCollectionOfEntity(Collection<Station> entities) {

    }

    public int findStationByName(String name) {

        SqlSession session = null;

        int stationID;

        try {
            session = myBatisMysqlSessionFactory.getSqlSessionFactory().openSession();
            StationMysqlMapper trainMapper = session.getMapper(StationMysqlMapper.class);

            stationID = trainMapper.findStationByName(name);

        } finally {
            session.close();
        }
        return stationID;
    }

    public List<Station> getAllEntities() {
        SqlSession session = null;

        try {
            session = myBatisMysqlSessionFactory.getSqlSessionFactory().openSession();
            StationMysqlMapper stationMapper = session.getMapper(StationMysqlMapper.class);
            return stationMapper.getAllEntities();
        } finally {
            session.close();
        }
    }

    public void deleteAllEntities() {

    }
}
