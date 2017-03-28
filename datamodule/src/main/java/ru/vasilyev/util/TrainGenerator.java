package ru.vasilyev.util;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import ru.vasilyev.dao.StationDao;
import ru.vasilyev.dao.TrainDao;
import ru.vasilyev.dao.WagonTypeDao;
import ru.vasilyev.model.Train;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TrainGenerator {

    @EJB
    private WagonTypeDao wagonTypeDao;

    @EJB
    private StationDao stationDao;

    @EJB
    private TrainDao trainDao;


    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void generateTrain(Train train) {
        trainDao.insertEntity(train);
    }


}
