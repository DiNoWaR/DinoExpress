package ru.vasilyev.dao;


import org.apache.ibatis.session.SqlSession;
import ru.vasilyev.mappers.mysqlmappers.TrainMysqlMapper;
import ru.vasilyev.model.Train;
import ru.vasilyev.views.RoutesByStationsAndDateView;
import ru.vasilyev.wrappers.RoutesByStationsAndDateWrapper;

import javax.ejb.*;
import java.util.Collection;
import java.util.List;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TrainDao extends AbstractDao<Train> {


    public void insertEntity(Train entity) {

        try (SqlSession session = mybatisSessionFactory.getSqlSessionFactory().openSession()) {
            TrainMysqlMapper trainMapper = session.getMapper(TrainMysqlMapper.class);
            trainMapper.insertEntity(entity);

        }
    }

    public void insertCollectionOfEntity(Collection<Train> entities) {

    }

    public List<Train> getAllEntities() {
        return null;
    }

    public void deleteAllEntities() {

    }

    public int findTrainByName(String name) {

        int trainID;

        try (SqlSession session = mybatisSessionFactory.getSqlSessionFactory().openSession()) {
            TrainMysqlMapper trainMapper = session.getMapper(TrainMysqlMapper.class);

            trainID = trainMapper.findTrainByName(name);

        }
        return trainID;
    }

}
