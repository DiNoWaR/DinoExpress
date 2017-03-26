package ru.vasilyev.dao;


import org.apache.ibatis.session.SqlSession;
import ru.vasilyev.domain.Station;
import ru.vasilyev.mappers.StationMapper;

import javax.ejb.Stateless;
import java.util.Collection;
import java.util.List;

@Stateless
public class StationDao extends AbstractDao<Station> {


    public void insertEntity(Station entity) {

    }

    public void insertCollectionOfEntity(Collection<Station> entities) {

    }

    public Station findEntityById(long id, Class<Station> clazz) {
        return null;
    }

    public List<Station> getAllEntities() {
        SqlSession session = null;

        try {
            session = myBatisSessionFactory.getSqlSessionFactory().openSession();
            StationMapper stationMapper = session.getMapper(StationMapper.class);
            return stationMapper.getAllEntities();
        } finally {
            session.close();
        }
    }

    public void deleteAllEntities() {

    }
}