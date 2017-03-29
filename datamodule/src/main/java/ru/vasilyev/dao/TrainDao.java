package ru.vasilyev.dao;


import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import org.apache.ibatis.session.SqlSession;
import ru.vasilyev.mappers.TrainMapper;
import ru.vasilyev.model.Train;

@Stateless
public class TrainDao extends AbstractDao<Train> {


    public void insertEntity(Train entity) {

        SqlSession session = null;

        try {
            session = myBatisSessionFactory.getSqlSessionFactory().openSession();
            TrainMapper trainMapper = session.getMapper(TrainMapper.class);
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
            session = myBatisSessionFactory.getSqlSessionFactory().openSession();
            TrainMapper trainMapper = session.getMapper(TrainMapper.class);

            trainID = trainMapper.findTrainByName(name);

        } finally {
            session.close();
        }
        return trainID;
    }

    public Train findEntityById(long id, Class<Train> clazz) {
        return null;
    }

    public List<Train> getAllEntities() {
        return null;
    }

    public void deleteAllEntities() {

    }
}
