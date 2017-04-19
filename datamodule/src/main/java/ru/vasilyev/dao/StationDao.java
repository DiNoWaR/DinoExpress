package ru.vasilyev.dao;


import org.apache.ibatis.session.SqlSession;
import ru.vasilyev.mappers.StationMapper;
import ru.vasilyev.model.Station;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import java.util.Collection;
import java.util.List;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class StationDao extends AbstractDao<Station> {


    public void insertEntity(Station station) {

    }

    public void insertCollectionOfEntity(Collection<Station> stations) {

    }

    public List<Station> getAllEntities() {

        try (SqlSession session = mybatisSessionFactory.getSqlSessionFactory().openSession()) {
            StationMapper stationMapper = session.getMapper(StationMapper.class);
            return stationMapper.getAllEntities();
        }
    }

    public void deleteAllEntities() {

    }

    public int findStationIdByName(String name) {

        int stationID;

        try (SqlSession session = mybatisSessionFactory.getSqlSessionFactory().openSession()) {
            StationMapper trainMapper = session.getMapper(StationMapper.class);

            stationID = trainMapper.findStationIdByName(name);
        }
        return stationID;
    }

}
