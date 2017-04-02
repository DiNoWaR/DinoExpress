package ru.vasilyev.dao.mysqldao;


import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import org.apache.ibatis.session.SqlSession;
import ru.vasilyev.mappers.mysqlmappers.TrainMysqlMapper;
import ru.vasilyev.model.Train;

@Stateless
public class TrainDao extends AbstractMySqlDao<Train> {


    public void insertEntity(Train entity) {

        SqlSession session = null;

        try {
            session = myBatisMysqlSessionFactory.getSqlSessionFactory().openSession();
            TrainMysqlMapper trainMapper = session.getMapper(TrainMysqlMapper.class);
            trainMapper.insertEntity(entity);

        } finally {
            session.close();
        }
    }

    public void insertCollectionOfEntity(Collection<Train> entities) {

    }

    public int findTrainByName(String name) {

        SqlSession session = null;

        int trainID;

        try {
            session = myBatisMysqlSessionFactory.getSqlSessionFactory().openSession();
            TrainMysqlMapper trainMapper = session.getMapper(TrainMysqlMapper.class);

            trainID = trainMapper.findTrainByName(name);

        } finally {
            session.close();
        }
        return trainID;
    }

    public List<Train> getAllEntities() {
        return null;
    }

    public void deleteAllEntities() {

    }
}
