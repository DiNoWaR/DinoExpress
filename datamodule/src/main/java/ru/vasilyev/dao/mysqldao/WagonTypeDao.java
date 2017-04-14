package ru.vasilyev.dao.mysqldao;


import org.apache.ibatis.session.SqlSession;
import ru.vasilyev.model.WagonType;
import ru.vasilyev.mappers.mysqlmappers.WagonTypeMysqlMapper;

import javax.ejb.*;
import java.util.Collection;
import java.util.List;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class WagonTypeDao extends AbstractMySqlDao<WagonType> {


    public void insertEntity(WagonType entity) {

    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void insertCollectionOfEntity(Collection<WagonType> entities) {

        try (SqlSession session = myBatisMysqlSessionFactory.getSqlSessionFactory().openSession()) {
            WagonTypeMysqlMapper wagonTypeMapper = session.getMapper(WagonTypeMysqlMapper.class);
            wagonTypeMapper.insertCollectionOfEntity(entities);

        }

    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<WagonType> getAllEntities() {

        try (SqlSession session = myBatisMysqlSessionFactory.getSqlSessionFactory().openSession()) {
            WagonTypeMysqlMapper wagonTypeMapper = session.getMapper(WagonTypeMysqlMapper.class);
            return wagonTypeMapper.getAllEntities();
        }
    }

    public void deleteAllEntities() {

    }
}
