package ru.vasilyev.dao;


import org.apache.ibatis.session.SqlSession;
import ru.vasilyev.mappers.mysqlmappers.TrainMysqlMapper;
import ru.vasilyev.model.Train;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import java.util.Collection;
import java.util.List;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TrainDao extends AbstractDao<Train> {


    public void insertEntity(Train train) {

        try (SqlSession session = mybatisSessionFactory.getSqlSessionFactory().openSession()) {
            TrainMysqlMapper trainMapper = session.getMapper(TrainMysqlMapper.class);
            trainMapper.insertEntity(train);

        }
    }

    public void insertCollectionOfEntity(Collection<Train> trains) {

    }

    public List<Train> getAllEntities() {
        return null;
    }

    public void deleteAllEntities() {

    }

    public int findTrainIdByName(String name) {

        int trainID;

        try (SqlSession session = mybatisSessionFactory.getSqlSessionFactory().openSession()) {
            TrainMysqlMapper trainMapper = session.getMapper(TrainMysqlMapper.class);

            trainID = trainMapper.findTrainIdByName(name);

        }
        return trainID;
    }

}
