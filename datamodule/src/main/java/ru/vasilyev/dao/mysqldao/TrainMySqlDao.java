package ru.vasilyev.dao.mysqldao;


import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import org.apache.ibatis.session.SqlSession;
import ru.vasilyev.mappers.mysqlmappers.TrainMysqlMapper;
import ru.vasilyev.model.Train;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TrainMySqlDao extends AbstractMySqlDao<Train> {


    public void insertEntity(Train entity) {

        try (SqlSession session = myBatisMysqlSessionFactory.getSqlSessionFactory().openSession()) {
            TrainMysqlMapper trainMapper = session.getMapper(TrainMysqlMapper.class);
            trainMapper.insertEntity(entity);

        }
    }

    public void insertCollectionOfEntity(Collection<Train> entities) {

    }

    public int findTrainByName(String name) {

        int trainID;

        try (SqlSession session = myBatisMysqlSessionFactory.getSqlSessionFactory().openSession()) {
            TrainMysqlMapper trainMapper = session.getMapper(TrainMysqlMapper.class);

            trainID = trainMapper.findTrainByName(name);

        }
        return trainID;
    }

    public List<Train> getAllEntities() {
        return null;
    }

    public void deleteAllEntities() {

    }
}
