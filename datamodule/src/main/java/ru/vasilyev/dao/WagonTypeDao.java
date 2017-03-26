package ru.vasilyev.dao;


import org.apache.ibatis.session.SqlSession;
import ru.vasilyev.domain.WagonType;
import ru.vasilyev.mappers.WagonTypeMapper;

import javax.ejb.Stateless;
import java.util.Collection;
import java.util.List;

@Stateless
public class WagonTypeDao extends AbstractDao<WagonType> {


    public void insertEntity(WagonType entity) {

    }

    public void insertCollectionOfEntity(Collection<WagonType> entities) {

    }

    public WagonType findEntityById(long id, Class<WagonType> clazz) {
        return null;
    }

    public List<WagonType> getAllEntities() {

        SqlSession session = null;

        try {
            session = myBatisSessionFactory.getSqlSessionFactory().openSession();
            WagonTypeMapper wagonTypeMapper = session.getMapper(WagonTypeMapper.class);
            return wagonTypeMapper.getAllEntities();
        } finally {
            session.close();
        }
    }

    public void deleteAllEntities() {

    }
}
