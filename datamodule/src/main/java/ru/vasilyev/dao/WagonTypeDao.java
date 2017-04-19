package ru.vasilyev.dao;


import org.apache.ibatis.session.SqlSession;
import ru.vasilyev.mappers.WagonTypeMapper;
import ru.vasilyev.model.WagonType;

import javax.ejb.*;
import java.util.Collection;
import java.util.List;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class WagonTypeDao extends AbstractDao<WagonType> {


    public void insertEntity(WagonType wagonType) {

    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void insertCollectionOfEntity(Collection<WagonType> wagonTypes) {

        try (SqlSession session = mybatisSessionFactory.getSqlSessionFactory().openSession()) {
            WagonTypeMapper wagonTypeMapper = session.getMapper(WagonTypeMapper.class);
            wagonTypeMapper.insertCollectionOfEntity(wagonTypes);

        }

    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<WagonType> getAllEntities() {

        try (SqlSession session = mybatisSessionFactory.getSqlSessionFactory().openSession()) {
            WagonTypeMapper wagonTypeMapper = session.getMapper(WagonTypeMapper.class);
            return wagonTypeMapper.getAllEntities();
        }
    }

    public void deleteAllEntities() {

    }
}
