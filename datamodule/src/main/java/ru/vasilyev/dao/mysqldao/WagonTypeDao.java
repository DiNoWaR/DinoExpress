package ru.vasilyev.dao.mysqldao;


import org.apache.ibatis.session.SqlSession;
import ru.vasilyev.model.WagonType;
import ru.vasilyev.mappers.mysqlmappers.WagonTypeMysqlMapper;

import javax.ejb.Stateless;
import java.util.Collection;
import java.util.List;

@Stateless
public class WagonTypeDao extends AbstractMySqlDao<WagonType> {


    public void insertEntity(WagonType entity) {

    }

    public void insertCollectionOfEntity(Collection<WagonType> entities) {

        SqlSession session = null;

        try {
            session = myBatisMysqlSessionFactory.getSqlSessionFactory().openSession();
            WagonTypeMysqlMapper wagonTypeMapper = session.getMapper(WagonTypeMysqlMapper.class);
            wagonTypeMapper.insertCollectionOfEntity(entities);

        } finally {
            session.close();
        }

    }

    public List<WagonType> getAllEntities() {

        SqlSession session = null;

        try {
            session = myBatisMysqlSessionFactory.getSqlSessionFactory().openSession();
            WagonTypeMysqlMapper wagonTypeMapper = session.getMapper(WagonTypeMysqlMapper.class);
            return wagonTypeMapper.getAllEntities();
        } finally {
            session.close();
        }
    }

    public void deleteAllEntities() {

    }
}
