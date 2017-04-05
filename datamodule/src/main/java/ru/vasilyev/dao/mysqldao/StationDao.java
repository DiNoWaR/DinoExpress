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

        int stationID;

        try (SqlSession session = myBatisMysqlSessionFactory.getSqlSessionFactory().openSession()) {
            StationMysqlMapper trainMapper = session.getMapper(StationMysqlMapper.class);

            stationID = trainMapper.findStationByName(name);

        }
        return stationID;
    }

    public List<Station> getAllEntities() {

        try (SqlSession session = myBatisMysqlSessionFactory.getSqlSessionFactory().openSession()) {
            StationMysqlMapper stationMapper = session.getMapper(StationMysqlMapper.class);
            return stationMapper.getAllEntities();
        }
    }

    public void deleteAllEntities() {

    }
}
