package ru.vasilyev.util;


import java.util.List;
import javax.ejb.EJB;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import ru.vasilyev.dao.SeatDao;
import ru.vasilyev.dao.StationDao;
import ru.vasilyev.dao.TrainDao;
import ru.vasilyev.dao.WagonDao;
import ru.vasilyev.dao.WagonTypeDao;
import ru.vasilyev.model.Train;
import ru.vasilyev.model.WagonType;

@Singleton
@Startup
@TransactionManagement(TransactionManagementType.CONTAINER)
public class Generator {

    @EJB
    private WagonTypeDao wagonTypeDao;

    @EJB
    private StationDao stationDao;

    @EJB
    private TrainDao trainDao;

    @EJB
    private SeatDao seatDao;

    @EJB
    private WagonDao wagonDao;



    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void generateTrain(Train train) {
        trainDao.insertEntity(train);
    }

    public void generateCollectionOfTrains(List<Train> trains) {
        trainDao.insertCollectionOfEntity(trains);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void generateWagonType(WagonType wagonType) {
        wagonTypeDao.insertEntity(wagonType);
    }






}
